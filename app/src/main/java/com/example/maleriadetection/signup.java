package com.example.maleriadetection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class signup extends AppCompatActivity {

    TextView signin;
    Button signup;
    TextInputLayout name, phone, email, pass, confirm;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progress2);
        signin = findViewById(R.id.register);
        signup = findViewById(R.id.signupbtn);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.emailSignup);
        pass = findViewById(R.id.passwordSignup);
        confirm = findViewById(R.id.confirmpasswordSignup);

        if (mAuth.getCurrentUser() != null) {
            Intent i = new Intent(signup.this, Signin.class);
            startActivity(i);
            finish();
        }


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(signup.this, Signin.class);
               startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getEditText().getText().toString();
                String ph = phone.getEditText().getText().toString();
                String em = email.getEditText().getText().toString();
                String password = pass.getEditText().getText().toString();
                String Confirm_pass = confirm.getEditText().getText().toString();
                if (TextUtils.isEmpty(Name)) {
                    name.setError("Enter your Name");
                    return;
                }
                if (TextUtils.isEmpty(ph)) {
                    Toast.makeText(signup.this, "Enter your phone number", Toast.LENGTH_SHORT).show();
                }
                if (ph.length() < 11) {
                    phone.setError("Enter Valid Phone number");
                    return;
                }
                if (TextUtils.isEmpty(em)) {
                    email.setError("Enter your Email");
                    return;
                }
                if (!(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$"))) {
                    pass.setError("password must be strong");
                    return;
                }
                if (!(Confirm_pass.matches(password))) {
                    confirm.setError("Password not matched");
                }
                else {
                    mAuth.createUserWithEmailAndPassword(em, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "User Added", Toast.LENGTH_SHORT).show();
                                VlidatePhoneNumber(Name, ph, password, em);

                            } else {
                                Toast.makeText(signup.this, "Authentication failed..." + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                            }
                        }
                    });

                }
                progressBar.setVisibility(View.VISIBLE);

            }
        });

    }

    private void VlidatePhoneNumber(String name, String ph, String password, String em) {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(ph).exists())) {

                    HashMap<String, Object> userhashmap = new HashMap<>();
                    userhashmap.put("Phone", ph);
                    userhashmap.put("Name", name);
                    userhashmap.put("Password", password);
                    userhashmap.put("Email", em);

                    Rootref.child("Users").child(ph)
                            .updateChildren(userhashmap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(signup.this, Home.class);
                                        startActivity(i);
                                    } else {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(signup.this, "Error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
//                else
//                {
//                    Toast.makeText(MainActivity2.this, "This " + id + " already Exist", Toast.LENGTH_SHORT).show();
//                    progressBar.setVisibility(View.GONE);
//                    Toast.makeText(MainActivity2.this, "Try Using another ID", Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
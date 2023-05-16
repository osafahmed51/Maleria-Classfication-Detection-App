package com.example.maleriadetection;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {

    TextInputLayout email,password;
    TextView forget,signup;
    Button signin;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.emailSignup);
        password = findViewById(R.id.passwordSignup);
        forget = findViewById(R.id.forgetPass);
        signup =findViewById(R.id.register);
        signin = findViewById(R.id.signupbtn);

        progressBar = findViewById(R.id.progress1);

        if (mAuth.getCurrentUser() != null) {
            Intent i = new Intent(Signin.this, Home.class);
            startActivity(i);
            finish();
        }


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent ii = new Intent(Signin.this,Home.class);
//                startActivity(ii);
                String em = email.getEditText().getText().toString();
                String pass = password.getEditText().getText().toString();
                if (TextUtils.isEmpty(em)) {
                    email.setError("Enter your Email");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    password.setError("Enter your Password");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(em, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Signin.this, "Login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Signin.this, Home.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(Signin.this, "Authentication failed..." + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText reset = new EditText(view.getContext());
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setTitle("Rest Password");
                alert.setMessage("Enter your Email to reset your Password");
                alert.setView(reset);
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mail = reset.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Signin.this, "Rest link is send to your Email", Toast.LENGTH_SHORT).show();
                            }
                        });
                        mAuth.sendPasswordResetEmail(mail).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Signin.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.create().show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(Signin.this, signup.class);
                startActivity(ii);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            Toast.makeText(this, "Successfully SignIn ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Signin.this, Home.class);
            startActivity(intent);
            finish();
//            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
            Toast.makeText(this, "Failed to SignIn ", Toast.LENGTH_SHORT).show();
        }
    }
}
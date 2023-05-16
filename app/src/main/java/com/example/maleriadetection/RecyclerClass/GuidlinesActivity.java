package com.example.maleriadetection.RecyclerClass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.maleriadetection.Adapter.GuidlineAdapter;
import com.example.maleriadetection.Adapter.casesAdapter;
import com.example.maleriadetection.Model.caseModel;
import com.example.maleriadetection.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GuidlinesActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    private GuidlineAdapter guidlineAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidlines);
        mAuth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.guidlinesrecycler);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();


//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //        Query mquery = FirebaseDatabase.getInstance().getReference("subjects").orderByChild("category").equalTo(getIntent().getStringExtra("id"));
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("continent");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    caseModel model = snapshot.getValue(caseModel.class);
//                    model.getAFRICAN();
                }
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("CASES_ACTIVITY", "DatabaseError: " + databaseError.getMessage());
                Toast.makeText(GuidlinesActivity.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        FirebaseRecyclerOptions<caseModel> options =
                new FirebaseRecyclerOptions.Builder<caseModel>()
                        .setQuery(myref, caseModel.class)
                        .build();
        guidlineAdapter = new GuidlineAdapter(getApplicationContext(), options);
        recyclerView.setAdapter(guidlineAdapter);
        guidlineAdapter.notifyDataSetChanged();



    }

    @Override
    protected void onStart() {
        super.onStart();
        guidlineAdapter.startListening();
    }

}
package com.example.maleriadetection.RecyclerClass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.maleriadetection.Adapter.casesAdapter;
import com.example.maleriadetection.Adapter.yearsAdapter;
import com.example.maleriadetection.Model.caseModel;
import com.example.maleriadetection.Model.yearsModel;
import com.example.maleriadetection.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class yearsActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    private yearsAdapter yearsadapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_years);

        mAuth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.daterecycler);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String id = getIntent().getStringExtra("id");
        String namee = getIntent().getStringExtra("name");
        String flag = getIntent().getStringExtra("img");

        Query mquery = FirebaseDatabase.getInstance().getReference("years").orderByChild("Name").equalTo(namee);
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("years");


        FirebaseRecyclerOptions<yearsModel> options =
                new FirebaseRecyclerOptions.Builder<yearsModel>()
                        .setQuery(mquery, yearsModel.class)
                        .build();
        yearsadapter = new yearsAdapter(getApplicationContext(), options);
        recyclerView.setAdapter(yearsadapter);
        yearsadapter.notifyDataSetChanged();
        progressDialog.dismiss();


    }

    @Override
    protected void onStart() {
        super.onStart();
        yearsadapter.startListening();
    }

}
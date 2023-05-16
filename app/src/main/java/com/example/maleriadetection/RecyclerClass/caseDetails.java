package com.example.maleriadetection.RecyclerClass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.maleriadetection.Adapter.DetailsAdapter;
import com.example.maleriadetection.Adapter.casesAdapter;
import com.example.maleriadetection.Model.DetailsModel;
import com.example.maleriadetection.Model.caseModel;
import com.example.maleriadetection.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class caseDetails extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    private DetailsAdapter detailsAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);
        mAuth = FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        recyclerView = findViewById(R.id.caseDetailsrecycler);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String id = getIntent().getStringExtra("id");

        Query mquery = FirebaseDatabase.getInstance().getReference("countries").orderByChild("ID").equalTo(id);
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("countries");

        FirebaseRecyclerOptions<DetailsModel> options =
                new FirebaseRecyclerOptions.Builder<DetailsModel>()
                        .setQuery(mquery, DetailsModel.class)
                        .build();
        detailsAdapter = new DetailsAdapter(getApplicationContext(), options);
        recyclerView.setAdapter(detailsAdapter);
        detailsAdapter.notifyDataSetChanged();
        progressDialog.dismiss();

    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsAdapter.startListening();
    }

}
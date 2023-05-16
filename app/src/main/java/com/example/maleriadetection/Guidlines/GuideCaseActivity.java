package com.example.maleriadetection.Guidlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.maleriadetection.Model.yearsModel;
import com.example.maleriadetection.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class GuideCaseActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GuideCaseAdapter guideCaseAdapter;
    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_case);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        recyclerView = findViewById(R.id.guidcaserecyclerr);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String id = getIntent().getStringExtra("id");
        String namee = getIntent().getStringExtra("name");

        Query mquery = FirebaseDatabase.getInstance().getReference("years").orderByChild("Name").equalTo(namee);
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("countries");

        FirebaseRecyclerOptions<yearsModel> options =
                new FirebaseRecyclerOptions.Builder<yearsModel>()
                        .setQuery(mquery, yearsModel.class)
                        .build();
        guideCaseAdapter = new GuideCaseAdapter(getApplicationContext(), options);
        recyclerView.setAdapter(guideCaseAdapter);
        guideCaseAdapter.notifyDataSetChanged();
        progressDialog.dismiss();

    }

    @Override
    protected void onStart() {
        super.onStart();
        guideCaseAdapter.startListening();
    }

}
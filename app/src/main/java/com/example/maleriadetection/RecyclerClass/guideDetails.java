package com.example.maleriadetection.RecyclerClass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.maleriadetection.Adapter.DetailsAdapter;
import com.example.maleriadetection.Adapter.GuidlineAdapter;
import com.example.maleriadetection.Adapter.countryGuideAdapter;
import com.example.maleriadetection.Adapter.guidedetailsAdapter;
import com.example.maleriadetection.Model.DetailsModel;
import com.example.maleriadetection.Model.GuidlinesMode;
import com.example.maleriadetection.Model.countryGuideModel;
import com.example.maleriadetection.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class guideDetails extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    private guidedetailsAdapter guidedetailsAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_details);
        mAuth = FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        recyclerView = findViewById(R.id.guiddetailsrecycler);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String id = getIntent().getStringExtra("id");

        Query mquery = FirebaseDatabase.getInstance().getReference("countries").equalTo(id);
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("countries").child("years");

        FirebaseRecyclerOptions<countryGuideModel> options =
                new FirebaseRecyclerOptions.Builder<countryGuideModel>()
                        .setQuery(myref, countryGuideModel.class)
                        .build();
        guidedetailsAdapter = new guidedetailsAdapter(getApplicationContext(), options);
        recyclerView.setAdapter(guidedetailsAdapter);
        guidedetailsAdapter.notifyDataSetChanged();
        progressDialog.dismiss();

    }

    @Override
    protected void onStart() {
        super.onStart();
        guidedetailsAdapter.startListening();
    }

}
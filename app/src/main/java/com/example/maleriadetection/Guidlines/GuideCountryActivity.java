package com.example.maleriadetection.Guidlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.maleriadetection.Adapter.DetailsAdapter;
import com.example.maleriadetection.Model.DetailsModel;
import com.example.maleriadetection.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class GuideCountryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GuideCountryAdapter guideCountryAdapter;
    ProgressDialog progressDialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_country);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        recyclerView = findViewById(R.id.guidCountryrecyclerr);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String id = getIntent().getStringExtra("id");

        Query mquery = FirebaseDatabase.getInstance().getReference("countries").orderByChild("ID").equalTo(id);
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child("countries");

        FirebaseRecyclerOptions<GuideCountryModel> options =
                new FirebaseRecyclerOptions.Builder<GuideCountryModel>()
                        .setQuery(mquery, GuideCountryModel.class)
                        .build();
        guideCountryAdapter = new GuideCountryAdapter(getApplicationContext(), options);
        recyclerView.setAdapter(guideCountryAdapter);
        guideCountryAdapter.notifyDataSetChanged();
        progressDialog.dismiss();

    }

    @Override
    protected void onStart() {
        super.onStart();
        guideCountryAdapter.startListening();
    }

}
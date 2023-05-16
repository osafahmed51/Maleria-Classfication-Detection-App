package com.example.maleriadetection.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maleriadetection.Model.caseModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.caseDetails;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class casesAdapter extends FirebaseRecyclerAdapter<caseModel, casesAdapter.myViewHolder> {

    Context mcontext;


    public casesAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<caseModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }


    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull caseModel model) {

        holder.name.setText(model.getName());
        holder.id.setText(model.getID());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, caseDetails.class);
                i.putExtra("id", model.getID());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);

            }
        });
    }

    @NonNull
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

//        RelativeLayout country;
        TextView name,id;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.countryName);
            id = itemView.findViewById(R.id.countryID);

        }

    }
}

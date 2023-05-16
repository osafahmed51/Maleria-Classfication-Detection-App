package com.example.maleriadetection.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.maleriadetection.Model.DetailsModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.caseDetails;
import com.example.maleriadetection.RecyclerClass.yearsActivity;
import com.example.maleriadetection.casesHardcode;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DetailsAdapter extends FirebaseRecyclerAdapter<DetailsModel, DetailsAdapter.myViewHolder> {

    Context mcontext;

    public DetailsAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<DetailsModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull DetailsAdapter.myViewHolder holder, int position, @NonNull DetailsModel model) {

        holder.name.setText(model.getName());
        holder.id.setText(model.getID());
        Glide.with(holder.flag.getContext())
                .load(model.getImg())
                .into(holder.flag);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, yearsActivity.class);
                i.putExtra("id", model.getID());
                i.putExtra("name", model.getName());
                i.putExtra("reigon", model.getReigon());
                i.putExtra("img", model.getImg());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);

            }
        });
    }

    @NonNull
    public DetailsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.case_details_row, parent, false);
        return new DetailsAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView name,id;
        ImageView flag;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.countries);
            id = itemView.findViewById(R.id.countriesID);
            flag = itemView.findViewById(R.id.flag);

        }

    }
}

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
import com.example.maleriadetection.Model.GuidlinesMode;
import com.example.maleriadetection.Model.countryGuideModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.guideDetails;
import com.example.maleriadetection.RecyclerClass.yearsActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class countryGuideAdapter extends FirebaseRecyclerAdapter<DetailsModel, countryGuideAdapter.myViewHolder> {
    Context mcontext;

    public countryGuideAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<DetailsModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull countryGuideAdapter.myViewHolder holder, int position, @NonNull DetailsModel model) {

        holder.name.setText(model.getName());
        holder.id.setText(model.getID());
        Glide.with(holder.flag.getContext())
                .load(model.getImg())
                .into(holder.flag);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, guideDetails.class);
                i.putExtra("id", model.getID());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);

            }
        });
    }

    @NonNull
    public countryGuideAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.case_details_row, parent, false);
        return new countryGuideAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        //        RelativeLayout country;
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

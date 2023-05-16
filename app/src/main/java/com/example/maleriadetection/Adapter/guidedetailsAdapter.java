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
import com.example.maleriadetection.Model.countryGuideModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.yearsActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class guidedetailsAdapter extends FirebaseRecyclerAdapter<countryGuideModel, guidedetailsAdapter.myViewHolder> {

    Context mcontext;

    public guidedetailsAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<countryGuideModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull guidedetailsAdapter.myViewHolder holder, int position, @NonNull countryGuideModel model) {

        holder.year.setText(model.getYear());
        holder.death.setText(model.getDeaths());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(mcontext, yearsActivity.class);
//                i.putExtra("id", model.getID());
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mcontext.startActivity(i);
//
//            }
//        });
    }

    @NonNull
    public guidedetailsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_details_row, parent, false);
        return new guidedetailsAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        //        RelativeLayout country;
        TextView year,death;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            year = itemView.findViewById(R.id.year1);
            death = itemView.findViewById(R.id.death1);

        }

    }
}

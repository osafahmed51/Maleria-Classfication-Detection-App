package com.example.maleriadetection.Guidlines;

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
import com.example.maleriadetection.Model.yearsModel;
import com.example.maleriadetection.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class GuideCaseAdapter extends FirebaseRecyclerAdapter<yearsModel, GuideCaseAdapter.myViewHolder> {

    Context mcontext;
    public GuideCaseAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<yearsModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull GuideCaseAdapter.myViewHolder holder, int position, @NonNull yearsModel model) {

        holder.name.setText(model.getName());
        holder.year.setText(model.getValue());
        holder.reigon.setText(model.getReigon());
        Glide.with(holder.flag.getContext())
                .load(model.getImg())
                .into(holder.flag);
        holder.death.setText(model.getDeath());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(mcontext, GuideHardcode.class);
//                i.putExtra("id", model.getID());
//                i.putExtra("name", model.getName());
//                i.putExtra("image", model.getImg());
//                i.putExtra("reigon", model.getReigon());
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mcontext.startActivity(i);
//
//            }
//        });
    }

    @NonNull
    public GuideCaseAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_case_row, parent, false);
        return new GuideCaseAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView name,year,death,reigon;
        ImageView flag;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.casecountry);
            year = itemView.findViewById(R.id.year);
            death = itemView.findViewById(R.id.cases);
            reigon = itemView.findViewById(R.id.casereigon);
            flag = itemView.findViewById(R.id.imagecountry);

        }

    }
}

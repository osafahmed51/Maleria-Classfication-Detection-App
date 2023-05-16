package com.example.maleriadetection.Guidlines;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.maleriadetection.Adapter.casesAdapter;
import com.example.maleriadetection.Model.caseModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.caseDetails;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class GuideCountryAdapter extends FirebaseRecyclerAdapter<GuideCountryModel, GuideCountryAdapter.myViewHolder> {

    Context mcontext;

    public GuideCountryAdapter (Context applicationContext, @NonNull FirebaseRecyclerOptions<GuideCountryModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull GuideCountryAdapter.myViewHolder holder, int position, @NonNull GuideCountryModel model) {

        holder.name.setText(model.getName());
        holder.id.setText(model.getID());
        holder.nametwo.setText(model.getName());

        Glide.with(holder.flag.getContext())
                .load(model.getImg())
                .into(holder.flag);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, GuideCaseActivity.class);
                i.putExtra("id", model.getID());
                i.putExtra("name", model.getName());
                i.putExtra("image", model.getImg());
                i.putExtra("reigon", model.getReigon());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);

            }
        });
    }

    @NonNull
    public GuideCountryAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_country_row, parent, false);
        return new GuideCountryAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView name,id,nametwo;
        ImageView flag;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.country);
            id = itemView.findViewById(R.id.countryID);
            nametwo = itemView.findViewById(R.id.nameother);
            flag = itemView.findViewById(R.id.countryflag);

        }

    }
}

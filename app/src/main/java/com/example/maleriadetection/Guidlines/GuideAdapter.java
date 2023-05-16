package com.example.maleriadetection.Guidlines;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maleriadetection.Adapter.casesAdapter;
import com.example.maleriadetection.Model.caseModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.caseDetails;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class GuideAdapter extends FirebaseRecyclerAdapter<GuideModel, GuideAdapter.myViewHolder> {

    Context mcontext;

    public GuideAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<GuideModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull GuideAdapter.myViewHolder holder, int position, @NonNull GuideModel model) {

        holder.name.setText(model.getName());
        holder.id.setText(model.getID());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, GuideCountryActivity.class);
                i.putExtra("id", model.getID());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);

            }
        });
    }

    @NonNull
    public GuideAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_row, parent, false);
        return new GuideAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView name,id;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.reigonName);
            id = itemView.findViewById(R.id.reigonID);

        }

    }
}




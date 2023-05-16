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
import com.example.maleriadetection.Model.serviceModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.caseDetails;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class serviceAdapter extends FirebaseRecyclerAdapter<serviceModel,serviceAdapter.myViewHolder> {
    Context mcontext;

    public serviceAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<serviceModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull serviceAdapter.myViewHolder holder, int position, @NonNull serviceModel model) {

        holder.name.setText(model.getName());
        holder.exp.setText(model.getExperience());
        holder.phone.setText(model.getPhone());
        holder.address.setText(model.getLocation());

    }

    @NonNull
    public serviceAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_row, parent, false);
        return new serviceAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView name,address,phone,exp;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.shopname);
            address = itemView.findViewById(R.id.location);
            phone = itemView.findViewById(R.id.phone);
            exp = itemView.findViewById(R.id.exp);

        }

    }
}

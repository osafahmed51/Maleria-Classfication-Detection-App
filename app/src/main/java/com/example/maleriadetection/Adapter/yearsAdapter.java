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
import com.example.maleriadetection.Model.caseModel;
import com.example.maleriadetection.Model.yearsModel;
import com.example.maleriadetection.R;
import com.example.maleriadetection.RecyclerClass.caseDetails;
import com.example.maleriadetection.RecyclerClass.moreDetails;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class yearsAdapter extends FirebaseRecyclerAdapter<yearsModel, yearsAdapter.myViewHolder> {

    Context mcontext;

    public yearsAdapter(Context applicationContext, @NonNull FirebaseRecyclerOptions<yearsModel> options) {
        super(options);
        this.mcontext = applicationContext;
    }
    protected void onBindViewHolder(@NonNull yearsAdapter.myViewHolder holder, int position, @NonNull yearsModel model) {

        holder.year.setText(model.getValue());
        holder.name.setText(model.getName());
        holder.case1.setText(model.getIndigenous());
        holder.case2.setText(model.getFalciparum());
        holder.case3.setText(model.getVivax());
        holder.case4.setText(model.getMixed());
        holder.case5.setText(model.getOther());
        holder.case6.setText(model.getImported());
        holder.case7.setText(model.getIntroduced());

        Glide.with(holder.flag.getContext())
                .load(model.getImg())
                .into(holder.flag);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(mcontext, moreDetails.class);
////                i.putExtra("id", model.getValue());
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mcontext.startActivity(i);
//
//            }
//        });
    }

    @NonNull
    public yearsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.years_row, parent, false);
        return new yearsAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView year,name,case1,case2,case3,case4,case5,case6,case7;
        ImageView flag;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            year = itemView.findViewById(R.id.yearDate);
            name = itemView.findViewById(R.id.yearsCountry);
            case1 = itemView.findViewById(R.id.case1);
            case2 = itemView.findViewById(R.id.case2);
            case3 = itemView.findViewById(R.id.case3);
            case4 = itemView.findViewById(R.id.case4);
            case5 = itemView.findViewById(R.id.case5);
            case6 = itemView.findViewById(R.id.case6);
            case7 = itemView.findViewById(R.id.case7);
            flag = itemView.findViewById(R.id.image);

        }

    }
}

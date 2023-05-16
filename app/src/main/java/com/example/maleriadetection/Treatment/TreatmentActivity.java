package com.example.maleriadetection.Treatment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.maleriadetection.R;

public class TreatmentActivity extends AppCompatActivity {

    RelativeLayout rel1,rel2,rel3,rel4;
    TextView txt1,txt2,txt3,txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);

        rel1 = findViewById(R.id.treatonelay);
        rel2 = findViewById(R.id.treattwolay);
        rel3 = findViewById(R.id.treatthreelay);
        rel4 = findViewById(R.id.treatfourlay);

        txt1 = findViewById(R.id.treatment1);
        txt2= findViewById(R.id.treatment2);
        txt3 = findViewById(R.id.treatment3);
        txt4 = findViewById(R.id.treatment4);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rel1.getVisibility() == View.VISIBLE){
                    rel1.setVisibility(View.GONE);
                } else {
                    rel1.setVisibility(View.VISIBLE);
                }
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rel2.getVisibility() == View.VISIBLE){
                    rel2.setVisibility(View.GONE);
                } else {
                    rel2.setVisibility(View.VISIBLE);
                }
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rel3.getVisibility() == View.VISIBLE){
                    rel3.setVisibility(View.GONE);
                } else {
                    rel3.setVisibility(View.VISIBLE);
                }
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rel4.getVisibility() == View.VISIBLE){
                    rel4.setVisibility(View.GONE);
                } else {
                    rel4.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}
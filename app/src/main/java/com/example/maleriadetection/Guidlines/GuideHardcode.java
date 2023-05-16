package com.example.maleriadetection.Guidlines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.maleriadetection.R;

public class GuideHardcode extends AppCompatActivity {

    TextView country_name,reigon_name,death1,death2,death3,death4,death5,death6,death7,death8,death9,death10,death11;
    ImageView flags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_hardcode);

        country_name = findViewById(R.id.countryName);
        reigon_name = findViewById(R.id.reigonName);
        flags = findViewById(R.id.flags);
        death1 = findViewById(R.id.death);
        death2 = findViewById(R.id.death2);
        death3 = findViewById(R.id.death3);
        death4 = findViewById(R.id.death4);
        death5 = findViewById(R.id.death5);
        death6 = findViewById(R.id.death6);
        death7 = findViewById(R.id.death7);
        death8 = findViewById(R.id.death8);
        death9 = findViewById(R.id.death9);
        death10 = findViewById(R.id.death10);
        death11 = findViewById(R.id.death11);

        String namee = getIntent().getStringExtra("name");
        String img = getIntent().getStringExtra("image");
        String reg = getIntent().getStringExtra("reigon");

        country_name.setText(namee);
        reigon_name.setText(reg);
        Glide.with(this)
                .load(img)
                .into(flags);

        if (namee.equals("Afghanistan")){
            death1.setText("22");
            death2.setText("40");
            death3.setText("36");
            death4.setText("24");
            death5.setText("32");
            death6.setText("49");
            death7.setText("47");
            death8.setText("10");
            death9.setText("01");
            death10.setText("00");
            death11.setText("00");
        } else if (namee.equals("Iran")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("01");
            death7.setText("00");
            death8.setText("01");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        } else if (namee.equals("Pakistan")) {
            death1.setText("00");
            death2.setText("04");
            death3.setText("240");
            death4.setText("260");
            death5.setText("56");
            death6.setText("34");
            death7.setText("33");
            death8.setText("113");
            death9.setText("102");
            death10.setText("00");
            death11.setText("80");
        }
        else if (namee.equals("Saudi Arabia")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Algeria")) {
            death1.setText("01");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Angola")) {
            death1.setText("8114");
            death2.setText("6909");
            death3.setText("5736");
            death4.setText("7300");
            death5.setText("5714");
            death6.setText("7832");
            death7.setText("15997");
            death8.setText("13967");
            death9.setText("11814");
            death10.setText("18691");
            death11.setText("11797");
        }
        else if (namee.equals("Benin")) {
            death1.setText("964");
            death2.setText("1753");
            death3.setText("2261");
            death4.setText("2288");
            death5.setText("1869");
            death6.setText("1416");
            death7.setText("1646");
            death8.setText("2182");
            death9.setText("2138");
            death10.setText("2589");
            death11.setText("2336");
        }
        else if (namee.equals("Chad")) {
            death1.setText("886");
            death2.setText("1220");
            death3.setText("1359");
            death4.setText("1881");
            death5.setText("1720");
            death6.setText("1572");
            death7.setText("1686");
            death8.setText("2088");
            death9.setText("1948");
            death10.setText("3374");
            death11.setText("2955");
        }
        else if (namee.equals("Argentina")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Brazil")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Colombia")) {
            death1.setText("42");
            death2.setText("23");
            death3.setText("24");
            death4.setText("10");
            death5.setText("17");
            death6.setText("18");
            death7.setText("36");
            death8.setText("19");
            death9.setText("09");
            death10.setText("03");
            death11.setText("05");
        }
        else if (namee.equals("Haiti")) {
            death1.setText("08");
            death2.setText("05");
            death3.setText("06");
            death4.setText("10");
            death5.setText("09");
            death6.setText("15");
            death7.setText("13");
            death8.setText("12");
            death9.setText("19");
            death10.setText("07");
            death11.setText("11");
        }
        else if (namee.equals("Bangladesh")) {
            death1.setText("37");
            death2.setText("36");
            death3.setText("11");
            death4.setText("15");
            death5.setText("45");
            death6.setText("09");
            death7.setText("17");
            death8.setText("13");
            death9.setText("07");
            death10.setText("09");
            death11.setText("09");
        }
        else if (namee.equals("India")) {
            death1.setText("1018");
            death2.setText("754");
            death3.setText("519");
            death4.setText("440");
            death5.setText("562");
            death6.setText("384");
            death7.setText("331");
            death8.setText("194");
            death9.setText("96");
            death10.setText("77");
            death11.setText("93");
        }
        else if (namee.equals("Bhutan")) {
            death1.setText("02");
            death2.setText("01");
            death3.setText("01");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Indonesia")) {
            death1.setText("432");
            death2.setText("388");
            death3.setText("252");
            death4.setText("385");
            death5.setText("217");
            death6.setText("157");
            death7.setText("161");
            death8.setText("47");
            death9.setText("34");
            death10.setText("49");
            death11.setText("32");
        }
        else if (namee.equals("Armenia")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Azerbaijan")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Tajikistan")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Turkey")) {
            death1.setText("00");
            death2.setText("00");
            death3.setText("00");
            death4.setText("00");
            death5.setText("00");
            death6.setText("00");
            death7.setText("00");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Cambodia")) {
            death1.setText("151");
            death2.setText("94");
            death3.setText("45");
            death4.setText("12");
            death5.setText("18");
            death6.setText("10");
            death7.setText("03");
            death8.setText("01");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("China")) {
            death1.setText("19");
            death2.setText("33");
            death3.setText("45");
            death4.setText("12");
            death5.setText("18");
            death6.setText("10");
            death7.setText("03");
            death8.setText("01");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Malaysia")) {
            death1.setText("13");
            death2.setText("12");
            death3.setText("12");
            death4.setText("10");
            death5.setText("04");
            death6.setText("04");
            death7.setText("02");
            death8.setText("00");
            death9.setText("00");
            death10.setText("00");
            death11.setText("00");
        }
        else if (namee.equals("Philippines")) {
            death1.setText("30");
            death2.setText("12");
            death3.setText("16");
            death4.setText("12");
            death5.setText("10");
            death6.setText("20");
            death7.setText("07");
            death8.setText("04");
            death9.setText("02");
            death10.setText("09");
            death11.setText("03");
        }


    }
}
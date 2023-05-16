package com.example.maleriadetection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class casesHardcode extends AppCompatActivity {

    TextView country, reigon, des1, des2, des3, des4, des5, des1C, des2C, des3C, des4C, des5C,
            des1D, des2D, des3D, des4D, des5D, des1E, des2E, des3E, des4E, des5E, des1F, des2F,
            des3F, des4F, des5F, des1G, des2G, des3G, des4G, des5G, des1H, des2H, des3H, des4H,
            des5H, des1I, des2I, des3I, des4I, des5I, des1J, des2J, des3J, des4J, des5J, des1K,
            des2K, des3K, des4K, des5K;
    ImageView flagcountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_hardcode);

        country = findViewById(R.id.countryName);
        reigon = findViewById(R.id.reigonName2);
        flagcountry = findViewById(R.id.flags2);
        des1 = findViewById(R.id.indigenous);
        des2 = findViewById(R.id.falciparum);
        des3 = findViewById(R.id.mixed);
        des4 = findViewById(R.id.other);
        des5 = findViewById(R.id.Imported);
        des1C = findViewById(R.id.indigenous11);
        des2C = findViewById(R.id.falciparum2);
        des3C = findViewById(R.id.mixed1);
        des4C = findViewById(R.id.other1);
        des5C = findViewById(R.id.Imported1);
        des1D = findViewById(R.id.indigenous1C);
        des2D = findViewById(R.id.falciparumC);
        des3D = findViewById(R.id.mixedC);
        des4D = findViewById(R.id.otherC);
        des5D = findViewById(R.id.ImportedC);
        des1E = findViewById(R.id.indigenous1D);
        des2E = findViewById(R.id.falciparumD);
        des3E = findViewById(R.id.mixedD);
        des4E = findViewById(R.id.otherD);
        des5E = findViewById(R.id.ImportedD);
        des1F = findViewById(R.id.indigenous1E);
        des2F = findViewById(R.id.falciparumE);
        des3F = findViewById(R.id.mixedE);
        des4F = findViewById(R.id.otherE);
        des5F = findViewById(R.id.ImportedE);
        des1G = findViewById(R.id.indigenous1F);
        des2G = findViewById(R.id.falciparumF);
        des3G = findViewById(R.id.mixedF);
        des4G = findViewById(R.id.otherF);
        des5G = findViewById(R.id.ImportedF);
        des1H = findViewById(R.id.indigenous1G);
        des2H = findViewById(R.id.falciparumG);
        des3H = findViewById(R.id.mixedG);
        des4H = findViewById(R.id.otherG);
        des5H = findViewById(R.id.ImportedG);
        des1I = findViewById(R.id.indigenous1H);
        des2I = findViewById(R.id.falciparumH);
        des3I = findViewById(R.id.mixedH);
        des4I = findViewById(R.id.otherH);
        des5I = findViewById(R.id.ImportedH);
        des1J = findViewById(R.id.indigenous1I);
        des2J = findViewById(R.id.falciparumI);
        des3J = findViewById(R.id.mixedI);
        des4J = findViewById(R.id.otherI);
        des5J = findViewById(R.id.ImportedI);
        des1K = findViewById(R.id.indigenous1J);
        des2K = findViewById(R.id.falciparumJ);
        des3K = findViewById(R.id.mixedJ);
        des4K = findViewById(R.id.otherJ);
        des5K = findViewById(R.id.ImportedJ);
        des1K = findViewById(R.id.indigenous1K);
        des2K = findViewById(R.id.falciparumK);
        des3K = findViewById(R.id.mixedK);
        des4K = findViewById(R.id.otherK);
        des5K = findViewById(R.id.ImportedK);

        String namee = getIntent().getStringExtra("name");
        String img = getIntent().getStringExtra("img");
        String reg = getIntent().getStringExtra("reigon");

        country.setText(namee);
        reigon.setText(reg);
        Glide.with(this)
                .load(img)
                .into(flagcountry);

        if (namee.equals("Afghanistan")) {
            des1.setText("69798");
            des2.setText("6142");
            des3.setText("63255");
            des4.setText("0");
            des5.setText("0");

            des1C.setText("77549");
            des2C.setText("5581");
            des3C.setText("71968");
            des4C.setText("0");
            des5C.setText("0");

            des1D.setText("54840");
            des2D.setText("1231");
            des3D.setText("53609");
            des4D.setText("0");
            des5D.setText("0");

            des1E.setText("52965");
            des2E.setText("1877");
            des3E.setText("43369");
            des4E.setText("0");
            des5E.setText("0");

            des1F.setText("106478");
            des2F.setText("3000");
            des3F.setText("58362");
            des4F.setText("0");
            des5F.setText("0");

            des1G.setText("119859");
            des2G.setText("4004");
            des3G.setText("82891");
            des4G.setText("0");
            des5G.setText("0");

            des1H.setText("241233");
            des2H.setText("6369");
            des3H.setText("132407");
            des4H.setText("311");
            des5H.setText("0");

            des1I.setText("313086");
            des2I.setText("6907");
            des3I.setText("154468");
            des4I.setText("403");
            des5I.setText("0");

            des1J.setText("248689");
            des2J.setText("6437");
            des3J.setText("166583");
            des4J.setText("473");
            des5J.setText("0");

            des1K.setText("248689");
            des2K.setText("6437");
            des3K.setText("166583");
            des4K.setText("473");
            des5K.setText("0");
        }

    }
}
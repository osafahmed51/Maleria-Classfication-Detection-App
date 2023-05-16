package com.example.maleriadetection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.maleriadetection.Guidlines.GuideActivity;
import com.example.maleriadetection.RecyclerClass.ServiceActivity;
import com.example.maleriadetection.RecyclerClass.casesActivity;
import com.example.maleriadetection.Treatment.TreatmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout control, guidlines;
    RelativeLayout disease;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    MenuItem profilename;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    CardView cases, treatment, virus, guildines, services;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
        disease = findViewById(R.id.disease_layout);
        control = findViewById(R.id.control_layout);
        guidlines = findViewById(R.id.guidlines_layout);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        cases = findViewById(R.id.casesCard);
        treatment = findViewById(R.id.treatmentCard);
        guildines = findViewById(R.id.guidlinesCard);
        virus = findViewById(R.id.virusDetect);
        services = findViewById(R.id.servicesCard);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_close, R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_view);
        navigationView.setCheckedItem(R.id.homee);
        Menu menu = navigationView.getMenu();
        profilename = menu.findItem(R.id.profile);
        View header = navigationView.getHeaderView(0);

        ImageView img = header.findViewById(R.id.userprofilepic);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
//            Uri personPhoto = acct.getPhotoUrl();
            String imageUrl = acct.getPhotoUrl().toString();

            profilename.setTitle(personName);
            Glide.with(this).load(imageUrl).into(img);
        }


        cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, casesActivity.class);
                startActivity(i);
            }
        });
        virus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, virus_detection.class);
                startActivity(i);
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, ServiceActivity.class);
                startActivity(i);
            }
        });
        treatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, TreatmentActivity.class);
                startActivity(i);
            }
        });
        guildines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, GuideActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homee:

                break;
            case R.id.logout:
                mAuth.signOut();
                mGoogleSignInClient.signOut();
                Intent intent = new Intent(this, Signin.class);
                startActivity(intent);
                finish();
                break;
            case R.id.profile:
                break;

            case R.id.share:
                break;
            case R.id.About:

                break;
            case R.id.settings:

                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }

    }
}
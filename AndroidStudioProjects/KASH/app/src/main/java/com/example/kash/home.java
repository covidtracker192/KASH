package com.example.kash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    Button profile;
    Button vicinity;
    Button settings;
    Button testcenter;
    Button emergency;
    Button volunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile = findViewById(R.id.button2);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, profile.class);
                startActivity(intent);
                finish();
            }
        });

        vicinity =  findViewById(R.id.button7);
        vicinity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, UserMapsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        testcenter = findViewById(R.id.button8);
        testcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Test_MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        settings= findViewById(R.id.button9);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, settings.class);
                startActivity(intent);
                finish();
            }
        });

        emergency=findViewById(R.id.button10);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, emergency_contact.class);
                startActivity(intent);
                finish();
            }
        });

        volunteer=findViewById(R.id.button12);
        volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://forms.gle/z6eMHcJQuF9mrXfN7");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
    }
    public void onBackPressed(){
        stopService(new Intent(getApplicationContext(), Location_Services.class));
        Intent intent = new Intent(home.this, login_global.class);
        startActivity(intent);
        finish();
    }
    }


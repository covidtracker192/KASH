package com.example.kash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void onBackPressed(){
        stopService(new Intent(getApplicationContext(), Location_Services.class));
        Intent intent = new Intent(home.this, login_global.class);
        startActivity(intent);
        finish();
    }
    public void openprofile(View a){
        Intent intent = new Intent(home.this, profile.class);
        startActivity(intent);
        finish();
    }

    public void openvicalert(View a){
        Intent intent = new Intent(home.this, UserMapsActivity.class);
        startActivity(intent);
        finish();
    }

    public void opentestcenter(View a){
        Intent intent = new Intent(home.this, Test_MapsActivity.class);
        startActivity(intent);
        finish();
    }

    public void openemergencycontact(View a){
        Intent intent = new Intent(home.this, emergency_contact.class);
        startActivity(intent);
        finish();
    }

    public void openvolunteer(View a){
        Uri uriUrl = Uri.parse("https://forms.gle/z6eMHcJQuF9mrXfN7");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void openmeasures(View a){

    }

    public void opensettings(View a){
        Intent intent = new Intent(home.this, settings.class);
        startActivity(intent);
        finish();
    }

    }


package com.example.kash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class login_global extends AppCompatActivity {

    ImageView worker, user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_global);

        worker = findViewById(R.id.imageView33);
        user =  findViewById(R.id.imageView34);

            user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     if(isOnline()){
                        Intent intent = new Intent(login_global.this, user_verification.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(login_global.this, "Check your Internet Connection!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            worker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isOnline()){
                        Intent intent = new Intent(login_global.this, login_worker.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(login_global.this, "Check your Internet Connection!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
    public void onBackPressed()
    {
        finish();
    }
}

package com.example.kash;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    Button alert, profile, animation, emergency, test, settings, volunteer, pmcare, state;
    Button alert1, profile1, animation1, emergency1, test1, settings1, volunteer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        alert=findViewById(R.id.button8);
        alert1=findViewById(R.id.button9);
        profile=findViewById(R.id.button2);
        profile1=findViewById(R.id.button7);
        animation=findViewById(R.id.button13);
        animation1=findViewById(R.id.button14);
        emergency=findViewById(R.id.button15);
        emergency1=findViewById(R.id.button16);
        test=findViewById(R.id.button10);
        test1=findViewById(R.id.button12);
        settings=findViewById(R.id.button19);
        settings1=findViewById(R.id.button20);
        volunteer=findViewById(R.id.button17);
        volunteer1=findViewById(R.id.button18);
        pmcare=findViewById(R.id.button22);
        state=findViewById(R.id.button21);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, UserMapsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        alert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, UserMapsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, profile.class);
                startActivity(intent);
                finish();

            }
        });
        profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, profile.class);
                startActivity(intent);
                finish();

            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, emergency_contact.class);
                startActivity(intent);
                finish();

            }
        });
        emergency1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, emergency_contact.class);
                startActivity(intent);
                finish();

            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Test_MapsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Test_MapsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, settings.class);
                startActivity(intent);
                finish();

            }
        });
        settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, settings.class);
                startActivity(intent);
                finish();

            }
        });

        volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.mygov.in/task/join-war-against-covid-19-register-volunteer/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);

            }
        });
        volunteer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.mygov.in/task/join-war-against-covid-19-register-volunteer/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);

            }
        });

        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, preventive_measure.class);
                startActivity(intent);
                finish();


            }
        });
        animation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, preventive_measure.class);
                startActivity(intent);
                finish();

            }
        });

        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(home.this)
                        .setTitle("Karnataka State COVID-19 Relief Fund.")
                        .setMessage("You will be redirected to the official payment link of Karnataka State COVID-19 Relief Fund. Do you want to continue?")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with COVID-19 karnataka relief fund
                                Uri uriUrl = Uri.parse("https://cmrf.karnataka.gov.in/English/index.html");
                                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(launchBrowser);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Cancel", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

        pmcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(home.this)
                        .setTitle("PM CARES FUND")
                        .setMessage("You will be redirected to the official website of PM CARES Fund. Do you want to continue?")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with pmcares
                                Uri uriUrl = Uri.parse("https://www.pmcares.gov.in/en/");
                                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(launchBrowser);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Cancel", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });
    }
    public void onBackPressed(){
        Intent intent = new Intent(home.this, login_global.class);
        startActivity(intent);
        finish();
    }

    }


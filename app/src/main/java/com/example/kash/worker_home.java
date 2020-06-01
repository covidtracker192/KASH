package com.example.kash;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class worker_home extends AppCompatActivity {
Button mark, forum, setting;
Button mark1, forum1, settings1;
TextView mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_home);
        mark=findViewById(R.id.button);
        mark1=findViewById(R.id.button5);
        forum=findViewById(R.id.button6);
        forum1=findViewById(R.id.button11);
        setting=findViewById(R.id.button23);
        settings1=findViewById(R.id.button24);
        mail=findViewById(R.id.textView22);

        String email = PreferenceManager.getDefaultSharedPreferences(worker_home.this).getString("ID", "defaultStringIfNothingFound");
        String s1 = email.substring(0, email.lastIndexOf("@"));
        mail.setText(s1);
        mail.setTextColor(Color.parseColor("#000000"));
        mail.setGravity(Gravity.CENTER);
        Intent service = new Intent(getApplicationContext(), locationupdate.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

            worker_home.this.stopService(service);
        }
        else{
            stopService(service);
        }

        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(worker_home.this, forum.class);
                startActivity(intent);
                finish();

            }
        });
        forum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(worker_home.this, forum.class);
                startActivity(intent);
                finish();
            }
        });

        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(worker_home.this, patient_num.class);
                startActivity(intent);
                finish();
            }
        });
        mark1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(worker_home.this, patient_num.class);
                startActivity(intent);
                finish();
            }
        });


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(worker_home.this, settings_worker.class);
                startActivity(intent);
                finish();
                return;

            }
        });

        settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(worker_home.this, settings_worker.class);
                startActivity(intent);
                finish();
                return;

            }
        });

    }

    public void onBackPressed()
    {
        //public Dialog onCreateDialog(Bundle savedInstanceState){
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Signout", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with exit
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(worker_home.this, login_worker.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Cancel", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }
}

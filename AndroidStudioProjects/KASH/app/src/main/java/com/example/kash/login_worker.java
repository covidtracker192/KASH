package com.example.kash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_worker extends AppCompatActivity {
    EditText password;
    EditText userid;
    Button login;
    String id;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_worker);

        userid=findViewById(R.id.editText);
       password=findViewById(R.id.editText2);

        final String ogpass="covid19kash";
        final String ogid="kashworker1@kash.com";
        login = findViewById(R.id.button5);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=userid.getText().toString();
                pass=password.getText().toString();
                if (ogid.equals(id) && ogpass.equals(pass)) {
                    Intent intent = new Intent(login_worker.this, patient_num.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(login_worker.this, "Check UserID and Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onBackPressed(){
        Intent intent = new Intent(login_worker.this, login_global.class);
        startActivity(intent);
        finish();
    }
}

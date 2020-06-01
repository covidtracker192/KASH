package com.example.kash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_worker extends AppCompatActivity {
    EditText pass;
    EditText email;
    ImageView login;
    ProgressBar prog;
    ImageButton id;
    ImageButton pas;
    String mail;
    String password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_worker);
        email=findViewById(R.id.editText);
        pass=findViewById(R.id.editText2);
        login=findViewById(R.id.imageView8);
        prog=findViewById(R.id.progressBar3);
        id=findViewById(R.id.imageButton);
        pas=findViewById(R.id.imageButton2);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog.setVisibility(View.VISIBLE);
                mail=email.getText().toString();
                password=pass.getText().toString();
                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
                    return;
                }
               mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                           prog.setVisibility(View.GONE);
                           PreferenceManager.getDefaultSharedPreferences(login_worker.this).edit().putString("ID",mail).apply();
                           Intent intent = new Intent(login_worker.this, worker_home.class);
                           startActivity(intent);
                       }
                       else {
                           Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                           prog.setVisibility(View.GONE);
                       }
                   }
               });

            }
        });

        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(login_worker.this)
                        .setTitle("Enter User ID")
                        .setMessage("Enter the User ID provided by your organization.")
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Ok", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(login_worker.this)
                        .setTitle("Enter Password")
                        .setMessage("Enter the Password provided by your organization.")
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Ok", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });
    }
    public void onBackPressed(){
        Intent intent = new Intent(login_worker.this, login_global.class);
        startActivity(intent);
        finish();
    }
}

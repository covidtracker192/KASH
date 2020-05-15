package com.example.kash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class user_verification extends AppCompatActivity {
    public EditText editText;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_verification);

        editText = findViewById(R.id.mobile);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String number = editText.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }
                PreferenceManager.getDefaultSharedPreferences(user_verification.this).edit().putString("Phone",number).apply();

                Intent intent = new Intent(user_verification.this, verify_phone.class);
               intent.putExtra("phonenumber", number);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, checking.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}

package com.example.kash;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class checking extends AppCompatActivity {
    public String number;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);
        number= getIntent().getStringExtra("phone");
        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        number=PreferenceManager.getDefaultSharedPreferences(checking.this).getString("Phone", "defaultStringIfNothingFound");
        DatabaseReference Affected=FirebaseDatabase.getInstance().getReference("Affected");
        Affected.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener(){

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    startService(new Intent(getApplicationContext(), Location_Services.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

        number=PreferenceManager.getDefaultSharedPreferences(checking.this).getString("Phone", "defaultStringIfNothingFound");
        DatabaseReference DatabaseUnaffected=FirebaseDatabase.getInstance().getReference("Users");
        DatabaseUnaffected.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    Intent intent = new Intent(getApplicationContext(), home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

                else{
                    Intent intent = new Intent(getApplicationContext(), login_user.class);
                    intent.putExtra("phonenumber", number);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

    }
}

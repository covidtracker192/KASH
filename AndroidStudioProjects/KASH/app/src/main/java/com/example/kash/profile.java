package com.example.kash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {
    TextView Number;
    TextView Name;
    TextView Age;
    TextView Gender;
    TextView Blood;
    TextView Emergency;
    TextView Condition;
    TextView posneg;
    ProgressBar progressBar;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String number = PreferenceManager.getDefaultSharedPreferences(profile.this).getString("Phone", "defaultStringIfNothingFound");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Number=(TextView) findViewById(R.id.textView6);
        Number.setText(number);
        Name = (TextView) findViewById(R.id.textView9);
        Age = (TextView) findViewById(R.id.textView11);
        Gender = (TextView) findViewById(R.id.textView15);
        Blood = (TextView) findViewById(R.id.textView13);
        Emergency= (TextView) findViewById(R.id.textView17);
        Condition = (TextView) findViewById(R.id.textView23);
        posneg=(TextView) findViewById(R.id.textView28);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);
        progressBar.setVisibility(View.VISIBLE);
        DatabaseReference DatabaseUnaffected=FirebaseDatabase.getInstance().getReference("Users");
        DatabaseUnaffected.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot datas: dataSnapshot.getChildren()){
                    String name = datas.child("name").getValue().toString();
                    Name.setText(name);
                    String age = datas.child("age").getValue().toString();
                    Age.setText(age);
                    String gender = datas.child("sex").getValue().toString();
                    Gender.setText(gender);
                    String blood = datas.child("blood").getValue().toString();
                    Blood.setText(blood);
                    String emergency = datas.child("emergency").getValue().toString();
                    Emergency.setText(emergency);
                    String condition = datas.child("condition").getValue().toString();
                    Condition.setText(condition);
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
        DatabaseReference Affected=FirebaseDatabase.getInstance().getReference("Affected");
        Affected.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    posneg.setText("Positive");
                    posneg.setBackgroundColor(Color.parseColor("#FF0000"));
                }

                else {
                    posneg.setText("Negative");
                    posneg.setBackgroundColor(Color.parseColor("#008000"));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void onBackPressed()
    {
        Intent intent = new Intent(profile.this, home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    };
}

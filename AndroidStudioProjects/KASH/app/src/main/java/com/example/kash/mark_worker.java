package com.example.kash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class mark_worker extends AppCompatActivity {
    DatabaseReference DatabaseUnaffected;
    DatabaseReference DatabaseAffected;
    String id;
    TextView Number;
    TextView Name;
    TextView Age;
    TextView Gender;
    TextView Blood;
    TextView Emergency;
    TextView Condition;
    ProgressBar progressBar;
    String newname, newage, newgender, newblood, newemergency, newcondition;
    String Mobile;
    private Button positive;
    private Button healthy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_worker);
        Mobile=getIntent().getStringExtra("phonenumber2");
        Number=(TextView) findViewById(R.id.textView6);
        Number.setText(Mobile);
        Name = (TextView) findViewById(R.id.textView9);
        Age = (TextView) findViewById(R.id.textView11);
        Gender = (TextView) findViewById(R.id.textView15);
        Blood = (TextView) findViewById(R.id.textView13);
        Emergency= (TextView) findViewById(R.id.textView17);
        Condition = (TextView) findViewById(R.id.textView19);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);
        progressBar.setVisibility(View.VISIBLE);
        healthy=(Button) findViewById(R.id.button4);
        positive = (Button) findViewById(R.id.button3);
        DatabaseUnaffected= FirebaseDatabase.getInstance().getReference("Users");
        DatabaseUnaffected.orderByChild("mobile").equalTo(Mobile).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()) {
                    for (DataSnapshot datas : dataSnapshot.getChildren()) {
                        id =datas.child("id").getValue().toString();
                        String name = datas.child("name").getValue().toString();
                        Name.setText(name);
                        newname = name;
                        String age = datas.child("age").getValue().toString();
                        Age.setText(age);
                        newage = age;
                        String gender = datas.child("sex").getValue().toString();
                        Gender.setText(gender);
                        newgender = gender;
                        String blood = datas.child("blood").getValue().toString();
                        Blood.setText(blood);
                        newblood = blood;
                        String emergency = datas.child("emergency").getValue().toString();
                        Emergency.setText(emergency);
                        newemergency = emergency;
                        String condition = datas.child("condition").getValue().toString();
                        newcondition = condition;
                        Condition.setText(condition);
                    }
                    progressBar.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(mark_worker.this, "No Patient Found", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    healthy.setEnabled(false);
                    positive.setEnabled(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

        //checking if user is positive or healthy
        DatabaseReference DatabaseUnaffected=FirebaseDatabase.getInstance().getReference("Unaffected");
        DatabaseUnaffected.orderByChild("mobile").equalTo(Mobile).addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    healthy.setEnabled(false);
                }

                else {
                    positive.setEnabled(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

        //healthy to positive

        positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference DatabaseUnaffected= FirebaseDatabase.getInstance().getReference("Unaffected");
                DatabaseUnaffected.orderByChild("mobile").equalTo(Mobile).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot datas: dataSnapshot.getChildren()){
                            datas.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                addUser();
            }
        });
        // positive to healthy

        healthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAffected= FirebaseDatabase.getInstance().getReference("Affected");
                DatabaseAffected.orderByChild("mobile").equalTo(Mobile).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot datas: dataSnapshot.getChildren()){
                            datas.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                DatabaseReference saveloc=FirebaseDatabase.getInstance().getReference("Locations");
                GeoFire geoFire = new GeoFire(saveloc);
                geoFire.removeLocation(id);

                addUser2();
            }
        });
    }
    //if user is marked positive
    private void addUser(){
        DatabaseAffected= FirebaseDatabase.getInstance().getReference().child("Affected");
        if (!TextUtils.isEmpty(newname) && !TextUtils.isEmpty(newage) && !TextUtils.isEmpty(newgender) && !TextUtils.isEmpty(newblood) && !TextUtils.isEmpty(newemergency) && !TextUtils.isEmpty(newcondition)) {
            unaffected User =new unaffected(id, Mobile, newname, newage, newgender, newblood, newemergency, newcondition);
            DatabaseAffected.child(id).setValue(User);
            Toast.makeText(this, "User Added", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(mark_worker.this, confirm.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }
    // if user is marked healthy
    private void addUser2(){
        DatabaseUnaffected= FirebaseDatabase.getInstance().getReference("Unaffected");
        if (!TextUtils.isEmpty(newname) && !TextUtils.isEmpty(newage) && !TextUtils.isEmpty(newgender) && !TextUtils.isEmpty(newblood) && !TextUtils.isEmpty(newemergency) && !TextUtils.isEmpty(newcondition)) {
            unaffected User =new unaffected(id, Mobile, newname, newage, newgender, newblood, newemergency, newcondition);
            DatabaseUnaffected.child(id).setValue(User);
            Toast.makeText(this, "User Added", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(mark_worker.this, confirm.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
    public void onBackPressed()
    {
        Intent intent = new Intent(mark_worker.this, patient_num.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    };
}

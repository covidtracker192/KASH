package com.example.kash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class settings extends AppCompatActivity {
private Button delete;
private Button update;
String Mobile;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final String number = PreferenceManager.getDefaultSharedPreferences(settings.this).getString("Phone", "defaultStringIfNothingFound");
        delete = (Button) findViewById(R.id.button11);
        update=(Button) findViewById(R.id.button6);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, update_profile.class);
                startActivity(intent);
                finish();
            }
        });

       delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DatabaseReference DatabaseUnaffected = FirebaseDatabase.getInstance().getReference("Unaffected");
               DatabaseUnaffected.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       if (dataSnapshot.getValue() != null) {
                           //Unaffected DB
                           user = FirebaseAuth.getInstance().getCurrentUser();
                           String uuid=user.getUid();
                           DatabaseReference DatabaseUnaffected= FirebaseDatabase.getInstance().getReference("Unaffected").child(uuid);
                           DatabaseUnaffected.addListenerForSingleValueEvent(new ValueEventListener() {
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

                           //User DB
                           DatabaseReference User= FirebaseDatabase.getInstance().getReference("Users").child(uuid);
                           User.addListenerForSingleValueEvent(new ValueEventListener() {
                               @Override
                               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                   for(DataSnapshot datas: dataSnapshot.getChildren()){
                                       datas.getRef().removeValue();
                                       Toast.makeText(settings.this, "User Deleted", Toast.LENGTH_LONG).show();
                                   }
                               }

                               @Override
                               public void onCancelled(@NonNull DatabaseError databaseError) {

                               }

                           });
                           stopService(new Intent(getApplicationContext(), Location_Services.class));
                           Intent intent = new Intent(settings.this, login_global.class);
                           startActivity(intent);
                           finish();
                           return;
                       }
                       else {
                           Toast.makeText(settings.this, "You are a positive patient!! Profile can't be Deleted", Toast.LENGTH_LONG).show();

                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }


               });


           }
       });

    };
    public void onBackPressed(){
        Intent intent = new Intent(settings.this, home.class);
        startActivity(intent);
        finish();
        return;

    };

}

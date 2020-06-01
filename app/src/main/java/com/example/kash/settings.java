package com.example.kash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class settings extends AppCompatActivity {
ImageView deletepos;
ImageView deleteneg;
ImageView update;
ImageView about;
ProgressBar pro;
String number;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        deletepos = findViewById(R.id.imageView3);
        deleteneg=findViewById(R.id.imageView6);
        update=findViewById(R.id.imageView4);
        about=findViewById(R.id.imageView5);
        pro=findViewById(R.id.progressBar2);
        pro.setVisibility(View.VISIBLE);

        number= PreferenceManager.getDefaultSharedPreferences(settings.this).getString("Phone", "defaultStringIfNothingFound");

        DatabaseReference Affected= FirebaseDatabase.getInstance().getReference("Unaffected");
        Affected.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    deleteneg.setVisibility(View.VISIBLE);
                    update.setVisibility(View.VISIBLE);
                    about.setVisibility(View.VISIBLE);
                }

                else {
                    deletepos.setVisibility(View.VISIBLE);
                    update.setVisibility(View.VISIBLE);
                    about.setVisibility(View.VISIBLE);
                }
                pro.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        deleteneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //public Dialog onCreateDialog(Bundle savedInstanceState){
                new AlertDialog.Builder(settings.this)
                        .setTitle("Delete Profile")
                        .setMessage("Are you sure you want to delete your profile?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete
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
                                Intent service = new Intent(getApplicationContext(), locationupdate.class);
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

                                    settings.this.stopService(service);
                                }
                                else{
                                    stopService(service);
                                }
                                Intent intent = new Intent(settings.this, login_global.class);
                                startActivity(intent);
                                finish();

                            }
                        })
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Cancel", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        deletepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(settings.this)
                        .setTitle("COVID-19 Positive")
                        .setMessage("You are a positive patient!! Profile can't be deleted.")

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Ok", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, update_profile.class);
                startActivity(intent);
                finish();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, About.class);
                startActivity(intent);
                finish();
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

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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class update_profile extends AppCompatActivity {
    TextView Number;
    TextView Name;
    TextView Age;
    TextView Gender;
    TextView Blood;
    EditText Emergency;
    EditText Condition;
    ProgressBar progressBar;
    String number;
    ImageView update;
    // ProgressBar progressBar;
    String newname, newage, newgender, newblood, newemergency, newcondition;
    String Mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        Number=findViewById(R.id.mobile2);
        Name = findViewById(R.id.mobile);
        Age = findViewById(R.id.mobile4);
        Gender = findViewById(R.id.mobile5);
        Blood =findViewById(R.id.mobile6);
        Emergency = findViewById(R.id.emergency);
        Condition = findViewById(R.id.Information);
        number= PreferenceManager.getDefaultSharedPreferences(update_profile.this).getString("Phone", "defaultStringIfNothingFound");
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        update=findViewById(R.id.imageView9);

        DatabaseReference User= FirebaseDatabase.getInstance().getReference("Users");
        User.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot datas : dataSnapshot.getChildren()) {
                        String number=datas.child("mobile").getValue().toString();
                        Number.setText(number);
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
                        String condition = datas.child("condition").getValue().toString();
                        Condition.setText(condition);
                    }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.exit(0);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newemergency = Emergency.getText().toString();
                newcondition = Condition.getText().toString();
                DatabaseReference DatabaseUnaffected = FirebaseDatabase.getInstance().getReference("Unaffected");
                DatabaseUnaffected.orderByChild("mobile").equalTo(number).addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getValue() != null){
                            if (!TextUtils.isEmpty(newemergency) && !TextUtils.isEmpty(newcondition)) {
                                String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                DatabaseReference Unaffected = FirebaseDatabase.getInstance().getReference("Unaffected").child(user.getUid());
                                unaffected User = new unaffected(id, number, newname, newage, newgender, newblood, newemergency, newcondition);
                                Unaffected.setValue(User);
                            }
                            else {
                                Toast.makeText(update_profile.this, "Fill the missing details!", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            if (!TextUtils.isEmpty(newemergency) && !TextUtils.isEmpty(newcondition)) {
                                String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                DatabaseReference Affected = FirebaseDatabase.getInstance().getReference("Affected").child(user.getUid());
                                unaffected User = new unaffected(id, number, newname, newage, newgender, newblood, newemergency, newcondition);
                                Affected.setValue(User);
                            }
                            else {
                                Toast.makeText(update_profile.this, "Fill the missing details!", Toast.LENGTH_LONG).show();
                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (!TextUtils.isEmpty(newemergency) && !TextUtils.isEmpty(newcondition)) {
                    String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    DatabaseReference Userdata = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
                    unaffected User = new unaffected(id, number, newname, newage, newgender, newblood, newemergency, newcondition);
                    Userdata.setValue(User);

                    Toast.makeText(update_profile.this, "Profile Updated", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(update_profile.this, settings.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(update_profile.this, "Fill the missing details!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void onBackPressed()
    {
        Intent intent = new Intent(update_profile.this, settings.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    };
}

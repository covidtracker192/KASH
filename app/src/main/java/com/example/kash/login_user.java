package com.example.kash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login_user extends AppCompatActivity {
    String mobile;
    TextView mobile2;
    EditText name;
    EditText age;
    EditText Emergency;
    EditText Condition;
    ImageView submit;
    Spinner dropdown;
    Spinner dropdown2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        //to get mobile number
        mobile= PreferenceManager.getDefaultSharedPreferences(login_user.this).getString("Phone", "defaultStringIfNothingFound");
        mobile2=findViewById(R.id.mobile);
        mobile2.setText(mobile);
        name = findViewById(R.id.Name);
        age = findViewById(R.id.age);
        Emergency = findViewById(R.id.emergency);
        Condition = findViewById(R.id.Information);
        dropdown= findViewById(R.id.sex);
        String[] gender = new String[]{"Gender","Male", "Female", "Others", "Rather Not Specify"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);
        dropdown.setAdapter(adapter);
        dropdown2 = findViewById(R.id.blood);
        String[] grp = new String[]{"Blood Group","A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, grp);
        dropdown2.setAdapter(adapter2);
        submit= findViewById(R.id.imageView15);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }
    private void addUser(){
        String Mobile = mobile2.getText().toString();
        String Name = name.getText().toString();
        String Age = age.getText().toString();
        String Sex=dropdown.getSelectedItem().toString();
        String Blood=dropdown2.getSelectedItem().toString();
        String emergency = Emergency.getText().toString();
        String condition = Condition.getText().toString();

        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Age) && !TextUtils.isEmpty(Sex) && !TextUtils.isEmpty(Blood) && !TextUtils.isEmpty(emergency) && !TextUtils.isEmpty(condition)) {
            FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
            String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
            DatabaseReference Userdata=FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
            unaffected User =new unaffected(id, Mobile, Name, Age, Sex, Blood, emergency, condition);
            Userdata.setValue(User);
            DatabaseReference Unaffected =FirebaseDatabase.getInstance().getReference("Unaffected").child(user.getUid());
            unaffected data =new unaffected(id, Mobile, Name, Age, Sex, Blood, emergency, condition);
            Unaffected.setValue(data);
            Toast.makeText(this, "User Added", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(login_user.this, home.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Fill the missing details!", Toast.LENGTH_LONG).show();
        }
    }
    public void onBackPressed(){
        Intent intent = new Intent(login_user.this, login_global.class);
        startActivity(intent);
        finish();
    }
}
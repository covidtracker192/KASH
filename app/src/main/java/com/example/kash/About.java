package com.example.kash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Layout;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        about=findViewById(R.id.textabout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            about.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        about.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onBackPressed(){
        Intent intent = new Intent(About.this, settings.class);
        startActivity(intent);
        finish();
        return;

    };
}

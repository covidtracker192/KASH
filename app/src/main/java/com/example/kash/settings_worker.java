package com.example.kash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class settings_worker extends AppCompatActivity {
ImageView update;
ImageView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_worker);

        update=findViewById(R.id.imageView20);
        about=findViewById(R.id.imageView21);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings_worker.this, about_worker.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(settings_worker.this, password_change.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(settings_worker.this, worker_home.class);
        startActivity(intent);
        finish();
        return;

    };
}

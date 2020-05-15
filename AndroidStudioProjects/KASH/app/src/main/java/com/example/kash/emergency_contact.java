package com.example.kash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class emergency_contact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact);

        TextView nhn;
        nhn=findViewById(R.id.textView36);
        nhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+911800112545"));
                startActivity(intent);
            }
        });

        TextView khn;
        khn=findViewById(R.id.textView39);
        khn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918046848600"));
                startActivity(intent);
            }
        });

        TextView cf;
        cf=findViewById(R.id.textView41);
        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91112"));
                startActivity(intent);
            }
        });

        TextView farmer;
        farmer=findViewById(R.id.textView43);
        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918022212818"));
                startActivity(intent);
            }
        });

        TextView food;
        food=findViewById(R.id.textView45);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91155214"));
                startActivity(intent);
            }
        });

        TextView ola;
        ola=findViewById(R.id.textView47);
        ola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919154153917"));
                startActivity(intent);
            }
        });

        TextView task;
        task=findViewById(R.id.textView49);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919946499464"));
                startActivity(intent);
            }
        });

        TextView hd;
        hd=findViewById(R.id.textView51);
        hd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918061914960"));
                startActivity(intent);
            }
        });

        TextView symp;
        symp=findViewById(R.id.textView53);
        symp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+9114410"));
                startActivity(intent);
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////
        TextView bengurb;
        bengurb=findViewById(R.id.textView56);
        bengurb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918022967200"));
                startActivity(intent);
            }
        });

        TextView bengrur;
        bengrur=findViewById(R.id.textView58);
        bengrur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918029781021"));
                startActivity(intent);
            }
        });

        TextView bagal;
        bagal=findViewById(R.id.textView90);
        bagal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918354236240"));
                startActivity(intent);
            }
        });

        TextView belga;
        belga=findViewById(R.id.textView94);
        belga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918312407290"));
                startActivity(intent);
            }
        });

        TextView bell;
        bell=findViewById(R.id.textView92);
        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918392277100"));
                startActivity(intent);
            }
        });

        TextView bid;
        bid=findViewById(R.id.textView60);
        bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+9118004254316"));
                startActivity(intent);
            }
        });

        TextView cham;
        cham=findViewById(R.id.textView62);
        cham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+9180226223160"));
                startActivity(intent);
            }
        });

        TextView chik;
        chik=findViewById(R.id.textView64);
        chik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+9180262238950"));
                startActivity(intent);
            }
        });

        TextView chit;
        chit=findViewById(R.id.textView68);
        chit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918194222056"));
                startActivity(intent);
            }
        });

        TextView dak;
        dak=findViewById(R.id.textView98);
        dak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918242442590"));
                startActivity(intent);
            }
        });

        TextView dav;
        dav=findViewById(R.id.textView70);
        dav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918191234034"));
                startActivity(intent);
            }
        });

        TextView dhar;
        dhar=findViewById(R.id.textView72);
        dhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918362447547"));
                startActivity(intent);
            }
        });

        TextView gad;
        gad=findViewById(R.id.textView74);
        gad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918372239177"));
                startActivity(intent);
            }
        });

        TextView has;
        has=findViewById(R.id.textView76);
        has.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918172261111"));
                startActivity(intent);
            }
        });

        TextView hav;
        hav=findViewById(R.id.textView78);
        hav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918375249102"));
                startActivity(intent);
            }
        });

        TextView kala;
        kala=findViewById(R.id.textView80);
        kala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918472278698"));
                startActivity(intent);
            }
        });

        TextView koda;
        koda=findViewById(R.id.textView88);
        koda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918272220606"));
                startActivity(intent);
            }
        });

        TextView kol;
        kol=findViewById(R.id.textView84);
        kol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918152243521"));
                startActivity(intent);
            }
        });

        TextView kopp;
        kopp=findViewById(R.id.textView86);
        kopp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918539225001"));
                startActivity(intent);
            }
        });

        TextView man;
        man=findViewById(R.id.textView96);
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+9182322924655"));
                startActivity(intent);
            }
        });

        TextView mys;
        mys=findViewById(R.id.textView100);
        mys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918212423800"));
                startActivity(intent);
            }
        });

        TextView rai;
        rai=findViewById(R.id.textView102);
        rai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918532228559"));
                startActivity(intent);
            }
        });

        TextView rama;
        rama=findViewById(R.id.textView104);
        rama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918277517672"));
                startActivity(intent);
            }
        });

        TextView shiv;
        shiv=findViewById(R.id.textView106);
        shiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918182221010"));
                startActivity(intent);
            }
        });

        TextView utt;
        utt=findViewById(R.id.textView82);
        utt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918382229857"));
                startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        Intent intent = new Intent(emergency_contact.this, home.class);
        startActivity(intent);
        finish();
    }
}

package org.atctech.al_quranbangla;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.atctech.al_quranbangla.Utilities.GPSTracker;

public class MainActivity extends AppCompatActivity {

    private CardView viewQuran,kiblaDirection,viewRamjan,tasbeeh,namazTimeShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(1);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar ().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        AlarmManagerUtil alarmUtil = new AlarmManagerUtil();
        alarmUtil.initAlarmNotification(this);
        viewQuran = findViewById(R.id.viewQuran);
        kiblaDirection = findViewById(R.id.kiblaDirection);
        viewRamjan = findViewById(R.id.viewRamjan);
        tasbeeh = findViewById(R.id.tasbeeh);
        namazTimeShow = findViewById(R.id.namazTimeShow);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"AponaLohit.ttf");
        TextView quranshikhun = findViewById(R.id.quranShikhunBN);
        TextView ramjanTime = findViewById(R.id.ramjanTime);
        TextView kiblaDir = findViewById(R.id.kiblaDirText);
        TextView tasbeehText = findViewById(R.id.tasbeehText);
        TextView namazTime = findViewById(R.id.namazTime);
        quranshikhun.setTypeface(typeface);
        ramjanTime.setTypeface(typeface);
        kiblaDir.setTypeface(typeface);
        tasbeehText.setTypeface(typeface);
        namazTime.setTypeface(typeface);



//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},100);
//        }else {
//            locationintent = new Intent(this, GPSTracker.class);
//            startService(locationintent);
//        }


//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.move_to_left_text);
//        viewQuran.setAnimation(animation);

        viewQuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,QuranActivity.class));
                overridePendingTransition(R.anim.enter_from_left,R.anim.exit_out_left);
            }
        });

        kiblaDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CompassActivity.class));
                overridePendingTransition(R.anim.enter_from_left,R.anim.exit_out_left);
            }
        });

        viewRamjan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RamadanTimeActivity.class));
                overridePendingTransition(R.anim.enter_from_left,R.anim.exit_out_left);
            }
        });


        tasbeeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TasbeehActivity.class));
                overridePendingTransition(R.anim.enter_from_left,R.anim.exit_out_left);

            }
        });

        namazTimeShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NamazTimeActivity.class));
                overridePendingTransition(R.anim.enter_from_left,R.anim.exit_out_left);
            }
        });

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(MainActivity.this).setTitle("Exit")
                .setMessage("Are you sure you want to Exit ?")
                .setIcon(R.drawable.ic_exit_to_app_black_24dp)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }

}

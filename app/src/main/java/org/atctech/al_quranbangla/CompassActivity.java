package org.atctech.al_quranbangla;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.atctech.al_quranbangla.Utilities.CompassSensor;
import org.atctech.al_quranbangla.Utilities.GPSTracker;

public class CompassActivity extends AppCompatActivity implements SensorListener {

    private RelativeLayout direcCantainer;
    Context context;
    SensorManager sensorManager;
    static final int sensor = SensorManager.SENSOR_ORIENTATION;
    private CompassSensor compassSensor;
    View view;
    public  static double degree;
    GPSTracker gps;
    double latitude =23.7568691;
    double longitude = 90.3795441;
    double Qlati=21.42243;
    double Qlongi=39.82624;
    TextView degreeQibla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);



        LocalBroadcastManager.getInstance(this).registerReceiver(
                new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        latitude = Double.parseDouble(intent.getStringExtra(GPSTracker.EXTRA_LATITUDE));
                        longitude = Double.parseDouble(intent.getStringExtra(GPSTracker.EXTRA_LONGITUDE));

                    }
                }, new IntentFilter(GPSTracker.ACTION_LOCATION_BROADCAST)
        );
//        getSupportActionBar ().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar ().setCustomView(R.layout.custom_action_bar_2);
        getSupportActionBar().setTitle("কিবলা নির্ধারণ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context=this;
        direcCantainer = findViewById(R.id.cantainer_layout);
        degreeQibla = findViewById(R.id.idDegree);
        compassSensor = new CompassSensor(context);
        degree= CalculateDegree(latitude, longitude, Qlati, Qlongi);
        direcCantainer.addView(compassSensor);
        compassSensor.invalidate();
        sensorManager = (SensorManager)getSystemService(context.SENSOR_SERVICE);
        degreeQibla.setText(String.format("%.2f", degree)+ (char) 0x00B0);

        //Toast.makeText(this, String.valueOf(latitude) +" "+ String.valueOf(longitude), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onResume() {
//

        super.onResume();
        sensorManager.registerListener(this, sensor);
    }
    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(int sensor, float[] values) {
        if (sensor != CompassActivity.sensor)
            return;
        int orientation = (int) values[0];
        compassSensor.setDirections(orientation, orientation);
    }
    @Override
    public void onAccuracyChanged(int sensor, int accuracy) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                overridePendingTransition(R.anim.enter_from_right,R.anim.exit_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    //Calculating degree from current location and qibla location
    protected double CalculateDegree(double startLat, double startLng, double endLat, double endLng){
        double longitude1 = startLng;
        double longitude2 = endLng;
        double latitude1 = Math.toRadians(startLat);
        double latitude2 = Math.toRadians(endLat);
        double longDiff= Math.toRadians(longitude2 - longitude1);
        double y= Math.sin(longDiff)* Math.cos(latitude2);
        double x= Math.cos(latitude1)* Math.sin(latitude2)- Math.sin(latitude1)* Math.cos(latitude2)* Math.cos(longDiff);

        return (Math.toDegrees(Math.atan2(y, x))+360)%360;


    }

}

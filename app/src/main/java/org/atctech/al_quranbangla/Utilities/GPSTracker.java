package org.atctech.al_quranbangla.Utilities;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class GPSTracker extends Service implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    public static final int LOCATION_INTERVAL = 10000;
    public static final int FASTEST_LOCATION_INTERVAL = 1000;
    public static final String ACTION_LOCATION_BROADCAST = GPSTracker.class.getName() + "LocationBroadcast";
    public static final String EXTRA_LATITUDE = "extra_latitude";
    public static final String EXTRA_LONGITUDE = "extra_longitude";
    private static final String TAG = GPSTracker.class.getSimpleName();
    GoogleApiClient mLocationClient;
    LocationRequest mLocationRequest = new LocationRequest();
    double latitude;
    double longitude;
    Location location;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mLocationClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();


        mLocationRequest.setInterval(LOCATION_INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_LOCATION_INTERVAL);


        int priority = LocationRequest.PRIORITY_HIGH_ACCURACY; //by default
        //PRIORITY_BALANCED_POWER_ACCURACY, PRIORITY_LOW_POWER, PRIORITY_NO_POWER are the other priority modes


        mLocationRequest.setPriority(priority);
        mLocationClient.connect();


        //Make it stick to the notification panel so it is less prone to get cancelled by the Operating System.
        return START_STICKY;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /*
     * LOCATION CALLBACKS
     */
    @SuppressLint("MissingPermission")
    @Override
    public void onConnected(Bundle dataBundle) {

        LocationServices.FusedLocationApi.requestLocationUpdates(mLocationClient, mLocationRequest, (com.google.android.gms.location.LocationListener) this);

        Log.d(TAG, "Connected to Google API");
    }

    /*
     * Called by Location Services if the connection to the
     * location client drops because of an error.
     */
    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "Connection suspended");
    }


    //to get the location change
    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "Location changed");


        if (location != null) {

            latitude = location.getLatitude();
            longitude = location.getLongitude();

            sendLocationToUI(latitude, longitude);


        } else {
            Log.e(TAG, "Location is null");
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "Failed to connect to Google API");

    }

    public double getLatitude() {
        if (location != null) {
            latitude = location.getLatitude();
        }

        // return latitude
        return latitude;
    }

    /**
     * Function to get longitude
     */
    public double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }

        // return longitude
        return longitude;
    }

    private void sendLocationToUI(double lat, double lng) {

        Log.d(TAG, "Sending info...");

        Intent intent = new Intent(ACTION_LOCATION_BROADCAST);
        intent.putExtra(EXTRA_LATITUDE, lat);
        intent.putExtra(EXTRA_LONGITUDE, lng);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);


    }

}
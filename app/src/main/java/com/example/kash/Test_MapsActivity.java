package com.example.kash;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Test_MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng latLng;
    private FusedLocationProviderClient fusedLocationClient;
    private SupportMapFragment mapFragment;
    LocationRequest mLocationRequest;
    Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(30000);
        mLocationRequest.setFastestInterval(30000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        mMap.setMyLocationEnabled(true);

        // Test Center 1
        final LatLng center1 = new LatLng(12.959485, 77.574737);
        mMap.addMarker(new MarkerOptions().position(center1).title("Bangalore Medical College & Research Institute, Bengaluru").snippet("website: http://www.bmcri.org/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center1));

        //Test Center 2
        final LatLng center2 = new LatLng(12.964658, 77.628138);
        mMap.addMarker(new MarkerOptions().position(center2).title("Command Hospital (Air Force), Bengaluru").snippet("website: https://www.chaf-b.org/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center2));

        //Test Center 3
        final LatLng center3 = new LatLng(12.937347, 77.590940);
        mMap.addMarker(new MarkerOptions().position(center3).title("National Institute of Virology, Bangalore Field Unit, Bengaluru"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center3));

        //Test Center 4
        final LatLng center4 = new LatLng(12.975883, 77.729613);
        mMap.addMarker(new MarkerOptions().position(center4).title("Vydehi Institute Of Medical Sciences And Research Centre").snippet("website: http://www.vims.ac.in/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center4));

        //Test Center 5
        final LatLng center5 = new LatLng(12.940737, 77.598334);
        mMap.addMarker(new MarkerOptions().position(center5).title("National Institute of Mental Health and Neuro Sciences, Bangalore").snippet("website: http://nimhans.ac.in/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center5));

        //Test Center 6
        final LatLng center6 = new LatLng(12.932303, 77.685265);
        mMap.addMarker(new MarkerOptions().position(center6).title("Sakra World Hospital Lab Services, Devarabeesanahalli Varthur, Hobli").snippet("website: https://www.sakraworldhospital.com/lab-medicine.php"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center6));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(6));

        //Test Center 7
        final LatLng center7 = new LatLng(12.896058, 77.5995201);
        mMap.addMarker(new MarkerOptions().position(center7).title("Apollo Hospitals Bannerghatta").snippet("website: https://bangalore.apollohospitals.com/bannerghattaroad/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center7));

        //Test Center 8
        final LatLng center8 = new LatLng(13.932749, 75.566971);
        mMap.addMarker(new MarkerOptions().position(center8).title("SHIMOGA Institute of Medical Sciences (SIMS)").snippet("website: https://sims-shimoga.com/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center8));

        //Test Center 9
        final LatLng center9 = new LatLng(12.315320, 76.650410);
        mMap.addMarker(new MarkerOptions().position(center9).title("Mysore Medical College And Research Institute").snippet("website: https://www.mysoremedicalcollege.com/"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center9));

        //Test Center 10
        final LatLng center10 = new LatLng(12.867458, 74.843262);
        mMap.addMarker(new MarkerOptions().position(center10).title("Wenlock District Hospital, Mangalore"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center10));
      //  mMap.animateCamera(CameraUpdateFactory.zoomTo(6));



        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if(marker.getPosition().equals(center1)) {
                    Uri uriUrl = Uri.parse("http://www.bmcri.org/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center2)) {
                    Uri uriUrl = Uri.parse("https://www.chaf-b.org/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }

                else if(marker.getPosition().equals(center4)) {
                    Uri uriUrl = Uri.parse("http://www.vims.ac.in/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center5)) {
                    Uri uriUrl = Uri.parse("http://nimhans.ac.in/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center6)) {
                    Uri uriUrl = Uri.parse("https://www.sakraworldhospital.com/lab-medicine.php");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center7)) {
                    Uri uriUrl = Uri.parse("https://bangalore.apollohospitals.com/bannerghattaroad/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center8)) {
                    Uri uriUrl = Uri.parse("https://sims-shimoga.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center9)) {
                    Uri uriUrl = Uri.parse("https://www.mysoremedicalcollege.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }

            }
        });
    }
    LocationCallback mLocationCallback=new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location1 : locationResult.getLocations()) {
                if (getApplicationContext() != null) {
                    mLastLocation = location1;
                    latLng = new LatLng(location1.getLatitude(), location1.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
                }
            }

        }
    };
    public void onBackPressed(){
        stopService(new Intent(getApplicationContext(), Location_Services.class));
        Intent intent = new Intent(Test_MapsActivity.this, home.class);
        startActivity(intent);
        finish();
        return;

    };
}

package com.example.kash;

import androidx.fragment.app.FragmentActivity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class UserMapsActivity extends FragmentActivity implements OnMapReadyCallback{
    LatLng latLng;
    private GoogleMap nMap;
    private FusedLocationProviderClient fusedLocationClient;
    private SupportMapFragment mapFragment;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    String uuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_maps);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        nMap = googleMap;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(30000);
        mLocationRequest.setFastestInterval(30000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        nMap.setMyLocationEnabled(true);


    }
    LocationCallback mLocationCallback=new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location1 : locationResult.getLocations()) {
                if (getApplicationContext() != null) {
                    mLastLocation = location1;
                    latLng = new LatLng(location1.getLatitude(), location1.getLongitude());
                    nMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    nMap.animateCamera(CameraUpdateFactory.zoomTo(15));

                    if(!getpatientsaround){
                        positive();
                    }
                }
            }

        }
    };

    public void onBackPressed()
    {
        Intent intent = new Intent(UserMapsActivity.this, home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    };
    boolean getpatientsaround=false;
    List<Marker> markerList=new ArrayList<Marker>();
    private void positive(){
        getpatientsaround=true;
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        uuid=user.getUid();
        DatabaseReference positiveloc=FirebaseDatabase.getInstance().getReference().child("Locations");
        GeoFire geoFire=new GeoFire(positiveloc);
        GeoQuery geoQuery =geoFire.queryAtLocation(new GeoLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude()), 0.1);
        geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, GeoLocation location) {
                for (Marker markerIt : markerList) {
                    if (markerIt.getTag().equals(key)) {
                        return;
                    }
                }
                LatLng patLocation=new LatLng(location.latitude,location.longitude);
                if(!key.equals(uuid)) {
                    Marker mpatient = nMap.addMarker(new MarkerOptions().position(patLocation).title("Affected"));
                    mpatient.setTag(key);
                    markerList.add(mpatient);
                }
            }

            @Override
            public void onKeyExited(String key) {
                for(Marker markerIt: markerList) {
                    if(markerIt.getTag().equals(key)){
                        markerIt.remove();
                        markerList.remove(markerIt);
                        markerIt.remove();
                        return;
                    }
                }

            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {
                for(Marker markerIt: markerList) {
                    if(markerIt.getTag().equals(key)) {
                        markerIt.setPosition(new LatLng(location.latitude,location.longitude));
                    }
                }
            }

            @Override
            public void onGeoQueryReady() {

            }

            @Override
            public void onGeoQueryError(DatabaseError error) {

            }
        });
    };

}

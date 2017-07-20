package com.poojanshah.json_fist_application;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.poojanshah.json_fist_application.Injection.components.APIComponent;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor_Impl;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor_Impl2;
import com.poojanshah.json_fist_application.model.JustEat;
import com.poojanshah.json_fist_application.model.Restaurant;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

//    @Inject
//    Interactor_Impl interactor_;

    private GoogleMap mMap;

//    ArrayList<LatLng> latLngs;

    Interactor_Impl2 interactor_2;

    JustEat justEat;


    public MapsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        interactor_2 = new Interactor_Impl2();

//        Bundle extras = getIntent().getExtras();
//        latLngs = new ArrayList<>();
//
//        if (extras != null) {
//            latLngs = (ArrayList<LatLng>) extras.get("justEat");
//        }

    }

    private void OnError(Throwable throwable) {
        Log.i("Maps Throwable", throwable.getMessage());
        Log.i("Maps Throwable", String.valueOf(throwable.getCause()));
    }

    private void onSuccess(JustEat justEat) {
                for(Restaurant restaurant: justEat.getRestaurants()){
            Log.i("restaurant.getName()", restaurant.getName());
                    LatLng sydney = new LatLng(restaurant.getLatitude(),restaurant.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(sydney)).setTitle(restaurant.getName());
        }
        this.justEat = justEat;

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        for(LatLng l:latLngs){
////            Log.i("onMapReady", l.longitude + " " + l.latitude);
//            LatLng sydney = new LatLng(l.latitude,l.longitude);
//            mMap.addMarker(new MarkerOptions().position(sydney));
//        }

        interactor_2.getCakeList().observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}

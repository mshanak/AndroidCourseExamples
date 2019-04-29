package com.mshanak.adroidcourseexamples;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class LocationActivity extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationClient;
    TextView lat,lng;
    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        lat=findViewById(R.id.loc_lat);
        lng=findViewById(R.id.loc_long);
        submit_btn=findViewById(R.id.loc_btn_getLocation);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocation();
            }
        });
    }


    void getCurrentLocation() {
        Toast.makeText(LocationActivity.this,"getting location",Toast.LENGTH_SHORT).show();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            Toast.makeText(LocationActivity.this,"[Done] getting location",Toast.LENGTH_SHORT).show();

                            // Logic to handle location object
                            lat.setText(location.getLatitude()+"");
                            lng.setText("lng: "+location.getLongitude());

                        }
                    }
                });
    }


    boolean CheckLocationPermitions(){
//        if(ContextCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
//            if(ActivityCompat.shouldShowRequestPermissionRationale(LocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)){
//
//            }else{
//                ActivityCompat.requestPermissions(LocationActivity.this, new String[]{
//                        Manifest.permission.ACCESS_COARSE_LOCATION
//                },MY_PER);
//}
//            }
//        }





        return false;
    }

    void requestLocationPermitions(){

    }
}

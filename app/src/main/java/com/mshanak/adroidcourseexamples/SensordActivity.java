package com.mshanak.adroidcourseexamples;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SensordActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    List<Sensor> sensorList;
    ListView list_view;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensord);
        arrayList=new ArrayList<>();
        list_view=findViewById(R.id.sensors_list);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i=0;i<sensorList.size();i++){
            String data=sensorList.get(i).getName();
            arrayList.add(data);
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        list_view.setAdapter(arrayAdapter);
    }
}

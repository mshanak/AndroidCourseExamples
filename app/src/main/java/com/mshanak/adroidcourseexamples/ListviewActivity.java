package com.mshanak.adroidcourseexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListviewActivity extends AppCompatActivity {
    String[] coutries={"India","KAS","UAE","Oman"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        MyCustomAdapter adapter=new MyCustomAdapter(this,R.layout.activity_listview,this.coutries);

        ListView list1=(ListView)findViewById(R.id.countries_list);
        list1.setAdapter(adapter);

    }
}

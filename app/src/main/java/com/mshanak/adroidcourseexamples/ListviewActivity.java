package com.mshanak.adroidcourseexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {
    ArrayList<Country> countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        /**
         * Add data to the countries array
         */
        this.countries=new ArrayList<Country>();
        countries.add(new Country("Canada","Capital: Ottawa, Population: 35,295,770",R.drawable.ca));
        countries.add(new Country("The United Kingdom","Capital: London, Population: 63,705,000",R.drawable.gb));

        countries.add(new Country("Japan","Capital: Tokyo, Population: 127,180,000",R.drawable.jp));
        countries.add(new Country("The United States","Capital: Washington, Population: 317,706,000",R.drawable.us));
        countries.add(new Country("France","Capital: Paris, Population:65,844,000",R.drawable.fr));


        /**
         * User a custom adapter to display items of the list
         */
        MyCustomAdapter adapter=new MyCustomAdapter(this,R.layout.activity_listview,countries);
        ListView list1=(ListView)findViewById(R.id.countries_list);
        list1.setAdapter(adapter);

        /**
         * register a context menu to be show when the user long tap the item.
          */
        registerForContextMenu(list1);

     }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       menu.setHeaderTitle("More options");
        menu.add(0,v.getId(),0,"Show in Map");
        menu.add(0,v.getId(),0,"Wikipedia");
    }
}

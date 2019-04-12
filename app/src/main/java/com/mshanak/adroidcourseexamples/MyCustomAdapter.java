package com.mshanak.adroidcourseexamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter  extends ArrayAdapter<String> {

    ArrayList<Country>  countries;


    public MyCustomAdapter( Context context, int resource, ArrayList<Country> countries) {
        super(context, resource);
        this.countries=countries;
    }

    @Override
    public int getCount() {
        return this.countries.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.list_row_item, parent, false);
        TextView country_name=convertView.findViewById(R.id.listview_country_name);
        country_name.setText(countries.get(position).Name);

        TextView country_description=convertView.findViewById(R.id.country_desc);
        country_description.setText(countries.get(position).Description);

        ImageView image=convertView.findViewById(R.id.country_flag);
        image.setImageResource(countries.get(position).image);
        return convertView;
    }


}

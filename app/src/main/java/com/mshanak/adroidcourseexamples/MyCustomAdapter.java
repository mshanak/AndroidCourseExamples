package com.mshanak.adroidcourseexamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MyCustomAdapter  extends ArrayAdapter<String> {

    String[] countries;


    public MyCustomAdapter( Context context, int resource, String[] countries) {
        super(context, resource);
        this.countries=countries;
    }

    @Override
    public int getCount() {
        return this.countries.length;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.list_row_item, parent, false);

        return convertView;
    }


}

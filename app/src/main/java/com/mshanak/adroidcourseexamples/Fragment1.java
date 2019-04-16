package com.mshanak.adroidcourseexamples;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }

    private onItemSelectedInterface listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment1,null,false);


        return view;
    }

    private void  sendMessage(){
        this.listener.passDataToOtherFragment("mahdi value ");
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof onItemSelectedInterface){
            listener=(onItemSelectedInterface)context;
        }else {

        }
    }
}


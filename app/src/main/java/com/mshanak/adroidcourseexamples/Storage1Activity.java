package com.mshanak.adroidcourseexamples;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Storage1Activity extends AppCompatActivity {

SharedPreferences sharedPreferences;



    Button btn_save,btn_fetch;
    EditText input1,input2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage1);

        btn_save =findViewById(R.id.storage1_btn);
        btn_fetch =findViewById(R.id.storage1_btn2);
        input1=findViewById(R.id.stg1_i1);
        input2=findViewById(R.id.stg1_i2);

        sharedPreferences=getSharedPreferences("myprefernce", Context.MODE_PRIVATE);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",input1.getText().toString());
                editor.putString("age",input2.getText().toString());
                editor.commit();

                Toast.makeText(Storage1Activity.this,"Data submited succesfuly",Toast.LENGTH_SHORT).show();
            }
        });



        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name =sharedPreferences.getString("name","");
                String age =sharedPreferences.getString("age","");

                input1.setText(name);
                input2.setText(age);
                Toast.makeText(Storage1Activity.this,"Data fetched succesfuly",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

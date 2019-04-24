package com.mshanak.adroidcourseexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorInputActivity extends AppCompatActivity {
    Button input_send_btn;
    EditText input_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_input);

        input_send_btn=findViewById(R.id.input_send_btn);
        input_value=findViewById(R.id.input_value);


        input_send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  getIntent();
                String tag=intent.getStringExtra("name");


                Intent sendIntent=new Intent(CalculatorInputActivity.this,CalculatorMainActivity.class);
                if(tag.equals("height")){
                    sendIntent.putExtra("height",input_value.getText().toString());
                    setResult(CalculatorMainActivity.requestCode,sendIntent);
                    finish();
                }else{
                    sendIntent.putExtra("width",input_value.getText().toString());
                    setResult(CalculatorMainActivity.requestCode,sendIntent);
                    finish();
                }


            }
        });
    }
}

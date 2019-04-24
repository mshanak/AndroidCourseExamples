package com.mshanak.adroidcourseexamples;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorMainActivity extends AppCompatActivity {
    Button height_btn;
    Button width_btn;
    Button calculate_btn;
   static int requestCode=0;

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);


        height_btn =findViewById(R.id.cbtn1);
        width_btn =findViewById(R.id.cbtn2);
        calculate_btn=findViewById(R.id.cresultbtn);
        result=findViewById(R.id.cresulttxt);


        height_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorMainActivity.this,CalculatorInputActivity.class);
                intent.putExtra("name","height");
                startActivityForResult(intent,requestCode);
            }
        });
        width_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorMainActivity.this,CalculatorInputActivity.class);
                intent.putExtra("name","width");
                startActivityForResult(intent,requestCode);

            }
        });

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input1=Integer.parseInt(height_btn.getText().toString());
                int input2=Integer.parseInt(width_btn.getText().toString());
                int area=input1*input2;
                result.setText("Area: "+area);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data!=null && resultCode==requestCode){
            Bundle b=data.getExtras();
            if(b.getString("height")!=null){
                String value=data.getStringExtra(("height"));
                height_btn.setText(value);
            }else if(b.getString("width")!=null){
                String value=data.getStringExtra(("width"));
                width_btn.setText(value);
            }

        }
    }
}

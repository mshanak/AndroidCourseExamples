package com.mshanak.adroidcourseexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class HttpExampleActivity extends AppCompatActivity {
    private String url="http://hunnyjain2792.000webhostapp.com/cdac/index.php";
    private String Send_url="http://hunnyjain2792.000webhostapp.com/cdac/post.php";

    EditText Name_text, Age_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_example);
    Name_text =findViewById(R.id.h_name);
    Age_text =findViewById(R.id.h_age);
    }

    public void show(View view){
        StringRequest request =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(HttpExampleActivity.this, response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HttpExampleActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(HttpExampleActivity.this);
        requestQueue.add(request);
    }



    public void Send(View view){

        final String _name= Name_text.getText().toString();
       final String _age= Age_text.getText().toString();

        StringRequest request =new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(HttpExampleActivity.this, "result: "+response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HttpExampleActivity.this, "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params=new HashMap<>();
                params.put("name",_name);
                params.put("age",_age);

                return params;
            }
        };


        RequestQueue requestQueue= Volley.newRequestQueue(HttpExampleActivity.this);
        requestQueue.add(request);
    }
}

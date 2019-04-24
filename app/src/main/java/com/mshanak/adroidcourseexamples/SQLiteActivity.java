package com.mshanak.adroidcourseexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class SQLiteActivity extends AppCompatActivity {
    Button btn_save,btn_fetch;
    EditText name,last_name,qualifications;
    PersonSqlHelper sqlHelper;
    ListView uiListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        btn_save =findViewById(R.id.s_button);
        btn_fetch =findViewById(R.id.s_get_btn);
        name=findViewById(R.id.s_name);
        last_name=findViewById(R.id.s_lastname);
        qualifications=findViewById(R.id.s_qualification);
        uiListView =findViewById(R.id.people_list);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sqlHelper=new PersonSqlHelper(SQLiteActivity.this);
                sqlHelper.addPerson(name.getText().toString(),last_name.getText().toString(),qualifications.getText().toString());

            }
        });


        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData(v);
            }
        });

    }

    public void fetchData(View view){
        List<Person> list=sqlHelper.GetAllPeople();
        ArrayAdapter<Person> arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,list);
        uiListView.setAdapter(arrayAdapter);
    }
}

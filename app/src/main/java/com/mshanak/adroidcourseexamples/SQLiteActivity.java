package com.mshanak.adroidcourseexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteActivity extends AppCompatActivity {
    Button btn_save;
    EditText name,last_name,qualifications;
    PersonSqlHelper sqlHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        btn_save =findViewById(R.id.s_button);
        //btn_fetch =findViewById(R.id.storage1_btn2);
        name=findViewById(R.id.s_name);
        last_name=findViewById(R.id.s_lastname);
        qualifications=findViewById(R.id.s_qualification);

        sqlHelper=new PersonSqlHelper(this);
        sqlHelper.addPerson(name.getText().toString(),last_name.getText().toString(),qualifications.getText().toString());
    }
}

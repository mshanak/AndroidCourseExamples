package com.mshanak.adroidcourseexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /***
     * handles the event when the user tap on menu item
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg="";

        switch (item.getItemId()){
            case R.id.file:msg="File"; break;
            case R.id.edit:msg="Edit"; break;
            case R.id.copy:msg="Copy"; break;
            case R.id.paste:msg="Past"; break;
        }


        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();;


        return super.onOptionsItemSelected(item);
    }
}

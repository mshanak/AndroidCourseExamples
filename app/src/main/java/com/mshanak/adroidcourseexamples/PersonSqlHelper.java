package com.mshanak.adroidcourseexamples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PersonSqlHelper extends SQLiteOpenHelper {

    private static final String db_name = "db1";
    private static final String db_table_nam = "db1";
    private static final int db_version = 1;
    private static final String db_table_name = "people";

    private static final String db_table_create_command = "CREATE TABLE " + db_table_name +
            " (id INTEGER PRIMARY KEY ,Name TEXT, LastName TEXT, Qualifications TEXT)";


    public PersonSqlHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_table_create_command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE " + db_table_name);
            onCreate(db);
        }
    }


    void addPerson(String Name,String LastName,String Qualification){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",Name);
        values.put("LastName",LastName);
        values.put("Qualifications",Qualification);
        db.insert(db_table_name,null,values);
        db.close();

    }

    List<Person> GetAllPeople(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select  * from "+this.db_table_name;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor != null) cursor.moveToFirst();

        List<Person> list=new ArrayList<Person>();

        while(cursor.moveToNext()){
            Person p=new Person();
            p.setId(cursor.getInt(0));
            p.setName(cursor.getString(1));
            p.setLastName(cursor.getString(2));
            p.setQualifications(cursor.getString(3));
            list.add(p);
        }

        return list;
    }
}

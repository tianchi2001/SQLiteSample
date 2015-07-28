package com.example.administrator.sqlitesample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MyDBHelper myDBHelper = new MyDBHelper(this, "manage", 1);
        MyDBHelper myDBHelper = new MyDBHelper(this, "manage", 2);
//        SQLiteDatabase dbWriter = myDBHelper.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("name", "wewq");
//        cv.put("phone", "123456");
//        dbWriter.insert("user", null, cv);
//
//        cv = new ContentValues();
//        cv.put("name", "lili");
//        cv.put("phone", "321434");
//        dbWriter.insert("user", null, cv);
//        dbWriter.close();

SQLiteDatabase dbreader = myDBHelper.getReadableDatabase();
       Cursor c=dbreader.query("user", null, null, null, null, null, null);
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex("name"));
             String phone = c.getString(c.getColumnIndex("phone"));
           Log.d("lsx", "name: " + name + "| phone: " + phone);
             }
         if (c != null) c.close();
         if (dbreader != null) dbreader.close();

    }


}


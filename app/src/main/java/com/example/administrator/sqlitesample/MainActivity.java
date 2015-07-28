package com.example.administrator.sqlitesample;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHelper myDBHelper = new MyDBHelper(this, "manage", 1);
        SQLiteDatabase dbWriter = myDBHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", "zhangyu");
        cv.put("phone", "123456");
        dbWriter.insert("user", null, cv);

        cv = new ContentValues();
        cv.put("name", "lili");
        cv.put("phone", "321434");
        dbWriter.insert("user", null, cv);
        dbWriter.close();
    }


}


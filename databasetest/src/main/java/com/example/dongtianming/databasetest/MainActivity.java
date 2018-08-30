package com.example.dongtianming.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button create_btn, updata_btn, insert_btn, delete_btn, delete1_btn, xiugai_btn, search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create_btn = (Button) findViewById(R.id.create_database);
        updata_btn = (Button) findViewById(R.id.update_database);
        insert_btn = (Button) findViewById(R.id.insert_database);
        delete1_btn = (Button) findViewById(R.id.delete1_database);
        delete_btn = (Button) findViewById(R.id.delete_database);
        xiugai_btn = (Button) findViewById(R.id.xiugai_database);
        search_btn = (Button) findViewById(R.id.search_database);
        create_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_database:
                break;
            case R.id.update_database:
                break;
            case R.id.insert_database:
                break;
            case R.id.delete_database:
                break;
            case R.id.xiugai_database:
                break;
            case R.id.search_database:
                break;
            case R.id.delete1_database:
                break;
        }
    }

    public class DataBaseHlper extends SQLiteOpenHelper {
        private  Integer Version = 1;

        public DataBaseHlper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "create table person(id integer primary key autoincrement,name varchar(64),address varchar(64))";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "alter table person add sex varchar(8)";
            db.execSQL(sql);
        }
    }
}

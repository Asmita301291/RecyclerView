package com.example.recyclerview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {
    androidx.recyclerview.widget.RecyclerView rv_data;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Model> modellist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rv_data = findViewById(R.id.rv_data);
        modellist = new ArrayList<>();
        rv_data.setLayoutManager(new LinearLayoutManager(this));
        //rv_data.setHasFixedSize(true);
        recyclerViewAdapter=new RecyclerViewAdapter(modellist,this);

        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String[] cols={"username","password"};
        Cursor cursor=db.query("user_login",cols,"",null,"","","","");

        while (cursor.moveToNext()){
            String userName=cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String passWord=cursor.getString(cursor.getColumnIndexOrThrow("password"));

            Model model=new Model(""+userName,""+passWord);
            modellist.add(model);

        }
        cursor.close();
        rv_data.setAdapter(recyclerViewAdapter);
    }

    public void addnew(View view) {
        Intent intent= new Intent(RecyclerView.this,MainActivity.class);
        startActivity(intent);
    }
}
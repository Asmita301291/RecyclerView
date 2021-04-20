package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }
    public void sendDadata(View view) {
        String Username = username.getText().toString().trim();
        String Password = password.getText().toString().trim();
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", Username);
        values.put("password", Password);
        long rowId = db.insert("user_login", null, values);
        Log.e("Row Id", "************" + rowId +" "+Username);
        Toast.makeText(this, "Data Inserted Sucessfully\n" + Username + "\n" + Password + "\n" + rowId, Toast.LENGTH_LONG).show();

        Intent intent= new Intent(MainActivity.this,RecyclerView.class);
        startActivity(intent);

    }
}
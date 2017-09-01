package com.example.acer.sqliteregistration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.support.v7.appcompat.R.id.add;
import static com.example.acer.sqliteregistration.R.id.button;

public class MainActivity extends Activity {
    EditText user_name;
    EditText address;
    EditText mobile_no;
    EditText dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name = (EditText) findViewById(R.id.editText);
        address = (EditText) findViewById(R.id.editText2);
        mobile_no = (EditText) findViewById(R.id.editText3);
        dob = (EditText) findViewById(R.id.editText4);
        Button add_detail = (Button) findViewById(button);
        final SQLiteDatabase db = openOrCreateDatabase("registration", MODE_PRIVATE, null);
        //db.execSQL("Drop Table Details");
        db.execSQL("CREATE TABLE IF NOT EXISTS Details(ID INTEGER PRIMARY KEY ,user_name VARCHAR,address VARCHAR,mobile_no long,dob VARCHAR);");
        //db.execSQL("Delete from Details;");
        add_detail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(user_name.getText().toString().trim().length() == 0 || address.getText().toString().trim().length() == 0 ||mobile_no.getText().toString().trim().length() == 0 || dob.getText().toString().trim().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"No field should be empty",Toast.LENGTH_SHORT).show();
                }
                else if(mobile_no.getText().toString().trim().length() != 10){
                    Toast.makeText(getApplicationContext(),"Mobile no contain 10 digits",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.execSQL("INSERT INTO Details(user_name,address,mobile_no,dob)VALUES('" + user_name.getText() + "','" +
                            address.getText() + "','" + mobile_no.getText() + "','" + dob.getText() + "');");
                    Intent i = new Intent(MainActivity.this, MainActivitytwo.class);
                    startActivity(i);
                }
            }
        });

    }
}
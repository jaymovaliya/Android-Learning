package com.example.acer.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import static com.example.acer.sharedpreferences.R.styleable.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button b1;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Age = "age";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText3);

        b1 = (Button) findViewById(R.id.button);
        sharedpreferences  = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        ed1.setText(sharedpreferences.getString(Name,""));
        ed2.setText(sharedpreferences.getString(Age,""));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = ed1.getText().toString();
                String a = ed2.getText().toString();

                //SharedPreferences.Editor editor = SharedPreferences.edit();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putString(Age, a);
                editor.apply();
                Toast.makeText(MainActivity.this, "Data Added!", Toast.LENGTH_LONG).show();
            }
        });
    }
}



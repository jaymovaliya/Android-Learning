/*package com.example.acer.sqliteregistration;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by acer on 6/13/2017.
 */

/*public class DeleteContact extends Activity {
    Button delete;
    EditText name;
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.delete_activity);
        name = (EditText) findViewById(R.id.editText6);
        delete = (Button) findViewById(R.id.button7);
        final SQLiteDatabase db = openOrCreateDatabase("registration", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Details(user_name VARCHAR,address VARCHAR,mobile_no long,dob VARCHAR);");
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //String our_name = name.getText().toString();
                if (name.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter the name first", Toast.LENGTH_SHORT).show();
                } else {
                    db.execSQL("Delete from Details where user_name = '" + name.getText() + "';");

                        Toast.makeText(getApplicationContext(), "Deleted Sucessfully", Toast.LENGTH_LONG).show();
                    }
                }

        });
    }
}*/

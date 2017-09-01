package com.example.acer.sqliteregistration;

/*import android.app.Activity;
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

/*public class FindContact extends Activity {
    Button find;
    EditText name;
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.contact_activity);
        name = (EditText) findViewById(R.id.editText5);
        find = (Button) findViewById(R.id.button6);
        final SQLiteDatabase db = openOrCreateDatabase("registration", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Details(user_name VARCHAR,address VARCHAR,mobile_no long,dob VARCHAR);");
        find.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //String our_name = name.getText().toString();
                if (name.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter the name first", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor c = db.rawQuery("Select * from Details where user_name = '" + name.getText() + "';", null);
                    //String str = c.getString(0);
                    while (c.moveToNext()) {
                        StringBuffer buffer = new StringBuffer();
                        buffer.append("Name: " + c.getString(0) + "\n");
                        buffer.append("Address: " + c.getString(1) + "\n");
                        buffer.append("Mobile no: " + c.getString(2) + "\n");
                        buffer.append("Date of Birth: " + c.getString(3) + "\n\n");
                        String show = buffer.toString();
                        Toast.makeText(getApplicationContext(), "Values are:\n " + show, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}*/

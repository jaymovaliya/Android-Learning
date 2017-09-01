package com.example.acer.sqliteregistration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.app.ActionBar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by acer on 6/12/2017.
 */

public class MainActivitytwo extends AppCompatActivity {
   /* Button see_all;
    Button add_more;
    Button find_by_name;
    Button delete_by_name;*/
        //see_all.setOnClickListener(this);
   private List<Contact> contactList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactAdapter cAdapter;
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.second_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        cAdapter = new ContactAdapter(contactList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivitytwo.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);
        show_contact();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                Toast.makeText(MainActivitytwo.this, "Single Click on position        :" + position,
                        Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onLongClick(View view, final int position) {
                //final View myList = findViewById(R.id.delete);


                view.setOnLongClickListener(new View.OnLongClickListener() {

                    @Override
                    public boolean onLongClick(View view) {
                         PopupMenu p = new PopupMenu(MainActivitytwo.this, view);
                        p.getMenuInflater().inflate(R.menu.popup_menu, p.getMenu());
                        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.delete:
                                       SQLiteDatabase db = openOrCreateDatabase("registration", MODE_PRIVATE, null);
                                        Cursor c = db.rawQuery("SELECT ID FROM Details;", null);
                                        StringBuffer buffer = new StringBuffer();
                                        while (c.moveToNext()) {
                                            buffer.append( c.getInt(0));
                                        }
                                        String show = buffer.toString();//generate String of all id's present in contact list
                                        Integer del = Integer.parseInt(show);//convert String into integer
                                        Integer id = Integer.parseInt(Integer.toString(del).substring(0, 1));//get the id of first contact in list
                                        Integer final_id = id+position;
                                      db.execSQL("Delete from Details where ID = '" + final_id + "';");
                                        Toast.makeText(MainActivitytwo.this, "Deleted Sucessfully", Toast.LENGTH_SHORT).show();
                                       // contactList.remove(final_id);
                                        return true;
                                    default:
                                        return true;
                                }
                            }
                        });
                        p.show();
                        return true;
                    }

                });

            }
        }));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(MainActivitytwo.this,"Search selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_new:
                addData();
                return true;
            case R.id.delete:
                Toast.makeText(MainActivitytwo.this,"Delete selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void addData(){
        Intent i =new Intent(MainActivitytwo.this,MainActivity.class);
        startActivity(i);
    }
    public static interface ClickListener{
        public void onClick(View view,int position);
        public void onLongClick(View view,int position);
    }
    public void show_contact() {
        SQLiteDatabase db = openOrCreateDatabase("registration", MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM Details", null);
        Contact contact_obj = new Contact();
            while (c.moveToNext()) {
                contact_obj = new Contact("Name: "+c.getString(1),"City: "+c.getString(2),"Mobile: "+c.getString(3),"Dob: "+c.getString(4));
                contactList.add(contact_obj);
            }
            cAdapter.notifyDataSetChanged();
        }


//******************************************************************************
    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private MainActivitytwo.ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final MainActivitytwo.ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }}



        /*see_all = (Button) findViewById(R.id.button2);
        see_all.setOnClickListener(this);
        add_more = (Button) findViewById(R.id.button3);
        add_more.setOnClickListener(this);
        find_by_name = (Button) findViewById(R.id.button4);
        find_by_name.setOnClickListener(this);
        delete_by_name = (Button) findViewById(R.id.button5);
        delete_by_name.setOnClickListener(this);*/

        //final SQLiteDatabase db = openOrCreateDatabase("registration", MODE_PRIVATE, null);}
        //see_all.setOnClickListener(new View.OnClickListener() {
       /* public void onClick(View view) {
       // MainActivitytwo obj = new MainActivitytwo();
         SQLiteDatabase db = openOrCreateDatabase("registration", MODE_PRIVATE, null);
             if(view == see_all){
            Cursor c = db.rawQuery("SELECT * FROM Details", null);
            // db.execSQL("Delete from Details");
            if (c.getCount() == 0) {
                Toast.makeText(getApplicationContext(), "No Record found ", Toast.LENGTH_LONG).show();
                return;
            }
            Intent i = new Intent(MainActivitytwo.this,ContactShow.class);
                 startActivity(i);
           /* StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Name: " + c.getString(0) + "\n");
                buffer.append("Address: " + c.getString(1) + "\n");
                buffer.append("Mobile no: " + c.getString(2) + "\n");
                buffer.append("Date of Birth: " + c.getString(3) + "\n\n");
            }
            String show = buffer.toString();
            Toast.makeText(getApplicationContext(), "Values are:\n " + show, Toast.LENGTH_LONG).show();*/
       // }
        /*if(view == add_more){
            Intent i = new Intent(MainActivitytwo.this,MainActivity.class);
            startActivity(i);
        }
        if(view == find_by_name){
            Intent i = new Intent(MainActivitytwo.this,FindContact.class);
            startActivity(i);
        }
        if(view == delete_by_name){
            Intent i = new Intent(MainActivitytwo.this,DeleteContact.class);
            startActivity(i);
        }
    }
    }*/



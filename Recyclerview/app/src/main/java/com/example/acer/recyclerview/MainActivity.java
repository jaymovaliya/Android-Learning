package com.example.acer.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<fruit> fruitList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FruitAdapter fAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        fAdapter = new FruitAdapter(fruitList);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
       recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fAdapter);
        addFruitData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);

        return super.onCreateOptionsMenu(menu);
    }
    public void addFruitData(){
        fruit fruit_obj = new fruit(" Apple"," Red",R.drawable.apple);
        fruitList.add(fruit_obj);

         fruit_obj = new fruit(" Banana"," Yellow",R.drawable.banana);
        fruitList.add(fruit_obj);

         fruit_obj = new fruit(" Pineapple"," Yellow",R.drawable.pineapple);
        fruitList.add(fruit_obj);

         fruit_obj = new fruit(" Greps"," Green/Black",R.drawable.greps);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Guava"," Green/Red",R.drawable.guava);
        fruitList.add(fruit_obj);

         fruit_obj = new fruit(" Mango"," Yellow",R.drawable.mango);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Apple"," Red",R.drawable.apple);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Banana"," Yellow",R.drawable.banana);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Pineapple"," Yellow",R.drawable.pineapple);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Greps"," Green/Black",R.drawable.greps);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Guava"," Green/Red",R.drawable.guava);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Mango"," Yellow",R.drawable.mango);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Apple"," Red",R.drawable.apple);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Banana"," Yellow",R.drawable.banana);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Pineapple"," Yellow",R.drawable.pineapple);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Greps"," Green/Black",R.drawable.greps);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Guava"," Green/Red",R.drawable.guava);
        fruitList.add(fruit_obj);

        fruit_obj = new fruit(" Mango"," Yellow",R.drawable.mango);
        fruitList.add(fruit_obj);


        fAdapter.notifyDataSetChanged();
    }
}

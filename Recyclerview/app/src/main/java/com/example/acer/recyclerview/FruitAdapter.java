package com.example.acer.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by acer on 6/12/2017.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder>{
    private List<fruit> fruitList;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView fname,fcolor;
        public ImageView fimageid;
        public MyViewHolder(View view){
            super(view);
            fname = (TextView) view.findViewById(R.id.fname);
            fcolor = (TextView) view.findViewById(R.id.fcolor);
            fimageid =(ImageView)view.findViewById(R.id.imageView);
        }
    }
    public FruitAdapter(List<fruit> fruitList){
        this.fruitList = fruitList;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_show, parent, false);

        return new MyViewHolder(itemView);
    }
    public void onBindViewHolder(MyViewHolder holder, int position) {
        fruit fruit_obj = fruitList.get(position);
        holder.fname.setText(fruit_obj.getName());
        holder.fcolor.setText(fruit_obj.getColor());
        holder.fimageid.setImageResource(fruit_obj.getImage());
    }
    public int getItemCount() {
        return fruitList.size();
    }
}

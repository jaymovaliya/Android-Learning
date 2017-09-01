package com.example.acer.sqliteregistration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 6/13/2017.
 */

public class ContactAdapter extends  RecyclerView.Adapter<ContactAdapter.MyViewHolder>{
    private List<Contact> contactList;
   // private ArrayList<Contact> Filtered_contact_List;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView username,address,mobileno,dob;
        public MyViewHolder(View view){
            super(view);
            username = (TextView) view.findViewById(R.id.contact_show_name);
            address = (TextView) view.findViewById(R.id.contact_show_address);
            mobileno = (TextView) view.findViewById(R.id.contact_show_mobileno);
            dob = (TextView) view.findViewById(R.id.contact_show_dob);
        }
    }
    public ContactAdapter(List<Contact> contactList){
        this.contactList = contactList;
        //this.Filtered_contact_List = contactList;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_show, parent, false);

        return new MyViewHolder(itemView);
    }
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact_obj = contactList.get(position);
        holder.username.setText(contact_obj.getName());
        holder.address.setText(contact_obj.getAddress());
        holder.mobileno.setText(contact_obj.getMobileno());
        holder.dob.setText(contact_obj.getDob());

    }
    public int getItemCount() {
        return contactList.size();
    }}

/*public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    Filtered_contact_List = contactList;
                } else {

                    ArrayList<Contact> filteredList = new ArrayList<>();

                    for (Contact gcontact : contactList) {

                        if (gcontact.getName().toLowerCase().contains(charString) || gcontact.getAddress().toLowerCase().contains(charString) || gcontact.getMobileno().toLowerCase().contains(charString) || gcontact.getDob().toLowerCase().contains(charString)) {

                            filteredList.add(gcontact);
                        }
                    }

                    Filtered_contact_List = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = Filtered_contact_List;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                Filtered_contact_List = (ArrayList<Contact>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }}*/

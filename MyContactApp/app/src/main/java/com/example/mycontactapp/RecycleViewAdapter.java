package com.example.mycontactapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    ArrayList<BaseContact> listOfContacts;
    Context context;
    public RecycleViewAdapter(ArrayList<BaseContact> listOfContacts, Context context) {
        this.listOfContacts = listOfContacts;
        this.context = context;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_contact, parent,false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_contactName.setText(listOfContacts.get(position).getName());
        holder.tv_contactIDNum.setText(String.valueOf(listOfContacts.get(position).getNumber()));
        Glide.with(this.context).load(listOfContacts.get(position).getPhoto()).into(holder.iv_contactPic);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Add_Contact_Person.class);
                intent.putExtra("id", listOfContacts.get(position).getNumber());


                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listOfContacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_contactPic;
        TextView tv_contactName;
        TextView tv_contactIDNum;
        ConstraintLayout parentLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_contactPic = itemView.findViewById(R.id.iv_contactPic);
            tv_contactName = itemView.findViewById(R.id.tv_contactName);
            tv_contactIDNum = itemView.findViewById(R.id.tv_idNum);
            parentLayout = itemView.findViewById(R.id.oneLineContactLayout);
        }
    }
}

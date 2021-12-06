package com.example.presidentlistrecycleview;

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

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<President> presidentList;
    Context context;

    public RecycleViewAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_president,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_presName.setText(presidentList.get(position).getName());
        holder.tv_presElectionDate.setText(String.valueOf(presidentList.get(position).getDateOfElection()));
        Glide.with(this.context).load(presidentList.get(position).getImageURL()).into(holder.iv_presPic);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddEditOne.class);
                i.putExtra("id", presidentList.get(position).getId());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_presPic;
        TextView tv_presName;
        TextView tv_presElectionDate;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_presPic = itemView.findViewById(R.id.iv_presidentPicture);
            tv_presElectionDate = itemView.findViewById(R.id.tv_dateElection);
            tv_presName = itemView.findViewById(R.id.tv_presName);
            parentLayout = itemView.findViewById(R.id.oneLinePresidentLayout);
        }
    }
}

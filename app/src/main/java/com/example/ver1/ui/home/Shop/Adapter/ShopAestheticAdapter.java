package com.example.ver1.ui.home.Shop.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ver1.R;
import com.example.ver1.ui.home.Shop.ShopinfoActivity;
import com.example.ver1.ui.home.Shop.User;

import java.util.ArrayList;

public class ShopAestheticAdapter extends RecyclerView.Adapter<ShopAestheticAdapter.CustomViewHolder> {

    private ArrayList<User> arrayList;
    private Context context;
    private Intent intent;

    public ShopAestheticAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_pw.setText(arrayList.get(position).getPw());
        holder.tv_userName.setText(arrayList.get(position).getUserName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), ShopinfoActivity.class);
                intent.putExtra("Name", arrayList.get(position).getId());
                intent.putExtra("Area", arrayList.get(position).getPw());
                intent.putExtra("Menu", arrayList.get(position).getUserName());
                v.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_userName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_pw = itemView.findViewById(R.id.tv_pw);
            this.tv_userName = itemView.findViewById(R.id.tv_userName);
        }
    }

}

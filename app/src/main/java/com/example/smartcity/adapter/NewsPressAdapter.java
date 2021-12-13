package com.example.smartcity.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartcity.R;
import com.example.smartcity.bean.NewsCategoryBean;

import java.util.List;

public class NewsPressAdapter extends RecyclerView.Adapter{
    private LayoutInflater layoutInflater;
    private List<NewsCategoryBean> rowsBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;
    public  NewsPressAdapter (Context context, List<NewsCategoryBean> rowsBeans){
        this.rowsBeans = rowsBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.all_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,mItemClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return rowsBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView t;
        private MyItemClickListener myItemClickListener;

        public MyViewHolder(@NonNull View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            this.myItemClickListener=myItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
    //在activity中adapter中调用此方法，将点击事件监听传递过去，并赋值给全局监听
    public void setItemClickListener(MyItemClickListener myItemClickListener){
        this.mItemClickListener = myItemClickListener;
    }
}

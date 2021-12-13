package com.example.smartcity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartcity.R;
import com.example.smartcity.bean.MetroListResult;

import java.util.List;

public class MetroAdapter extends RecyclerView.Adapter<MetroAdapter.MyViewHoler>{
    private LayoutInflater layoutInflater;
    private List<MetroListResult.DataBean> rowsBeans;
    private Context context;
    private MyItemClickListener m;
   public MetroAdapter(List<MetroListResult.DataBean> rowsBeans, Context context){
       this.rowsBeans=rowsBeans;
       this.context=context;
       layoutInflater= LayoutInflater.from(context);
   }
    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=layoutInflater.inflate(R.layout.metro_item,parent,false);
       MyViewHoler myViewHoler=new MyViewHoler(view,m);
        return myViewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holer, int position) {
        holer.name.setText(rowsBeans.get(position).getLineName());
        holer.next.setText(rowsBeans.get(position).getNextStep().getName());
        holer.time.setText(rowsBeans.get(position).getReachTime()+"分钟");
    }

    @Override
    public int getItemCount() {
        return rowsBeans.size();
    }
    public class MyViewHoler extends RecyclerView.ViewHolder implements View.OnClickListener{
            private TextView name,next,time;
            private MyItemClickListener my;
        public MyViewHoler(@NonNull View view, MyItemClickListener my) {
            super(view);
            this.my=my;
            itemView.setOnClickListener(this);
            name=view.findViewById(R.id.metro_name);
            next=view.findViewById(R.id.metro_nextStep);
            time=view.findViewById(R.id.metro_time);
        }

        @Override
        public void onClick(View v) {
            if (my!=null) {
                my.onItemClick(v,getPosition());
            }
        }
    }
    public interface MyItemClickListener{
        void onItemClick(View view, int position);
    }
    public void setMyItemOnclick(MyItemClickListener m){
        this.m=m;
    }
}

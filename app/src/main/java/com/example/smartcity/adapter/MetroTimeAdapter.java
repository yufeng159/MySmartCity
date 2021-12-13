package com.example.smartcity.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartcity.R;
import com.example.smartcity.bean.MetroDetilsResult;

import java.util.List;

public class MetroTimeAdapter extends RecyclerView.Adapter<MetroTimeAdapter.MyViewHolder> {
    public static int seq;
    MetroDetilsResult.DataBean dataBean;
    List<MetroDetilsResult.DataBean.MetroStepListBean> lists;
    Context mContext;

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public MetroTimeAdapter(MetroDetilsResult.DataBean dataBean, Context mContext) {
        super();
        this.dataBean = dataBean;
        this.mContext = mContext;
        this.lists=dataBean.getMetroStepList();
    }

    /*
     * 覆盖方法
     */
    @Override
    public int getItemCount() {
        // TODO 自动生成的方法存根
        return lists.size();
    }

    /*
     * 覆盖方法
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        // TODO 自动生成的方法存根
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.metro_derils_time_list_item, arg0, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.setIsRecyclable(false);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,dian,line;
        /**
         * @param itemView
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.time_name);
            dian=itemView.findViewById(R.id.time_dian);
            line=itemView.findViewById(R.id.time_line);
            // TODO 自动生成的构造函数存根
        }

    }

    /*
     * 覆盖方法
     */
    @Override
    public void onBindViewHolder(MyViewHolder item, int position) {
        // TODO 自动生成的方法存根
          final MyViewHolder holer =item;
        holer.name.setText(lists.get(position).getName()+"");
        holer.name.setTextColor(Color.parseColor("#999999"));
        holer.dian.setBackgroundResource(R.drawable.time_dian_true);
        holer.line.setBackgroundResource(R.drawable.time_dian_true);
        if(dataBean.getRunStationsName().equals(lists.get(position).getName())) {
            holer.name.setText(lists.get(position).getName()+"");
            holer.name.setTextColor(mContext.getResources().getColor(R.color.result_points));
            holer.dian.setBackgroundResource(R.drawable.time_dian_ditie);
            holer.line.setBackgroundResource(R.drawable.time_dian_flase);
            this.seq = lists.get(position).getSeq();
        };
        if (seq<lists.get(position).getSeq()){
            holer.name.setText(lists.get(position).getName()+"");
            holer.name.setTextColor(mContext.getResources().getColor(R.color.bisque));
            holer.dian.setBackgroundResource(R.drawable.time_dian_flase);
            holer.line.setBackgroundResource(R.drawable.time_dian_flase);
        };
        if (position==lists.size()-1){
            item.line.setVisibility(View.GONE);
        }
    }



}

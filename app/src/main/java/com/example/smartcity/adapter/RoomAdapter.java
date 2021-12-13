package com.example.smartcity.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.R;
import com.example.smartcity.Utils.GlideUtil;
import com.example.smartcity.bean.RoomResult;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private LayoutInflater layoutInflater;
    private List<RoomResult.RowsBean> rowsBeans;
    private Context context;
    private RoomAdapter.MyItemClickListener mItemClickListener;
    public RoomAdapter(Context context, List<RoomResult.RowsBean> rowsBeans) {
        this.rowsBeans = rowsBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.all_room_item,parent,false);
        RoomViewHolder myViewHolder = new RoomViewHolder(view,mItemClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.RoomViewHolder holder, int position) {
        holder.name.setText(rowsBeans.get(position).getSourceName());
        holder.size.setText("面积："+rowsBeans.get(position).getAreaSize());
        holder.price.setText("价格:"+rowsBeans.get(position).getPrice());
        holder.desc.setText("详情:"+rowsBeans.get(position).getDescription());
        String url = ApiService.BASE_ULR + rowsBeans.get(position).getPic();
        GlideUtil g=new GlideUtil();
        g.getImg(20,context,url, holder.pic);
    }


    @Override
    public int getItemCount() {
        return rowsBeans.size();
    }
    public class RoomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //面积，价格，介绍，房源名称
        private TextView size,price,desc,name;

        private ImageView pic;
        private RoomAdapter.MyItemClickListener myListener;
        public RoomViewHolder(@NonNull View view, RoomAdapter.MyItemClickListener myItemClickListener) {
            super(view);

            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);
            size=view.findViewById(R.id.r_areasize);
            price=view.findViewById(R.id.r_price);
            desc=view.findViewById(R.id.r_description);
            name=view.findViewById(R.id.r_name);
            pic=view.findViewById(R.id.r_pic);
        }
        @Override
        public void onClick(View view) {
            if (myListener!=null) {
                myListener.onItemClick(view,getPosition());
            }
        }
    }
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
    //在activity中adapter中调用此方法，将点击事件监听传递过去，并赋值给全局监听
    public void setItemClickListener(RoomAdapter.MyItemClickListener myItemClickListener){
        this.mItemClickListener = myItemClickListener;
    }
}

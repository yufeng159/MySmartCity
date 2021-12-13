package com.example.smartcity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.R;
import com.example.smartcity.bean.AllResult;

import java.util.List;

public class RmRecycleAdapter extends RecyclerView.Adapter<RmRecycleAdapter.myHolder> {
    private LayoutInflater layoutInflater;
    private List<AllResult.RowsBean> rowsBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;
    private ViewGroup parent;
    private int viewType;

    public RmRecycleAdapter(Context context, List<AllResult.RowsBean> rowsBeans){
        this.context=context;
        this.rowsBeans=rowsBeans;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        this.viewType = viewType;
        // 创建ViewHolder, 返回每一项的布局
        View view = layoutInflater.inflate(R.layout.all_rm_item,parent,false);
        myHolder myViewHolder = new myHolder(view,mItemClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.name.setText(rowsBeans.get(position).getServiceName());
        holder.desc.setText(rowsBeans.get(position).getServiceDesc());
        String url = ApiService.BASE_ULR + rowsBeans.get(position).getImgUrl();
        Glide.with(context).load(url).apply(new RequestOptions()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return rowsBeans.size();
    }
    public class myHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView name,desc;
        private MyItemClickListener listener;

        public myHolder(@NonNull View v, MyItemClickListener listener) {
            super(v);
            this.listener=listener;
            itemView.setOnClickListener(this);
            img=v.findViewById(R.id.theme_img);
            name=v.findViewById(R.id.theme_name);
            desc=v.findViewById(R.id.theme_desc);
        }

        @Override
        public void onClick(View v) {
            if (listener!=null) {
                listener.onItemClick(v,getPosition());
            }
        }
    }
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
    //在activity中adapter中调用此方法，将点击事件监听传递过去，并赋值给全局监听
    public void setItemClickListener(MyItemClickListener m){
        this.mItemClickListener = m;
    }
}

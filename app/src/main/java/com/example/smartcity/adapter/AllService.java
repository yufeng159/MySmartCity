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
import com.example.smartcity.Utils.GlideImgLoader;
import com.example.smartcity.bean.AllResult;

import java.util.List;

public class AllService extends RecyclerView.Adapter<AllService.MyViewHolder>{
    private LayoutInflater layoutInflater;
    private List<AllResult.RowsBean> rowsBeans;
    private Context context;
    private MyItemClickListener mItemClickListener;

    /**
     * 构造方法 传入参数
     * @param context
     * @param rowsBeans
     */
    public AllService(Context context,List<AllResult.RowsBean> rowsBeans) {
        this.rowsBeans = rowsBeans;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建ViewHolder, 返回每一项的布局
        View view = layoutInflater.inflate(R.layout.all_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,mItemClickListener);
        return myViewHolder;
    }

    // 将数据与控件绑定
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.service_name.setText(rowsBeans.get(position).getServiceName());
        String url = ApiService.BASE_ULR + rowsBeans.get(position).getImgUrl();
//        Glide.with(context).load(url).apply(new RequestOptions()).into(holder.service_img);
        GlideImgLoader glideImgLoader=new GlideImgLoader();
        glideImgLoader.displayImage(context,url,holder.service_img);
    }

    // 返回Item总条数
    @Override
    public int getItemCount() {
        // return 10;
        return rowsBeans.size();
    }

    // 内部类，绑定控件
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView service_name;
        private ImageView service_img;
        private MyItemClickListener myListener;

        public MyViewHolder(@NonNull View view,MyItemClickListener myItemClickListener) {
            super(view);
            this.myListener = myItemClickListener;
            itemView.setOnClickListener(this);
            service_img = view.findViewById(R.id.all_image);
            service_name = view.findViewById(R.id.all_name);
        }

        @Override
        public void onClick(View view) {
            if (myListener!=null) {
                myListener.onItemClick(view,getPosition());
            }
        }
    }

    //创建一个回调接口
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
    //在activity中adapter中调用此方法，将点击事件监听传递过去，并赋值给全局监听
    public void setItemClickListener(MyItemClickListener myItemClickListener){
        this.mItemClickListener = myItemClickListener;
    }
}

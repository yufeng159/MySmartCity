package com.example.smartcity.fragments.allf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.R;
import com.example.smartcity.Utils.GlideUtil;
import com.example.smartcity.Utils.RgbColor;
import com.example.smartcity.bean.MetroLineList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MetroCityList extends Activity {
    private ImageView img;
    private TextView back;
    private ListView listView;
    List<MetroLineList.DataBean> list;
    List data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metro_city);
        initView();


    }

    private void initView() {
        img=findViewById(R.id.metro_city_img);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView=findViewById(R.id.metro_city_list);
        new GlideUtil().getImg(1,getApplicationContext(),
                ApiService.BASE_ULR+"prod-api/profile/upload/image/2021/05/08/554f2392-1e1c-4449-b95c-327a5f7ec91d.jpeg",img);
        initListView();
    }

    private void initListView() {
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<MetroLineList> call=service.metroLineList();
        call.enqueue(new Callback<MetroLineList>() {
            @Override
            public void onResponse(Call<MetroLineList> call, Response<MetroLineList> response) {
                list=response.body().getData();
                listView.setAdapter(new MyBaseAdapter(list));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int Id=list.get(position).getLineId();
                        String Name=list.get(position).getLineName();
                        //使用Bundle实现跳转传参
                        Intent i=new Intent(MetroCityList.this,MetroDetils.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("id",Id);
                        bundle.putString("name",Name);
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<MetroLineList> call, Throwable throwable) {

            }
        });

    }

    class MyBaseAdapter extends BaseAdapter {
        List<MetroLineList.DataBean> data;
         public MyBaseAdapter(List<MetroLineList.DataBean> list){
            this.data=list;
        }
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view= View.inflate(MetroCityList.this,R.layout.metro_line_list_item,null);//在list_item中有两个id,现在要把他们拿过来
            //组件一拿到，开始组装
            TextView name=(TextView)view.findViewById(R.id.metro_line_name);
            TextView color=(TextView)view.findViewById(R.id.metro_line_color);
            name.setText(data.get(position).getLineName()+"");
            color.setBackgroundColor(Color.parseColor(new RgbColor().getRandColor()));
            //组装玩开始返回
            return view;
        }

    }

}

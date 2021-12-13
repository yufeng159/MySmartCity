package com.example.smartcity.fragments.allf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.Main;
import com.example.smartcity.R;
import com.example.smartcity.adapter.MetroAdapter;
import com.example.smartcity.bean.MetroListResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MetroMian extends Activity implements View.OnClickListener{
    private RecyclerView list;
    public TextView back,city;
    List<MetroListResult.DataBean> data;
    private MetroAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metro);
      init();
        initRecycle();
    }
    public void init(){
        list=findViewById(R.id.metro_list);
        back=findViewById(R.id.back);
        back.setOnClickListener(this);
        city=findViewById(R.id.metro_city);
        city.setOnClickListener(this);
    }
    public void initRecycle(){
        ApiService s= ServiceFactory.getService(ApiService.class);
        Call<MetroListResult> call=s.metroList();
        call.enqueue(new Callback<MetroListResult>() {
            @Override
            public void onResponse(Call<MetroListResult> call, Response<MetroListResult> response) {
                data=response.body().getData();
                adapter=new MetroAdapter(data,getApplicationContext());
                list.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
                list.setAdapter(adapter);
                adapter.setMyItemOnclick(new MetroAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        int Id=data.get(position).getLineId();
                        String Name=data.get(position).getLineName();
                        //使用Bundle实现跳转传参

                        Intent i=new Intent(MetroMian.this,MetroDetils.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("id",Id);
                        bundle.putString("name",Name);
                        i.putExtras(bundle);
                        startActivity(i);
//                        new Handler(new Handler.Callback() {
//                            // 处理接收到消息的方法
//                            @Override
//                            public boolean handleMessage(Message msg) {
//                                startActivity(new Intent(i));
//                                return false;
//                            }
//                        }).sendEmptyMessageDelayed(0,300);
                    }
                });

            }
            @Override
            public void onFailure(Call<MetroListResult> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                startActivity(new Intent(this, Main.class));
                finish();
                break;
            case R.id.metro_city:
                startActivity(new Intent(this, MetroCityList.class));
                break;
        }
    }
}

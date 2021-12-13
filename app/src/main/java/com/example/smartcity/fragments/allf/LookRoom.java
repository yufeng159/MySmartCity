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
import com.example.smartcity.R;
import com.example.smartcity.adapter.RoomAdapter;
import com.example.smartcity.bean.RoomResult;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LookRoom extends Activity implements View.OnClickListener{

    List<RoomResult.RowsBean> list,rows;
    private TextView back;
    private RoomAdapter adapter;
    private RecyclerView view;
    private TextView es,zf,lp,zj;//二手，租房，楼盘，中介
    public String type="123";
    private Banner banner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_room);
        initView();
        initRoom();
    }

    private void initView() {
        view=findViewById(R.id.r_recycler);
        es=findViewById(R.id.r_es);
        zf=findViewById(R.id.r_zf);
        lp=findViewById(R.id.r_lp);
        zj=findViewById(R.id.r_zj);
        back=findViewById(R.id.back);
        banner=findViewById(R.id.r_banner);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        es.setOnClickListener(this);
        zf.setOnClickListener(this);
        lp.setOnClickListener(this);
        zj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.r_es:
                type="二手";
                initadapter();
                break;
            case R.id.r_zf:
                type="租房";
                initadapter();
                break;
            case R.id.r_lp:
                type="楼盘";
                initadapter();
                break;
            case R.id.r_zj:
                type="中介";
                initadapter();
                break;
        }
    }
    private void initRoom() {
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<RoomResult> call=service.Room();
        call.enqueue(new Callback<RoomResult>() {
            @Override
            public void onResponse(Call<RoomResult> call, Response<RoomResult> response) {
               list=response.body().getRows();
                initadapter();
            }

            @Override
            public void onFailure(Call<RoomResult> call, Throwable throwable) {

            }
        });
    }
    private void initadapter(){
        List<RoomResult.RowsBean> a=new ArrayList<>();
                for (int i=0;i<list.size();i++){
                    if (type.equals("123")){
                        a=list;
                    }else if(type.equals(list.get(i).getHouseType())){
                        a.add(new RoomResult.RowsBean(list.get(i).getId(),list.get(i).getSourceName(),list.get(i).getAreaSize(),list.get(i).getPrice(),list.get(i).getPic(),list.get(i).getDescription()));
                    }
                }
                rows=a;
                adapter=new RoomAdapter(getApplicationContext(),rows);
                view.setLayoutManager(new GridLayoutManager(getApplication(),1));
                //设置适配器
                view.setAdapter(adapter);
                view.setNestedScrollingEnabled(false);
                adapter.setItemClickListener(new RoomAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent =new Intent(LookRoom.this,LookDetilsRoom.class);
                        int id=rows.get(position).getId();

                                intent.putExtra("id",id);
                                startActivity(intent);
                    }
                });
    }
}

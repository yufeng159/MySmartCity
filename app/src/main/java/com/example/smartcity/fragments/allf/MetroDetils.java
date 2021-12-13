package com.example.smartcity.fragments.allf;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.R;
import com.example.smartcity.adapter.MetroTimeAdapter;
import com.example.smartcity.bean.MetroDetilsResult;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MetroDetils extends Activity {

    public String name;
    private TextView back, Title;
    private TextView num, time, km,start,end;
    private RecyclerView recyclerView;
    private MetroTimeAdapter adapter;
    public List<MetroDetilsResult.DataBean.MetroStepListBean> steplist;
    public MetroDetilsResult.DataBean data;
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metrodetils);
        initView();
    }


    private void initView() {
        //使用bundle获取传过来的参数
        Bundle bundle = this.getIntent().getExtras();
        name = bundle.getString("name");
        int id = bundle.getInt("id");
        back = findViewById(R.id.back);
        Title = findViewById(R.id.txt_topbar);
        num = findViewById(R.id.metro_number);
        time = findViewById(R.id.metro_time);
        km = findViewById(R.id.metro_km);
        start=findViewById(R.id.metro_start);
        end=findViewById(R.id.metro_end);
        Title.setText(name);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call call=service.metroDetils(id);
        call.enqueue(new Callback<MetroDetilsResult>() {
            @Override
            public void onResponse(Call<MetroDetilsResult> call, Response<MetroDetilsResult> response) {
                data=response.body().getData();
                start.setText(data.getFirst());
                end.setText(data.getEnd());
                Random random=new Random();
                if (data.getStationsNumber()==null)
                    num.setText(random.nextInt(10)+"站");
                else
                    num.setText(data.getStationsNumber()+"站");
                if((data.getRemainingTime()+"")==null){
                    time.setText("0分钟");
                }else{
                    time.setText(data.getRemainingTime()+"分钟");
                }
                km.setText(data.getKm()+"KM");

                recyclerView=findViewById(R.id.metro_time_list);
                //横向滚动
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),8));
                recyclerView.getRecycledViewPool().setMaxRecycledViews(1,0);
                adapter=new MetroTimeAdapter(data,getApplicationContext());
                MetroTimeAdapter.seq=findCurrentSeq(data);
                recyclerView.setAdapter(adapter);
                recyclerView.scrollToPosition(MetroTimeAdapter.seq);
            }

            @Override
            public void onFailure(Call<MetroDetilsResult> call, Throwable throwable) {

            }
        });
    }
    int findCurrentSeq(MetroDetilsResult.DataBean dataBean){
        List<MetroDetilsResult.DataBean.MetroStepListBean> list=dataBean.getMetroStepList();
        for(int i=0;i<list.size();i++){
            MetroDetilsResult.DataBean.MetroStepListBean step=list.get(i);
            if(step.getName().equals(dataBean.getRunStationsName())){
                return step.getSeq();
            }
        }
        return 0;
    }
}



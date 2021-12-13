package com.example.smartcity.fragments.allf.jobf;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.R;
import com.example.smartcity.User.Login;
import com.example.smartcity.bean.JobpostResult;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobPostF extends Fragment {
    private Banner banner;
    private GridView grid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.job_post_fragment,null);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        if (Login.token=="null"){
            Toast.makeText(getContext(),"请先登录", Toast.LENGTH_SHORT).show();
        }else{
            initdata();
        }

    }

    private void initView() {
        grid=getActivity().findViewById(R.id.gridview1);
        banner=getActivity().findViewById(R.id.j_banner);
    }


    public void initdata(){
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<JobpostResult> call=service.post(Login.token);
        call.enqueue(new Callback<JobpostResult>() {
            @Override
            public void onResponse(Call<JobpostResult> call, Response<JobpostResult> response) {
                List<JobpostResult.RowsBean> rowsBeans=response.body().getRows();
                List<Map<String, String>> listitem = new ArrayList<Map<String, String>>();
                for(int i = 0; i< rowsBeans.size();i++){
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("title",rowsBeans.get(i).getProfessionName());
                    listitem.add(map);
                }
                SimpleAdapter simpleAdapter=new SimpleAdapter(getContext(),listitem,R.layout.job_grid_item,new String[]{"title"},new int[]{R.id.job_text});
                grid.setAdapter(simpleAdapter);
            }

            @Override
            public void onFailure(Call<JobpostResult> call, Throwable throwable) {
                Toast.makeText(getContext(),"请登录", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

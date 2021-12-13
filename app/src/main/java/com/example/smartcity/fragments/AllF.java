package com.example.smartcity.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.Main;
import com.example.smartcity.R;
import com.example.smartcity.Utils.SortUtil;
import com.example.smartcity.adapter.AllService;
import com.example.smartcity.bean.AllResult;
import com.example.smartcity.fragments.allf.JobMain;
import com.example.smartcity.fragments.allf.LookRoom;
import com.example.smartcity.fragments.allf.MetroMian;
import com.example.smartcity.fragments.allf.Zxing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AllF extends Fragment {
    List<AllResult.RowsBean> alls;
    private AllService adapter;
    private RecyclerView allView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.all_fragment,null);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initService();
        allView=getActivity().findViewById(R.id.all_list);
    }

    private void initService() {
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<AllResult> call=service.Service();
        call.enqueue(new Callback<AllResult>() {
            @Override
            public void onResponse(Call<AllResult> call, Response<AllResult> response) {
                //取出数据
                alls=response.body().getRows();
                //按id从大到小排序
//                alls.add(new AllResult.RowsBean(0,"更多服务","","更多服务"));
                alls.add(new AllResult.RowsBean(1,"二维码","","更多服务"));
                alls.add(new AllResult.RowsBean(2,"三级联动","","更多服务"));
                SortUtil.sortList(alls,"id","DESC");

                Message message = new Message();
                message.what = 2;
                han.sendMessage(message);
            }

            @Override
            public void onFailure(Call<AllResult> call, Throwable throwable) {

            }
        });
    }
    public android.os.Handler han = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Toast.makeText(getActivity(),""+alls.toString(), Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    //实例化adapter
                    adapter();
                    break;

            }
        }

    };
    public void adapter(){
        adapter=new AllService(getContext(),alls);
        //设置每行5个图标
        allView.setLayoutManager(new GridLayoutManager(getContext(),5));
        //设置适配器
        allView.setAdapter(adapter);
        HomeF h=new HomeF();
        h.setOnclick(adapter);
       adapter.setItemClickListener(new AllService.MyItemClickListener() {
           @Override
           public void onItemClick(View view, int position) {
               int id=alls.get(position).getId();
               String name=alls.get(position).getServiceName();
               switch (id){
                   case 0:
                       Main m=(Main)getActivity();
                       m.fAll.performClick();
                       break;
                   case 1:
                       startActivity(new Intent(getActivity(), Zxing.class));
                       break;
                   case 2:
                       startActivity(new Intent(getActivity(), MetroMian.class));
                       break;
                   case 21:
                       startActivity(new Intent(getActivity(), JobMain.class));
                       break;
                   case 20:
                       startActivity(new Intent(getActivity(), LookRoom.class));
                       break;
                   default:
                       Toast.makeText(getContext(),"你点击了Id为"+id+"的"+name+"未实现", Toast.LENGTH_SHORT).show();
                       break;
               }
           }
       });
    }
}

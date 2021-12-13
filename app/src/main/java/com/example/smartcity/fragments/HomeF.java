package com.example.smartcity.fragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.Main;
import com.example.smartcity.R;
import com.example.smartcity.Utils.GlideImgLoader;
import com.example.smartcity.Utils.SortUtil;
import com.example.smartcity.adapter.AllService;
import com.example.smartcity.bean.AllResult;
import com.example.smartcity.bean.BannerResult;
import com.example.smartcity.customhem.SearchView;
import com.example.smartcity.fragments.allf.JobMain;
import com.example.smartcity.fragments.allf.LookRoom;
import com.example.smartcity.fragments.allf.MetroMian;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeF extends Fragment {
    private List<AllResult.RowsBean> alls;
    private SearchView searchView;
    private List<String> data = new ArrayList<>();
    private AllService adapter;
    private RecyclerView allView;
    private FrameLayout frameLayout;
    private FragmentManager fManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initRecycle();

        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<BannerResult> call=service.Banner();
        call.enqueue(new Callback<BannerResult>() {
            @Override
            public void onResponse(Call<BannerResult> call, Response<BannerResult> response) {
                List<BannerResult.RowsBean> rowsBeans=response.body().getRows();
                List list=new ArrayList();
                for(int i=0;i<rowsBeans.size();i++){
                    list.add(ApiService.BASE_ULR+rowsBeans.get(i).getAdvImg());
                }
                Banner banner=getActivity().findViewById(R.id.h_banner);
                banner.setImageLoader(new GlideImgLoader());
                banner.setDelayTime(3000);
                banner.setImages(list);
                banner.start();
            }

            @Override
            public void onFailure(Call<BannerResult> call, Throwable t) {

            }
        });
        fManager=getActivity().getFragmentManager();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_news_f,new NewsF()).commit();
        searchView.getSearchWay(new SearchView.SearchWay<String>(){
            @Override
            public List<String> getData() {
                return data;
            }

            @Override
            public boolean matchItem(String item, String s) {
                return item.contains(s);
            }

            @Override
            public void update(List<String> resultList) {
                //设置数据
            }
        });
    }



    private void initView() {
        allView=getActivity().findViewById(R.id.h_serviceView);
        searchView=getActivity().findViewById(R.id.search);
    }
    private void initRecycle() {
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<AllResult> call=service.Service();
        call.enqueue(new Callback<AllResult>() {
            @Override
            public void onResponse(Call<AllResult> call, Response<AllResult> response) {
                List<AllResult.RowsBean> c=response.body().getRows();

                if (c.size()>10){
                    SortUtil.sortList(c,"id","DESC");
                    alls=new ArrayList<>( c.subList(0,9));
                    alls.add(new AllResult.RowsBean(0,"更多服务","","更多服务"));
                }else {
                    alls=new ArrayList<>(c);
                }
//                按id从大到小排序
                SortUtil.sortList(alls,"id","DESC");
                setServiceData(adapter,allView,alls,5);
//                int screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽（像素，如：480px）
//                int screenHeight = getActivity().getWindowManager().getDefaultDisplay().getHeight(); // 屏幕高（像素，如：800p）
//                //判断屏幕竖屏横屏
//                if(screenHeight<screenWidth){
//                    setRmData(adapter2,rmView,c,4);
//                }else {
//                    setRmData(adapter2,rmView,c,2);
//                }

            }

            @Override
            public void onFailure(Call<AllResult> call, Throwable t) {

            }
        });
    }
    public void setServiceData(AllService a, RecyclerView r, List<AllResult.RowsBean> rows, int i){
        a=new AllService(getContext(),rows);
        r.setLayoutManager(new GridLayoutManager(getContext(),i));
        r.setAdapter(a);
        setOnclick(a);
    }
    //设置点击事件
    public void setOnclick(AllService adapter){
        adapter.setItemClickListener(new AllService.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ccOnclick(view,position);
            }
        });
    }
    public void ccOnclick(View view,int position){
        int id=alls.get(position).getId();
        String name=alls.get(position).getServiceName();
        switch (id){
            case 0:
                Main m=(Main)getActivity();
                m.fAll.performClick();
                break;
            case 2:
                startActivity(new Intent(getActivity(), MetroMian.class));
            case 21:
                startActivity(new Intent(getActivity(), JobMain.class));
                break;
            case 20:
                startActivity(new Intent(getActivity(), LookRoom.class));
                break;
            default:
                Toast.makeText(getContext(),"你点击了Id为"+id+"的"+name+"未实现",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

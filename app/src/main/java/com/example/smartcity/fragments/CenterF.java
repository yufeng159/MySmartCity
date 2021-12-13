package com.example.smartcity.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.Main;
import com.example.smartcity.R;
import com.example.smartcity.User.Login;
import com.example.smartcity.Utils.GlideUtil;
import com.example.smartcity.bean.InfoResult;
import com.example.smartcity.bean.UserBean;
import com.example.smartcity.fragments.centerf.Info;
import com.example.smartcity.fragments.centerf.ResetPwd;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CenterF extends Fragment implements View.OnClickListener{
    public static UserBean user;
    private ImageView cAvatar;
    private TextView cUsername;
    private TextView cInfo;
    private TextView cAllorder;
    private TextView cResetPwd;
    private TextView cFeedback;
    private Button cLogout;
    public InfoResult info;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.center_fragment,null);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        Info();
    }
    private void initView() {
        cAvatar = getActivity().findViewById(R.id.c_avatar);
        cUsername = getActivity().findViewById(R.id.c_username);
        cInfo = getActivity().findViewById(R.id.c_info);//个人信息
        cAllorder = getActivity().findViewById(R.id.c_allorder);//全部订单
        cResetPwd = getActivity().findViewById(R.id.c_resetPwd);//修改密码
        cFeedback = getActivity().findViewById(R.id.c_feedback);//意见反馈
        cLogout = getActivity().findViewById(R.id.c_logout);//退出登录

        cInfo.setOnClickListener(this);
        cAllorder.setOnClickListener(this);
        cResetPwd.setOnClickListener(this);
        cFeedback.setOnClickListener(this);
        cLogout.setOnClickListener(this);

    }

    public void Logout(){
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<InfoResult> call=service.logout(Login.token);
        call.enqueue(new Callback<InfoResult>() {
            @Override
            public void onResponse(Call<InfoResult> call, Response<InfoResult> response) {
                response.body();
                System.out.println(response.code());
                if (response.code()==405){
                    Login.token="null";
                    startActivity(new Intent(getActivity(), Main.class));
                }
            }
            @Override
            public void onFailure(Call<InfoResult> call, Throwable throwable) {

            }
        });
    }
    public void Info(){
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<InfoResult> call=service.getinfo(Login.token);
        call.enqueue(new Callback<InfoResult>() {
            @Override
            public void onResponse(Call<InfoResult> call, Response<InfoResult> response) {
                 user =response.body().getUser();
                cUsername.setText(user.getUserName());
                GlideUtil g=new GlideUtil();
                g.getImg(getActivity(),ApiService.BASE_ULR+user.getAvatar(),cAvatar);
            }

            @Override
            public void onFailure(Call<InfoResult> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c_info:
                startActivity(new Intent(getContext(), Info.class));
                break;
            case R.id.c_allorder:
                break;
            case R.id.c_resetPwd:
                startActivity(new Intent(getContext(), ResetPwd.class));
                break;
            case R.id.c_feedback:
                break;
            case R.id.c_logout:
                Logout();
                break;



        }
    }
}

package com.example.smartcity.fragments.centerf;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.Main;
import com.example.smartcity.R;
import com.example.smartcity.User.Login;
import com.example.smartcity.Utils.GlideUtil;
import com.example.smartcity.bean.Result;
import com.example.smartcity.fragments.CenterF;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Info extends Activity {
    private TextView uid,idcard,username,score,email;
    private EditText nickename,phone;
    private RadioButton sex1,sex0;
    private ImageView avatar;
    private Button put;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        initView();
    }

    private void initView() {
        uid=findViewById(R.id.if_Id);
        idcard=findViewById(R.id.if_card);
        username=findViewById(R.id.if_user);
        score=findViewById(R.id.if_score);
        nickename=findViewById(R.id.if_nick);
        email=findViewById(R.id.if_email);
        phone=findViewById(R.id.if_phone);
        sex1=findViewById(R.id.if_sex1);
        sex0=findViewById(R.id.if_sex0);
        avatar=findViewById(R.id.if_avatar);
        TextView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String card= CenterF.user.getIdCard().substring(0,2)+"********"+CenterF.user.getIdCard().substring(14,CenterF.user.getIdCard().length());
        uid.setText("??????ID???"+CenterF.user.getUserId());
        idcard.setText("????????????"+card);
        username.setText("?????????"+CenterF.user.getUserName());
        score.setText("?????????"+CenterF.user.getScore());
        nickename.setText(CenterF.user.getNickName());//"?????????"
        email.setText("?????????"+CenterF.user.getEmail());//"?????????"
        phone.setText(CenterF.user.getPhonenumber());//"????????????"


        GlideUtil g =new GlideUtil();//"?????????"
        g.getImg(this, ApiService.BASE_ULR+CenterF.user.getAvatar(),avatar);
        //"?????????"
        if(CenterF.user.getSex().equals("0")){
            sex0.setChecked(true);
        }else{
            sex1.setChecked(true);
        }
        put=findViewById(R.id.put);
        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                put();
            }
        });
    }
    private void put(){
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        if(!sex1.isChecked()){
            hashMap.put("sex","0");
        }else{
            hashMap.put("sex","1");
        }
        hashMap.put("nickName",nickename.getText().toString());
        hashMap.put("avatar",CenterF.user.getAvatar());
        hashMap.put("phonenumber",phone.getText().toString());
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<Result> call=service.putinfo(Login.token,hashMap);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result=response.body();
                System.out.println(result.toString());
                Toast.makeText(getApplicationContext(),result.getMsg(), Toast.LENGTH_SHORT).show();
                if (result.getCode()==200){
                    startActivity(new Intent(getApplicationContext(), Main.class));
                    finish();
                }

            }
            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                System.out.println("????????????");
            }
        });
    }
}

package com.example.smartcity.fragments.centerf;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.Main;
import com.example.smartcity.R;
import com.example.smartcity.User.Login;
import com.example.smartcity.bean.Result;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPwd extends Activity {
    private EditText oldpwd,newpwd;
    private Button reset;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpwd);
        initView();
    }

    private void initView() {
        oldpwd=findViewById(R.id.old_pwd);
        newpwd=findViewById(R.id.new_pwd);
        newpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        reset=findViewById(R.id.resetpwd);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            resetpwd();
            }
        });
        TextView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void resetpwd(){
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("oldPassword",oldpwd.getText().toString());
        hashMap.put("newPassword",newpwd.getText().toString());
        ApiService service= ServiceFactory.getService(ApiService.class);
        Call<Result> call=service.putPwd(Login.token,hashMap);
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
                System.out.println("连接失败");
            }
        });
    }
}

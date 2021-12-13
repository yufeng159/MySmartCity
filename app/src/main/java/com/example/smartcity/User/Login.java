package com.example.smartcity.User;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.Main;
import com.example.smartcity.R;
import com.example.smartcity.bean.Result;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends Activity {
    public static SharedPreferences sp=null;
    private Button login;
    private EditText acc;
    private EditText pwd;
    private Button register;
    private CheckBox jz;
    public static String token="null";
    public static Result result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        sp=this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        acc.setText(sp.getString("acc",null));
        pwd.setText(sp.getString("pwd",null));
        jz.setChecked(sp.getBoolean("jz",true));
    }
    void init(){
        acc=findViewById(R.id.et_username);
        pwd=findViewById(R.id.et_password);
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        login =findViewById(R.id.button_login);
        register=findViewById(R.id.button_register);
        jz=findViewById(R.id.checkBox);
        //登录点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = acc.getText().toString();
                String password=pwd.getText().toString();
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("username",account);
                hashMap.put("password",password);

                ApiService service= ServiceFactory.getService(ApiService.class);
                Call<Result> call=service.login(hashMap);
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        result=response.body();
                        System.out.println(result.toString());
                        Toast.makeText(getApplicationContext(),result.getMsg(), Toast.LENGTH_SHORT).show();
                        if (result.getCode()==200){
                            Edit();
                            token=result.getToken();
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
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
    public void Edit(){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("acc",acc.getText().toString());
        editor.putString("name","null");
        if (jz.isChecked()){
            editor.putString("pwd",pwd.getText().toString());
            editor.putBoolean("jz",true);
            editor.commit();
        }else {
            editor.putString("pwd",null);
            editor.putBoolean("jz",false);
            editor.commit();
        }

    }

}

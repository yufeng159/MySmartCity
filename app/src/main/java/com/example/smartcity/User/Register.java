package com.example.smartcity.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.R;
import com.example.smartcity.bean.Result;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends Activity {
    private ImageView avatar;
    private EditText acc;
    private EditText name;
    private EditText pwd;
    private EditText emali;
    private EditText phone;
    private RadioGroup rg;
    private RadioButton sex0;
    private RadioButton sex1;
    private Button register;
    private Button login;
    private EditText idcard;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
    }
    void init(){
        avatar = findViewById(R.id.reg_avatar);
        acc = findViewById(R.id.reg_acc);
        name = findViewById(R.id.reg_name);
        pwd = findViewById(R.id.reg_pwd);
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        emali = findViewById(R.id.emali);
        phone = findViewById(R.id.phone);
        rg = findViewById(R.id.rg);
        sex0 = findViewById(R.id.sex0);
        sex1 = findViewById(R.id.sex1);
        register = findViewById(R.id.reg_btn_register);
        login = findViewById(R.id.reg_btn_login);
        idcard=findViewById(R.id.idcard);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("avatar",avatar.toString());
                hashMap.put("userName",acc.getText().toString());
                hashMap.put("password",pwd.getText().toString());
                hashMap.put("nickName",name.getText().toString());
                hashMap.put("email",emali.getText().toString());
                hashMap.put("phonenumber",phone.getText().toString());
                if(!sex1.isChecked()){
                    System.out.println(1);
                    hashMap.put("sex","0");
                }else{
                    hashMap.put("sex","1");
                }
                hashMap.put("idCard",idcard.getText().toString());

                ApiService service= ServiceFactory.getService(ApiService.class);
                Call<Result> call=service.register(hashMap);
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        Result result;
                       result=response.body();
                        System.out.println(result.toString());

                        if (result.getCode()==200){
                            startActivity(new Intent(getApplicationContext(), Login.class));
                            finish();
                            Toast.makeText(getApplicationContext(),"注册成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),result.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable throwable) {
                        System.out.println("连接失败");
                    }
                });
            }
        });
    }
}

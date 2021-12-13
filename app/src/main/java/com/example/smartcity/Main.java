package com.example.smartcity;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.smartcity.User.Login;
import com.example.smartcity.fragments.AllF;
import com.example.smartcity.fragments.CenterF;
import com.example.smartcity.fragments.FoundingF;
import com.example.smartcity.fragments.HomeF;
import com.example.smartcity.fragments.NewsF;

public class Main extends FragmentActivity implements View.OnClickListener {
    public TextView fHome,fAll,fFounding,fNews,fCenter;
    private FrameLayout frame;
    private FragmentManager fManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        fManager=getFragmentManager();
        fHome.performClick();
    }

    private void initView() {
        frame = findViewById(R.id.con_frame);
        fHome = findViewById(R.id.f_home);
        fHome.setCompoundDrawables(null,setimg(R.drawable.home_img),null,null);
        fAll = findViewById(R.id.f_all);
        fAll.setCompoundDrawables(null,setimg(R.drawable.all_img),null,null);
        fFounding = findViewById(R.id.f_founding);
        fFounding.setCompoundDrawables(null,setimg(R.drawable.founding_img),null,null);
        fNews = findViewById(R.id.f_news);
        fNews.setCompoundDrawables(null,setimg(R.drawable.new_img),null,null);
        fCenter = findViewById(R.id.f_center);
        fCenter.setCompoundDrawables(null,setimg(R.drawable.center_img),null,null);
        fAll.setOnClickListener(this);
        fCenter.setOnClickListener(this);
        fFounding.setOnClickListener(this);
        fHome.setOnClickListener(this);
        fNews.setOnClickListener(this);
    }

    private void setSele(){
        fHome.setSelected(false);
        fAll.setSelected(false);
        fCenter.setSelected(false);
        fFounding.setSelected(false);
        fNews.setSelected(false);
    }
    private Drawable setimg(int i){
        Drawable drawable=getResources().getDrawable(i);
        drawable.setBounds(0,0,60,60);
        return drawable;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.f_home:
                setSele();
                fHome.setSelected(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.con_frame,new HomeF()).commit();
                break;
            case R.id.f_all:
                setSele();
                fAll.setSelected(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.con_frame,new AllF()).commit();
                break;
            case R.id.f_founding:
                setSele();
                fFounding.setSelected(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.con_frame,new FoundingF()).commit();
                break;
            case R.id.f_news:
                setSele();
                fNews.setSelected(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.con_frame,new NewsF()).commit();
                break;
            case R.id.f_center:
                if (Login.token.equals("null")){
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    finish();
                }else{
                    setSele();
                    fCenter.setSelected(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.con_frame,new CenterF()).commit();
                }
                break;
        }
    }
}

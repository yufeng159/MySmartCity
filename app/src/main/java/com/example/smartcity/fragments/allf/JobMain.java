package com.example.smartcity.fragments.allf;


import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.smartcity.R;
import com.example.smartcity.fragments.allf.jobf.JobDeliverF;
import com.example.smartcity.fragments.allf.jobf.JobPostF;
import com.example.smartcity.fragments.allf.jobf.JobResumeF;

public class JobMain extends FragmentActivity implements View.OnClickListener {
    public static TextView back;
    private FrameLayout frameLayout;
    private FragmentManager manager;
    private FrameLayout jobFrame;
    private TextView jobPost;
    private TextView jobDeliver;
    private TextView jobResume;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_main);
        initView();
        manager=getFragmentManager();
        jobPost.performClick();
    }


    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.job_deliver:
                    setSele();
                    jobDeliver.setSelected(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.job_frame,new JobDeliverF()).commit();
                    break;
                case R.id.job_post:
                    setSele();
                    jobPost.setSelected(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.job_frame,new JobPostF()).commit();
                    break;
                case R.id.job_resume:
                    setSele();
                    jobResume.setSelected(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.job_frame,new JobResumeF()).commit();
                    break;
            }
    }
    private void initView() {
        jobFrame = (FrameLayout) findViewById(R.id.job_frame);
        back=findViewById(R.id.back);
        jobPost = (TextView) findViewById(R.id.job_post);
        jobDeliver = (TextView) findViewById(R.id.job_deliver);
        jobResume = (TextView) findViewById(R.id.job_resume);
        back.setOnClickListener(this);
        jobPost.setOnClickListener(this);
        jobDeliver.setOnClickListener(this);
        jobResume.setOnClickListener(this);
    }

    private void setSele(){
        jobDeliver.setSelected(false);
        jobPost.setSelected(false);
        jobResume.setSelected(false);
    }
}

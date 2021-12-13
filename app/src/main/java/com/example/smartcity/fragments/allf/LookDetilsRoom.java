package com.example.smartcity.fragments.allf;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.ApiService.ApiService;
import com.example.smartcity.ApiService.ServiceFactory;
import com.example.smartcity.R;
import com.example.smartcity.Utils.GlideUtil;
import com.example.smartcity.bean.RoomDetilsResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LookDetilsRoom extends Activity {
    private TextView rName;
    private ImageView rPic;
    private TextView rAreasize;
    private TextView rPrice;
    private TextView rDescription, rType;
    private Button back;
    private Button rPhone;


    public int id;
    RoomDetilsResult.DataBean dataBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_room_detils);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", id);
        initView();
        iitDetils();
    }


    private void initView() {
        rName = (TextView) findViewById(R.id.r_name);
        rPic = (ImageView) findViewById(R.id.r_pic);
        rAreasize = (TextView) findViewById(R.id.r_areasize);
        rPrice = (TextView) findViewById(R.id.r_price);
        rDescription = (TextView) findViewById(R.id.r_description);
        back = (Button) findViewById(R.id.back);
        rPhone = (Button) findViewById(R.id.r_phone);
        rType = findViewById(R.id.r_type);
    }

    private void iitDetils() {
        ApiService service = ServiceFactory.getService(ApiService.class);
        Call<RoomDetilsResult> call = service.RoomDetils(id);
        call.enqueue(new Callback<RoomDetilsResult>() {
            @Override
            public void onResponse(Call<RoomDetilsResult> call, Response<RoomDetilsResult> response) {
                dataBeans = response.body().getData();
                GlideUtil g = new GlideUtil();
                g.getImg(30, getApplication(), ApiService.BASE_ULR + dataBeans.getPic(), rPic);
                rName.setText("房源名称：" + dataBeans.getSourceName());
                rAreasize.setText("建筑面积：" + dataBeans.getAreaSize());
                rType.setText("房源类型：" + dataBeans.getHouseType());
                rDescription.setText("" + dataBeans.getDescription());
                rPrice.setText("房源单价：" + dataBeans.getPrice());
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                rPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String number = dataBeans.getTel();
                        if (ContextCompat.checkSelfPermission(LookDetilsRoom.this, Manifest.permission.CALL_PHONE) !=
                                PackageManager.PERMISSION_GRANTED)//这个括号也真是难打，真的难打
                        {
                            ActivityCompat.requestPermissions(LookDetilsRoom.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                        } else {

                            call2();

                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<RoomDetilsResult> call, Throwable throwable) {

            }
        });
    }

    private void call2() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:13372716502"));
            startActivity(intent);

        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResult) {
        switch (requestCode) {
            case 1:
                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    call2();
                } else {
                    Toast.makeText(this, "你拒绝了这个权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }

    }
}

package com.example.smartcity.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GlideImgLoader implements ImageLoader {
    private static final int SUCCESS = 1;
    private static final int FALL = 2;
    @Override
    public void displayImage(Context context, Object path, final ImageView imageView) {
//        RoundedCorners roundedCorners=new RoundedCorners(1);
//        RequestOptions cover=new RequestOptions()
//                .transforms(new CenterCrop(),roundedCorners);
//        Glide.with(context).asBitmap().load(path).apply(cover).into(imageView);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    //加载网络成功进行UI的更新,处理得到的图片资源
                    case SUCCESS:
                        //通过message，拿到字节数组
                        byte[] Picture = (byte[]) msg.obj;
                        //使用BitmapFactory工厂，把字节数组转化为bitmap
                        Bitmap bitmap = BitmapFactory.decodeByteArray(Picture, 0, Picture.length);
                        //通过imageview，设置图片
                        imageView.setImageBitmap(bitmap);
                        break;
                }
            }
        };
        OkHttpClient ok=new OkHttpClient();
        Request request= new Request.Builder()
                .url((String) path)
                .build();
        Call call=ok.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] Picture_bt = response.body().bytes();
                //通过handler更新UI
                Message message = handler.obtainMessage();
                message.obj = Picture_bt;
                message.what = SUCCESS;
                handler.sendMessage(message);
            }
        });
    }

    public void displayImage(int c,Context context, Object path, ImageView imageView) {
        RoundedCorners roundedCorners=new RoundedCorners(c);
        RequestOptions cover=new RequestOptions()
                .transforms(new CenterCrop(),roundedCorners);
        Glide.with(context).asBitmap().load(path).apply(cover).into(imageView);
    }
}

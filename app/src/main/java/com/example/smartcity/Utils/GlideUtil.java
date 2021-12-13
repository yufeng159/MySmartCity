package com.example.smartcity.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {

    public void getImg(Context context, String path, ImageView imageView){
        RequestOptions options=new RequestOptions();
        Glide.with(context).load(path).apply(options).into(imageView);
    }
    public void getImg(int i, Context context, String path, ImageView imageView){
        Glide.with(context).load(path).apply(new RequestOptions().transforms(new CenterCrop(),new RoundedCorners(i))).into(imageView);
    }
}

package com.example.smartcity.fragments.allf;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class liandong_3 extends Activity {

    public static String getJson(Context context, String fileName) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toString();
    }
}

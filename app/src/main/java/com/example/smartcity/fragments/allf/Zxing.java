package com.example.smartcity.fragments.allf;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.smartcity.R;
import com.example.smartcity.Utils.QRCodeUtil;

import java.io.File;

public class Zxing extends Activity {
    private EditText contentET;
    private ImageView iv;
    private Button btn1,btn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcode);
       contentET= findViewById(R.id.create_qr_content);
       iv=findViewById(R.id.create_qr_iv);
       btn1=findViewById(R.id.create_btn_1);
       btn2=findViewById(R.id.btn2);
        final CheckBox addLogoCB = (CheckBox) findViewById(R.id.create_qr_addLogo);
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final String filePath = getFileRoot(Zxing.this) + File.separator
                       + "qr_" + System.currentTimeMillis() + ".jpg";

               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       boolean success = QRCodeUtil.createQRImage(contentET.getText().toString().trim(), 800, 800,
                               addLogoCB.isChecked() ?
                                       BitmapFactory.decodeResource(getResources(), R.drawable.all_true) : null,
                               filePath);
                       if (success) {
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   iv.setImageBitmap(BitmapFactory.decodeFile(filePath));
                               }
                           });
                       }
                   }
               }).start();
           }
       });
    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });
    }
    private String getFileRoot(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File external = context.getExternalFilesDir(null);
            if (external != null) {
                return external.getAbsolutePath();
            }
        }

        return context.getFilesDir().getAbsolutePath();
    }
}

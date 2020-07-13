package com.ty.dldlhook;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.Bundle;
import android.widget.Button;

import com.ty.help.Help;
import com.ty.help.MyOnClick;
import com.ty.util.SoUtil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new MyOnClick());

    }


    @Override
    protected void onStart() {
        super.onStart();

        Help help = new Help("");
        if(!help.checkFile())
        {
            finish();

        }

//        if(!SoUtil.getAnalysis())
//        {
//            finish();
//
//        }

       // Log.i("tyty"," 111 -- "+SoUtil.getAnalysis());


        getPermission();
    }

    public  void  test()
    {

    }

    private  void  getPermission()
    {
        //使用兼容库就无需判断系统版本
        int hasWriteStoragePermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission == PackageManager.PERMISSION_GRANTED) {
            //拥有权限，执行操作
            //initScan();
        }else{
            //没有权限，向用户请求权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }
    }
}

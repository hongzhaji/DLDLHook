package com.ty.help;

import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import com.ty.dldlhook.R;
import com.ty.util.DownloadUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Help {


    private  String name;
    private String rootPath ;
    private  int id;
    public Help(String name,int id)
    {
        this.name = name;
        this.id = id;
        rootPath = Environment.getExternalStorageDirectory().getPath()+"/";
    }
        public  void  getResoure()
        {
            Log.i("tyty"," --- getResoure");
        }

        public  void  putResonre()
        {
            //rootPath+"Android/data/com.qidian.dldl.huawei/scripts/app/ui/dialogs/" ---- "QUIDialogMonopolyFingerguessing.lua" "QUIDialogMonopoly.lua" 大富翁
            if(id == R.id.button)
            {
                downFile("http://47.107.87.28:8080/JsonData/QUIDialogMonopolyFingerguessing.lua",
                        rootPath+"Android/data/com.qidian.dldl.huawei/scripts/app/ui/dialogs/","QUIDialogMonopolyFingerguessing.lua");
                downFile("http://47.107.87.28:8080/JsonData/QUIDialogMonopoly.lua",
                        rootPath+"Android/data/com.qidian.dldl.huawei/scripts/app/ui/dialogs/","QUIDialogMonopoly.lua");

//                downFile("http://47.107.87.28:8080/JsonData/QUIDialogMonopolyFingerguessing.lua",
//                        rootPath+"Android/","QUIDialogMonopolyFingerguessing.lua");
//                downFile("http://47.107.87.28:8080/JsonData/QUIDialogMonopoly.lua",
//                        rootPath+"Android/","QUIDialogMonopoly.lua");


            }else  if(id == R.id.speed)
            {
                //加速  ootPath+"Android/data/com.qidian.dldl.huawei/scripts/app/"   MyApp.lua
                downFile("http://47.107.87.28:8080/JsonData/MyApp.lua",rootPath+"Android/data/com.qidian.dldl.huawei/scripts/app/","MyApp.lua");
            }


        }

        public void  helphelp()
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getResoure();
                    putResonre();
                }
            }).start();
        }


        public  boolean checkFile()
        {


            File file = new File(rootPath+"Android/data/com.qidian.dldl.huawei/scripts/app/MyApp.lua");
            return  file.exists();
        }

        private  void  downFile(String url,String fileDir,String fileName)
        {
            DownloadUtil.get().download(url,fileDir,fileName,new DownloadUtil.OnDownloadListener()
            {

                @Override
                public void onDownloadSuccess(File file) {

                    Log.i("tyty"," --- finish  file = "+file.getName());
                }

                @Override
                public void onDownloading(int progress) {

                }

                @Override
                public void onDownloadFailed(Exception e) {

                }
            });
        }

}

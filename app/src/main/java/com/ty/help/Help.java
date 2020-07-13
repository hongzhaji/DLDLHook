package com.ty.help;

import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Help {


    private  String name;
    private String rootPath ;
    public Help(String name)
    {
        this.name = name;
        rootPath = Environment.getExternalStorageDirectory().getPath()+"/";
    }
        public  void  getResoure()
        {
            
        }

        public  void  putResonre()
        {
            try {
                File file = new File(rootPath+this.name);
                FileWriter fileWriter = new FileWriter(file);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
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

}

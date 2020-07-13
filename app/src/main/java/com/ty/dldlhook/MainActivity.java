package com.ty.dldlhook;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.ty.help.Help;
import com.ty.help.MyOnClick;
import com.ty.util.SoUtil;

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

        if(!SoUtil.getAnalysis())
        {
            finish();

        }

       // Log.i("tyty"," 111 -- "+SoUtil.getAnalysis());
    }
}

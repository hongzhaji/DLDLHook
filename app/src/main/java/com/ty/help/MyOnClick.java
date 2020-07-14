package com.ty.help;

import android.view.View;

public class MyOnClick implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Help help = new Help(""+view.getId(),view.getId());
        help.helphelp();
    }
}

package com.ty.util;

public class SoUtil {
    static
    {
        System.loadLibrary("game");
    }

    public  static native boolean getAnalysis();
}

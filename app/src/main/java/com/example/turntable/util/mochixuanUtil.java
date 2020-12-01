package com.example.turntable.util;

import android.content.Context;
import android.view.WindowManager;

public class mochixuanUtil {

    Context context;

    public mochixuanUtil(Context context) {
        this.context = context;
    }

    public int getWidth() {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getWidth();
    }

    public int getHeigth() {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getHeight();
    }

    public int getMinLenght() {
        return Math.min(getHeigth(),getWidth());
    }

    public int getMaxLenght() {
        return Math.max(getHeigth(),getWidth());
    }
}

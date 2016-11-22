package com.example.parallax.moving_background;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Tela {

    private DisplayMetrics metrics;

    public Tela(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        this.metrics = new DisplayMetrics();
        display.getMetrics(this.metrics);
    }

    public int getAltura(){
        return this.metrics.heightPixels;
    }

    public int getLargura(){
        return this.metrics.widthPixels;
    }
}

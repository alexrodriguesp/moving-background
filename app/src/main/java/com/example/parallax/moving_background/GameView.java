package com.example.parallax.moving_background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

public class GameView extends View implements Runnable {

    private Bitmap bmpCeu;
    private Bitmap bmpTerra;

    private Tela tela;

    private boolean running = true;

    private int xCeu, xTerra;

    public GameView(Context context){
        super(context);
        Thread minhaThread = new Thread(this);
        minhaThread.setPriority(Thread.MIN_PRIORITY);
        minhaThread.start();
        this.tela = new Tela(context);
    }

    public void run(){
        while(running){
            try{
                Thread.sleep(32);
            }catch(InterruptedException e){
                Log.e("Parallax Scroll", "Game Loop Finalizado !!");
            }
            postInvalidate();
        }
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        bmpCeu = BitmapFactory.decodeResource(getResources(), R.drawable.imagem01);
        this.bmpCeu = Bitmap.createScaledBitmap(bmpCeu, this.tela.getLargura(), this.tela.getAltura(), false);

        bmpTerra = BitmapFactory.decodeResource(getResources(), R.drawable.imagem02);
        this.bmpTerra = Bitmap.createScaledBitmap(bmpTerra, this.tela.getLargura(), this.tela.getAltura(), false);

        xCeu = xCeu - 30;
        int newxCeu = bmpCeu.getWidth() - (-xCeu);
        if(newxCeu <= 0) {
            xCeu = 0;
            canvas.drawBitmap(bmpCeu, xCeu, 0, null);
        } else{
            canvas.drawBitmap(bmpCeu, xCeu, 0, null);
            canvas.drawBitmap(bmpCeu, newxCeu, 0, null);
        }

        xTerra = xTerra - 100;
        int newxTerra = bmpTerra.getWidth() - (-xTerra);
        if(newxTerra <= 0) {
            xTerra = 0;
            canvas.drawBitmap(bmpTerra, xTerra, 0, null);
        } else {
            canvas.drawBitmap(bmpTerra, xTerra, 0, null);
            canvas.drawBitmap(bmpTerra, newxTerra, 0, null);
        }
    }

}

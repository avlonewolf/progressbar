package com.example.lenovo.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import android.view.View;

/**
 * Created by Lenovo on 11/4/2017.
 */

public class DemoView extends View {
    double sAngle;
    float minutes=3;
    double endX,endY;
    RectF oval;
    float currentAngle;
    Paint paint;
    public DemoView(Context context,AttributeSet attrs){
        super(context,attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        oval = new RectF();

        sAngle= (minutes/10)*360;


    }
    public float getArcAngle() {
        return ((float) sAngle);
    }

    public void setArcAngle(float arcAngle) {
        this.sAngle = arcAngle;
    }
    public void setMinutes(float minu){
        minutes=minu;
        postInvalidate();
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        oval.set( getLeft()+((getRight()-getLeft())/2)-250,
                getTop(),
                getLeft()+((getRight()-getLeft())/2)+250,
                getTop()+500);



        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(25);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(oval, 270, ((float) sAngle), true, paint);
        endX= Math.cos(Math.toRadians(270 + sAngle)) * 250 +  getLeft()+(getRight()-getLeft())/2
               ;

        endY = Math.sin(Math.toRadians(270 + sAngle)) * 250 +  getTop()+250;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        canvas.drawCircle(  getLeft()+(getRight()-getLeft())/2,
                getTop()+250,250,paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(60);


        canvas.drawText(minutes+" Minutes", getLeft()+(getRight()-getLeft())/2-160,
                getTop()+250,paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(((float) endX), ((float) endY),20,paint);

    }
}
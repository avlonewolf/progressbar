package com.example.lenovo.progress;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Lenovo on 11/4/2017.
 */

public class ArcAngleAnimation extends Animation {

    private DemoView arcView;

    private float oldAngle;
    private float newAngle;

    public ArcAngleAnimation(DemoView arcView, float newAngle) {
        this.oldAngle = arcView.getArcAngle();
        this.newAngle = newAngle;
        this.arcView = arcView;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        arcView.setArcAngle(angle);
        arcView.requestLayout();
    }
}

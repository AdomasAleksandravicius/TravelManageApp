package com.example.travelmanageapp.compound_control;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class RateBar extends View {

    ArrayList<Star> stars = new ArrayList<>();
    float ratioRadius = 0.3f;
    float ratioInnerRadius = 0.1f;
    int numberOfPoint = 5;

    public RateBar(Context context) {
        super(context);
    }

    public RateBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RateBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setStars(int count) {
        for (int x = 0; x < count; x++) {
            stars.add(new Star(40, 40, 120 * ratioRadius, 120 * ratioInnerRadius, numberOfPoint));
        }

        invalidate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setWillNotDraw(false);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int x = 0; x < stars.size(); x++) {
            Star star = stars.get(x);
            star.getPath().offset(x * 100, 0);
            canvas.drawPath(star.getPath(), star.getPaint());
        }
    }
}
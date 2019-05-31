package com.example.travelmanageapp.compound_control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.travelmanageapp.R;

import org.w3c.dom.Text;

import java.util.Objects;

public class RatingView extends LinearLayout {

    public RatingView(Context context) {
        super(context);
        //init();
        System.out.println("onDraw");
    }

    public RatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        invalidate();
        System.out.println("onDraw");
        //init();
    }

    public RatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        invalidate();
        System.out.println("onDraw");
        //init();
    }

    public RatingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        invalidate();
        System.out.println("onDraw");
        //init();
    }
//
//    public void init(){
//        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.rating_view, this);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path star = createStarBySize(40, 40);

        Paint paint = new Paint();
////        Path path = new Path();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.TRANSPARENT);
//        canvas.drawPaint(paint);

        System.out.println("onDraw");
        paint.setStrokeWidth(3);
        paint.setPathEffect(null);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(star, paint);
    }

    private Path createStarBySize(float width, int steps) {
        float halfWidth = width / 2.0F;
        float bigRadius = halfWidth;
        float radius = halfWidth / 2.0F;
        float degreesPerStep = (float) Math.toRadians(360.0F / (float) steps);
        float halfDegreesPerStep = degreesPerStep / 2.0F;
        Path ret = new Path();
        ret.setFillType(Path.FillType.EVEN_ODD);
        float max = (float) (2.0F* Math.PI);
        ret.moveTo(width, halfWidth);
        for (double step = 0; step < max; step += degreesPerStep) {
            ret.lineTo((float)(halfWidth + bigRadius * Math.cos(step)), (float)(halfWidth + bigRadius * Math.sin(step)));
            ret.lineTo((float)(halfWidth + radius * Math.cos(step + halfDegreesPerStep)), (float)(halfWidth + radius * Math.sin(step + halfDegreesPerStep)));
        }
        ret.close();
        return ret;
    }
}

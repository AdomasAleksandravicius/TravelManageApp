package com.example.travelmanageapp.on_draw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RatingBar;

import com.example.travelmanageapp.R;

public class TripRating extends android.support.v7.widget.AppCompatRatingBar {

    private int[] starArrayColor = {
            R.drawable.down,
            R.drawable.rating,
            R.drawable.like,
            R.drawable.like,
            R.drawable.like,
    };

    private int[] starArrayGrey = {
            R.drawable.grey_down,
            R.drawable.grey,
            R.drawable.like_grey,
            R.drawable.like_grey,
            R.drawable.like_grey,
    };

    public TripRating(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TripRating(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TripRating(Context context) {
        super(context);
    }
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        int stars = getNumStars();
        float rating = getRating();
        float x = 0;

        for (int i=0;i<stars;i++) {
            Bitmap bitmap;
            Resources res = getResources();
            Paint paint = new Paint();
            x += 50;

            if ((int) rating-1 == i) {
                bitmap = BitmapFactory.decodeResource(res, starArrayColor[i]);
            } else {
                bitmap = BitmapFactory.decodeResource(res, starArrayGrey[i]);
            }
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 48, 48, true);
            canvas.drawBitmap(scaled, x, 0, paint);
            canvas.save();
        }
    }
}

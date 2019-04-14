package com.example.travelmanageapp.compound_control;

import android.content.Context;
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

    private RatingBar ratingBar;
    private TextView ratingText;

    public RatingView(Context context) {
        super(context);
        init();
    }

    public RatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RatingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.rating_view, this);
        ratingBar.findViewById(R.id.ratingBar);
        ratingText.findViewById(R.id.ratingText);

    }

    public void setRating(int rating){
        this.ratingBar.setRating(rating);
        this.ratingText.setText("Rate our app!");
        this.ratingBar.setMax(10);
    }
}

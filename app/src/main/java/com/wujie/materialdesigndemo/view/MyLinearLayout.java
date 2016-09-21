package com.wujie.materialdesigndemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.wujie.materialdesigndemo.R;

/**
 * Created by Administrator on 2016/9/21.
 */
public class MyLinearLayout extends LinearLayout{
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(0, 5);
        path.lineTo(0, 35);
        path.quadTo(0, 40, 5, 40);
        path.lineTo(10, 40);
        path.lineTo(15, 50);
        path.lineTo(20, 40);
        path.lineTo(55, 40);
        path.quadTo(60, 40, 60, 35);
        path.lineTo(60, 5);
        path.quadTo(60, 0, 55, 0);
        path.lineTo(5, 0);
        path.quadTo(0, 0, 0, 5);
        path.close();
        canvas.drawPath(path, paint);

    }
}

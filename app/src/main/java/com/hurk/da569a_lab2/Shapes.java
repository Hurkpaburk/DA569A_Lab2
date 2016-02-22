package com.hurk.da569a_lab2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;

/**
 * Based on example for Screen information gives by course literature
 */
public class Shapes extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new DrawView(this));
    }

    public class DrawView extends View {

        public DrawView(Context context) {
            super(context);
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
        }


        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);

            canvas.drawARGB(255, 154, 246, 240);
            int width = canvas.getWidth();
            int height = canvas.getHeight();

            //Draw Box
            paint.setColor(Color.MAGENTA);
            canvas.drawRect(width / 2, height / 2, 2 * width / 3, 3 * height / 4, paint);

            //Draw Triangle
            paint.setColor(Color.BLACK);
            canvas.drawLine(100, 300, 300, 300 + 300, paint);
            canvas.drawLine(300, 300 + 300, 500, 300, paint);
            canvas.drawLine(500, 300, 100, 300, paint);
        }
    }
}

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
import android.view.WindowManager;

/**
 * Based on example for Screen information gives by course literature
 */
public class ScreenInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new DrawView(this));
    }

    public class DrawView extends View {
        DisplayMetrics displayMetrics;

        public DrawView(Context context) {
            super(context);
            displayMetrics = new DisplayMetrics();

            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawARGB(255, 154, 246, 240);
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setTextSize(height / 40);
            Paint paintInfo = new Paint();
            paintInfo.setColor(Color.BLACK);
            paintInfo.setTextSize(height / 20);

            int x = width / 10, y = height / 2, step = 60;
            canvas.drawText("Screen Info: ", x, y, paintInfo);
            y = y + 2 * step;
            canvas.drawText("Density: " + displayMetrics.density, x, y, paint);
            y = y + step;
            canvas.drawText("Scaled density: " + displayMetrics.scaledDensity, x, y, paint);
            y = y + step;
            canvas.drawText("Density dpi: " + displayMetrics.densityDpi, x, y, paint);
            y = y + step;
            canvas.drawText("Width: " + width, x, y, paint);
            y = y + step;
            canvas.drawText("Height: " + height, x, y, paint);
            y = y + step;
            canvas.drawText("X dpi: " + displayMetrics.xdpi, x, y, paint);
            y = y + step;
            canvas.drawText("Y dpi: " + displayMetrics.ydpi, x, y, paint);
        }
    }
}

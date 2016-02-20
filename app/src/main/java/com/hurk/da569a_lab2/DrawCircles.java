package com.hurk.da569a_lab2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;

import java.util.Random;

/**
 * Example for Screen information gives by course literature
 */
public class DrawCircles extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new DrawView(this));
    }

    public class DrawView extends View {
        Bitmap bufferBitmap;
        Canvas bufferCanvas;
        Point screenSize;
        Random rand = new Random();

        public DrawView(Context context) {
            super(context);

            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            screenSize = new Point(displayMetrics.widthPixels - 20, displayMetrics.heightPixels - 20);
            bufferBitmap = Bitmap.createBitmap(screenSize.x, screenSize.y, Bitmap.Config.ARGB_8888);
            bufferCanvas = new Canvas(bufferBitmap);
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            drawOnBuffer();

            canvas.drawBitmap(bufferBitmap, 0, 0, new Paint());
        }

        public void drawOnBuffer() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            bufferCanvas.drawColor(Color.argb(255, 154, 246, 240));

            for (int i = 0; i < 50; i++) {
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);
                paint.setColor(Color.rgb(r, g, b));

                int x = rand.nextInt(bufferCanvas.getWidth());
                int y = rand.nextInt(bufferCanvas.getHeight());
                int rad = rand.nextInt(bufferCanvas.getWidth() / 2) + 20;

                bufferCanvas.drawCircle(x, y, rad, paint);
            }
        }
    }
}

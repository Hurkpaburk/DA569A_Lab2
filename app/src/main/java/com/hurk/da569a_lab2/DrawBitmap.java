package com.hurk.da569a_lab2;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.io.IOException;
import java.io.InputStream;

/**
 * Based on example for Screen information gives by course literature
 */
public class DrawBitmap extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new DrawView(this));
    }

    public class DrawView extends View {
        Bitmap monster = null;

        public DrawView(Context context) {
            super(context);
            try {
                AssetManager assets = context.getAssets();
                InputStream inputStream = assets.open("blinking_green.png");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                monster = BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawARGB(255, 154, 246, 240);
            canvas.drawBitmap(monster, 400, 400, null);
        }
    }
}

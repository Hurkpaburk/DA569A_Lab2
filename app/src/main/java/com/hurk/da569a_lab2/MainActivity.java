package com.hurk.da569a_lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void screenInfo(View view) {
        Intent intent = new Intent(this, ScreenInfo.class);
        startActivity(intent);
    }

    public void drawCircles(View view) {
        Intent intent = new Intent(this, DrawCircles.class);
        startActivity(intent);
    }
}

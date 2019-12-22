package com.example.eyetracking_service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.eyetracking_service.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScrollActivity extends AppCompatActivity {

    private int POS_Y = 700;
    private int upperlimit;
    private int lowerlimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        //텍스트 끌어오기
        TextView test = (TextView) findViewById(R.id.raintext);
        test.setText(readTxt());


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        upperlimit = displayMetrics.heightPixels / 5;
        lowerlimit = 4 * (displayMetrics.heightPixels / 5);


        Thread scroller = new Thread(new Runnable(){
            @Override
            public void run(){
                final ScrollView scrollview = ((ScrollView) findViewById(R.id.ScrollView));
                while(true)
                {
                    //---------- SCROLL HERE --------------
                    if ( POS_Y < upperlimit)
                    {scrollview.smoothScrollBy(0, -2);}
                    else if (POS_Y > lowerlimit)
                    {scrollview.smoothScrollBy(0, 2);}

                    System.out.println(POS_Y + " // " + upperlimit + ", " + lowerlimit);
                    //---------- SCROLL HERE --------------
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        scroller.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                POS_Y += 200;
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                POS_Y -= 200;
                return true;
        }
        return false;
    }

    private String readTxt() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.heavy_rain);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while(i != -1){
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"UTF-8");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    //public void scrolling
}

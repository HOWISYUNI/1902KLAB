package com.example.eyetracking_service;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eyetracking_service.R;
import com.example.eyetracking_service.fontactivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TextActivity extends AppCompatActivity {

    static final int BAEMIN = 11;
    static final int BATANG = 22;
    static final int DEFONT = 33;
    TextView dupview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        TextView test = (TextView) findViewById(R.id.textdomain);
        test.setText(readTxt());
        dupview = test;

        Button fontbtn = (Button) findViewById(R.id.font);
        fontbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TextActivity.this, fontactivity.class);
                startActivityForResult(intent,11);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 11){
            switch (resultCode){
                case BAEMIN:
                    dupview.setTypeface(Typeface.createFromAsset(getAssets(),"font/bmhanna_11yrs_ttf.ttf"));
                    break;
                case BATANG:
                    dupview.setTypeface(Typeface.createFromAsset(getAssets(),"font/ridibatang.otf"));
                    break;
                case DEFONT:
                    dupview.setTypeface(Typeface.createFromFile("/system/fonts/AndroidClock.ttf"));
                    break;
            }
        }
    }

    private String readTxt() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.loveletter);
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
}

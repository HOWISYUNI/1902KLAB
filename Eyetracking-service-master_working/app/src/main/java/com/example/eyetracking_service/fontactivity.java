package com.example.eyetracking_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eyetracking_service.R;

public class fontactivity extends AppCompatActivity implements View.OnClickListener{
    static final int BAEMIN = 11;
    static final int BATANG = 22;
    static final int DEFONT = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fontactivity);

        Button bae = (Button) findViewById(R.id.baemin);
        Button bat = (Button) findViewById(R.id.batang);
        Button defont = (Button) findViewById(R.id.defont);

        bae.setOnClickListener(this);
        bat.setOnClickListener(this);
        defont.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.baemin:
                setResult(BAEMIN);
                break;
            case R.id.batang:
                setResult(BATANG);
                break;
            case R.id.defont:
                setResult(DEFONT);
                break;
        }
    }
}

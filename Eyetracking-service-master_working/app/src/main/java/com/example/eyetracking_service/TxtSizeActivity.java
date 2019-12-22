package com.example.eyetracking_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eyetracking_service.R;

public class TxtSizeActivity extends AppCompatActivity implements View.OnClickListener{
    static final int SMALL = 1;
    static final int MEDIUM = 2;
    static final int LARGE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt_size_activiity);

        Button btn1 = (Button) findViewById(R.id.small);
        Button btn2 = (Button) findViewById(R.id.medium);
        Button btn3 = (Button) findViewById(R.id.large);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.small:
                setResult(SMALL, intent);
                finish();
                break;
            case R.id.medium:
                setResult(MEDIUM, intent);
                finish();
                break;
            case R.id.large:
                setResult(LARGE, intent);
                finish();
                break;
        }
    }
}

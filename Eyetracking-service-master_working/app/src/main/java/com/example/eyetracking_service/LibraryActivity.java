package com.example.eyetracking_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eyetracking_service.R;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), com.example.e_book_reader.TextActivity.class);
                Intent intent = new Intent(getApplicationContext(), com.example.eyetracking_service.TextActivity.class);
                startActivity(intent);
            }
        });

        Button rainbutton = (Button) findViewById(R.id.button2);
        rainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), com.example.e_book_reader.ScrollActivity.class);
                Intent intent = new Intent(getApplicationContext(), com.example.eyetracking_service.HighlightActivity.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), com.example.e_book_reader.HighlightActivity.class);
                Intent intent = new Intent(getApplicationContext(), com.example.eyetracking_service.HighlightActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.eyetracking_service;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eyetracking_service.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HighlightActivity extends AppCompatActivity {

    TextView dupview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlight);

        TextView highlightext = (TextView) findViewById(R.id.HLtextdomain);
        dupview = highlightext;

        highlightext.setText(readTxt());

        Button txtsizebutton = (Button) findViewById(R.id.sizebutton);
        txtsizebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(HighlightActivity.this, com.example.e_book_reader.TxtSizeActivity.class);
                Intent intent = new Intent(HighlightActivity.this, com.example.eyetracking_service.TxtSizeActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            switch (resultCode){
                case 1:
                    dupview.setTextSize(10);
                    break;
                case 2:
                    dupview.setTextSize(15);
                    break;
                case 3:
                    dupview.setTextSize(30);
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

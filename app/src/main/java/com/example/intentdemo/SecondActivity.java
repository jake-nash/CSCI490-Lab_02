package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button moonButton;
    private Button waterfallButton;
    int imageID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Intent i = getIntent();

        moonButton = findViewById(R.id.supermoonButton);
        waterfallButton = findViewById(R.id.waterfallButton);

        moonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("SecondActivity", "moon button clicked");
                Log.i("SecondActivity", "imageID = "+R.id.moonImage);
                imageID = R.drawable.supermoon;
                finish();
            }
        });

        waterfallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("SecondActivity", "waterfall button clicked");
                Log.i("SecondActivity", "imageID = "+R.id.waterfallImage);
                imageID = R.drawable.waterfall;
                finish();
            }
        });
    }

    @Override
    public void finish() {
        Intent intent2 = new Intent();
        intent2.putExtra("imageID", imageID);
        setResult(RESULT_OK, intent2);
        super.finish();
    }
}
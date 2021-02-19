package com.example.intentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button goToSecondActivity;
    private Intent i;
    private static int ACTIVITY2_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToSecondActivity = findViewById(R.id.mainButton);
        i = new Intent(this, SecondActivity.class);


        goToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(i, ACTIVITY2_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ACTIVITY2_REQUEST_CODE && resultCode== Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                int imageID = extras.getInt("imageID");
                ConstraintLayout currentLayout = findViewById(R.id.main_layout);
                Log.i("MainActivity", "imageID = "+imageID);
                Log.i("MainActivity", "reached line 48, some problem with \"getDrawable(imageID)\"");
                currentLayout.setBackground(getDrawable(imageID));
            }
        }
    }
}
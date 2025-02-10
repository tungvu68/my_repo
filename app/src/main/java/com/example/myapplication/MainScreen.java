package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainScreen extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        Button btnCallAction = findViewById(R.id.btnCallAction);
        Button btnSMSAction = findViewById(R.id.btnSMSAction);
        Button btnCameraAction = findViewById(R.id.btnCameraAction);
        Button btnViewUrlAction = findViewById(R.id.btnViewUrlAction);
        Button btnSendToAction = findViewById(R.id.btnSendToAction);

        btnCallAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang MainActivity khi click vào nút Call
                Intent intent = new Intent(MainScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSMSAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, SMSActivity.class);
                startActivity(intent);
            }
        });

        btnViewUrlAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, ViewUrlActivity.class);
                startActivity(intent);
            }
        });



    }
}
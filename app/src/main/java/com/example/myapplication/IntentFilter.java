package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentFilter extends AppCompatActivity {
    WebView myscreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_fillter);
        myscreen = findViewById(R.id.myscreen);
        Intent intent = getIntent();
    }
}
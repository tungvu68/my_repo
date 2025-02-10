package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentFilterActivity extends AppCompatActivity {
    WebView myscreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter);

        myscreen = findViewById(R.id.myscreen);

        // Lấy Intent từ Activity
        Intent intent = getIntent();

        // Lấy URI từ Intent
        Uri link = intent.getData();

        // Kiểm tra xem URI có hợp lệ không trước khi load URL
        if (link != null) {
            try {
                // Load URL vào WebView
                myscreen.loadUrl(link.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Thông báo lỗi nếu không có URI
            myscreen.loadData("No URL found", "text/html", "UTF-8");
        }
    }
}

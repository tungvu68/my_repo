package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ViewUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_url);

        // Set up the Facebook click listener
        findViewById(R.id.imgfacebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Facebook URL in the browser or app
                openUrl("https://www.facebook.com");
            }
        });

        // Set up the Instagram click listener
        findViewById(R.id.imgInstagram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Instagram URL in the browser or app
                openUrl("https://www.instagram.com");
            }
        });
    }

    // Helper method to open a URL
    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        // Check if there's an app that can handle this intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);  // Open the URL
        }
    }
}

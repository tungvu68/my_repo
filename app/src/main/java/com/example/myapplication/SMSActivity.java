package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_smsactivvity);

        findViewById(R.id.btnsms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the phone number and message
                EditText edtPhone = findViewById(R.id.edtPhone);
                String phone = edtPhone.getText().toString();

                // Call the function to open SMS app
                openSMSApp(phone, "");
            }
        });
    }

    private void openSMSApp(String phoneNumber, String message) {
        // Create an implicit intent to open the SMS app
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber)); // The phone number is passed here
        intent.putExtra("sms_body", "enter text"); // The message will be pre-filled

        // Check if there's an app that can handle this intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent); // Open the SMS app
        }
    }
}

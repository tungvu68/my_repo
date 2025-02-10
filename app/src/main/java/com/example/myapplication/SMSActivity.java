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
                EditText edtPhone = findViewById(R.id.edtPhone);
                String phone = edtPhone.getText().toString();
                // We can add the string message to send
                openSMSApp(phone, "");
            }
        });
    }

    private void openSMSApp(String phoneNumber, String message) {
        // Create an implicit intent to open the SMS app
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));
        intent.putExtra("sms_body", "enter text");

        startActivity(intent);

    }
}

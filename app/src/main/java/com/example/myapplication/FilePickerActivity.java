package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FilePickerActivity extends AppCompatActivity {
    private static final int PICK_FILE_REQUEST_CODE = 1;
    private TextView txtFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_picker); // Sử dụng layout đúng

        // Khai báo các View
        Button btnPickFile = findViewById(R.id.btnPickFile);
        txtFileName = findViewById(R.id.txtFileName);

        // Set listener để mở file picker
        btnPickFile.setOnClickListener(v -> pickFile());
    }

    // Phương thức mở file picker
    private void pickFile() {
        // Tạo một implicit intent để mở file picker
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Chọn tất cả các loại file
        intent.addCategory(Intent.CATEGORY_OPENABLE); // Cho phép chọn file có thể mở được

        // Mở file picker bằng startActivityForResult
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Kiểm tra nếu kết quả là từ file picker
        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri fileUri = data.getData();
            if (fileUri != null) {
                // Lấy tên file từ URI
                String fileName = fileUri.getLastPathSegment();
                txtFileName.setText("Selected file: " + fileName); // Hiển thị tên file
            }
        }
    }
}

package com.example.bookmanager_hung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class ScreenMainActivity extends AppCompatActivity {
    FrameLayout layoutUser, layoutTheLoai, layoutSach, layoutHoadon;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_main);
        layoutUser = findViewById(R.id.frameUser);
        layoutUser = findViewById(R.id.frameUser);
        layoutUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ScreenMainActivity.this, User.class);
                startActivity(intent);

            }
        });

        layoutTheLoai = findViewById(R.id.FrameTheLoai);
        layoutTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ScreenMainActivity.this, Screen_TheLoai.class);
                startActivity(intent);
            }
        });

        layoutSach = findViewById(R.id.FrameSach);
        layoutSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ScreenMainActivity.this, Screen_SachActivity.class);
                startActivity(intent);
            }
        });

        layoutHoadon = findViewById(R.id.FrameHoadon);
        layoutHoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ScreenMainActivity.this, Screen_HoaDonActivity.class);
                startActivity(intent);
            }
        });

    }
}

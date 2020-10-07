package com.example.bookmanager_hung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookmanager_hung.dao.NguoiDungDao;
import com.example.bookmanager_hung.model.NguoiDung;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPass;
    Button btnDangNhap, btnHuyDangNhap;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.edtUsernameLogin);
        edPass = findViewById(R.id.edtPassword);
        btnDangNhap = findViewById(R.id.btnLogin);
        btnHuyDangNhap = findViewById(R.id.btnExit);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, ScreenMainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkLogin(View view) {
        NguoiDungDao nguoiDungDao = new NguoiDungDao(this);
        String username = edUsername.getText().toString();
        String password = edPass.getText().toString();
        NguoiDung nguoiDung = new NguoiDung(username, password);
        boolean reault = nguoiDungDao.isLogin(nguoiDung);
        if (reault) {
            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            intent = new Intent(LoginActivity.this, ScreenMainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "Đăng nhập that bai", Toast.LENGTH_SHORT).show();

        }
    }

}

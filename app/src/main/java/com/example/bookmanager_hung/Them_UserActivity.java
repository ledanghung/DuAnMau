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

public class Them_UserActivity extends AppCompatActivity {
    NguoiDungDao nguoiDungDAO;
    EditText edUser, edPass, edPhone, edFullName;
    Button btnhiennguoidung;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        edUser = findViewById(R.id.edUsername);
        edPass = findViewById(R.id.edPhone);
        edPhone = findViewById(R.id.edphone);
        edFullName = findViewById(R.id.edFuulname);
        btnhiennguoidung = findViewById(R.id.btnShowND);
        btnhiennguoidung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Them_UserActivity.this, User.class);
                startActivity(intent);
            }
        });
    }

    public void addNewUser(View view) {
        nguoiDungDAO = new NguoiDungDao(Them_UserActivity.this);
        String username = edUser.getText().toString();
        String pass = edPass.getText().toString();
        String phone = edPhone.getText().toString();
        String fullname = edFullName.getText().toString();

        NguoiDung nguoiDung = new NguoiDung(username, pass, phone, fullname);

        boolean isInsertTrue = nguoiDungDAO.inserNguoiDung(nguoiDung);
        if (isInsertTrue) {
            Toast.makeText(getApplicationContext(), "Thêm Thành Công", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "thêm thất bại", Toast.LENGTH_LONG).show();
        }
    }


}

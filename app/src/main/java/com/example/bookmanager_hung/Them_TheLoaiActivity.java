package com.example.bookmanager_hung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookmanager_hung.dao.TheLoaiDao;
import com.example.bookmanager_hung.model.TheLoai;

public class Them_TheLoaiActivity extends AppCompatActivity {
    Intent intent;
    TheLoaiDao theLoaiDao;
    EditText edID, edTenTL, edMota, edVitri;
    Button btnThem, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_the_loai);
        edID = findViewById(R.id.edIDTL);
        edTenTL = findViewById(R.id.edTenTL);
        edMota = findViewById(R.id.edMota);
        edVitri = findViewById(R.id.edVitri);
        btnThem = findViewById(R.id.btnThem);
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Them_TheLoaiActivity.this, Screen_TheLoai.class);
                startActivity(intent);
            }
        });
    }

    public void AddTL(View view) {
        theLoaiDao = new TheLoaiDao(Them_TheLoaiActivity.this);
        String maTheLoai = edID.getText().toString();
        String tenTheLoai = edTenTL.getText().toString();
        String moTa = edMota.getText().toString();
        String viTri = edVitri.getText().toString();
        TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai, moTa, viTri);
        boolean isInsertTrue = theLoaiDao.insertTheLoai(theLoai);
        if (isInsertTrue) {
            Toast.makeText(getApplicationContext(), "Thêm Thành Công", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "thêm thất bại", Toast.LENGTH_LONG).show();
        }


    }
}


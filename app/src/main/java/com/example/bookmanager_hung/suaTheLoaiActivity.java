package com.example.bookmanager_hung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookmanager_hung.dao.TheLoaiDao;

public class suaTheLoaiActivity extends AppCompatActivity {
    Button btnUPdate;
    Intent intent;
    TheLoaiDao theLoaiDAO;
    EditText edTenTheLoai, edMoTa;
    String maTheLoai, tenTheLoai, moTa;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_the_loai);
        btnUPdate = findViewById(R.id.btnSuaTheLoai);
        edMoTa = findViewById(R.id.edMoTa);
        edTenTheLoai = findViewById(R.id.edTenTheLoai);
        btnShow = findViewById(R.id.btnShowDStheLoai);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(suaTheLoaiActivity.this, Screen_TheLoai.class);
            }
        });
        intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            maTheLoai = b.getString("matheloai");
            tenTheLoai = b.getString("tentheloai");
            moTa = b.getString("mota");
            edTenTheLoai.setText(tenTheLoai);
            edMoTa.setText(moTa);
        }
        setTitle("update The Loai");
    }

    public void UpdateTheLoai(View view) {
        String tenTheLoai = edTenTheLoai.getText().toString();
        String moTa = edMoTa.getText().toString();
        TheLoaiDao theLoaiDAO = new TheLoaiDao(suaTheLoaiActivity.this);

        if (theLoaiDAO.updateInfoTheLoai(maTheLoai, tenTheLoai, moTa) > 0) {
            Toast.makeText(this, "Update thanh cong", Toast.LENGTH_LONG).show();
            intent = new Intent(this, suaTheLoaiActivity.class);
            startActivity(intent);
        }

    }
}

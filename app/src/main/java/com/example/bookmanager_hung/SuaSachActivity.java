package com.example.bookmanager_hung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bookmanager_hung.dao.SachDAO;
import com.example.bookmanager_hung.dao.TheLoaiDao;
import com.example.bookmanager_hung.model.Sach;
import com.example.bookmanager_hung.model.TheLoai;

import java.util.ArrayList;

public class SuaSachActivity extends AppCompatActivity {
    ArrayList<TheLoai> theLoaiArrayList;
    TheLoaiDao theLoaiDao;
    Intent intent;
    SachDAO sachDAO;
    Spinner spnMatheloai;
    EditText edTenSach, edTacgia, edNXB, edGiabia, edSoluong, edmaSach;
    String maSach, maTheloai, tenSach, NXB, giaBia, soLuong, tacGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_sach);
        spnMatheloai = findViewById(R.id.spnTheLoai);
        edTenSach = findViewById(R.id.edtenSachsua);
        edGiabia = findViewById(R.id.edGiaBiasua);
        edTacgia = findViewById(R.id.edTacGiasua);
        //edNXB = findViewById(R.id.edNXB);
        edSoluong = findViewById(R.id.edSoLuongsua);
        edmaSach = findViewById(R.id.edIDSachsua);
        hienthi();
        theLoaiDao = new TheLoaiDao(this);
        theLoaiArrayList = (ArrayList<TheLoai>) theLoaiDao.getALLTheloai();
        ArrayAdapter arrayAdapterSach = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item);
        spnMatheloai.setAdapter(arrayAdapterSach);
        spnMatheloai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maTheloai = theLoaiArrayList.get(spnMatheloai.getSelectedItemPosition()).getMaTheLoai();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void hienthi() {
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        edmaSach.setText(b.getString("maSach"));
        edTenSach.setText(b.getString("tenSach"));
        // edNXB.setText(b.getString("NXB"));
        edTacgia.setText(b.getString("tacGia"));
        edGiabia.setText((b.getString("giaBia")));
        edSoluong.setText(b.getString("soLuong"));
    }

    public void suaSach(View view) {
        SachDAO sachDAO = new SachDAO(this);
        if (sachDAO.updateSach(maSach, maTheloai, edTenSach.getText().toString(), edTacgia.getText().toString(), edNXB.getText().toString(), edGiabia.getText().toString(), edSoluong.getText().toString()) > 0) {
            Toast.makeText(this, "update Thanh Cong", Toast.LENGTH_LONG).show();
        }
    }
}


package com.example.bookmanager_hung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bookmanager_hung.dao.SachDAO;
import com.example.bookmanager_hung.dao.TheLoaiDao;
import com.example.bookmanager_hung.model.Sach;
import com.example.bookmanager_hung.model.TheLoai;

import java.util.ArrayList;

public class Them_SachActivity extends AppCompatActivity {
    Intent intent;
    Button btnShowSach, btnThem, btnHuy;
    SachDAO sachDAO;
    TheLoaiDao theLoaiDao;
    Spinner spnTheloai;
    EditText edMaSach, edTenSach, edNXB, edTacGia, edGiaBia, edSoLuong;
    String maTheLoai = "";
    ArrayList<TheLoai> theLoaiArrayList;
    ArrayList<String> abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__sach);
        setTitle("Thêm Sách");
        spnTheloai = findViewById(R.id.spnTheLoai);
        edMaSach = findViewById(R.id.edMaSach);
        edTacGia = findViewById(R.id.edTacGia);
        edTenSach = findViewById(R.id.edTenSach);
        edNXB = findViewById(R.id.edNXB);
        edGiaBia = findViewById(R.id.edGiaBia);
        edSoLuong = findViewById(R.id.edSoLuong);
        btnThem = findViewById(R.id.btnThem);
        btnShowSach = findViewById(R.id.btnShowBook);
        btnShowSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Them_SachActivity.this, Screen_SachActivity.class);
                startActivity(intent);
            }
        });
        theLoaiDao = new TheLoaiDao(this);
        theLoaiArrayList = (ArrayList<TheLoai>) theLoaiDao.getALLTheloai();
//        abc = new ArrayList<>();
//        for (int i=0;i<theLoaiArrayList.size();i++){
//            abc.add(theLoaiArrayList.get(i).getTenTheLoai());
//
//        }

        ArrayAdapter arrayAdapterSach = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, theLoaiArrayList);
        spnTheloai.setAdapter(arrayAdapterSach);
        spnTheloai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maTheLoai = theLoaiArrayList.get(spnTheloai.getSelectedItemPosition()).getMaTheLoai();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void addBook(View view) {

        SachDAO sachDAO = new SachDAO(Them_SachActivity.this);
        Sach sach = new Sach(edMaSach.getText().toString(), maTheLoai, edTenSach.getText().toString(), edNXB.getText().toString(), edSoLuong.getText().toString(), edTacGia.getText().toString(), edGiaBia.getText().toString());

        try {
            if (sachDAO.inserSach(sach) > 0) {
                Toast.makeText(this, "Thêm Sách Thành Công", Toast.LENGTH_LONG).show();


            } else {
                Toast.makeText(this, "Thêm Sách Thất Bại", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {

        }
    }

}
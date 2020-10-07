package com.example.bookmanager_hung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bookmanager_hung.adapter.TheLoaiAdapter;
import com.example.bookmanager_hung.dao.TheLoaiDao;
import com.example.bookmanager_hung.model.TheLoai;

import java.util.ArrayList;

public class Screen_TheLoai extends AppCompatActivity {
    Intent intent;
    ListView lvTL;
    ArrayList<TheLoai> dsTheloai = new ArrayList<>();
    TheLoaiDao theLoaiDao;
    TheLoaiAdapter theLoaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen__the_loai);
        lvTL = findViewById(R.id.ListTheLoai);
        dsTheloai = new ArrayList<>();
        theLoaiDao = new TheLoaiDao(this);
        dsTheloai = (ArrayList<TheLoai>) theLoaiDao.getALLTheloai();
        theLoaiAdapter = new TheLoaiAdapter(this, dsTheloai, R.layout.item_theloai);
        lvTL.setAdapter(theLoaiAdapter);
        lvTL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(Screen_TheLoai.this, suaTheLoaiActivity.class);
                Bundle b = new Bundle();
                b.putString("matheloai", dsTheloai.get(i).getMaTheLoai());
                b.putString("tentheloai", dsTheloai.get(i).getTenTheLoai());
                b.putString("mota", dsTheloai.get(i).getMoTa());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_theloai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addTheLoai:
                intent = new Intent(Screen_TheLoai.this, Them_TheLoaiActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

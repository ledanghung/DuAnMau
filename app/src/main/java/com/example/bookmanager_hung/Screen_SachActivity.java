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
import android.widget.SearchView;

import com.example.bookmanager_hung.adapter.SachAdapter;
import com.example.bookmanager_hung.dao.SachDAO;
import com.example.bookmanager_hung.model.Sach;

import java.util.ArrayList;

public class Screen_SachActivity extends AppCompatActivity {
    Intent intent;
    ListView listView;
    ArrayList<Sach> sachArrayList;
    SachDAO sachDAO;
    SachAdapter sachAdapter = null;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen__sach);
        listView = findViewById(R.id.lvSach);
        searchView = findViewById(R.id.svSach);

        sachArrayList = new ArrayList<>();
        sachDAO = new SachDAO(this);
        sachArrayList = (ArrayList<Sach>) sachDAO.getAllSach();
        sachAdapter = new SachAdapter(Screen_SachActivity.this, sachArrayList, R.layout.item_sach);
        listView.setAdapter(sachAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(Screen_SachActivity.this, SuaSachActivity.class);
                Bundle b = new Bundle();
                b.putString("maSach", sachArrayList.get(i).getMaSach());
                b.putString("tenSach", sachArrayList.get(i).getTenSach());
                b.putString("soLuong", sachArrayList.get(i).getSoLuong());
                b.putString("giaBia", sachArrayList.get(i).getGiaBia());
                b.putString("tacGia", sachArrayList.get(i).getTacGia());
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
                intent = new Intent(Screen_SachActivity.this, Them_SachActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
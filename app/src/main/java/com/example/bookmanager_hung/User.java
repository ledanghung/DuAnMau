package com.example.bookmanager_hung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.bookmanager_hung.adapter.UserAdapter;
import com.example.bookmanager_hung.dao.NguoiDungDao;
import com.example.bookmanager_hung.model.NguoiDung;

import java.util.ArrayList;

public class User extends AppCompatActivity {
    Intent intent;
    ListView lvNguoiDung;
    ArrayList<NguoiDung> dsNguoiDung;
    NguoiDungDao nguoiDungDao;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Quan Ly  Nguoi Dung");
        setContentView(R.layout.activity_user);
        lvNguoiDung = findViewById(R.id.lvNguoiDung);
        dsNguoiDung = new ArrayList<>();
        nguoiDungDao = new NguoiDungDao(this);
        dsNguoiDung = (ArrayList<NguoiDung>) nguoiDungDao.getALLnguoiDung();
        userAdapter = new UserAdapter(this, dsNguoiDung, R.layout.item_user);
        lvNguoiDung.setAdapter(userAdapter);

//        lvNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(User.this,SuaNDActivity.class);
//                Bundle b = new Bundle();
//                b.putString("username",dsNguoiDung.get(i).getUsename());
//                b.putString("phone",dsNguoiDung.get(i).getPhone());
//                b.putString("fullname",dsNguoiDung.get(i).getFullname());
//                intent.putExtras(b);
//                startActivity(intent);
////            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.adduser:
                intent = new Intent(User.this, Them_UserActivity.class);
                startActivity(intent);
                return true;
            case R.id.changepass:
                intent = new Intent(User.this, ChangePass.class);
                startActivity(intent);

                return true;
            case R.id.exitUser:
                intent = new Intent(User.this, LoginActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

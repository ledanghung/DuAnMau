package com.example.bookmanager_hung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bookmanager_hung.dao.NguoiDungDao;

public class SuaNDActivity extends AppCompatActivity {
    EditText edusername, edphone, edfullname;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_nd);
        edfullname = (EditText) findViewById(R.id.edfullname);
        edphone = (EditText) findViewById(R.id.edPhone);
        edusername = (EditText) findViewById(R.id.edUsername);
        btnSave = findViewById(R.id.btnsave);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            edusername.setText(b.getString("username"));
            edphone.setText(b.getString("phone"));
            edfullname.setText(b.getString("fullname"));

        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDungDao nguoiDungDao = new NguoiDungDao(SuaNDActivity.this);
                String username = edusername.getText().toString();
                String phone = edphone.getText().toString();
                String fullname = edfullname.getText().toString();
                nguoiDungDao.updateNguoiDung(username, phone, fullname);
                Intent intent = new Intent(SuaNDActivity.this, User.class);
                startActivity(intent);
            }
        });
    }
}

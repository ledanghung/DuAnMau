package com.example.bookmanager_hung.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import com.example.bookmanager_hung.database.DatabaseHelper;
import com.example.bookmanager_hung.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDao {
    public static final String TABLE_NAME = "TheLoai";
    public static final String SQL_THE_LOAI = " " +
            "CREATE TABLE TheLoai (matheloai text primary key, tentheloai text, mota text, vitri text);";
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static String TAG = "Đ ";

    public TheLoaiDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public boolean insertTheLoai(TheLoai tl) {
        ContentValues values = new ContentValues();
        values.put("matheloai", tl.getMaTheLoai());
        values.put("tentheloai", tl.getTenTheLoai());
        values.put("mota", tl.getMoTa());
        values.put("vitri", tl.getViTri());

        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == 1) {
                return false;
            }
        } catch (Exception e) {
            Log.e("TheLoaiDAO", e.toString());
            return false;
        }
        return true;
    }

    public int deleteTheloai(String matheloai) {
        int result = db.delete(TABLE_NAME, "matheloai=?", new String[]{matheloai});
        if (result == 0) {
            return -1; //delete khong thanh cong
        } else {
            return 1;
        }
    }

    public List<TheLoai> getALLTheloai() {
        List<TheLoai> dsTheloai = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            TheLoai tl = new TheLoai();
            tl.setMaTheLoai(c.getString(0));
            tl.setTenTheLoai(c.getString(1));
            tl.setMoTa(c.getString(2));
            tl.setViTri(c.getString(3));
            dsTheloai.add(tl);
            Log.d("//=====", tl.toString());
            c.moveToNext();
        }
        c.close();
        return dsTheloai;
    }

    public int updateInfoTheLoai(String maTheloai, String tenTheLoai, String moTa) {
        ContentValues values = new ContentValues();
        values.put("tentheloai", tenTheLoai);
        values.put("mota", moTa);
        values.put("matheloai", maTheloai);
        int result = db.update(TABLE_NAME, values, "matheloai=?", new String[]{maTheloai});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

}

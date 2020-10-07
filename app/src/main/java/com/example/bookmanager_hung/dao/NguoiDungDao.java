package com.example.bookmanager_hung.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import com.example.bookmanager_hung.database.DatabaseHelper;
import com.example.bookmanager_hung.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    public static final String TABLE_NAME = "NguoiDung";
    public static final String SQL_NGUOI_DUNG = "" + "CREATE TABLE NguoiDung (username text primary key," +
            "password text, phone text, hoten text);";

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static String TAG = "Đifhfg ";

    public NguoiDungDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public boolean inserNguoiDung(NguoiDung nd) {
        ContentValues values = new ContentValues();
        values.put("username", nd.getUsename());
        values.put("password", nd.getPass());
        values.put("phone", nd.getPhone());
        values.put("hoten", nd.getFullname());
        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == -1) {
                return false;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
            return false;
        }
        return true;
    }

    public boolean isLogin(NguoiDung nd) {
        String sqlSelect = "select username, password from nguoidung " + " where username = ? and password=? ";
        Cursor c = db.rawQuery(sqlSelect, new String[]{nd.getUsename(), nd.getPass()});
        if (c.moveToFirst()) {
            return true;
        }
        return false;
    }

    public List<NguoiDung> getALLnguoiDung() {
        List<NguoiDung> dsNguoidung = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NguoiDung objNguoiDung = new NguoiDung();
            objNguoiDung.setUsename(c.getString(0));
            objNguoiDung.setPass(c.getString(1));
            objNguoiDung.setPhone(c.getString(2));
            objNguoiDung.setFullname(c.getString(3));
            dsNguoidung.add(objNguoiDung);
            Log.d("//=====", objNguoiDung.toString());
            c.moveToNext();
        }
        c.close();
        return dsNguoidung;
    }

    public int deleteNguoiDungByID(String username) {
        int result = db.delete(TABLE_NAME, "username=?", new String[]{username});
        if (result == 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public int updateNguoiDung(String username, String phone, String fullname) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("phone", phone);
        values.put("hoten", fullname);
        int result = db.update(TABLE_NAME, values, "username=?",
                new String[]{username});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}

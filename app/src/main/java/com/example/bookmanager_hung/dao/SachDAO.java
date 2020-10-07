package com.example.bookmanager_hung.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bookmanager_hung.database.DatabaseHelper;
import com.example.bookmanager_hung.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "Sach";
    public static final String SQL_SACH = "CREATE TABLE Sach (maSach text primary key, maTheLoai text, tensach text," +
            "tacGia text, NXB text, giaBia double, soLuong number);";
    public static final String TAG = "SachDAO";

    public SachDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // insert
    public int inserSach(Sach s) {
        ContentValues values = new ContentValues();
        values.put("maSach", s.getMaSach());
        values.put("maTheLoai", s.getMaTheLoai());
        values.put("tenSach", s.getTenSach());
        values.put("tacGia", s.getTacGia());
        values.put("NXB", s.getNXB());
        values.put("giaBia", s.getGiaBia());
        values.put("soLuong", s.getSoLuong());
        if (checkPrimaryKey(s.getMaSach())) {
            int result = db.update(TABLE_NAME, values, "maSach=?", new String[]{s.getMaSach()});
            if (result == 0) {
                return -1;
            }
        } else {
            try {
                if (db.insert(TABLE_NAME, null, values) == -1) {
                    return -1;
                }
            } catch (Exception ex) {

            }
        }
        return 1;
    }

    public boolean checkPrimaryKey(String strPrimaryKey) {
        //select
        String[] columns = {"maSach"};
        //WHERE clause
        String selection = "maSach=?";
        //WHERE clause arguments
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try {
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            if (i <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //getall
    public List<Sach> getAllSach() {
        List<Sach> dsSach = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Sach s = new Sach();
            s.setMaSach(c.getString(0));
            s.setMaTheLoai(c.getString(1));
            s.setTenSach(c.getString(2));
            s.setTacGia(c.getString(3));
            s.setNXB(c.getString(4));
            s.setGiaBia(c.getString(5));
            s.setSoLuong(c.getString(6));
            dsSach.add(s);
            Log.d("//=====", s.toString());
            c.moveToNext();
        }
        c.close();
        return dsSach;
    }

    public int deleteSach(String maSach) {
        int result = db.delete(TABLE_NAME, "maSach=?", new String[]{maSach});
        if (result == 0) {
            return -1;

        } else return 1;
    }

    public int updateSach(String maSach, String maTheLoai, String tenSach, String giaBia, String soLuong, String NXB, String tacGia) {
        ContentValues values = new ContentValues();
        values.put("maSach", maSach);
        values.put("maTheLoai", maTheLoai);
        values.put("tenSach", tenSach);
        values.put("giaBia", giaBia);
        values.put("soLuong", soLuong);
        values.put("NXB", NXB);
        values.put("tacGia", tacGia);
        int result = db.update(TABLE_NAME, values, "maSach=?", new String[]{maSach});
        if (result == 0) {
            return -1;
        } else return 1;
    }

}



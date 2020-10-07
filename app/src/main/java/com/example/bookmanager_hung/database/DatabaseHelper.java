package com.example.bookmanager_hung.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bookmanager_hung.dao.NguoiDungDao;
import com.example.bookmanager_hung.dao.SachDAO;
import com.example.bookmanager_hung.dao.TheLoaiDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager3";

    public static final int VERSION = 6;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NguoiDungDao.SQL_NGUOI_DUNG);
        sqLiteDatabase.execSQL(TheLoaiDao.SQL_THE_LOAI);
        sqLiteDatabase.execSQL(SachDAO.SQL_SACH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + NguoiDungDao.TABLE_NAME);
        sqLiteDatabase.execSQL("Drop table if exists " + TheLoaiDao.TABLE_NAME);
        sqLiteDatabase.execSQL("Drop table if exists " + SachDAO.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

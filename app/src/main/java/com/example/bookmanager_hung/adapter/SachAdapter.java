package com.example.bookmanager_hung.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookmanager_hung.R;
import com.example.bookmanager_hung.Screen_SachActivity;
import com.example.bookmanager_hung.dao.SachDAO;
import com.example.bookmanager_hung.dao.TheLoaiDao;
import com.example.bookmanager_hung.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachAdapter extends BaseAdapter {
    Screen_SachActivity screen_sach;
    ArrayList<Sach> arrSach;
    List<Sach> arrsoftSach;
    SachDAO sachDAO;
    int myLayout;

    public SachAdapter(Screen_SachActivity screen_sach, ArrayList<Sach> arrSach, int mylayout) {
        this.screen_sach = screen_sach;
        this.arrSach = arrSach;
        this.myLayout = mylayout;
    }

    public static class ViewHolder {
        ImageView imgIconbook, iconDeletebook, iconSuabook;
        TextView tvMaSach, tvSoLuong;
    }

    @Override
    public int getCount() {
        return arrSach.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) screen_sach.getSystemService(screen_sach.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(myLayout, null);
            holder.tvMaSach = view.findViewById(R.id.tvMaSach);
            holder.tvSoLuong = view.findViewById(R.id.tvSoLuong);
            holder.iconDeletebook = view.findViewById(R.id.IconDeletebook);
            holder.iconDeletebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sachDAO = new SachDAO(screen_sach);
                    sachDAO.deleteSach(arrSach.get(i).getMaSach());
                    arrSach.remove(i);
                    notifyDataSetChanged();
                }
            });

            //view
            view.setTag(holder);
        } else holder = (ViewHolder) view.getTag();
        Sach sach = arrSach.get(i);
        holder.tvMaSach.setText(sach.getTenSach());
        holder.tvSoLuong.setText(sach.getSoLuong());
        return view;
    }
}

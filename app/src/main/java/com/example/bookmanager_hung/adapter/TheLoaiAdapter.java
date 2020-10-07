package com.example.bookmanager_hung.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookmanager_hung.R;
import com.example.bookmanager_hung.Screen_TheLoai;
import com.example.bookmanager_hung.dao.TheLoaiDao;
import com.example.bookmanager_hung.model.TheLoai;

import java.util.ArrayList;

public class TheLoaiAdapter extends BaseAdapter {
    Screen_TheLoai theLoai;
    ArrayList<TheLoai> listTL;
    int LayoutTL;
    TheLoaiDao theLoaiDao;

    public TheLoaiAdapter(Screen_TheLoai theLoai, ArrayList<TheLoai> listTL, int LayoutTL) {
        this.theLoai = theLoai;
        this.listTL = listTL;
        this.LayoutTL = LayoutTL;
    }

    @Override
    public int getCount() {
        return listTL.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgIconTL, IconDeleteTL;
        TextView edIDTL, edVitri, edTenTL;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) theLoai.getSystemService(theLoai.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(LayoutTL, null);
            holder.imgIconTL = view.findViewById(R.id.imgIconTL);
            holder.IconDeleteTL = view.findViewById(R.id.IconDeleteTL);
            holder.IconDeleteTL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    theLoaiDao = new TheLoaiDao(theLoai);
                    theLoaiDao.deleteTheloai(listTL.get(i).getMaTheLoai());
                    listTL.remove(i);
                    notifyDataSetChanged();
                }
            });
            holder.edIDTL = view.findViewById(R.id.edIDTL);
            holder.edTenTL = view.findViewById(R.id.edTenTL);
            holder.edVitri = view.findViewById(R.id.edVitri);

            view.setTag(holder);
        } else holder = (TheLoaiAdapter.ViewHolder) view.getTag();
        holder.edIDTL.setText(listTL.get(i).getMaTheLoai());
        holder.edTenTL.setText(listTL.get(i).getTenTheLoai());
        holder.edVitri.setText(listTL.get(i).getViTri());
        return view;
    }
}

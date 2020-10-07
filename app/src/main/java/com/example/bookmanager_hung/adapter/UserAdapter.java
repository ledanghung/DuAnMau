package com.example.bookmanager_hung.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bookmanager_hung.R;
import com.example.bookmanager_hung.SuaNDActivity;
import com.example.bookmanager_hung.User;
import com.example.bookmanager_hung.dao.NguoiDungDao;
import com.example.bookmanager_hung.model.NguoiDung;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    Intent intent;
    User user;
    ArrayList<NguoiDung> userList;
    int layoutUser;
    NguoiDungDao nguoiDungDAO;

    public UserAdapter(User user, ArrayList<NguoiDung> userList, int layoutUser) {
        this.user = user;
        this.userList = userList;
        this.layoutUser = layoutUser;
    }

    @Override
    public int getCount() {
        return userList.size();
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
        ImageView imgIconU, iconDelete, iconSuaU;
        TextView edNameU, edPhoneU;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) user.getSystemService(user.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layoutUser, null);
            holder.iconSuaU = view.findViewById(R.id.IconSuaUser);
            holder.iconSuaU.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(user, SuaNDActivity.class);
                    Bundle b = new Bundle();
                    b.putString("username", userList.get(i).getUsename());
                    b.putString("phone", userList.get(i).getPhone());
                    b.putString("fullname", userList.get(i).getFullname());
                    intent.putExtras(b);
                    user.startActivity(intent);
                }
            });
            holder.imgIconU = view.findViewById(R.id.imgIconUser);
            holder.edNameU = view.findViewById(R.id.edNameUser);
            holder.edPhoneU = view.findViewById(R.id.edPhoneUser);
            holder.iconDelete = view.findViewById(R.id.IconDeleteUser);
            holder.iconDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nguoiDungDAO = new NguoiDungDao(user);
                    nguoiDungDAO.deleteNguoiDungByID(userList.get(i).getUserName());
                    userList.remove(i);
                    notifyDataSetChanged();
                }
            });
            view.setTag(holder);
        } else holder = (ViewHolder) view.getTag();
        holder.edNameU.setText(userList.get(i).getUserName());
        holder.edPhoneU.setText(userList.get(i).getPhone());
        return view;
    }
}

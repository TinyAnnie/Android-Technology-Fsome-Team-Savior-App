package com.dut2018.fsometeam.savior;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


//*********************************************//


public class providerAdapter extends BaseAdapter {
    ArrayList<provider> listData;
    LayoutInflater inflater;
    Context mContext;
    //Hamf taoj cuar custom
    public providerAdapter(Context context, ArrayList<provider> listData){

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listData = listData;
        this.mContext = context;

    }
    //trả về số phần tử hiển thị trong listView
    @Override
    public int getCount(){
        return listData.size();
    }

    //Trả về đối tượng được lấy theo vị trí
    @Override
    public Object getItem(int position){
        return listData.get(position);
    }
    @Override
    public long getItemId(int position){
        return  0;
    }
    //Hàm quan trọng nhất, hiển thị giao diện của listView
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Lấy đối tượng cần được hiển thị ở vị trí position
        provider p = listData.get(position);
        //khai báo các component
        TextView txtName, txtAddress, txtDistance;
        ImageView m_imageView;
        //Khởi tạo view
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_provider, parent, false);
        }
        txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtAddress = (TextView) convertView.findViewById(R.id.txtAddress);
        txtDistance = (TextView) convertView.findViewById((R.id.txtDistance));
        //txtImage = (ImageView) convertView.findViewById(R.id.image);
        m_imageView = (ImageView) convertView.findViewById(R.id.image);

        //set dữ liệu vào items của listView
        txtName.setText(p.getM_nameProvider());
        txtAddress.setText(p.getM_addressProvider());
        txtDistance.setText(p.getM_distance());
        m_imageView.setBackground(p.getM_url_image());

        return convertView;
    }
}
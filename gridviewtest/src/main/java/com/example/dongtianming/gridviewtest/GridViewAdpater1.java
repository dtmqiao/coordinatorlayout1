package com.example.dongtianming.gridviewtest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by dongtianming on 2018/8/18.
 */

public class GridViewAdpater1 extends BaseAdapter {
    String string="重庆";
    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        if (convertView==null){
            view=View.inflate(parent.getContext(), R.layout.grid_item,null);
        }
        else {
            view=convertView;
        }
        TextView grid_item_textview=view.findViewById(R.id.grid_item_textview);
        grid_item_textview.setText(string);
        return view;
    }
}

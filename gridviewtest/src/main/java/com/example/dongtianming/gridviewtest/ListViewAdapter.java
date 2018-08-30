package com.example.dongtianming.gridviewtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dongtianming on 2018/8/18.
 */

public class ListViewAdapter extends BaseAdapter {
    List<City> cities;
    Context mContext;

    public ListViewAdapter(List<City> cities, Context mContext) {
        this.cities = cities;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return cities.size()+2;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
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
        ViewHolder viewHolder=null;
        if (getItemViewType(position)==0){
            view=View.inflate(parent.getContext(),R.layout.item,null);
            GridView gridView=view.findViewById(R.id.gridview1);
            gridView.setAdapter(new GridViewAdpater1());
            return view;
        }
        else if (getItemViewType(position)==1){
            view=View.inflate(parent.getContext(),R.layout.item2,null);
            GridView gridView=view.findViewById(R.id.gridview2);
            gridView.setAdapter(new GridViewAdapter2());
            return view;
        }
        else {
            if (convertView==null){
                convertView=View.inflate(parent.getContext(),R.layout.item3,null);
                viewHolder=new ViewHolder();
                viewHolder.textview1=convertView.findViewById(R.id.textview1);
                viewHolder.item_textview=convertView.findViewById(R.id.item_textview);
                convertView.setTag(viewHolder);
            }
            else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            TextView item_textview = viewHolder.item_textview;
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
      return position < 2 ? position : 2;
    }
    public class ViewHolder{
        TextView textview1;
        TextView item_textview;
    }
}

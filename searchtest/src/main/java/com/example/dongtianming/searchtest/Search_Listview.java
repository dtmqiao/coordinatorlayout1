package com.example.dongtianming.searchtest;

import android.content.Context;
import android.widget.ListView;

/**
 * Created by dongtianming on 2018/8/29.
 */

public class Search_Listview extends ListView {
    public Search_Listview(Context context) {

        super(context);

    }


    //通过复写其onMeasure方法、达到对ScrollView适配的效果

    @Override

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}

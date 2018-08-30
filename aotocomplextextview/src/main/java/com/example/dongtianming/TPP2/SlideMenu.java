package com.example.dongtianming.TPP2;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dongtianming on 2018/8/11.
 */

public class SlideMenu extends ViewGroup {
    public SlideMenu(Context context) {
        super(context);
    }

    public SlideMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SlideMenu(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //设置子VIEW的宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View leftmenu=getChildAt(0);
        LayoutParams leftmenuLayoutParams = leftmenu.getLayoutParams();
        leftmenu.measure(leftmenuLayoutParams.width,heightMeasureSpec);
        View content=getChildAt(1);
        content.measure(widthMeasureSpec,heightMeasureSpec);
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View leftmenu=getChildAt(0);
        leftmenu.layout(-leftmenu.getMeasuredWidth(),0,0,b);
        View content=getChildAt(1);
        content.layout(l, t, r, b);
    }
}

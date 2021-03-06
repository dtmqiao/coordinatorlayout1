package com.example.dongtianming.coordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dongtianming on 2018/8/2.
 */

public class SampleTitleBehavior extends CoordinatorLayout.Behavior<View> {
    private float deltaY;//标题顶部与recycler的距离

    public SampleTitleBehavior() {
    }

    public SampleTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (deltaY == 0) {
            deltaY = dependency.getY() - child.getHeight();
            System.out.println("666666666666666666666666666666666距离deltay"+deltaY+"  "+"getY"+dependency.getY()+"   "+"getHeight"+child.getHeight());
        }
       /* float dy = dependency.getY() - child.getHeight();
        dy = dy < 0 ? 0 : dy;
        System.out.println("666666666666666666666666666666666距离dy"+dy+"  "+"getY"+dependency.getY()+"   "+"getHeight"+child.getHeight());
        float y = -(dy / deltaY) * child.getHeight();
        System.out.println("666666666666666666666666666666666距离y"+y+"  "+"getY"+dependency.getY()+"   "+"getHeight"+child.getHeight());*/
        float y=dependency.getY()-deltaY;
        if (y<0){
            y=0;
        }
        child.setTranslationY(-y);
        return true;
    }


}

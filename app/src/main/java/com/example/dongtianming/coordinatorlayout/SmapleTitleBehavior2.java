package com.example.dongtianming.coordinatorlayout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dongtianming on 2018/8/7.
 */

public class SmapleTitleBehavior2 extends CoordinatorLayout.Behavior<ViewGroup> {
    private float deltaY;//标题顶部与recycler的距离
    private boolean isRfresh=false;

    public SmapleTitleBehavior2() {;
    }

    public SmapleTitleBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ViewGroup child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ViewGroup child, View dependency) {
        if (deltaY == 0) {
            deltaY = dependency.getY() - child.getHeight();

        }
       /* float dy = dependency.getY() - child.getHeight();
        dy = dy < 0 ? 0 : dy;
        System.out.println("666666666666666666666666666666666距离dy"+dy+"  "+"getY"+dependency.getY()+"   "+"getHeight"+child.getHeight());
        float y = -(dy / deltaY) * child.getHeight();
        System.out.println("666666666666666666666666666666666距离y"+y+"  "+"getY"+dependency.getY()+"   "+"getHeight"+child.getHeight());*/
        float y=dependency.getY()-deltaY;
        System.out.println("666666666666666666666666666666666距离deltay"+y+"  "+"getY"+dependency.getY()+"   "+"getHeight"+child.getHeight());
        if (y<0){
            y=0;
        }
        View view=view=child.getChildAt(0);;
        if (y>14){
            isRfresh=true;
            view.setAlpha(0);
            view.setEnabled(false);
        }
        if ((y<=14)&&(isRfresh==true)){
            isRfresh=false;
            view.setAlpha(1);
            view.setEnabled(true);
            ObjectAnimator animator=ObjectAnimator.ofFloat(view,"translationX",child.getWidth(),0);
            animator.setDuration(200);
            animator.start();
        }
        child.setTranslationY(-y);
        float alpha = (1/ y)*20;
        child.setAlpha(alpha);

        return true;
    }
}

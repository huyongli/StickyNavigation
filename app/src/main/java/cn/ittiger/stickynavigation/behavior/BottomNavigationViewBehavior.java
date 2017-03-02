package cn.ittiger.stickynavigation.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ylhu on 17-3-2.
 */
public class BottomNavigationViewBehavior extends CoordinatorLayout.Behavior<View> {

    public BottomNavigationViewBehavior() {

    }

    public BottomNavigationViewBehavior(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {

        ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).topMargin = parent.getMeasuredHeight() - child.getMeasuredHeight();
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {

        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        int top = ((AppBarLayout.Behavior)((CoordinatorLayout.LayoutParams)dependency.getLayoutParams()).getBehavior()).getTopAndBottomOffset();
        ViewCompat.setTranslationY(child, -top);
        return false;
    }
}

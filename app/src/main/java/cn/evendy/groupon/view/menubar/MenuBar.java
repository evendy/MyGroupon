package cn.evendy.groupon.view.menubar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.evendy.groupon.R;
import cn.evendy.groupon.view.listener.MenuItemClickListener;


/**
 * @author: evendy
 * @time: 2015/5/18 9:42
 */
public class MenuBar extends LinearLayout {
    private Drawable mDividerDrawable;
    private Context mContext;
    protected MenuItemClickListener menuItemClickListener;

    public MenuBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MenuBar);
        this.mDividerDrawable = a.getDrawable(R.styleable.MenuBar_menu_divider);
        setFocusable(true);
    }

    @Override
    public void addView(View child) {
        if (child.getLayoutParams() == null) {
            LayoutParams lp;
            if (getOrientation() == LinearLayout.HORIZONTAL) {
                lp = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
            } else {
                lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
            lp.setMargins(0, 0, 0, 0);
            child.setLayoutParams(lp);
        }
        child.setFocusable(true);
        child.setClickable(true);

        addDivider();
        super.addView(child);

        setChildViewClickListener(child);
    }

    /**
     * 添加间隔线
     */
    private void addDivider() {
        if (mDividerDrawable != null) {
            ImageView divider = new ImageView(mContext);
            LinearLayout.LayoutParams lp = null;

            if (getOrientation() == HORIZONTAL) {
                lp = new LayoutParams(mDividerDrawable.getIntrinsicWidth(),
                        LayoutParams.MATCH_PARENT);
            } else {
                lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
            lp.setMargins(0, 20, 0,20);
            divider.setLayoutParams(lp);
            divider.setBackgroundDrawable(mDividerDrawable);
            super.addView(divider);
        }
        removeFirstDivider();
    }

    /**
     * 删除第一条间隔线
     */
    public void removeFirstDivider() {
        if (null != mDividerDrawable && getMenuCount() == 1) {
            getChildAt(0).setVisibility(View.GONE);
        }
    }

    public int getMenuCount() {
        int children = getChildCount();

        // If we have dividers, then we will always have an odd number of
        // children: 1, 3, 5, ... and we want to convert that sequence to
        // this: 1, 2, 3, ...
        if (mDividerDrawable != null) {
            children = (children + 1) / 2;
        }
        return children;
    }

    private void setChildViewClickListener(View child) {
        child.setOnClickListener(new OnChildViewClickListener(getMenuCount() - 1));
    }

    private class OnChildViewClickListener implements OnClickListener {
        private int menuIndex;

        public OnChildViewClickListener(int menuIndex) {
            this.menuIndex = menuIndex;
        }

        @Override
        public void onClick(View v) {
            onChildViewClick(v, menuIndex);
        }
    }

    protected void onChildViewClick(View view, int menuIndex) {
        if (null != menuItemClickListener) {
            menuItemClickListener.menuItemClick(view, menuIndex);
        }
    }

    public void setMenuItemClickListener(MenuItemClickListener menuItemClickListener) {
        this.menuItemClickListener = menuItemClickListener;
    }

    public View getChildMenuViewAt(int index) {
        // If we are using dividers, then instead of tab views at 0, 1, 2, ...
        // we have tab views at 0, 2, 4, ...
        if (mDividerDrawable != null) {
            index *= 2;
        }
        return getChildAt(index);
    }
}

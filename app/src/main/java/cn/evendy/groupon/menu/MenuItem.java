package cn.evendy.groupon.menu;

import android.view.View;

/**
 * @author: evendy
 * @time: 2015/5/18 23:48
 * @mail: 244085027@qq.com
 */
public abstract class MenuItem {
    protected <V extends View> V findViewById(View view, int resId) {
        return (V) view.findViewById(resId);
    }

    public abstract View getView();
}

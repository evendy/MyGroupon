package cn.evendy.groupon.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.evendy.groupon.R;

/**
 * @author: evendy
 * @time: 2015/5/17 23:39
 * @mail: 244085027@qq.com
 */
public class MineMenuItem extends MenuItem {
    private LayoutInflater inflater;
    private int nameRes;
    private Drawable icon;

    /**
     * @param context
     * @param iconRes
     * @param nameRes
     */
    public MineMenuItem(Context context, int iconRes, int nameRes) {
        this.inflater = LayoutInflater.from(context);
        this.nameRes = nameRes;
        this.icon = context.getResources().getDrawable(iconRes);

    }

    @Override
    public View getView() {
        View menuView = inflater.inflate(R.layout.view_mine_menu_item, null);
        TextView menuItem = findViewById(menuView, R.id.menu_item);
        menuItem.setText(nameRes);
        //API提示，setCompoundDrawables()调用的时候，Drawable对象必须调用setBounds(int left, int top, int right, int bottom)方法,不然无法正常显示
        icon.setBounds(0, 0, icon.getMinimumWidth(), icon.getMinimumHeight());
        menuItem.setCompoundDrawables(null, icon, null, null);
        return menuView;
    }

}

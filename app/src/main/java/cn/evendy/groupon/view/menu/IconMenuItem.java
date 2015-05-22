package cn.evendy.groupon.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.evendy.groupon.R;

/**
 * @author: evendy
 * @time: 2015/5/17 10:58
 * @mail: 244085027@qq.com
 */
public class IconMenuItem extends MenuItem {

    private LayoutInflater inflater;
    private int iconRes;
    private String nameRes;

    public IconMenuItem(Context context, int iconRes, String nameRes) {
        this.inflater = LayoutInflater.from(context);
        this.iconRes = iconRes;
        this.nameRes = nameRes;
    }

    @Override
    public View getView() {
        View menuView = inflater.inflate(R.layout.view_menu, null);
        ImageView menuIcon = findViewById(menuView, R.id.menu_icon);
        TextView menuName = findViewById(menuView, R.id.menu_name);
        menuIcon.setImageResource(iconRes);
        menuName.setText(nameRes);
        return menuView;
    }


}

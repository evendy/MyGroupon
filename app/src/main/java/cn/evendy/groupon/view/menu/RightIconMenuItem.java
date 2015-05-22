package cn.evendy.groupon.view.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.evendy.groupon.R;

/**
 * @author: evendy
 * @time: 2015/5/21 16:23
 */
public class RightIconMenuItem extends MenuItem {

    private LayoutInflater inflater;
    private Bitmap icon;
    private String title;
    private String content;

    public RightIconMenuItem(Context context, Bitmap icon, String title, String content) {
        this.inflater = LayoutInflater.from(context);
        this.icon = icon;
        this.title = title;
        this.content = content;
    }

    @Override
    public View getView() {
        View menuView = inflater.inflate(R.layout.view_righticon_menuitem, null);
        TextView menuTitle = findViewById(menuView, R.id.menu_title);
        TextView menuContent = findViewById(menuView, R.id.menu_content);
        ImageView menuIcon = findViewById(menuView, R.id.menu_icon);
        if (null != title) {
            menuTitle.setText(title);
        }
        if (null != content) {
            menuContent.setText(content);
        }
        if (null != menuIcon) {
            menuIcon.setImageBitmap(icon);
        }
        return menuView;
    }
}

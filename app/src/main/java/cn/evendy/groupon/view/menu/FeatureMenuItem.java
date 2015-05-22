package cn.evendy.groupon.view.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.evendy.groupon.R;
import cn.evendy.groupon.view.DeleteTextView;

/**
 * @author: evendy
 * @time: 2015/5/18 23:31
 * @mail: 244085027@qq.com
 */
public class FeatureMenuItem extends MenuItem {
    private Context context;
    private Bitmap menuIcon;
    private String menuName;
    private String oPrice;
    private String nPrice;


    public FeatureMenuItem(Context context, Bitmap menuIcon, String menuName, String oPrice, String nPrice) {
        this.context = context;
        this.menuIcon = menuIcon;
        this.menuName = menuName;
        this.oPrice = oPrice;
        this.nPrice = nPrice;
    }

    @Override
    public View getView() {
        View container = LayoutInflater.from(context).inflate(R.layout.view_featured_menuitem, null);
        ImageView vIcon = findViewById(container, R.id.home_featured_menu_icon);
        TextView vName = findViewById(container, R.id.home_featured_menu_name);
        TextView vNprice = findViewById(container, R.id.home_featured_menu_nprice);
        DeleteTextView vOprice = findViewById(container, R.id.home_featured_menu_oprice);
        if (null != menuIcon) {
            vIcon.setImageBitmap(menuIcon);
        }
        if (null != menuName) {
            vName.setText(menuName);
        }
        if (null != nPrice) {
            vNprice.setText("¥ " + nPrice);
        }
        if (null != oPrice) {
            vOprice.setText(oPrice);
        }
        return container;
    }

}

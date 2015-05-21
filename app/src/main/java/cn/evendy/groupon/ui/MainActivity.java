package cn.evendy.groupon.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import cn.evendy.groupon.R;
import cn.evendy.groupon.base.BaseActivity;
import cn.evendy.groupon.fragment.FeaturedFragment;
import cn.evendy.groupon.fragment.HomeFragment;
import cn.evendy.groupon.fragment.MineFragment;
import cn.evendy.groupon.fragment.NearbyFragment;
import cn.evendy.groupon.listener.MenuSelectItemChangeListener;
import cn.evendy.groupon.menu.IconMenuItem;
import cn.evendy.groupon.view.menu.SelectMenuBar;

/**
 * @author: evendy
 * @time: 2015/5/16 16:01
 * @mail: 244085027@qq.com
 */
public class MainActivity extends BaseActivity implements MenuSelectItemChangeListener {
    private static final int TAB_HOME = 0;
    private static final int TAB_NEARBY = 1;
    private static final int TAB_FEATURED = 2;
    private static final int TAB_MINE = 3;

    private SelectMenuBar menuBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        menuBar = findView(R.id.bottom_bar);
        menuBar.addView(new IconMenuItem(getContext(), R.drawable.tab_home, R.string.home).getView());
        menuBar.addView(new IconMenuItem(getContext(), R.drawable.tab_nearby, R.string.nearby).getView());
        menuBar.addView(new IconMenuItem(getContext(), R.drawable.tab_featured, R.string.featured).getView());
        menuBar.addView(new IconMenuItem(getContext(), R.drawable.tab_mine, R.string.mine).getView());

        menuBar.setMenuSelectItemChangeListener(this);
        menuBar.setCurSelectItem(TAB_HOME);
    }

    private void menuItemChange(int menuIndex) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        switch (menuIndex) {
            case TAB_HOME: {
                fragment = new HomeFragment();
                break;
            }
            case TAB_NEARBY: {
                fragment = new NearbyFragment();
                break;
            }
            case TAB_FEATURED: {
                fragment = new FeaturedFragment();
                break;
            }
            case TAB_MINE: {
                fragment = new MineFragment();
                break;
            }
        }
        fragmentTransaction.replace(R.id.main_content, fragment).commit();
    }

    @Override
    public void MenuSelectItemChange(View menuView, int menuIndex) {
        menuItemChange(menuIndex);
    }
}

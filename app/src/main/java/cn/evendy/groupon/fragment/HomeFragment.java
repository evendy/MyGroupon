package cn.evendy.groupon.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.evendy.groupon.R;
import cn.evendy.groupon.base.BaseFragment;
import cn.evendy.groupon.constans.HeaderStyle;
import cn.evendy.groupon.listener.MenuItemClickListener;
import cn.evendy.groupon.listener.HeaderRightBTNClickListener;
import cn.evendy.groupon.listener.HeaderLeftTextClickListener;

import cn.evendy.groupon.menu.FeatureMenuItem;
import cn.evendy.groupon.util.TimeUtils;
import cn.evendy.groupon.view.SearchBar.OnSearchVoiceClickListener;
import cn.evendy.groupon.view.SearchBar.OnSearchTextClickListener;
import cn.evendy.groupon.view.adapter.AdViewPagerAdapter;
import cn.evendy.groupon.view.headerbar.HeaderBar;
import cn.evendy.groupon.view.menu.MenuBar;


/**
 * @author: evendy
 * @time: 2015/5/17 12:19
 * @mail: 244085027@qq.comOn
 */
public class HomeFragment extends BaseFragment implements MenuItemClickListener, OnSearchVoiceClickListener, OnSearchTextClickListener, HeaderLeftTextClickListener, HeaderRightBTNClickListener, AdViewPagerAdapter.ShowItemClickListener {
    @InjectView(R.id.home_featured_menu)
    protected MenuBar featuredMenu;
    @InjectView(R.id.last_hour)
    protected TextView vLastHour;
    @InjectView(R.id.last_min)
    protected TextView vLastMin;
    @InjectView(R.id.last_second)
    protected TextView vLastSecond;
    @InjectView(R.id.all_groupon)
    protected TextView allGrouponBTN;
    @InjectView(R.id.main_home_header)
    protected HeaderBar headerBar;
    @InjectView(R.id.home_style_menu)
    protected ViewPager styleMenu;

    private Timer timer;

    private int bitMapRes = R.mipmap.tuanlist_category_icon_dianying_high;

    private AdViewPagerAdapter adapter;

    private final int count = 16;
    private int row = 2;
    private final int column = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHeader();
        initStyleMenu();
        initFeatureMenu();
        initCountDownTimer();
    }

    private void initStyleMenu() {
        List<Integer> bitMaps = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            bitMaps.add(bitMapRes);
        }

        adapter = new AdViewPagerAdapter(getContext(), bitMaps, row, column);
        styleMenu.setAdapter(adapter);
        adapter.setShowItemClickListener(this);
    }

    private void initHeader() {
        headerBar.init(HeaderStyle.STYLE_HOME_HEADER);
        headerBar.setOnSearchVoiceClickListener(this);
        headerBar.setOnSearchTextClickListener(this);
        headerBar.setOnHeaderLeftTextClickListener(this);
        headerBar.setOnHeaderRightBTNClickListener(this);
        headerBar.setLeftText("深圳");
    }

    private void initFeatureMenu() {
        featuredMenu.addView(new FeatureMenuItem(getContext(), null, "menu", "60", "120").getView());
        featuredMenu.addView(new FeatureMenuItem(getContext(), null, "menu", "60", "120").getView());
        featuredMenu.addView(new FeatureMenuItem(getContext(), null, "menu", "60", "120").getView());
        featuredMenu.setMenuItemClickListener(this);

    }

    private void initCountDownTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 0, 1000);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            refreshCuntDownTimer();
        }
    };

    private void refreshCuntDownTimer() {
        long countdownTime = TimeUtils.getCountdownTime();
        long tLastHour = countdownTime / (60 * 60);
        long tLastMin = countdownTime % (60 * 60) / 60;
        long tLastSecond = countdownTime % 60;
        vLastHour.setText(tLastHour < 10 ? "0" + tLastHour : "" + tLastHour);
        vLastMin.setText(tLastMin < 10 ? "0" + tLastMin : "" + tLastMin);
        vLastSecond.setText(tLastSecond < 10 ? "0" + tLastSecond : "" + tLastSecond);
    }

    @Override
    public void menuItemClick(View menuView, int position) {
        Toast.makeText(getContext(), "click FeatureMenu " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public void onSearchVoiceClick(View view) {
        Toast.makeText(getContext(), "click onSearchVoiceClick ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHeaderLeftTextClick(View view) {
        Toast.makeText(getContext(), "click onHeaderLeftTextClick ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHeaderBTNClick(View view) {
        Toast.makeText(getContext(), "click onHeaderBTNClick ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSearchTextClickListener(View view) {
        Toast.makeText(getContext(), "click onSearchTextClickListener ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowItemClick(long position) {
        Toast.makeText(getContext(), "click onShowItemClick " + position, Toast.LENGTH_SHORT).show();
    }
}

package cn.evendy.groupon.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.evendy.groupon.R;
import cn.evendy.groupon.base.BaseFragment;
import cn.evendy.groupon.constans.HeaderStyle;
import cn.evendy.groupon.module.GrouponItemDTO;
import cn.evendy.groupon.util.CommonUtils;
import cn.evendy.groupon.util.TimeUtils;
import cn.evendy.groupon.view.adapter.FeaturedGrouponAdapter;
import cn.evendy.groupon.view.headerbar.HeaderBar;
import cn.evendy.groupon.view.listener.HeaderRightBTNClickListener;

/**
 * @author: evendy
 * @time: 2015/5/17 12:19
 * @mail: 244085027@qq.com
 */
public class FeaturedFragment extends BaseFragment implements HeaderRightBTNClickListener, AdapterView.OnItemClickListener {
    @InjectView(R.id.main_featured_header)
    protected HeaderBar headerBar;
    @InjectView(R.id.last_hour)
    protected TextView vLastHour;
    @InjectView(R.id.last_min)
    protected TextView vLastMin;
    @InjectView(R.id.last_second)
    protected TextView vLastSecond;
    @InjectView(R.id.featured_groupon)
    protected ListView featuredList;

    private Timer timer;
    private FeaturedGrouponAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_featured, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHeader();
        initCountDownTimer();
        initGrouponMain();
    }

    private void initGrouponMain() {

        List<GrouponItemDTO> list = new ArrayList<GrouponItemDTO>();

        GrouponItemDTO itemDTO = new GrouponItemDTO();
        itemDTO.setName("童子鸡");
        itemDTO.setDistance(419);
        itemDTO.setDescribe("好好吃的童子鸡");
        itemDTO.setSalePrice(80);
        itemDTO.setOriginalPrice(100.0f);
        itemDTO.setSellingPrice(120);
        itemDTO.setScore(4.5f);
        itemDTO.setSaleNumber(1000);
        itemDTO.setFreeAppoint(true);
        list.add(itemDTO);

        itemDTO = new GrouponItemDTO();
        itemDTO.setName("童子鸡");
        itemDTO.setDistance(1500);
        itemDTO.setDescribe("好好吃的童子鸡");
        itemDTO.setSalePrice(80);
        itemDTO.setOriginalPrice(100.0f);
        itemDTO.setSellingPrice(120);
        itemDTO.setScore(4.5f);
        itemDTO.setSaleNumber(1000);
        itemDTO.setVipRight(true);
        itemDTO.setFlashPush(true);
        list.add(itemDTO);

        itemDTO = new GrouponItemDTO();
        itemDTO.setName("童子鸡");
        itemDTO.setDistance(1500);
        itemDTO.setDescribe("好好吃的童子鸡");
        itemDTO.setSalePrice(80);
        itemDTO.setOriginalPrice(100.0f);
        itemDTO.setSellingPrice(120);
        itemDTO.setScore(5);
        itemDTO.setSaleNumber(1000);
        itemDTO.setIsTicket(true);
        list.add(itemDTO);

        itemDTO = new GrouponItemDTO();
        itemDTO.setName("童子鸡");
        itemDTO.setDistance(1500);
        itemDTO.setDescribe("好好吃的童子鸡");
        itemDTO.setSalePrice(80);
        itemDTO.setOriginalPrice(100.0f);
        itemDTO.setSellingPrice(120);
        itemDTO.setScore(4.5f);
        itemDTO.setSaleNumber(1000);
        itemDTO.setIsTicket(true);
        list.add(itemDTO);

        adapter = new FeaturedGrouponAdapter(getContext(), list);
        featuredList.setAdapter(adapter);

        CommonUtils.setListViewHeightBasedOnChildren(featuredList);

        featuredList.setOnItemClickListener(this);
    }

    private void initHeader() {
        headerBar.init(HeaderStyle.STYLE_RIGHTBTN);
        headerBar.setOnHeaderRightBTNClickListener(this);
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
    public void onHeaderBTNClick(View view) {
        showToast("onHeaderBTNClick");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        showToast("click Groupon list " + position);
    }
}

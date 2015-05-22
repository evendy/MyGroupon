package cn.evendy.groupon.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.evendy.groupon.R;
import cn.evendy.groupon.base.BaseFragment;
import cn.evendy.groupon.constans.HeaderStyle;
import cn.evendy.groupon.view.listener.HeaderRightBTNClickListener;
import cn.evendy.groupon.util.TimeUtils;
import cn.evendy.groupon.view.headerbar.HeaderBar;

/**
 * @author: evendy
 * @time: 2015/5/17 12:19
 * @mail: 244085027@qq.com
 */
public class FeaturedFragment extends BaseFragment implements HeaderRightBTNClickListener {
    @InjectView(R.id.main_featured_header)
    protected HeaderBar headerBar;
    @InjectView(R.id.last_hour)
    protected TextView vLastHour;
    @InjectView(R.id.last_min)
    protected TextView vLastMin;
    @InjectView(R.id.last_second)
    protected TextView vLastSecond;

    private Timer timer;

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
}

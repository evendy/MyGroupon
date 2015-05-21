package cn.evendy.groupon;

import android.app.Application;
import android.content.Intent;

import com.baidu.frontia.FrontiaApplication;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: evendy
 * @time: 2015/5/16 17:02
 * @mail: 244085027@qq.com
 */
public class GrouponApplication extends Application {
    private Timer timer;

    @Override
    public void onCreate() {
        super.onCreate();
        FrontiaApplication.
                initFrontiaApplication(getApplicationContext());

        initCounDownTimer();
    }

    private void initCounDownTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendCounDownTimerBroadcast();
            }
        }, 0, 1000);
    }

    private void sendCounDownTimerBroadcast(){
        Intent intent = new Intent();

        sendBroadcast(intent);
    }
}

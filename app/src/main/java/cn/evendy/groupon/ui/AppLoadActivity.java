package cn.evendy.groupon.ui;

import android.os.Bundle;
import android.os.Handler;

import cn.evendy.groupon.R;
import cn.evendy.groupon.base.BaseActivity;

/**
 * @author: evendy
 * @time: 2015/5/16 16:01
 * @mail: 244085027@qq.com
 */
public class AppLoadActivity extends BaseActivity {
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apploading);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                toMainActivity();
            }

        };

        handler.postDelayed(runnable
                , 2000);
    }

    private void toMainActivity() {
        startActivity(MainActivity.class);
        finish();
        overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}

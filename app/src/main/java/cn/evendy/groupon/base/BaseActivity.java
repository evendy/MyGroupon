package cn.evendy.groupon.base;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.baidu.frontia.Frontia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.evendy.groupon.constans.Constants;
import cn.evendy.groupon.util.ScreenUtils;

/**
 * @author: evendy
 * @time: 2015/5/16 16:04
 * @mail: 244085027@qq.com
 */
public class BaseActivity extends FragmentActivity {
    protected List<AsyncTask> mAsyncTasks = new ArrayList<AsyncTask>();
    protected int screenHeight;
    protected int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenHeight = ScreenUtils.getScreenHeight(getContext());
        screenWidth = ScreenUtils.getScreenWidth(getContext());
        Frontia.init(getApplicationContext(), Constants.BAIDU_APPKEY);
    }

    protected <V extends View> V findView(int resId) {
        return (V) findViewById(resId);
    }

    @Override
    protected void onDestroy() {
        clearAsyncTask();
        super.onDestroy();
    }

    protected void putAsyncTask(AsyncTask<Void, Void, Boolean> asyncTask) {
        mAsyncTasks.add(asyncTask.execute());
    }

    protected void clearAsyncTask() {
        Iterator<AsyncTask> iterator = mAsyncTasks
                .iterator();
        while (iterator.hasNext()) {
            AsyncTask asyncTask = iterator.next();
            if (asyncTask != null && !asyncTask.isCancelled()) {
                asyncTask.cancel(true);
            }
        }
        mAsyncTasks.clear();
    }


    protected void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }


    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void startActivity(String action) {
        startActivity(action, null);
    }

    protected void startActivity(String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected Context getContext() {
        return this;
    }

}

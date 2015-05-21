package cn.evendy.groupon.base;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: evendy
 * @time: 2015/5/16 18:34
 * @mail: 244085027@qq.com
 */
public class BaseFragment extends Fragment {
    protected List<AsyncTask> mAsyncTasks = new ArrayList<AsyncTask>();

    public BaseFragment() {
        super();
    }

    @Override
    public void onDestroy() {
        clearAsyncTask();
        super.onDestroy();
    }

    public <V extends View> V findViewById(int id) {
        if (getView() == null)
            return null;
        return (V) getView().findViewById(id);
    }

    protected void putAsyncTask(AsyncTask<Void, Void, Boolean> asyncTask) {
        mAsyncTasks.add(asyncTask.execute());
    }

    protected void clearAsyncTask() {
        Iterator<AsyncTask> iterator = mAsyncTasks
                .iterator();
        while (iterator.hasNext()) {
            AsyncTask<Void, Void, Boolean> asyncTask = iterator.next();
            if (asyncTask != null && !asyncTask.isCancelled()) {
                asyncTask.cancel(true);
            }
        }
        mAsyncTasks.clear();
    }

    /**
     * 通过Class跳转界面 *
     */
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        startActivity(intent);
    }

    protected Context getContext() {
        return getActivity();
    }

    protected void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

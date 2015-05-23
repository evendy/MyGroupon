package cn.evendy.groupon.view;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;

import cn.evendy.groupon.util.CommonUtils;

/**
 * @author: evendy
 * @time: 2015/5/23 12:57
 * @mail: 244085027@qq.com
 */
public class WrapListView extends ListView {
    public WrapListView(Context context) {
        super(context);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        CommonUtils.setListViewHeightBasedOnChildren(this);
    }
}

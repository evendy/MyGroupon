package cn.evendy.groupon.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * @author: evendy
 * @time: 2015/5/23 12:18
 * @mail: 244085027@qq.com
 */
public class CommonUtils {
    private CommonUtils() {
        throw new RuntimeException("cannot init ScreenUtils");
    }

    public static String getDistance(float distance) {
        StringBuilder sb = new StringBuilder();
        sb.append(distance > 1000 ? distance / 1000.0 + "km" : distance + "m");
        return sb.toString();
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        View listItem;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}

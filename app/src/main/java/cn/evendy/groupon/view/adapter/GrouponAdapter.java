package cn.evendy.groupon.view.adapter;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * @author: evendy
 * @time: 2015/5/21 18:06
 */
public class GrouponAdapter extends CommonAdapter<Map<String, String>> {
    public GrouponAdapter(Context context, List<Map<String, String>> list, int itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    public void inflaterView(ViewHolder viewHolder, int position, Map<String, String> item) {

    }
}
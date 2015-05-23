package cn.evendy.groupon.view.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

import cn.evendy.groupon.R;
import cn.evendy.groupon.module.GrouponItemDTO;
import cn.evendy.groupon.util.CommonUtils;

/**
 * @author: evendy
 * @time: 2015/5/21 18:06
 */
public class GrouponAdapter extends CommonAdapter<GrouponItemDTO> {
    public GrouponAdapter(Context context, List<GrouponItemDTO> list) {
        super(context, list, R.layout.view_home_groupon_item);
    }

    @Override
    public void inflaterView(ViewHolder viewHolder, int position, GrouponItemDTO item) {
        if (null != item.getIConUrl()) {

        }

        if (null != item.getName()) {
            viewHolder.setText(R.id.item_name, item.getName());
        }
        if (item.getDistance() > 0) {
            viewHolder.setText(R.id.item_distance, CommonUtils.getDistance(item.getDistance()));
        } else {
            viewHolder.getView(R.id.item_distance).setVisibility(View.INVISIBLE);
        }
        if (null != item.getDescribe()) {
            viewHolder.setText(R.id.item_describe, item.getDescribe());
        }
        if (item.getSalePrice() > 0) {
            viewHolder.getView(R.id.group_sale).setVisibility(View.VISIBLE);
            viewHolder.setText(R.id.item_current_price, "" + item.getSalePrice());
            viewHolder.setText(R.id.item_original_price, "" + item.getOriginalPrice());
        } else {
            viewHolder.getView(R.id.item_price).setVisibility(View.VISIBLE);
            viewHolder.setText(R.id.item_price, getContext().getString(R.string.price, item.getPrice()));
        }
        if (item.isLow()) {
            viewHolder.getView(R.id.item_low_price).setVisibility(View.VISIBLE);
        }
        if (null != item.getActives()) {
            viewHolder.getView(R.id.item_active_price).setVisibility(View.VISIBLE);
        }
        if (item.getSaleNumber() > 0) {
            viewHolder.getView(R.id.item_sale_num).setVisibility(View.VISIBLE);
            viewHolder.setText(R.id.item_sale_num, getContext().getString(R.string.sale_number, item.getSaleNumber()));
        } else {
            viewHolder.getView(R.id.item_sale_num).setVisibility(View.INVISIBLE);
        }
    }
}
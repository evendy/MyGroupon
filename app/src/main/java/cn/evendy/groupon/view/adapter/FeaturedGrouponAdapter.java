package cn.evendy.groupon.view.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

import cn.evendy.groupon.R;
import cn.evendy.groupon.module.GrouponItemDTO;
import cn.evendy.groupon.util.CommonUtils;

/**
 * @author: evendy
 * @time: 2015/5/24 10:24
 * @mail: 244085027@qq.com
 */
public class FeaturedGrouponAdapter extends CommonAdapter<GrouponItemDTO> {
    public FeaturedGrouponAdapter(Context context, List<GrouponItemDTO> list) {
        super(context, list, R.layout.view_featured_groupon_item);
    }

    @Override
    public void inflaterView(ViewHolder viewHolder, int position, GrouponItemDTO item) {
        if (null != item.getIConUrl()) {

        }
        if (item.isFlashPush()) {
            viewHolder.setImageResource(R.id.item_icon_flag, R.mipmap.groupon_ic_flash);
        }
        if (item.isFreeAppoint()) {
            viewHolder.setImageResource(R.id.item_icon_flag, R.mipmap.groupon_ic_free_appoint);
        }

        viewHolder.setText(R.id.item_name, item.getName());
        if (item.isTicket()) {
            viewHolder.getView(R.id.item_ticket).setVisibility(View.VISIBLE);
        }
        viewHolder.setText(R.id.item_distance, CommonUtils.getDistance(item.getDistance()));
        viewHolder.setText(R.id.item_describe, item.getDescribe());
        if (item.isVipRight()) {
            viewHolder.getView(R.id.item_vip_rights).setVisibility(View.VISIBLE);
        }
        viewHolder.setText(R.id.item_price, getContext().getString(R.string.price, item.getSalePrice()));
        viewHolder.setText(R.id.item_original_price, getContext().getString(R.string.price, item.getOriginalPrice()));
        viewHolder.setText(R.id.item_selling_price, "" + item.getSellingPrice());
        viewHolder.setText(R.id.item_score, getContext().getString(R.string.score, item.getScore()));
        viewHolder.setText(R.id.item_sale_num, getContext().getString(R.string.sale_number, item.getSaleNumber()));
    }
}

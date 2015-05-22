package cn.evendy.groupon.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.evendy.groupon.R;
import cn.evendy.groupon.base.BaseFragment;
import cn.evendy.groupon.constans.HeaderStyle;
import cn.evendy.groupon.view.listener.HeaderRightBTNClickListener;
import cn.evendy.groupon.view.listener.MenuItemClickListener;
import cn.evendy.groupon.view.menu.MineMenuItem;
import cn.evendy.groupon.view.headerbar.HeaderBar;
import cn.evendy.groupon.view.menubar.MenuBar;

/**
 * @author: evendy
 * @time: 2015/5/17 12:19
 * @mail: 244085027@qq.com
 */
public class MineFragment extends BaseFragment implements MenuItemClickListener, HeaderRightBTNClickListener {
    @InjectView(R.id.mine_menu)
    protected MenuBar mineMenu;
    @InjectView(R.id.mine_user_avator)
    protected ImageView userAvator;
    @InjectView(R.id.mine_user_name)
    protected TextView userName;
    @InjectView(R.id.mine_paid_msg)
    protected TextView minePaidMsg;
    @InjectView(R.id.mine_vip_tips)
    protected TextView mineVipTips;
    @InjectView(R.id.luckly_money_sum)
    protected TextView lucklyMoney;
    @InjectView(R.id.voucher_num)
    protected TextView voucherNum;
    @InjectView(R.id.main_mine_header)
    protected HeaderBar headerBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHeaderBar();
        initMineMenu();
        initEvents();
    }

    private void initHeaderBar() {
        headerBar.init(HeaderStyle.STYLE_RIGHTBTN);
        headerBar.setOnHeaderRightBTNClickListener(this);
    }

    private void initEvents() {
        minePaidMsg.setText(getResources().getString(R.string.mine_paid_msg, "1"));
        lucklyMoney.setText(getResources().getString(R.string.luckly_money_sum, "0"));
        voucherNum.setText(getResources().getString(R.string.voucher_num, "0"));
    }

    private void initMineMenu() {
        mineMenu.addView(new MineMenuItem(getContext(), R.drawable.mine_coupon, R.string.coupon).getView());
        mineMenu.addView(new MineMenuItem(getContext(), R.drawable.mine_unpaid, R.string.unpaid).getView());
        mineMenu.addView(new MineMenuItem(getContext(), R.drawable.mine_unreceive, R.string.unreceive).getView());
        mineMenu.addView(new MineMenuItem(getContext(), R.drawable.mine_favorite, R.string.favorite).getView());

        mineMenu.setMenuItemClickListener(this);
    }

    @OnClick({R.id.mine_user_item,
            R.id.mine_paid, R.id.mine_paid_item,
            R.id.mine_hotel, R.id.mine_hotel_item,
            R.id.mine_vip, R.id.mine_vip_item,
            R.id.mine_store_card, R.id.mine_store_card_item,
            R.id.mine_luckly_money, R.id.mine_luckly_money_item,
            R.id.mine_voucher, R.id.mine_voucher_item,
            R.id.mine_wallet, R.id.mine_wallet_item,
            R.id.mine_msg, R.id.mine_msg_item
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_user_item: {
                break;
            }
            case R.id.mine_paid:
            case R.id.mine_paid_item: {
                break;
            }
            case R.id.mine_hotel:
            case R.id.mine_hotel_item: {
                break;
            }
            case R.id.mine_vip:
            case R.id.mine_vip_item: {
                break;
            }
            case R.id.mine_store_card:
            case R.id.mine_store_card_item: {
                break;
            }
            case R.id.mine_luckly_money:
            case R.id.mine_luckly_money_item: {
                break;
            }
            case R.id.mine_voucher:
            case R.id.mine_voucher_item: {
                break;
            }
            case R.id.mine_wallet:
            case R.id.mine_wallet_item: {
                break;
            }
            case R.id.mine_msg:
            case R.id.mine_msg_item: {
                break;
            }

        }
    }

    @Override
    public void menuItemClick(View menuView, int menuIndex) {
        showToast("menu " + menuIndex);
    }

    @Override
    public void onHeaderBTNClick(View view) {
        showToast("onHeaderBTNClick ");
    }
}

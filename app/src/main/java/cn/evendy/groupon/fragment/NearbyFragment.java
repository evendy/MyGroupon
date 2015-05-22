package cn.evendy.groupon.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.evendy.groupon.R;
import cn.evendy.groupon.base.BaseFragment;
import cn.evendy.groupon.constans.HeaderStyle;
import cn.evendy.groupon.view.listener.HeaderRightBTNClickListener;
import cn.evendy.groupon.view.headerbar.HeaderBar;

/**
 * @author: evendy
 * @time: 2015/5/17 12:19
 * @mail: 244085027@qq.com
 */
public class NearbyFragment extends BaseFragment implements HeaderRightBTNClickListener {
    @InjectView(R.id.main_nearby_header)
    protected HeaderBar headerBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHeader();
    }

    private void initHeader() {
        headerBar.init(HeaderStyle.STYLE_RIGHTBTN);
        headerBar.setOnHeaderRightBTNClickListener(this);
    }

    @Override
    public void onHeaderBTNClick(View view) {
        showToast("onHeaderBTNClick");
    }
}

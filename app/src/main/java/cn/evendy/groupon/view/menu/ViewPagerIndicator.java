package cn.evendy.groupon.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import cn.evendy.groupon.R;

/**
 * @author: evendy
 * @time: 2015/5/23 08:20
 * @mail: 244085027@qq.com
 */
public class ViewPagerIndicator extends MenuItem{
    private Context context;

    public ViewPagerIndicator(Context context){
        this.context=context;

    }
    @Override
    public View getView() {
        View indicator= LayoutInflater.from(context).inflate(R.layout.view_viewpager_indicator,null);
        return indicator;
    }
}

package cn.evendy.groupon.view.headerbar;

import android.content.Context;
import android.util.AttributeSet;

import cn.evendy.groupon.constans.HeaderStyle;

public class SearchHeaderBar extends HeaderBar {

	public SearchHeaderBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void init(HeaderStyle headerBarStyle) {
		super.init(headerBarStyle);
		switch (headerBarStyle) {
		case STYLE_SEARCHBAR: {
			setSearchBar();
			break;
		}
		default:
			break;
		}
	}

	private void setSearchBar() {
		
	}

}

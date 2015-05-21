package cn.evendy.groupon.view.headerbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.evendy.groupon.R;
import cn.evendy.groupon.constans.HeaderStyle;
import cn.evendy.groupon.listener.HeaderLeftTextClickListener;
import cn.evendy.groupon.listener.HeaderRightBTNClickListener;
import cn.evendy.groupon.view.SearchBar;
import cn.evendy.groupon.view.SearchBar.OnSearchTextClickListener;
import cn.evendy.groupon.view.SearchBar.OnSearchVoiceClickListener;


public class HeaderBar extends LinearLayout {
    protected LayoutInflater mInflater;
    protected View mHeaderBar;
    protected ImageView logoIcon;
    protected LinearLayout leftContainer;
    protected LinearLayout midContainer;
    protected LinearLayout rightContainer;

    protected TextView rightTextView;
    protected TextView leftTitle;
    protected ImageView rightBTN;
    private SearchBar searchBar;
    private TextView leftText;

    protected String title;
    protected String rightText;
    protected int iConId;
    protected int rightIconId;

    protected OnSearchTextClickListener onSearchTextClickListener;
    protected OnSearchVoiceClickListener searchVoiceClickListener;
    protected HeaderRightBTNClickListener headerRightBTNClickListener;
    protected HeaderLeftTextClickListener headerLeftTextClickListener;

    public HeaderBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.styleable.def_style);
    }

    public HeaderBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initViewParams(context, attrs, defStyleAttr);
    }

    private void initViewParams(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar, defStyleAttr, 0);
        title = typedArray.getString(R.styleable.HeaderBar_hTitle);
        rightText = typedArray.getString(R.styleable.HeaderBar_rightText);
        iConId = typedArray.getResourceId(R.styleable.HeaderBar_hIcon, R.mipmap.ic_launcher);
        rightIconId = typedArray.getResourceId(R.styleable.HeaderBar_rightIcon, R.mipmap.mine_settings);

        title = title == null ? "" : title;
        rightText = rightText == null ? "" : title;

        typedArray.recycle();
    }

    private void init(Context context) {
        mInflater = LayoutInflater.from(context);
        mHeaderBar = mInflater.inflate(R.layout.base_headerbar, null);
        addView(mHeaderBar);
        initViews();
    }

    protected void initViews() {
        logoIcon = findHeaderViewById(R.id.logo);
        leftContainer = findHeaderViewById(R.id.headerbar_left_container);
        midContainer = findHeaderViewById(R.id.headerbar_mid_container);
        rightContainer = findHeaderViewById(R.id.headerbar_right_container);
    }

    public void init(HeaderStyle headerBarStyle) {
        cleanChildView();
        switch (headerBarStyle) {
            case STYLE_DEFAULT: {
                defaultTitle();
                break;
            }
            case STYLE_RIGHTBTN: {
                defaultRightBtnHeader();
                break;
            }
            case STYLE_RIGHTTEXT: {
                defaultRightTextHeader();
                break;
            }
            case STYLE_HOME_HEADER: {
                homeHeader();
                break;
            }
            default:
                break;
        }
    }

    private void defaultTitle() {
        logoIcon.setVisibility(View.VISIBLE);
    }

    private void defaultRightBtnHeader() {
        setLeftTitle();
        setRightBTN();
    }

    private void defaultRightTextHeader() {
        setLeftTitle();
        setRightText();
    }

    private void homeHeader() {
        setLeftText();
        setMidSearchBar();
        setRightBTN();
    }

    protected void setLeftTitle() {
        View leftView = mInflater.inflate(R.layout.view_header_logo,
                leftContainer, false);
        leftContainer.addView(leftView);
        leftTitle = findViewById(leftView, R.id.left_title);
        setHeaderTitle(title);
    }

    private void setLeftText() {
        View leftView = mInflater.inflate(R.layout.view_header_left_text,
                leftContainer, false);
        leftContainer.addView(leftView);
        leftText = findViewById(leftView, R.id.header_text_spinner);
        leftText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != headerLeftTextClickListener) {
                    headerLeftTextClickListener.onHeaderLeftTextClick(v);
                }
            }
        });
    }



    private void setMidSearchBar() {
        View leftView = mInflater.inflate(R.layout.view_header_searchbar,
                midContainer, false);
        midContainer.addView(leftView);
        searchBar = findViewById(midContainer, R.id.header_search);
        searchBar
                .setOnSearchVoiceClickListener(new OnSearchVoiceClickListener() {
                    @Override
                    public void onSearchVoiceClick(View view) {
                        if (null != searchVoiceClickListener) {
                            searchVoiceClickListener.onSearchVoiceClick(view);
                        }
                    }
                });
        searchBar.setOnSearchTextClickListener(new OnSearchTextClickListener() {
            @Override
            public void onSearchTextClickListener(View view) {
                onSearchTextClickListener.onSearchTextClickListener(view);
            }
        });
    }

    protected void setRightText() {
        View rightView = mInflater.inflate(R.layout.view_header_right_text,
                rightContainer, false);
        rightContainer.addView(rightView);
        rightTextView = findViewById(rightView, R.id.header_right_text);
        setHeaderRightText(rightText);
        rightTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != headerRightBTNClickListener) {
                    headerRightBTNClickListener.onHeaderBTNClick(v);
                }
            }
        });
    }

    protected void setRightBTN() {
        View rightView = mInflater.inflate(R.layout.view_header_right_btn,
                rightContainer, false);
        rightContainer.addView(rightView);
        rightBTN = findViewById(rightView, R.id.header_right_btn);
        setRightIcon(rightIconId);
        rightBTN.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != headerRightBTNClickListener) {
                    headerRightBTNClickListener.onHeaderBTNClick(v);
                }
            }
        });
    }

    public void setHeaderRightText(String title) {
        if (null != title && rightText != null) {
            this.rightText = title;
            rightTextView.setText(title);
        }
    }

    public void setHeaderTitle(String title) {
        if (null != title && leftTitle != null) {
            this.title = title;
            leftTitle.setText(title);
        }
    }

    public void setRightIcon(int rightIconId) {
        if (null != rightBTN) {
            rightBTN.setImageResource(rightIconId);
        }
    }

    public void setLeftText(String text) {
        if (null != text && null != leftText) {
            leftText.setText(text);
        }
    }

    public void setOnHeaderRightBTNClickListener(HeaderRightBTNClickListener headerRightBTNClickListener) {
        this.headerRightBTNClickListener = headerRightBTNClickListener;
    }

    public void setOnHeaderLeftTextClickListener(
            HeaderLeftTextClickListener headerLeftTextClickListener) {
        this.headerLeftTextClickListener = headerLeftTextClickListener;
    }

    public void setOnSearchVoiceClickListener(
            OnSearchVoiceClickListener searchVoiceClickListener) {
        this.searchVoiceClickListener = searchVoiceClickListener;
    }

    public void setOnSearchTextClickListener(
            OnSearchTextClickListener onSearchTextClickListener) {
        this.onSearchTextClickListener = onSearchTextClickListener;
    }

    private void cleanChildView() {
        leftContainer.removeAllViews();
        midContainer.removeAllViews();
        rightContainer.removeAllViews();
    }

    protected <V extends View> V findHeaderViewById(int id) {
        return findViewById(mHeaderBar, id);
    }

    protected <V extends View> V findViewById(View view, int id) {
        return (V) view.findViewById(id);
    }
}

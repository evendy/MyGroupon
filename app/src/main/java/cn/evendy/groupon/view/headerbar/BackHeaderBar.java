package cn.evendy.groupon.view.headerbar;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import cn.evendy.groupon.R;
import cn.evendy.groupon.constans.HeaderStyle;
import cn.evendy.groupon.listener.HeaderBackBTNClickListener;
import cn.evendy.groupon.listener.SpinnerClickListener;

public class BackHeaderBar extends HeaderBar {
    private View headerBackBTN;
    private TextView headerSpinner;
    private SpinnerClickListener spinnerClickListener;
    protected HeaderBackBTNClickListener headerBackBTNClickListener;

    public BackHeaderBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init(HeaderStyle headerBarStyle) {
        super.init(headerBarStyle);
        switch (headerBarStyle) {
            case STYLE_BACK: {
                backBtnHeader();
                break;
            }
            case STYLE_BACK_RIGHTTEXT: {
                backBtnTextHeader();
                break;
            }
            case STYLE_BACK_RIGHTBTN: {
                backBtnBtntHeader();
                break;
            }
            case STYLE_BACK_SPINNER_RIGHTTEXT: {
                backSpinnerHeader();
                break;
            }
            default:
                break;
        }
    }

    private void backSpinnerHeader() {
        setLeftSpinner();
        setRightText();
    }

    private void backBtnHeader() {
        setLeftBackBTN();
    }

    private void backBtnBtntHeader() {
        setLeftBackBTN();
        setRightBTN();
    }

    private void backBtnTextHeader() {
        setLeftBackBTN();
        setRightText();
    }

    private void setLeftBackBTN() {
        View leftView = mInflater.inflate(R.layout.view_header_back,
                leftContainer, false);
        leftContainer.addView(leftView);
        leftTitle = findViewById(leftView, R.id.left_title);
        setHeaderTitle(title);
        headerBackBTN = findViewById(leftView, R.id.heder_back);
        headerBackBTN.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != headerBackBTNClickListener) {
                    headerBackBTNClickListener.onBackBTNClick(v);
                }
            }
        });
    }

    private void setLeftSpinner() {
        View leftView = mInflater.inflate(R.layout.view_header_back_spinner,
                leftContainer, false);
        leftContainer.addView(leftView);
        headerBackBTN = findViewById(leftView, R.id.heder_back);
        headerBackBTN.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != headerBackBTNClickListener) {
                    headerBackBTNClickListener.onBackBTNClick(v);
                }
            }
        });

        headerSpinner = findViewById(leftView, R.id.heder_spinner);
        headerSpinner.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != spinnerClickListener) {
                    spinnerClickListener.onSpinnerClickListener(v);
                }
            }
        });
    }

    public void setOnSpinnerText(CharSequence text) {
        headerSpinner.setText(text);
    }

    public void setOnSpinnerClickListener(
            SpinnerClickListener spinnerClickListener) {
        this.spinnerClickListener = spinnerClickListener;
    }

    public void setOnBackBTNClickListener(
            HeaderBackBTNClickListener headerBackBTNClickListener) {
        this.headerBackBTNClickListener = headerBackBTNClickListener;
    }

}

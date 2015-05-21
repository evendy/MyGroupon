package cn.evendy.groupon.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import cn.evendy.groupon.R;

public class SearchBar extends EditText implements TextWatcher,
        OnFocusChangeListener {

    private Drawable mClearDrawable;
    private Drawable mSearchDrawable;
    private Drawable mSearchVoiceDrawable;

    private boolean isShowClearIcon;
    private OnSearchVoiceClickListener listener;
    private OnSearchTextClickListener onSearchTextClickListener;

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        // 这里构造方法很重要，不加这个很多属性不能再XML里面定义
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mClearDrawable = getResources().getDrawable(
                R.mipmap.submit_clear_normal);
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(),
                mClearDrawable.getIntrinsicHeight());

        mSearchDrawable = getResources().getDrawable(R.mipmap.searchbar_icon);
        mSearchDrawable.setBounds(0, 0, mSearchDrawable.getIntrinsicWidth(),
                mSearchDrawable.getIntrinsicHeight());

        mSearchVoiceDrawable = getResources().getDrawable(
                R.mipmap.searchbar_icon_voice_normal);
        mSearchVoiceDrawable.setBounds(0, 0,
                mSearchVoiceDrawable.getIntrinsicWidth(),
                mSearchVoiceDrawable.getIntrinsicHeight());

        showClearIcon(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    private void showClearIcon(boolean flag) {
        isShowClearIcon = flag;
        Drawable right = flag ? mClearDrawable : mSearchVoiceDrawable;
        setCompoundDrawables(mSearchDrawable, getCompoundDrawables()[1], right,
                getCompoundDrawables()[3]);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            showClearIcon(getText().length() > 0);
        } else {
            showClearIcon(false);
        }
        showShakeAnimation(hasFocus);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    /**
     * 当输入框里面内容发生变化的时候回调的方法
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int count, int after) {
        showClearIcon(s.length() > 0);
    }

    /**
     * 设置晃动动画
     */
    private void showShakeAnimation(boolean flag) {
        if (flag)
            this.setAnimation(shakeAnimation(5));
        else
            this.clearAnimation();
    }

    /**
     * 晃动动画
     *
     * @param counts 1秒钟晃动多少下
     * @return
     */
    public static Animation shakeAnimation(int counts) {
        Animation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }

    /**
     * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件 当我们按下的位置 在 EditText的宽度 -
     * 图标到控件右边的间距 - 图标的宽度 和 EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向没有考虑
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getCompoundDrawables()[2] != null) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                boolean touchable;
                if (isShowClearIcon) {
                    touchable = event.getX() > (getWidth() - getPaddingRight() - mClearDrawable
                            .getIntrinsicWidth())
                            && (event.getX() < ((getWidth() - getPaddingRight())));
                    if (touchable) {
                        this.setText("");
                    }
                } else {
                    touchable = event.getX() > (getWidth() - getPaddingRight() - mSearchVoiceDrawable
                            .getIntrinsicWidth())
                            && (event.getX() < ((getWidth() - getPaddingRight())));
                    if (touchable && null != listener) {
                        listener.onSearchVoiceClick(this);
                    }
                }
                if (!touchable) {
                    if (null != onSearchTextClickListener) {
                        onSearchTextClickListener.onSearchTextClickListener(this);
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public void setOnSearchVoiceClickListener(
            OnSearchVoiceClickListener listener) {
        this.listener = listener;
    }

    public void setOnSearchTextClickListener(
            OnSearchTextClickListener onSearchTextClickListener) {
        this.onSearchTextClickListener = onSearchTextClickListener;
    }

    public interface OnSearchVoiceClickListener {
        void onSearchVoiceClick(View view);
    }

    public interface OnSearchTextClickListener {
        void onSearchTextClickListener(View view);
    }

}

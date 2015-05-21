package cn.evendy.groupon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import cn.evendy.groupon.R;

/**
 * @author: evendy
 * @time: 2015/5/18 23:52
 * @mail: 244085027@qq.com
 */
public class DeleteTextView extends TextView {
    private int colorIds;
    private Paint paint;

    public DeleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public DeleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);

    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DeleteTextView, defStyleAttr, 0);
        colorIds = typedArray.getColor(R.styleable.DeleteTextView_lineColor, R.color.line_def);
        typedArray.recycle();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(colorIds);
        int width = getWidth();
        int y = getHeight() / 2;
        canvas.drawLine(0, y, width, y, paint);
    }

    public void setLineColor(int colorIds) {
        this.colorIds = colorIds;
        invalidate();
    }
}

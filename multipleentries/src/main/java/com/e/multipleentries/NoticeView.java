package com.e.multipleentries;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

/**
 * @author weioule
 * @date 2019/8/2.
 */
public class NoticeView extends TextSwitcher implements ViewSwitcher.ViewFactory {

    private static final int FLAG_START_AUTO_SCROLL = 0;
    private static final int FLAG_STOP_AUTO_SCROLL = 1;

    private float mTextSize = 16;
    private int textColor = Color.GREEN;
    private long time;

    /**
     * @param textSize  字号
     * @param textColor 字体颜色
     */
    public void setText(float textSize, int textColor) {
        mTextSize = textSize;
        this.textColor = textColor;
    }

    private Context mContext;
    private int currentIndex = -1;
    private ArrayList<SpannableString> textList;
    private Handler handler;

    public NoticeView(Context context) {
        this(context, null);
        mContext = context;
    }

    public NoticeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        textList = new ArrayList<>();
    }

    public void setAnimTime(long animDuration) {
        setFactory(this);
        Animation mInUp = anim(1.2f, 0, animDuration);
        Animation mOutUp = anim(0, -1.2f, animDuration);

        setInAnimation(mInUp);
        setOutAnimation(mOutUp);
        mInUp.setDuration(animDuration);
        mOutUp.setDuration(animDuration);
    }

    private Animation anim(float from, float to, long mDuration) {
        final TranslateAnimation anim = new TranslateAnimation(0, 0f, 0, 0f, Animation.RELATIVE_TO_PARENT, from, Animation.RELATIVE_TO_PARENT, to);
        anim.setDuration(mDuration);
        anim.setFillAfter(false);
        anim.setInterpolator(new LinearInterpolator());
        return anim;
    }

    /**
     * 间隔时间
     *
     * @param time
     */
    public void setTextStillTime(final long time) {
        this.time = time;
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case FLAG_START_AUTO_SCROLL:
                        if (textList.size() > 0) {
                            currentIndex++;
                            setText(textList.get(currentIndex % textList.size()));
                        }
                        handler.sendEmptyMessageDelayed(FLAG_START_AUTO_SCROLL, time);
                        break;
                    case FLAG_STOP_AUTO_SCROLL:
                        handler.removeMessages(FLAG_START_AUTO_SCROLL);
                        break;
                }
            }
        };
    }

    /**
     * 设置数据源
     *
     * @param titles
     */
    public void setTextList(ArrayList<SpannableString> titles) {
        textList.clear();
        textList.addAll(titles);
        currentIndex = 0;
        setCurrentText(textList.get(currentIndex % textList.size()));
        handler.sendEmptyMessageDelayed(FLAG_START_AUTO_SCROLL, time - 800);
    }

    /**
     * 开始滚动
     */
    public void startAutoScroll() {
        if (!handler.hasMessages(FLAG_START_AUTO_SCROLL)) {
            handler.sendEmptyMessageDelayed(FLAG_START_AUTO_SCROLL, time - 800);
        }
    }

    /**
     * 停止滚动
     */
    public void stopAutoScroll() {
        if (handler != null)
            handler.sendEmptyMessage(FLAG_STOP_AUTO_SCROLL);
    }

    @Override
    public View makeView() {
        TextView t = new TextView(mContext);
        t.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        t.setMaxLines(2);
        t.setEllipsize(TextUtils.TruncateAt.END);
        t.setSingleLine();
        t.setTextColor(textColor);
        t.setTextSize(mTextSize);
        t.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        return t;
    }

    public ArrayList<SpannableString> getTextList() {
        return textList;
    }

    public void removeTitle() {
        if (textList != null) {
            textList.clear();
        }
    }
}

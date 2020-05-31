package com.e.multipleentries.deletgate;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.NoticeView;
import com.e.multipleentries.R;
import com.e.multipleentries.base.BaseViewHolder;
import com.e.multipleentries.base.ItemViewDelegate;

import java.util.ArrayList;
import java.util.List;


/**
 * 消息通知轮播提示
 * Created by weioule
 * on 2019/7/19.
 */
public class NoticeDeletgate extends ItemViewDelegate<GameCenterBean> {

    private NoticeView noticeView;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.game_notice_item;
    }

    @Override
    public boolean isForViewType(GameCenterBean item) {
        return "notice".equals(item.getKey());
    }

    @Override
    public void convert(BaseViewHolder holder, final GameCenterBean bean, int position) {
        List<GameCenterBean> list = bean.getList();
        noticeView = holder.getView(R.id.notice_view);
        //避免条目复用重复添加
        if (noticeView.getTextList().size() > 0) return;

        ArrayList<SpannableString> messages = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String userName = list.get(i).getUser_name();
            String name = list.get(i).getName();

            if (TextUtils.isEmpty(userName)) {
                userName = "胡椒粉";
            }
            if (TextUtils.isEmpty(userName)) {
                userName = "小鸟消消";
            }

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("【");
            stringBuffer.append(userName + i);
            stringBuffer.append("】");
            stringBuffer.append("在");
            stringBuffer.append(name);
            stringBuffer.append("游戏中获得");
            stringBuffer.append(list.get(i).getAmount());
            stringBuffer.append("金币");

            int lenght = userName.length() + 2;

            SpannableString spannableString = new SpannableString(stringBuffer);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(0xff2B2A29);
            spannableString.setSpan(colorSpan, lenght, lenght + name.length() + 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

            messages.add(spannableString);
        }

        noticeView.setText(13, 0xFFFF6D2D);
        noticeView.setTextStillTime(2000);
        noticeView.setAnimTime(1000);
        noticeView.setTextList(messages);
    }

    public void startFlipping() {
        if (null != noticeView)
            noticeView.startAutoScroll();
    }

    public void stopFlipping() {
        if (null != noticeView)
            noticeView.stopAutoScroll();
    }
}

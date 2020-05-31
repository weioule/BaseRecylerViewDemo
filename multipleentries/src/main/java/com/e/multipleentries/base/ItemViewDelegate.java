package com.e.multipleentries.base;


import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhy on 16/6/22.
 */
public abstract class ItemViewDelegate<T> {

    protected RemoveItemListener removeItemListener;

    public abstract int getItemViewLayoutId();

    public abstract boolean isForViewType(T item);

    public abstract void convert(BaseViewHolder holder, T t, int adapterPosition);

    public void onViewRecycled(BaseViewHolder holder) {
    }

    public void setViewVisible(View view, int visible) {
        if (view == null) return;
        view.setVisibility(visible);
    }

    public void setRemoveItemListener(RemoveItemListener removeItemListener) {
        this.removeItemListener = removeItemListener;
    }

    public interface RemoveItemListener {
        void removeItem(int podition);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(@NonNull Context context, float dpValue) {
        final DisplayMetrics dm = context.getResources().getDisplayMetrics();
        final float scale = dm.density;
        return (int) (dpValue * scale + 0.5f);
    }
}

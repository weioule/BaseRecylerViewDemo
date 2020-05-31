package com.e.multipleentries.base;


import androidx.collection.SparseArrayCompat;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.e.multipleentries.MyApplication;


/**
 * Created by zhy on 16/6/22.
 */
public class ItemViewDelegateManager<T> {
    SparseArrayCompat<ItemViewDelegate<T>> delegates = new SparseArrayCompat();

    public int getItemViewDelegateCount() {
        return delegates.size();
    }

    public ItemViewDelegateManager<T> addDelegate(ItemViewDelegate<T> delegate) {
        if (delegate != null) {
            delegates.put(delegates.size(), delegate);
        }
        return this;
    }

    public ItemViewDelegateManager<T> addDelegate(int viewType, ItemViewDelegate<T> delegate) {
        if (delegates.get(viewType) != null) {
            throw new IllegalArgumentException(
                    "An ItemViewDelegate is already registered for the viewType = "
                            + viewType
                            + ". Already registered ItemViewDelegate is "
                            + delegates.get(viewType));
        }
        delegates.put(viewType, delegate);
        return this;
    }

    public ItemViewDelegateManager<T> removeDelegate(ItemViewDelegate<T> delegate) {
        if (delegate == null) {
            throw new NullPointerException("ItemViewDelegate is null");
        }
        int indexToRemove = delegates.indexOfValue(delegate);

        if (indexToRemove >= 0) {
            delegates.removeAt(indexToRemove);
        }
        return this;
    }

    public ItemViewDelegateManager<T> removeDelegate(int itemType) {
        int indexToRemove = delegates.indexOfKey(itemType);

        if (indexToRemove >= 0) {
            delegates.removeAt(indexToRemove);
        }
        return this;
    }

    // Multiple entries
    // upgrade
    public int getItemViewType(T item, int position) {
        int delegatesCount = delegates.size();
        for (int i = delegatesCount - 1; i >= 0; i--) {
            ItemViewDelegate<T> delegate = delegates.valueAt(i);
            if (delegate.isForViewType(item)) {
                return delegates.keyAt(i);
            }
        }

        if (MyApplication.isInDebug())
            SmartToast.show("delegate 类型匹配失败！position = " + position);
        return -1;
    }

    public void convert(BaseViewHolder holder, T item, int adapterPosition) {
        ItemViewDelegate<T> delegate = delegates.get(holder.getItemViewType());
        if (delegate != null) {
            delegate.convert(holder, item, adapterPosition);
            return;
        }

        if (MyApplication.isInDebug())
            SmartToast.show("convert() 失败！delegate 未添加，position = " + adapterPosition);
    }

    public void onViewRecycled(BaseViewHolder holder) {
        int delegatesCount = delegates.size();
        for (int i = 0; i < delegatesCount; i++) {
            ItemViewDelegate<T> delegate = delegates.valueAt(i);
            delegate.onViewRecycled(holder);
        }
    }

    public ItemViewDelegate getItemViewDelegate(int viewType) {
        return delegates.get(viewType);
    }

    public int getItemViewLayoutId(int viewType) {
        return getItemViewDelegate(viewType).getItemViewLayoutId();
    }

    public int getItemViewType(ItemViewDelegate itemViewDelegate) {
        return delegates.indexOfValue(itemViewDelegate);
    }
}

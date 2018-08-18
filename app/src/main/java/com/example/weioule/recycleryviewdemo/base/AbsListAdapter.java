package com.example.weioule.recycleryviewdemo.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by weioule.
 * Date on 2018/8/17.
 */
public abstract class AbsListAdapter<E> extends BaseAdapter {

    protected List<E> mDataLists;
    protected LayoutInflater mLayoutInflater;

    private final Object mLock = new Object();

    public AbsListAdapter() {
        mDataLists = new ArrayList<>();
    }

    public AbsListAdapter(List<E> lists) {
        mDataLists = lists;
    }

    @Override
    public int getCount() {
        return mDataLists == null ? 0 : mDataLists.size();
    }

    @Override
    public E getItem(int position) {
        return mDataLists == null ? null : mDataLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            if (mLayoutInflater == null) {
                mLayoutInflater = LayoutInflater.from(parent.getContext());
            }
            convertView = mLayoutInflater.inflate(getLayout(position), parent, false);
            convertView.setTag(this);
        }

        setData(convertView, position);

        return convertView;
    }

    protected abstract int getLayout(int position);

    protected abstract void setData(View convertView, int position);

    public void addItem(E item) {
        addItem(-1, item);
    }

    public void addItem(int position, E item) {
        synchronized (mLock) {
            if (mDataLists == null) {
                mDataLists = new ArrayList<>();
            }

            if (position < 0 || position > mDataLists.size()) {
                mDataLists.add(item);
            } else {
                mDataLists.add(position, item);
            }

            notifyDataSetChanged();
        }
    }

    public void addAll(List<E> lists) {
        synchronized (mLock) {
            if (mDataLists == null) {
                mDataLists = lists;
            } else {
                mDataLists.addAll(lists);
            }

            notifyDataSetChanged();
        }
    }

    public void remove(int position) {
        synchronized (mLock) {
            if (mDataLists != null && position >= 0 && mDataLists.size() > 0 && mDataLists.size() > position) {
                mDataLists.remove(position);
                notifyDataSetChanged();
            }
        }
    }

    public void replace(List<E> lists) {
        synchronized (mLock) {
            mDataLists = lists;
            notifyDataSetChanged();
        }
    }

    public void clear() {
        synchronized (mLock) {
            if (mDataLists != null) {
                mDataLists.clear();
                notifyDataSetChanged();
            }
        }
    }
}

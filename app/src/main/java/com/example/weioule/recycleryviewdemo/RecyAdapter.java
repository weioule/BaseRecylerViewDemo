package com.example.weioule.recycleryviewdemo;

import android.view.View;


import com.example.weioule.recycleryviewdemo.base.BaseRecylerViewAdapter;
import com.example.weioule.recycleryviewdemo.base.BaseViewHolder;

import java.util.List;

/**
 * Author by weioule.
 * Date on 2018/8/17.
 */
public class RecyAdapter extends BaseRecylerViewAdapter<MyBean> {

    public RecyAdapter(List<MyBean> mDataLists) {
        super(mDataLists);
    }

    @Override
    protected int getLayout(int viewType) {
        if (1 == viewType) {
            return R.layout.item;
        } else {
            return R.layout.item2;
        }
    }

    @Override
    public int getMultipleItemViewType(int position) {
        if (position % 2 == 0) {
            return 1;
        } else {
            return super.getMultipleItemViewType(position);
        }
    }

    @Override
    protected void bindData(BaseViewHolder holder, final MyBean data, final int position) {
        if (holder.getItemViewType() == 1) {
            holder.setText(R.id.tv, data.getTv());
            holder.setOnClickListener(R.id.tv, new View.OnClickListener()

            {
                @Override
                public void onClick(View v) {
                    if (null != getOnItemClickListener())
                        getOnItemClickListener().onItemClick(RecyAdapter.this, v, position);
                }
            });
        } else {
            holder.setImageResource(R.id.iv, R.drawable.ic_launcher_background);
        }


    }
}

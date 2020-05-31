package com.e.multipleentries.adapter;

import android.content.Context;


import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.base.BaseRecylerViewAdapter;
import com.e.multipleentries.deletgate.SmallGameItemDeletgate;

import java.util.List;

/**
 * Created by koudai_nick on 2018/9/12.
 */

public class SmallGameItemAdapter extends BaseRecylerViewAdapter<GameCenterBean> {

    public SmallGameItemAdapter(Context context, List<GameCenterBean> list) {
        super(context, list);
        addItemViewDelegate(new SmallGameItemDeletgate());
    }
}

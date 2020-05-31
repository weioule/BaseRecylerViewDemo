package com.e.multipleentries.adapter;

import android.content.Context;

import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.base.BaseRecylerViewAdapter;
import com.e.multipleentries.deletgate.OrdinaryGameItemDelagate;

import java.util.List;

public class OrdinaryGameAdapter extends BaseRecylerViewAdapter<GameCenterBean> {

    public OrdinaryGameAdapter(Context activity, List<GameCenterBean> mDataLists) {
        super(activity, mDataLists);

        addItemViewDelegate(new OrdinaryGameItemDelagate());
    }
}

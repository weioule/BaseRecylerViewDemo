package com.e.multipleentries.adapter;

import android.content.Context;

import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.base.BaseRecylerViewAdapter;
import com.e.multipleentries.deletgate.AgainstGameItemDeletgate;

import java.util.List;

public class AgainstGameAdapter extends BaseRecylerViewAdapter<GameCenterBean> {

    public AgainstGameAdapter(Context activity, List<GameCenterBean> mDataLists) {
        super(activity, mDataLists);

        addItemViewDelegate(new AgainstGameItemDeletgate());
    }
}

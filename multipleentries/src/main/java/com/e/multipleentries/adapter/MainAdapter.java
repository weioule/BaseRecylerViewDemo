package com.e.multipleentries.adapter;

import android.content.Context;

import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.base.BaseRecylerViewAdapter;
import com.e.multipleentries.deletgate.AgainstGameDelegate;
import com.e.multipleentries.deletgate.LbGameDeletgate;
import com.e.multipleentries.deletgate.NoticeDeletgate;
import com.e.multipleentries.deletgate.OrdinaryGameDeletgate;
import com.e.multipleentries.deletgate.SmallGameDeletgate;

import java.util.List;

/**
 * Created by weioule
 * on 2019/7/9.
 */
public class MainAdapter extends BaseRecylerViewAdapter<GameCenterBean> {

    public MainAdapter(Context context, List<GameCenterBean> list) {
        super(context, list);
        addItemViewDelegate(new LbGameDeletgate());
        addItemViewDelegate(new NoticeDeletgate());
        addItemViewDelegate(new AgainstGameDelegate());
        addItemViewDelegate(new OrdinaryGameDeletgate());
        addItemViewDelegate(new SmallGameDeletgate());
    }
}

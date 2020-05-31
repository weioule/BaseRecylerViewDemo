package com.e.multipleentries.deletgate;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.R;
import com.e.multipleentries.RecyclerViewDivider;
import com.e.multipleentries.adapter.SmallGameItemAdapter;
import com.e.multipleentries.base.BaseViewHolder;
import com.e.multipleentries.base.ItemViewDelegate;

/**
 * Created by weioule
 * on 2019/7/9.
 */
public class SmallGameDeletgate extends ItemViewDelegate<GameCenterBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.small_game_item;
    }

    @Override
    public boolean isForViewType(GameCenterBean item) {
        return "develop_game".equals(item.getKey());
    }

    @Override
    public void convert(BaseViewHolder holder, GameCenterBean bean, int position) {
        RecyclerView recyclerView = holder.getView(R.id.recycle_view);
        SmallGameItemAdapter adapter = new SmallGameItemAdapter(holder.itemView.getContext(), bean.getList());
        recyclerView.setLayoutManager(new GridLayoutManager(holder.itemView.getContext(), 2));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        RecyclerViewDivider divider = new RecyclerViewDivider.Builder(holder.getContext())
                .setStyle(RecyclerViewDivider.Style.BOTH)
                .setColor(holder.itemView.getResources().getColor(R.color.transparent))
                .setOrientation(RecyclerViewDivider.GRIDE_VIW)
                .setSize(6)
                .build();

        if (recyclerView.getItemDecorationCount() == 0)
            recyclerView.addItemDecoration(divider);
    }
}

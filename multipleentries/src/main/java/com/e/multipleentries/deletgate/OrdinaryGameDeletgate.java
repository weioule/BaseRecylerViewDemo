package com.e.multipleentries.deletgate;

import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.R;
import com.e.multipleentries.RecyclerViewDivider;
import com.e.multipleentries.adapter.OrdinaryGameAdapter;
import com.e.multipleentries.base.BaseViewHolder;
import com.e.multipleentries.base.ItemViewDelegate;


/**
 * Created by weioule
 * on 2019/7/9.
 */
public class OrdinaryGameDeletgate extends ItemViewDelegate<GameCenterBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.ordinary_game_item;
    }

    @Override
    public boolean isForViewType(GameCenterBean item) {
        return "happy_game".equals(item.getKey());
    }

    @Override
    public void convert(BaseViewHolder holder, final GameCenterBean bean, int position) {
        TextView gameTitle = holder.getView(R.id.tv_title);
        gameTitle.setText(bean.getTitle());

        RecyclerView recyclerView = holder.getView(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        recyclerView.setAdapter(new OrdinaryGameAdapter(holder.getContext(), bean.getList()));

        RecyclerViewDivider divider = new RecyclerViewDivider.Builder(holder.getContext())
                .setStyle(RecyclerViewDivider.Style.BETWEEN)
                .build();
        if (recyclerView.getItemDecorationCount() == 0)
            recyclerView.addItemDecoration(divider);
    }
}

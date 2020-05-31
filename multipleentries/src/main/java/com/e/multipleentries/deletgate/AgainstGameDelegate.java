package com.e.multipleentries.deletgate;

import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.R;
import com.e.multipleentries.RecyclerViewDivider;
import com.e.multipleentries.adapter.AgainstGameAdapter;
import com.e.multipleentries.base.BaseViewHolder;
import com.e.multipleentries.base.ItemViewDelegate;

import java.util.List;


/**
 * 对战游戏
 * Created by weioule
 * on 2019/7/19.
 */
public class AgainstGameDelegate extends ItemViewDelegate<GameCenterBean> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.against_game_item;
    }

    @Override
    public boolean isForViewType(GameCenterBean item) {
        return "fight_game".equals(item.getKey());
    }

    @Override
    public void convert(BaseViewHolder holder, final GameCenterBean bean, int position) {
        List<GameCenterBean> list = bean.getList();
        TextView gameTitle = holder.getView(R.id.tv_title);
        gameTitle.setText(bean.getTitle());

        RecyclerView recyclerView = holder.getView(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.itemView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AgainstGameAdapter(holder.getContext(), list));

        RecyclerViewDivider divider = new RecyclerViewDivider.Builder(holder.getContext())
                .setStyle(RecyclerViewDivider.Style.BOTH)
                .setColor(holder.itemView.getResources().getColor(R.color.transparent))
                .setOrientation(RecyclerViewDivider.HORIZONTAL)
                .setSize(13)
                .build();
        if (recyclerView.getItemDecorationCount() == 0)
            recyclerView.addItemDecoration(divider);
    }
}

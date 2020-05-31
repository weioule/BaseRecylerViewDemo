package com.e.multipleentries.deletgate;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.e.multipleentries.GameCenterBean;
import com.e.multipleentries.NoDoubleClickListener;
import com.e.multipleentries.R;
import com.e.multipleentries.base.BaseViewHolder;
import com.e.multipleentries.base.ItemViewDelegate;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class OrdinaryGameItemDelagate extends ItemViewDelegate<GameCenterBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.ordinary_game_child_item;
    }

    @Override
    public boolean isForViewType(GameCenterBean item) {
        return true;
    }

    @Override
    public void convert(BaseViewHolder holder, final GameCenterBean bean, final int position) {
        ImageView gameIcon = holder.getView(R.id.game_icon);

        Glide.with(holder.itemView.getContext())
                .load(bean.getImg())
                .transform(new RoundedCornersTransformation(dp2px(holder.getContext(), 3), 0))
                .into(gameIcon);

        holder.itemView.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View view) {
                SmartToast.show("ordinary_game_item " + position);
            }
        });
    }
}

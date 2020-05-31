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

/**
 * Created by weioule
 * on 2019/7/9.
 */
public class LbGameDeletgate extends ItemViewDelegate<GameCenterBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.lb_game_item;
    }

    @Override
    public boolean isForViewType(GameCenterBean item) {
        return "limit_game".equals(item.getKey());
    }

    @Override
    public void convert(BaseViewHolder holder, final GameCenterBean bean, final int position) {
        ImageView imageView = holder.getView(R.id.img);
        String img = bean.getImg();
        Glide.with(holder.itemView.getContext())
                .load(img)
                .transform(new RoundedCornersTransformation(dp2px(holder.getContext(), 8), 0))
                .into(imageView);

        holder.itemView.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View view) {
                SmartToast.show("limit_game " + position);
            }
        });
    }
}

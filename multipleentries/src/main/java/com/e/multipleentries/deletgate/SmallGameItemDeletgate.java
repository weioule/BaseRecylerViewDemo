package com.e.multipleentries.deletgate;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
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
public class SmallGameItemDeletgate extends ItemViewDelegate<GameCenterBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.small_game_child_item;
    }

    @Override
    public boolean isForViewType(GameCenterBean item) {
        return true;
    }

    @Override
    public void convert(final BaseViewHolder holder, final GameCenterBean bean, final int position) {
        ImageView imageView = holder.getView(R.id.game_icon);
        Glide.with(holder.itemView.getContext())
                .load(bean.getImg())
                .transform(new RoundedCornersTransformation(dp2px(holder.getContext(), 5), 0))
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        DisplayMetrics display = getDisplayMetrics(holder.getContext());
                        int image_width = resource.getIntrinsicWidth();
                        int image_height = resource.getIntrinsicHeight();
                        // 获取图片宽高，按比例调整图片大小，3为列数
                        int actual_width = display.widthPixels / 3;

                        int actualHeight = image_height * actual_width / (image_width == 0 ? actual_width : image_width);
                        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
//                        params.width = actual_width;
//                        params.height = actualHeight;
                        return false;
                    }
                })
                .into(imageView);

        holder.itemView.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View view) {
                SmartToast.show("small_game_item " + position);
            }
        });
    }
}

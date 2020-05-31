package com.e.multipleentries;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.multipleentries.adapter.MainAdapter;
import com.e.multipleentries.base.ItemViewDelegate;
import com.e.multipleentries.deletgate.NoticeDeletgate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.title_iv_right)
    ImageView title_iv_right;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<GameCenterBean> mDatas = new ArrayList<>();
    private NoticeDeletgate noticeDeletgate;
    private LinearLayoutManager layoutManager;
    private int noticeIndex = -1;

    @OnClick({R.id.title_iv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_iv_left:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        getDatas();
        setData();
    }

    private void getDatas() {
        for (int i = 0; i < 5; i++) {
            GameCenterBean bean = new GameCenterBean();
            switch (i) {
                case 0:
                    bean.setKey("limit_game");
                    bean.setTitle("小游戏");
                    bean.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590748992074&di=9923c5869a147b1a7197c9f8fdeac6c6&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F77782e6d4f5dd46e6891cb4a2597891825132af4.jpg");
                    break;
                case 1:
                    bean.setKey("notice");
                    bean.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590655412965&di=6b6af558de12fa5614cc5553573da16d&imgtype=0&src=http%3A%2F%2Fc1.haibao.cn%2Fimg%2F600_0_100_1%2F1500618372.8727%2Fe4c82dd769a015332af74b2400d9c164.jpg");
                    break;
                case 2:
                    bean.setKey("develop_game");
                    bean.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590655119585&di=b6df8b656cb8906a60aa5a9e7e84ea0a&imgtype=0&src=http%3A%2F%2Fimage.namedq.com%2Fuploads%2F20181003%2F13%2F1538545138-uwLWHskIPZ.jpg");
                    break;
                case 3:
                    bean.setKey("fight_game");
                    bean.setTitle("对战游戏");
                    bean.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590655296660&di=320793df11e9d4d06035d0b5405dc774&imgtype=0&src=http%3A%2F%2Ff2.img4399.com%2Fnewsm~uploads%2Fuserup%2F1702%2F23113035SC.jpg");
                    break;
                case 4:
                    bean.setKey("happy_game");
                    bean.setTitle("福利中心");
                    bean.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590655375620&di=101152895323c4d4d742e96434dab7e5&imgtype=0&src=http%3A%2F%2Fpic.qqtn.com%2Fup%2F2016-6%2F201606281637418276762.png");
                    break;
            }
            bean.setName("王者荣耀" + i);
            if (i == 3 || i == 4 || i == 1) {
                bean.setList(mDatas);
                bean.setList(mDatas);
            }

            bean.setList(mDatas);
            mDatas.add(bean);
        }
    }

    protected void initView() {
        tvTitle.setText("游戏中心");
        title_iv_right.setVisibility(View.VISIBLE);
        adapter = new MainAdapter(this, null);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        RecyclerViewDivider divider = new RecyclerViewDivider.Builder(this)
                .setStyle(RecyclerViewDivider.Style.BOTH)
                .setColor(getResources().getColor(R.color.transparent))
                .setSize(15)
                .build();
        recyclerView.addItemDecoration(divider);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (null != noticeDeletgate) {
                    if ((noticeIndex < firstVisibleItemPosition || noticeIndex > lastVisibleItemPosition))
                        noticeDeletgate.stopFlipping();
                    else
                        noticeDeletgate.startFlipping();
                }
            }
        });
    }

    public void setData() {
        adapter.replace(mDatas);

        for (int i = 0; i < mDatas.size(); i++) {
            if ("notice".equals(mDatas.get(i).getKey())) {
                ItemViewDelegate<GameCenterBean> itemViewDelegate = adapter.getItemViewDelegate(i);
                if (null != itemViewDelegate && itemViewDelegate instanceof NoticeDeletgate) {
                    noticeDeletgate = (NoticeDeletgate) itemViewDelegate;
                    noticeIndex = i;
                }
                break;
            }
        }
    }
}

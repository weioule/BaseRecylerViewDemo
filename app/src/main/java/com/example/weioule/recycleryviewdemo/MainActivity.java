package com.example.weioule.recycleryviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.weioule.recycleryviewdemo.base.BaseRecylerViewAdapter;
import com.example.weioule.recycleryviewdemo.base.RecyclerViewDivider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TextView mView1;
    private TextView mView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv);

        initData();
    }

    public void initData() {

        ArrayList<MyBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyBean bean = new MyBean();
            bean.setTv("recyclerView_itme+ " + i);
            list.add(bean);
        }

        final RecyAdapter recyAdapter = new RecyAdapter(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerViewDivider());
        mRecyclerView.setAdapter(recyAdapter);

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(40));

        mView1 = new TextView(this);
        mView1.setText("我是HeaderView _01");
        mView1.setLayoutParams(params);
        mView1.setGravity(Gravity.CENTER);
        recyAdapter.addHeaderView(mView1);

        TextView view2 = new TextView(this);
        view2.setText("我是HeaderView _02");
        view2.setLayoutParams(params);
        view2.setGravity(Gravity.CENTER);
        recyAdapter.addHeaderView(view2);

        TextView view3 = new TextView(this);
        view3.setText("我是footerView _01");
        view3.setLayoutParams(params);
        view3.setGravity(Gravity.CENTER);
        recyAdapter.addFooterView(view3);

        TextView view4 = new TextView(this);
        view4.setText("我是footerView _02");
        view4.setLayoutParams(params);
        view4.setGravity(Gravity.CENTER);
        recyAdapter.addFooterView(view4, 2);

        recyAdapter.setOnItemClickListener(new BaseRecylerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseRecylerViewAdapter adapter, View view, int position) {
                view.setBackgroundColor(0xffff0000);
            }
        });

        mRecyclerView.postDelayed(new Runnable() {

            @Override
            public void run() {
                mView3 = new TextView(MainActivity.this);
                mView3.setText("我是footerView _03");
                mView3.setLayoutParams(params);
                mView3.setGravity(Gravity.CENTER);
                recyAdapter.addFooterView(mView3);
            }
        }, 3000);


        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyAdapter.removeFooterView(mView3);
            }
        }, 4000);

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyAdapter.removeAllFooterView();
            }
        }, 5000);

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyAdapter.removeHeaderView(mView1);
            }
        }, 6000);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyAdapter.removeAllHeaderView();
            }
        }, 7000);
    }

    private int dp2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}

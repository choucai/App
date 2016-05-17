package com.dream.widget;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dream.adapter.RecyclerAdapter;
import com.dream.app.R;
import com.dream.base.BaseActivity;
import com.dream.model.entity.ModelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * AppBarLayout & CoordinatorLayout & RecyclerView
 *
 * http://blog.csdn.net/feiduclear_up/article/details/46514791
 * <p>
 * 【scroll】所有想滚动出屏幕的view都需要设置这个flag- 没有设置这个flag的view将被固定在屏幕顶部
 * 【enterAlways】 这个flag让任意向下的滚动都会导致该view变为可见，启用快速“返回模式”
 * 【enterAlwaysCollapsed】 当你的视图已经设置minHeight属性又使用此标志时，你的视图只能已最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度
 * 【exitUntilCollapsed】 滚动退出屏幕，最后折叠在顶端
 */
public class Activity03 extends BaseActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;

    private List<ModelBean> beanList;
    private RecyclerAdapter adapter;

    private String des[] = {"云层里的阳光", "好美的海滩", "好美的海滩", "夕阳西下的美景", "夕阳西下的美景", "夕阳西下的美景", "夕阳西下的美景", "夕阳西下的美景", "好美的海滩"};
    private int resId[] = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.img5, R.mipmap.img3, R.mipmap.img1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);

        initView();
        initData();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rv_app_bar);
        //设置布局显示方式
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, true));
        //设置添加删除item时候的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private void initData() {
        beanList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ModelBean bean = new ModelBean();
            bean.setResId(resId[i]);
            bean.setTitle(des[i]);
            beanList.add(bean);
        }
        adapter = new RecyclerAdapter(this, beanList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object object) {
                Toast.makeText(Activity03.this, ((ModelBean) object).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

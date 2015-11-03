package com.dream.widget;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dream.adapter.RecyclerAdapter;
import com.dream.app.R;
import com.dream.base.BaseActivity;
import com.dream.model.entity.ModelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * CollapsingToolbarLayout's Demo
 */
public class CollapsingToolbarLayoutActivity extends BaseActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView ivImage;

    private List<ModelBean> beanList;
    private RecyclerAdapter adapter;

    private String des[] = {"云层里的阳光", "好美的海滩", "好美的海滩", "夕阳西下的美景", "夕阳西下的美景", "夕阳西下的美景", "夕阳西下的美景", "夕阳西下的美景", "好美的海滩"};
    private int resId[] = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.img5, R.mipmap.img3, R.mipmap.img1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);

        initView();
        initData();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("为了梦,追梦");

        ivImage = (ImageView) findViewById(R.id.ivImage);
        ivImage.setImageResource(R.mipmap.img1);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "在此处替换成你自己的行为", Snackbar.LENGTH_LONG).setAction("Action", null).show();
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
                Toast.makeText(CollapsingToolbarLayoutActivity.this, ((ModelBean) object).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}

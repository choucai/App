package com.dream.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dream.base.BaseActivity;

/**
 * 写成可以传参数-动态加载的Activity.
 */
public class ListActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private static final String PACKAGE_PATH = "packagePath";
    private static final String TITLE = "title";
    private static final String ARRAY = "array";

    /**
     *
     */
    public static final String PATH_WIDGET = "com.dream.widget.Activity";

    /**
     *
     */
    public static final String PATH_SENIOR = "com.dream.senior.Activity";


    private String packagePath;

    private Toolbar toolbar;

    private ListView lvAcitivy;

    private String[] strArray;

    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        String title = getIntent().getStringExtra(TITLE);
        setTitle(title);

        toolbar = (Toolbar) findViewById(R.id.tb_widget_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_36dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int array = getIntent().getIntExtra(ARRAY,0);
        strArray = getResources().getStringArray(array);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strArray);

        lvAcitivy = (ListView) findViewById(R.id.lv_activity);
        lvAcitivy.setAdapter(arrayAdapter);
        lvAcitivy.setOnItemClickListener(this);

        packagePath = getIntent().getStringExtra(PACKAGE_PATH);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= 100) {
            Toast.makeText(this, "此列表最多添加100个Item", Toast.LENGTH_SHORT).show();
            return;
        }

        String clzPath = packagePath + (position < 10 ? "0" + position : position);
        try {
            Class activityClass = Class.forName(clzPath);
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "您访问的类路径不存在", Toast.LENGTH_SHORT).show();
        }
    }


    public static void startAction(Context context, String packagePath, String title, int array) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(PACKAGE_PATH, packagePath);
        intent.putExtra(TITLE, title);
        intent.putExtra(ARRAY, array);
        context.startActivity(intent);
    }
}

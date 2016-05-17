package com.dream.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dream.base.BaseActivity;

/**
 * 相关模块列表
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private final String ACTIVITY_PATH = "com.dream.widget.Activity";

    private ListView lvAcitivy;

    private String[] strArray;

    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strArray = getResources().getStringArray(R.array.arr_activity);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strArray);

        lvAcitivy = (ListView) findViewById(R.id.lv_activity);
        lvAcitivy.setAdapter(arrayAdapter);
        lvAcitivy.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position >= 100) {
            Toast.makeText(this,"此列表最多添加100个Item",Toast.LENGTH_SHORT).show();
            return;
        }

        String clzPath = ACTIVITY_PATH + (position < 10 ? "0" + position : position);
        try {
            Class activityClass = Class.forName(clzPath);
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,"您访问的类路径不存在",Toast.LENGTH_SHORT).show();
        }
    }
}

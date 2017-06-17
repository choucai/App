package com.dream.senior;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.dream.app.R;
import com.dream.base.BaseActivity;


/**
 * https://www.aswifter.com/2015/11/04/android-6-permission/
 *
 * android6.0运行时权限详解
 * http://www.jianshu.com/p/57798618bd90#rd
 * <p>
 * Android 6.0 运行时权限处理完全解析
 * http://blog.csdn.net/lmj623565791/article/details/50709663
 * <p>
 * 聊一聊 Android 6.0 的运行时权限
 * https://blog.coding.net/blog/understanding-marshmallow-runtime-permission
 * <p>
 * Android M 新的运行时权限开发者需要知道的一切
 * http://jijiaxin89.com/2015/08/30/Android-s-Runtime-Permission/
 * <p>
 * 在Android 6.0 设备上动态获取权限
 * http://gudong.name/%E6%8A%80%E6%9C%AF/2015/11/10/android_m_permission.html
 */
public class Activity00 extends BaseActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }


    public void onClick(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(Activity00.this, "hava this permission", Toast.LENGTH_SHORT).show();
            // TODO 做自己想做的事.
        } else { //当用户拒绝掉权限时.
            if (ActivityCompat.shouldShowRequestPermissionRationale(Activity00.this, Manifest.permission.READ_CONTACTS)) {

                Toast.makeText(Activity00.this, "true", Toast.LENGTH_SHORT).show();

                AlertDialog dialog = new AlertDialog.Builder(this).
                        setTitle("该权限保证手机不会爆炸^ ^").
                        setPositiveButton("我需要此权限!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(
                                        Activity00.this,
                                        new String[]{Manifest.permission.READ_CONTACTS},
                                        MY_PERMISSIONS_REQUEST_READ_CONTACTS
                                );
                            }
                        }).
                        setNegativeButton("炸吧炸吧~", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Activity00.this, "准备爆炸了", Toast.LENGTH_SHORT).show();
                            }
                        }).
                        show();
            } else {
                Toast.makeText(Activity00.this, "false", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(
                        Activity00.this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS
                );

            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // TODO 做自己想做的事
                } else {
                    showDialog();
                }
                break;
        }
    }

    private void showDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this).
                setTitle("还可以手动开启哦~").
                setMessage("可以前往设置->app->myapp->permission打开").
                setPositiveButton("确定!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();

    }


}

package com.dream.app;

import android.os.Bundle;

import com.dream.base.BaseActivity;
import com.dream.view.EgWidget.CustomView;

public class MainActivity extends BaseActivity {

    private CustomView mCustomView;// 我们的自定义View

    LeakClass leakClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取控件
//        mCustomView = (CustomView) findViewById(R.id.cv);
//        /*
//         * 开线程
//         */
//        new Thread(mCustomView).start();


        leakClass = new LeakClass();
        leakClass.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        leakClass.setIsPlay(false);
        leakClass.interrupt();
        leakClass = null;
    }

    class LeakClass extends Thread {

        boolean isPlay = true;

        @Override
        public void run() {
            while (isPlay) {
//                try {
//                    Thread.sleep(60 * 60 * 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }

        public boolean isPlay() {
            return isPlay;
        }

        public void setIsPlay(boolean isPlay) {
            this.isPlay = isPlay;
        }
    }

}

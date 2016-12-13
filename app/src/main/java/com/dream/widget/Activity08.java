package com.dream.widget;

import android.os.Bundle;

import com.dream.app.R;
import com.dream.base.BaseActivity;
import com.dream.java.pattern.dp11_proxy.Android.Presenter;
import com.dream.java.pattern.dp11_proxy.Android.PresenterImpl;

import static com.dream.java.pattern.dp11_proxy.Android.TestNetToast.createPresenter;

public class Activity08 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window_menu);


        Presenter presenter = createPresenter(PresenterImpl.class);
        presenter.startActionLogin();
    }
}

package com.dream.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.dream.app.R;
import com.dream.base.BaseActivity;

public class SnackBarActivity extends BaseActivity {

    View.OnClickListener mOnClickListener;

    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    snackbar = Snackbar
                            .make(coordinatorLayout, "勇气会带给爱人安全感", Snackbar.LENGTH_INDEFINITE)
                            .setAction("真理", mOnClickListener);

                    snackbar.setActionTextColor(Color.RED);

                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(Color.DKGRAY);

                    TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);

                    snackbar.show();
                }
            }
        });

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setChecked(false);
                snackbar.dismiss();
            }
        };
    }

}

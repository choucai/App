package com.dream.net;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dream.app.R;
import com.dream.base.BaseActivity;
import com.dream.model.entity.BookInUser;
import com.dream.model.entity.BookParcelable;
import com.dream.model.entity.BookSerializable;

/**
 * Android序列化：Serializable和Parcelable详解.
 * <p/>
 * http://blog.csdn.net/k845824379/article/details/49617959
 * <p/>
 * Serializable参见 {@link BookSerializable}
 */
public class Activity01 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable_parcelable);
    }

    public void onClick(View view){
        BookParcelable bookParcelable = new BookParcelable(52,"I love you");
        BookInUser bookInUser = new BookInUser(25,"Love",bookParcelable);

        Intent intent = new Intent(this,Activity00.class);
        intent.putExtra("Book",bookInUser);
        startActivity(intent);
    }
}

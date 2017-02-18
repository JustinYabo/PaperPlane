package com.xpp.neo1.paperplane.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.xpp.neo1.paperplane.app.App;

/**
 * Created by neo1 on 2017/2/10.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        ((App)getApplicationContext()).addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App)getApplicationContext()).removeActivity(this);
    }
}

package com.xpp.neo1.paperplane.account.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xpp.neo1.paperplane.R;
import com.xpp.neo1.paperplane.app.App;
import com.xpp.neo1.paperplane.app.AppComponent;
import com.xpp.neo1.paperplane.base.BaseActivity;

import javax.inject.Inject;

public class RegisterActivity extends BaseActivity {
    @Inject
    App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

}

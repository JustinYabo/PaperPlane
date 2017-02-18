package com.xpp.neo1.paperplane.app;

import com.xpp.neo1.paperplane.account.login.LoginActivity;
import com.xpp.neo1.paperplane.account.register.RegisterActivity;
import com.xpp.neo1.paperplane.base.BaseActivity;
import com.xpp.neo1.paperplane.home.MainActivity;

import dagger.Component;

/**
 * Created by neo1 on 2017/2/15.
 */
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity activity);
}

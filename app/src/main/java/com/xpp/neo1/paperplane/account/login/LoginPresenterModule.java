package com.xpp.neo1.paperplane.account.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neo1 on 2017/2/16.
 */
@Module
public class LoginPresenterModule {
    private final LoginContract.View view;

    public LoginPresenterModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    LoginContract.View view() {
        return this.view;
    }
}

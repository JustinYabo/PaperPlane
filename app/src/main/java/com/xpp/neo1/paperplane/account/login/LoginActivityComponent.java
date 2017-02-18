package com.xpp.neo1.paperplane.account.login;

import dagger.Component;
import dagger.Module;

/**
 * Created by neo1 on 2017/2/16.
 */
@Component(modules = {LoginPresenterModule.class})
public interface LoginActivityComponent {
    void inject(LoginActivity loginActivity);

}

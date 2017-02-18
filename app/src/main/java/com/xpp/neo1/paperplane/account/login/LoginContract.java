package com.xpp.neo1.paperplane.account.login;

import com.xpp.neo1.paperplane.base.BasePresenter;
import com.xpp.neo1.paperplane.base.BaseView;
import com.xpp.neo1.paperplane.bean.User;

/**
 * Created by neo1 on 2017/2/13.
 */

public interface LoginContract {
    interface View extends BaseView{
        String getUserName();

        String getPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity(User user);

        void showFailedError();

        void toRegisterActivity();
    }

    interface Presenter extends BasePresenter {
        void login(String username, String password);
    }
}

package com.xpp.neo1.paperplane.account.register;

import com.xpp.neo1.paperplane.base.BasePresenter;
import com.xpp.neo1.paperplane.base.BaseView;

/**
 * Created by neo1 on 2017/2/13.
 */

public interface RegisterContract {
    interface View extends BaseView{
        void showResgistering();

        void hideResgistering();

        void back();

        void toMainActivity();

        void showFailedError();

    }

    interface Presenter extends BasePresenter {
        void register(String username, String password);
    }
}

package com.xpp.neo1.paperplane.home.reader.zhihu;

import com.xpp.neo1.paperplane.account.register.RegisterContract;
import com.xpp.neo1.paperplane.base.BasePresenter;
import com.xpp.neo1.paperplane.base.BaseView;

/**
 * Created by neo1 on 2017/2/14.
 */

public interface ZhihuContract {
    interface View extends BaseView<Presenter> {
        void showError();

        void showLoading();

        void hideLoading();

        void showDatas();

        void showTimePickerDialog();
    }

    interface Presenter extends BasePresenter {
        void loadPosts(long date, boolean clearing);

        void refresh();

        void loadMore(long date);

        void startReading(int position);

        void randomNews();
    }
}

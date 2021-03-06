package com.xpp.neo1.paperplane.home.reader.douban;

import com.xpp.neo1.paperplane.base.BasePresenter;
import com.xpp.neo1.paperplane.base.BaseView;

/**
 * Created by neo1 on 2017/2/14.
 */

public interface DoubanContract {
    interface View extends BaseView {
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

package com.xpp.neo1.paperplane.home.reader.zhihu;

import com.xpp.neo1.paperplane.base.BasePresenter;
import com.xpp.neo1.paperplane.base.BaseView;
import com.xpp.neo1.paperplane.bean.ZhihuNews;

import java.util.List;

/**
 * Created by neo1 on 2017/2/14.
 */

public interface ZhihuContract {
    interface View extends BaseView {
        void showError();

        void showLoading();

        void hideLoading();

        void showDatas(List<ZhihuNews.StoriesBean> beanList);

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

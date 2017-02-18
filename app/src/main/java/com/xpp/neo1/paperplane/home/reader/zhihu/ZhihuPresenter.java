package com.xpp.neo1.paperplane.home.reader.zhihu;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by neo1 on 2017/2/14.
 */

public class ZhihuPresenter implements ZhihuContract.Presenter {
    private ZhihuContract.View mView;

    @Inject
    public ZhihuPresenter(ZhihuContract.View view) {
        mView = view;
    }

    @Override
    public void loadPosts(long date, boolean clearing) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore(long date) {

    }

    @Override
    public void startReading(int position) {

    }

    @Override
    public void randomNews() {

    }

    @Override
    public void start() {

    }
}

package com.xpp.neo1.paperplane.home.reader.douban;

import android.content.Context;

/**
 * Created by neo1 on 2017/2/14.
 */

public class DoubanPresenter implements DoubanContract.Presenter {
    private DoubanContract.View mView;

    public DoubanPresenter(Context context, DoubanContract.View view) {
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

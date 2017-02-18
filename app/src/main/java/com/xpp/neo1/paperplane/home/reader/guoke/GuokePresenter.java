package com.xpp.neo1.paperplane.home.reader.guoke;

import android.content.Context;

/**
 * Created by neo1 on 2017/2/14.
 */

public class GuokePresenter implements GuokeContract.Presenter {
    private GuokeContract.View mView;
    private Context mContext;

    public GuokePresenter(Context context, GuokeContract.View view) {
        mView = view;
        mContext = context;
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

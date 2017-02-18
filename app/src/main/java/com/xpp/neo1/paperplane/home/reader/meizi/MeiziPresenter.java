package com.xpp.neo1.paperplane.home.reader.meizi;

import android.content.Context;

/**
 * Created by neo1 on 2017/2/14.
 */

public class MeiziPresenter implements MeiziContract.Presenter {
    private Context mContext;
    private MeiziContract.View mView;

    public MeiziPresenter(Context context, MeiziContract.View view) {
        mContext = context;
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

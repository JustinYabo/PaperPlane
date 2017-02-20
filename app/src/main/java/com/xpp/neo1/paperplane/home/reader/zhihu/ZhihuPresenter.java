package com.xpp.neo1.paperplane.home.reader.zhihu;

import com.xpp.neo1.paperplane.bean.ZhihuNews;
import com.xpp.neo1.paperplane.network.NetWork;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

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
    public void loadPosts(long date, final boolean clearing) {
        String time = dateToString(date);
        if (clearing) mView.showLoading();
        NetWork.getZhihuApi()
                .getHistory(time)
                .map(new Function<ZhihuNews, List<ZhihuNews.StoriesBean>>() {
                    @Override
                    public List<ZhihuNews.StoriesBean> apply(ZhihuNews zhihuNews) throws Exception {
                        return zhihuNews.getStories();
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ZhihuNews.StoriesBean>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(List<ZhihuNews.StoriesBean> storiesBeen) {
                        mView.showDatas(storiesBeen, clearing);
                    }

                    @Override
                    public void onError(Throwable t) {
                        mView.showError();
                        mView.hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });
    }

    @Override
    public void refresh() {
        loadPosts(Calendar.getInstance().getTimeInMillis(), true);
    }

    @Override
    public void loadMore(long date) {
        loadPosts(date, false);
    }

    @Override
    public void startReading(int position) {

    }

    @Override
    public void randomNews() {

    }

    @Override
    public void start() {
        loadPosts(Calendar.getInstance().getTimeInMillis(), true);
    }

    /**
     * long to String  yyyymmdd
     *
     * @param date
     * @return
     */
    private String dateToString(long date) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(date));
    }
}

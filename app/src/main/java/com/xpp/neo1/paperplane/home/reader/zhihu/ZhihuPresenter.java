package com.xpp.neo1.paperplane.home.reader.zhihu;

import com.xpp.neo1.paperplane.bean.ZhihuNews;
import com.xpp.neo1.paperplane.network.NetWork;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public void loadPosts(long date, boolean clearing) {
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
                        mView.showDatas(storiesBeen);
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

    /**
     * long to String  yyyymmdd
     *
     * @param date
     * @return
     */
    private String dateToString(long date) {
        Date date1 = new Date(date);
        DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
        return dateFormat.format(date1);
    }
}

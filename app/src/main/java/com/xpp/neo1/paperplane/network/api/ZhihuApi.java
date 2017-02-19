package com.xpp.neo1.paperplane.network.api;

import com.xpp.neo1.paperplane.bean.ZhihuNews;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by neo1 on 2017/2/17.
 */

public interface ZhihuApi {
    //获取最新的数据
    @GET("latest")
    Flowable<ZhihuNews> getLatest();

    //获取之前时间的新闻
    @GET("before/{date}")
    Flowable<ZhihuNews> getHistory(@Path("date") String date);

}

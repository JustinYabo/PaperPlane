package com.xpp.neo1.paperplane.home.reader.zhihu;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neo1 on 2017/2/17.
 */
@Module
public class ZhihuPresenterModule {
    private final ZhihuContract.View view;

    public ZhihuPresenterModule(ZhihuContract.View view) {
        this.view = view;
    }

    @Provides
    ZhihuContract.View view() {
        return view;
    }
}

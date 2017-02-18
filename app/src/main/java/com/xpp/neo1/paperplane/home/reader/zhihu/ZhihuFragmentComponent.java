package com.xpp.neo1.paperplane.home.reader.zhihu;

import dagger.Component;

/**
 * Created by neo1 on 2017/2/17.
 */
@Component(modules = ZhihuPresenterModule.class)
public interface ZhihuFragmentComponent {
    void inject(ZhihuFragment fragment);
}

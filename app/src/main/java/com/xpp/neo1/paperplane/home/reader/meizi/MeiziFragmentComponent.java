package com.xpp.neo1.paperplane.home.reader.meizi;

import dagger.Component;

/**
 * Created by neo1 on 2017/2/17.
 */
@Component(modules = MeiziPresenerModule.class)
public interface MeiziFragmentComponent {
    void inject(MeiziFragment fragment);
}

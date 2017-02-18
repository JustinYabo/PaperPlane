package com.xpp.neo1.paperplane.home.reader.guoke;

import dagger.Component;

/**
 * Created by neo1 on 2017/2/17.
 */
@Component(modules = GuokePresenterModule.class)
public interface GuokeFragmentComponent {
    void inject(GuokeFragment fragment);
}

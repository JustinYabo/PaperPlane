package com.xpp.neo1.paperplane.home.reader.guoke;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neo1 on 2017/2/17.
 */
@Module
public class GuokePresenterModule {
    private final GuokeContract.View view;

    public GuokePresenterModule(GuokeContract.View view) {
        this.view = view;
    }

    @Provides
    GuokeContract.View view() {
        return this.view;
    }
}

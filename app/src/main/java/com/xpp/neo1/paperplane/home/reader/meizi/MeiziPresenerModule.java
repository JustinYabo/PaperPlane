package com.xpp.neo1.paperplane.home.reader.meizi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neo1 on 2017/2/17.
 */
@Module
public class MeiziPresenerModule {
    private final MeiziContract.View view;

    public MeiziPresenerModule(MeiziContract.View view) {
        this.view = view;
    }

    @Provides
    MeiziContract.View view() {
        return this.view;
    }
}


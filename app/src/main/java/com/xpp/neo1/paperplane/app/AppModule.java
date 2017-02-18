package com.xpp.neo1.paperplane.app;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neo1 on 2017/2/15.
 */
@Module
public class AppModule {
    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    public Application provideApplication() {
        return app;
    }
}

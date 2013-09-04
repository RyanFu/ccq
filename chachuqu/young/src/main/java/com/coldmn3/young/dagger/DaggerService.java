package com.coldmn3.young.dagger;

import android.app.Service;

/**
 * Base class for injectable services.
 */
public abstract class DaggerService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        getInjector().inject(this);
    }

    protected Injector getInjector() {
        return (Injector) getApplication();
    }
}

package com.coldmn3.young.dagger;

import android.app.IntentService;

/**
 * Base class for injectable intent services.
 */
public abstract class DaggerIntentService extends IntentService {

    public DaggerIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getInjector().inject(this);
    }

    protected Injector getInjector() {
        return (Injector) getApplication();
    }
}

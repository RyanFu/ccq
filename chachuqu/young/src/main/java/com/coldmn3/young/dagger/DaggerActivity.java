package com.coldmn3.young.dagger;

import android.os.Bundle;
import android.app.Activity;

/**
 * Base class for injectable activities.
 */
public abstract class DaggerActivity extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getInjector().inject(this);
    }

    protected Injector getInjector() {
        return (Injector) getApplication();
    }
}

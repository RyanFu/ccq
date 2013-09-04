package com.coldmn3.young.dagger;

import android.os.Bundle;
import android.app.ListActivity;

/**
 * Base class for injectable activities.
 */
public abstract class DaggerListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getInjector().inject(this);
    }

    protected Injector getInjector() {
        return (Injector) getApplication();
    }
}

package com.coldmn3.young.dagger;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Base class for injectable fragment activities.
 */
public abstract class DaggerFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getInjector().inject(this);
    }

    protected Injector getInjector() {
        return (Injector) getApplication();
    }
}

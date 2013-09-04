package com.coldmn3.young.dagger;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

/**
 * Base class for injectable list fragments.
 */
public abstract class DaggerListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle icicle) {
        super.onActivityCreated(icicle);
        getInjector().inject(this);
    }

    protected Injector getInjector() {
        return (Injector) getActivity().getApplication();
    }
}

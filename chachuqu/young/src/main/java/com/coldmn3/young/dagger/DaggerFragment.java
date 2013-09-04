package com.coldmn3.young.dagger;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Base class for injectable fragments.
 */
public abstract class DaggerFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle icicle) {
        super.onActivityCreated(icicle);
        getInjector().inject(this);
    }

    protected Injector getInjector() {
        return (Injector) getActivity().getApplication();
    }
}

package com.fisbang.fisbang.store;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fisbang.fisbang.R;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class StoreFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_store, container, false);

        ButterKnife.bind(this, v);
        return v;
    }

}

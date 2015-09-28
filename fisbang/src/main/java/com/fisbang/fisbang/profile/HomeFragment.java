package com.fisbang.fisbang.profile;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.adapter.ProfileTimelineArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFragment extends ListFragment {

    private final List<Long> mRowsData = new ArrayList<>();
    private ProfileTimelineArrayAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i = 0; i < 25; i++) {
            mRowsData.add(System.currentTimeMillis() + (i * 1000 * 24 * 60 * 60));
        }
        this.mAdapter = new ProfileTimelineArrayAdapter(getActivity(), this.mRowsData);
        setListAdapter(this.mAdapter);
    }
}

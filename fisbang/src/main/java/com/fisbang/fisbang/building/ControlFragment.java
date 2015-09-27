package com.fisbang.fisbang.building;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.adapter.BuildingControlArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ControlFragment extends ListFragment {

    private final List<Long> mRowsData = new ArrayList<>();
    private BuildingControlArrayAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_control, container, false);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i = 0; i < 25; i++) {
            mRowsData.add((long) i);
        }
        this.mAdapter = new BuildingControlArrayAdapter(getActivity(), this.mRowsData);
        setListAdapter(this.mAdapter);
    }
}

package com.fisbang.fisbang.profile;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.adapter.ProfileTimelineArrayAdapter;
import com.fisbang.fisbang.main.MainActivity;
import com.fisbang.fisbang.model.Timeline;
import com.fisbang.fisbang.util.FontCache;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFragment extends ListFragment {

    @Bind(R.id.txt_kwh_value)
    TextView mKwhValue;
    @Bind(R.id.txt_kwh_unit)
    TextView mKwhUnit;

    private final List<Timeline> mRowsData = new ArrayList<>();
    private ProfileTimelineArrayAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        ButterKnife.bind(this, v);

        mKwhValue.setTypeface(FontCache.get(MainActivity.FONTNAME, getActivity()));
        mKwhUnit.setTypeface(FontCache.get(MainActivity.FONTNAME, getActivity()));

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i = 0; i < 25; i++) {
            mRowsData.add(new Timeline(Timeline.TYPE.values()[i % 3], System.currentTimeMillis() / 1000l, ""));
        }
        this.mAdapter = new ProfileTimelineArrayAdapter(getActivity(), this.mRowsData);
        setListAdapter(this.mAdapter);
    }
}

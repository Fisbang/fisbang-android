package com.fisbang.fisbang.setting;

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
public class SettingFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        ButterKnife.bind(this, v);
        return v;
    }

}

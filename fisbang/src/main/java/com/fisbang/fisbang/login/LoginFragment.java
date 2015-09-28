package com.fisbang.fisbang.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.profile.HomeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

    @Bind(R.id.txtCreateAccount)
    TextView mCreateAccount;
    @Bind(R.id.btnLogin)
    Button mLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.txtCreateAccount)
    public void signup() {
        Fragment frag = new SignUpFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
    }

    @OnClick(R.id.btnLogin)
    public void login() {
        Fragment frag = new HomeFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
    }
}

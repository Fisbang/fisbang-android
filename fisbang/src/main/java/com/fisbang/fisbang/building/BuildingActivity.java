package com.fisbang.fisbang.building;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fisbang.fisbang.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuildingActivity extends AppCompatActivity {

    @Bind(R.id.layout_toolbar)
    Toolbar mToolbar;
    public static FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_container);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.main_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mFragmentManager = getSupportFragmentManager();

        Fragment frag = new BuildingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.building_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.layout_btn_energy)
    public void energy() {
        Fragment frag = new BuildingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
    }

    @OnClick(R.id.layout_btn_control)
    public void control() {
        Fragment frag = new ControlFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
    }

    @OnClick(R.id.layout_btn_saving)
    public void saving() {
        Fragment frag = new SavingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
    }
}

package com.fisbang.fisbang.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.building.BuildingActivity;
import com.fisbang.fisbang.login.LoginFragment;
import com.fisbang.fisbang.setting.SettingActivity;
import com.fisbang.fisbang.store.StoreActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public final static String FONTNAME = "rockwell.ttf";

    @Bind(R.id.layout_toolbar)
    Toolbar mToolbar;
    public static FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setLogo(R.drawable.ic_fisbang_logo);
        mToolbar.inflateMenu(R.menu.main_menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mFragmentManager = getSupportFragmentManager();

        Fragment frag = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
            case R.id.action_building:
                intent = new Intent(this, BuildingActivity.class);
                startActivity(intent);
                break;
            case R.id.action_store:
                intent = new Intent(this, StoreActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

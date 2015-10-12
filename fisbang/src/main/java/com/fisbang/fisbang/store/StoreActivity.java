package com.fisbang.fisbang.store;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.main.MainActivity;
import com.fisbang.fisbang.util.FontCache;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {

    @Bind(R.id.layout_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.txt_toolbar_header)
    TextView mToolbarHeader;

    public static FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_container);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.main_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mFragmentManager = getSupportFragmentManager();

        mToolbarHeader.setTypeface(FontCache.get(MainActivity.FONTNAME, this));

        Fragment frag = new StoreFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();
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
}

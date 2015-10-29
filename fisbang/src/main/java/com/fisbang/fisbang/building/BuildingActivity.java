package com.fisbang.fisbang.building;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.main.MainActivity;
import com.fisbang.fisbang.util.FontCache;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuildingActivity extends AppCompatActivity {

    @Bind(R.id.layout_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.txt_toolbar_header)
    TextView mToolbarHeader;

    @Bind(R.id.img_btn_energy)
    ImageView mBtnEnergy;
    @Bind(R.id.img_btn_control)
    ImageView mBtnControl;
    @Bind(R.id.img_btn_saving)
    ImageView mBtnSaving;

    @Bind(R.id.txt_btn_energy)
    TextView mTxtEnergy;
    @Bind(R.id.txt_btn_control)
    TextView mTxtControl;
    @Bind(R.id.txt_btn_saving)
    TextView mTxtSaving;

    public static FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_container);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.main_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mFragmentManager = getSupportFragmentManager();

        mToolbarHeader.setTypeface(FontCache.get(MainActivity.FONTNAME, this));

        Fragment frag = new BuildingFragment();
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

    @OnClick(R.id.layout_btn_energy)
    public void energy() {
        Fragment frag = new BuildingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();

        mBtnEnergy.setImageResource(R.drawable.ic_big_energy_active);
        mBtnControl.setImageResource(R.drawable.ic_big_control_inactive);
        mBtnSaving.setImageResource(R.drawable.ic_big_saving_inactive);

        mTxtEnergy.setTextColor(getResources().getColor(R.color.control_label_active));
        mTxtControl.setTextColor(getResources().getColor(R.color.light_gray));
        mTxtSaving.setTextColor(getResources().getColor(R.color.light_gray));
    }

    @OnClick(R.id.layout_btn_control)
    public void control() {
        Fragment frag = new ControlFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();

        mBtnEnergy.setImageResource(R.drawable.ic_big_energy_inactive);
        mBtnControl.setImageResource(R.drawable.ic_big_control_active);
        mBtnSaving.setImageResource(R.drawable.ic_big_saving_inactive);

        mTxtEnergy.setTextColor(getResources().getColor(R.color.light_gray));
        mTxtControl.setTextColor(getResources().getColor(R.color.control_label_active));
        mTxtSaving.setTextColor(getResources().getColor(R.color.light_gray));
    }

    @OnClick(R.id.layout_btn_saving)
    public void saving() {
        Fragment frag = new SavingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, frag).commitAllowingStateLoss();

        mBtnEnergy.setImageResource(R.drawable.ic_big_energy_inactive);
        mBtnControl.setImageResource(R.drawable.ic_big_control_inactive);
        mBtnSaving.setImageResource(R.drawable.ic_big_saving_active);

        mTxtEnergy.setTextColor(getResources().getColor(R.color.light_gray));
        mTxtControl.setTextColor(getResources().getColor(R.color.light_gray));
        mTxtSaving.setTextColor(getResources().getColor(R.color.control_label_active));
    }
}

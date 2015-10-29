package com.fisbang.fisbang.building;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.main.MainActivity;
import com.fisbang.fisbang.util.FisbangColorTemplate;
import com.fisbang.fisbang.util.FontCache;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class BuildingFragment extends Fragment {
    @Bind(R.id.spinner_day)
    Spinner mDaysSpinner;
    @Bind(R.id.piechart_saving)
    PieChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_building, container, false);

        ButterKnife.bind(this, v);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.days_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDaysSpinner.setAdapter(adapter);
        mDaysSpinner.getBackground().setColorFilter(getResources().getColor(android.R.color.darker_gray), PorterDuff.Mode.SRC_ATOP);

        mChart.setUsePercentValues(true);
        mChart.setDescription("");

        mChart.setDragDecelerationFrictionCoef(0.95f);
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);
        mChart.setRotationEnabled(true);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);
        mChart.setCenterTextSize(20f);
        String valueText = "Total Energy\n3251\nkWh";
        mChart.setCenterText(valueText);

        mChart.setCenterTextTypeface(FontCache.get(MainActivity.FONTNAME, getActivity()));
        mChart.setData(generatePieData());
        mChart.getLegend().setEnabled(false);
        mChart.setCenterTextColor(Color.DKGRAY);

        return v;
    }

    public PieData generatePieData() {

        int count = 5;

        ArrayList<Entry> entries1 = new ArrayList<Entry>();
        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("TV");
        xVals.add("PC");
        xVals.add("Lightning");
        xVals.add("Air Conditioning");
        xVals.add("Others");

        for (int i = 0; i < count; i++) {
            entries1.add(new Entry((float) (Math.random() * 60) + 40, i));
        }

        PieDataSet ds1 = new PieDataSet(entries1, "");
        ds1.setColors(FisbangColorTemplate.createColors(getResources()));
        ds1.setSliceSpace(0f);
        ds1.setValueTextColor(Color.BLACK);
        ds1.setValueTextSize(12f);
        ds1.setValueFormatter(new PercentFormatter());

        PieData d = new PieData(xVals, ds1);

        return d;
    }
}

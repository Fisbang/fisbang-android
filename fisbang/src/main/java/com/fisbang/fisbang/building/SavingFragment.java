package com.fisbang.fisbang.building;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fisbang.fisbang.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class SavingFragment extends Fragment {

    @Bind(R.id.barchart_saving)
    BarChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_saving, container, false);

        ButterKnife.bind(this, v);

        mChart.setDescription("");
        mChart.setHighlightEnabled(false);
        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);

        mChart.setData(generateBarData(100, 3));

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);
        l.setXOffset(32f);
        l.setTextSize(10f);

        mChart.getAxisRight().setEnabled(false);
        mChart.getXAxis().setEnabled(true);
        mChart.getXAxis().setDrawGridLines(false);
        mChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        mChart.getXAxis().setTextSize(10f);
        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getAxisLeft().setAxisMaxValue(mChart.getYMax() + l.mNeededHeight);

        mChart.invalidate();

        return v;
    }

    public BarData generateBarData(float range, int count) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add(getLabel(i));
        }

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 3;
            yVals1.add(new BarEntry(val, i));
            yVals2.add(new BarEntry(val * 80 / 100, i));
        }

        BarDataSet set1 = new BarDataSet(yVals1, "Actual");
        set1.setColor(getResources().getColor(R.color.main_color));
        BarDataSet set2 = new BarDataSet(yVals2, "Saving");
        set2.setColor(getResources().getColor(R.color.control_bg_blue));

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);
        BarData data = new BarData(xVals, dataSets);
        return data;
    }

    private String[] mLabels = new String[]{"Oct", "Nov", "Dec"};

    private String getLabel(int i) {
        return mLabels[i];
    }
}

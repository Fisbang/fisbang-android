package com.fisbang.fisbang.util;

import android.content.res.Resources;

import com.fisbang.fisbang.R;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmad Muhsin Kurnia (ahmad@sense-os.nl) on 10/9/15.
 */
public class FisbangColorTemplate extends ColorTemplate {

    private static int[] colors = {R.color.chart_1, R.color.chart_2, R.color.chart_3, R.color.chart_4, R.color.chart_5};

    public static List<Integer> createColors(Resources r) {

        List<Integer> result = new ArrayList<Integer>();

        for (int i : colors) {
            result.add(r.getColor(i));
        }

        return result;
    }
}

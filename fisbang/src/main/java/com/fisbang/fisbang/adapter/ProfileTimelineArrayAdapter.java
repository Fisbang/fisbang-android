package com.fisbang.fisbang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fisbang.fisbang.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ahmad Muhsin Kurnia (ahmad@sense-os.nl) on 9/27/15.
 */
public class ProfileTimelineArrayAdapter extends ArrayAdapter<Long> {

    public ProfileTimelineArrayAdapter(final Context context,
                                       final List<Long> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            final LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.list_item_profile_timeline, null);
        }

        ViewHolder holder = (ViewHolder) v.getTag();

        if (holder == null) {
            holder = new ViewHolder(v);
        }

        holder.mTxtTimeline.setText("This is timeline item #" + (position + 1));
        holder.mTxtDate.setText("#" + (position + 1));

        return v;
    }

    static class ViewHolder {
        @Bind(R.id.txt_timeline)
        TextView mTxtTimeline;
        @Bind(R.id.txt_date)
        TextView mTxtDate;

        public ViewHolder(final View v) {
            ButterKnife.bind(this, v);
            v.setTag(this);
        }
    }
}

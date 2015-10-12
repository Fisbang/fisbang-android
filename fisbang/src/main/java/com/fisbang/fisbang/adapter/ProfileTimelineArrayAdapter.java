package com.fisbang.fisbang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fisbang.fisbang.R;
import com.fisbang.fisbang.model.Timeline;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ahmad Muhsin Kurnia (ahmad@sense-os.nl) on 9/27/15.
 */
public class ProfileTimelineArrayAdapter extends ArrayAdapter<Timeline> {

    public ProfileTimelineArrayAdapter(final Context context,
                                       final List<Timeline> objects) {
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

        Timeline timeline = getItem(position);

        switch (timeline.getType()) {
            case ENERGY:
                holder.mImgTimeline.setImageResource(R.drawable.ic_energy_icon);
                break;
            case SAVING:
                holder.mImgTimeline.setImageResource(R.drawable.ic_saving_icon);
                break;
            case STORE:
                holder.mImgTimeline.setImageResource(R.drawable.ic_store_icon);
                break;

            default:
                holder.mImgTimeline.setImageResource(R.drawable.ic_energy_icon);
                break;
        }

        holder.mTxtTimeline.setText("This is timeline item #" + (position + 1));
        holder.mTxtDate.setText("" + timeline.getDateMillis());

        return v;
    }

    static class ViewHolder {
        @Bind(R.id.img_ic_timeline)
        ImageView mImgTimeline;
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

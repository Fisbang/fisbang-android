package com.fisbang.fisbang.model;

/**
 * Created by Ahmad Muhsin Kurnia (ahmad@sense-os.nl) on 10/8/15.
 */
public class Timeline {

    public static enum TYPE {
        ENERGY,
        SAVING,
        STORE,
    }

    private TYPE mType;
    private long mDateMillis;
    private String mText;

    public Timeline(TYPE mType, long mDateMillis, String mText) {
        this.mType = mType;
        this.mDateMillis = mDateMillis;
        this.mText = mText;
    }

    public TYPE getType() {
        return mType;
    }

    public void setType(TYPE mType) {
        this.mType = mType;
    }

    public long getDateMillis() {
        return mDateMillis;
    }

    public void setDateMillis(long mDateMillis) {
        this.mDateMillis = mDateMillis;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }
}

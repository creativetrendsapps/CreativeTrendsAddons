package com.creativetrends.addons.app;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**Created by Creative Trends Apps on 3/24/2017.*/

public class SimpleTextView extends AppCompatTextView {

    /*
     * Caches typefaces based on their file path and name, so that they don't have to be created every time when they are referenced.
     */
    private static Typeface mTypeface;

    public SimpleTextView(final Context context) {
        this(context, null);
    }

    public SimpleTextView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Playball-Regular.ttf");
        }
        setTypeface(mTypeface);
    }

}
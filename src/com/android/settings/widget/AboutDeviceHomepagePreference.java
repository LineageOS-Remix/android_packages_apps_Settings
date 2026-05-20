package com.android.settings.widget;

import android.content.res.ColorStateList;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.preference.PreferenceViewHolder;

import com.android.settings.R;

public class AboutDeviceHomepagePreference extends HomepagePreference {

    public AboutDeviceHomepagePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.colorAccent, typedValue, true);
        int accentColor = typedValue.data;

        TypedValue inverseColor = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.textColorPrimaryInverse, inverseColor, true);
        int textInverse = inverseColor.data;

        holder.itemView.post(() -> {
            holder.itemView.setBackgroundTintList(ColorStateList.valueOf(accentColor));

            TextView title = holder.itemView.findViewById(android.R.id.title);
            TextView summary = holder.itemView.findViewById(android.R.id.summary);
            ImageView icon = holder.itemView.findViewById(android.R.id.icon);

            if (title != null) title.setTextColor(textInverse);
            if (summary != null) summary.setTextColor(textInverse);
            if (icon != null) icon.setImageTintList(ColorStateList.valueOf(textInverse));
        });
    }
}

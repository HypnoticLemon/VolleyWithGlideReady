package com.hypnoticlemon.testapplicationjava;

import android.view.View;

/**
 * Created by sit38 on 11-01-2017.
 */

public interface OnRecyclerItemClickListener {
    void ItemClick(int position, String data, View view, int id);
}

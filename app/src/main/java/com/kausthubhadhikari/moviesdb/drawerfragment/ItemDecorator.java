package com.kausthubhadhikari.moviesdb.drawerfragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kausthubhadhikari on 18/12/16.
 */

public class ItemDecorator extends RecyclerView.ItemDecoration {

    private int size;

    public ItemDecorator(int size) {
        this.size = size;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = size;
        }
        outRect.left = size;
        outRect.right = size;
        outRect.bottom = size;
    }
}

package com.kausthubhadhikari.moviesdb.model.manager;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kausthubhadhikari on 18/12/16.
 */

public class HorizontalItemDecorator extends RecyclerView.ItemDecoration {

    private int size;

    public HorizontalItemDecorator(int size) {
        this.size = size;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = size;
        }
        outRect.top = size;
        outRect.right = size;
        outRect.bottom = size;
    }

}

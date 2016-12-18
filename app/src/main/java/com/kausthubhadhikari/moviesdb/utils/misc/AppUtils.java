package com.kausthubhadhikari.moviesdb.utils.misc;

import android.content.res.Resources;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public class AppUtils {

    public static int dpTox(int size) {
        return (int) (size * Resources.getSystem().getDisplayMetrics().density);
    }

}

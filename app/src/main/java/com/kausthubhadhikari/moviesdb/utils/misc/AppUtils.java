package com.kausthubhadhikari.moviesdb.utils.misc;

import android.content.res.Resources;

import com.kausthubhadhikari.moviesdb.model.pojo.detail.Genre;

import java.util.ArrayList;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public class AppUtils {

    public static int dpTox(int size) {
        return (int) (size * Resources.getSystem().getDisplayMetrics().density);
    }

    public static String genreToString(ArrayList<Genre> genres) {
        if (genres.size() == 0) {
            return " ";
        } else if (genres.size() == 1) {
            return genres.get(0).name;
        } else if (genres.size() == 2) {
            return genres.get(0).name + " & " + genres.get(1).name;
        } else {
            String data = "";
            for (int i = 0; i < genres.size(); i++) {
                if (genres.size() - 1 == i) {
                    data = data + "& " + genres.get(i);
                } else {
                    data = data + ", " + genres.get(i);
                }
            }
            return data;
        }
    }

}

package es.adrianmarin.movies.utils;

import android.content.Context;

import es.adrianmarin.movies.R;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public class ScreenUtils {

    public static boolean isLandscape(Context context){
        return context.getResources().getBoolean(R.bool.is_landscape);
    }

}

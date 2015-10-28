package es.adrianmarin.movies.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class ImageUtils {

    public static void setImage(Context context, String url, ImageView imageView){
        Picasso.with(context)
                .load(url)
                .into(imageView);
    }

}

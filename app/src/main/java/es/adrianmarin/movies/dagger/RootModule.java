package es.adrianmarin.movies.dagger;

import android.content.Context;

import dagger.Module;
import es.adrianmarin.movies.base.MoviesApplication;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
@Module(injects = MoviesApplication.class, library = true, complete  = false)
public class RootModule {

    private Context context;

    public RootModule(Context context) {
        this.context = context;
    }

}

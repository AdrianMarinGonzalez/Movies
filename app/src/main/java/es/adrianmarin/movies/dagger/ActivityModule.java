package es.adrianmarin.movies.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.model.repository.MoviesRepository;
import es.adrianmarin.movies.model.repository.api.MoviesAPIRepository;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
@Module(
        complete = false,
        library = true
)
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideApplicationContext(){
        return context;
    }

}

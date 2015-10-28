package es.adrianmarin.movies.dagger;

import javax.inject.Named;

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
public class RepositoryModule {

    @Provides
    public MoviesRepository provideMoviesRepository(){
        return new MoviesAPIRepository();
    }

}

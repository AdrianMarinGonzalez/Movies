package es.adrianmarin.movies.dagger;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.domain.repository.MoviesRepository;
import es.adrianmarin.movies.domain.repository.api.MoviesAPIRepository;

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

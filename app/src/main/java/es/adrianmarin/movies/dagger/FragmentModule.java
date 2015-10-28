package es.adrianmarin.movies.dagger;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailFragment;
import es.adrianmarin.movies.presentation.view.movies.MoviesFragment;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
@Module(complete = false,
        library = true
)
public class FragmentModule {

    @Provides
    public MoviesFragment provideMoviesFragment(){
        return new MoviesFragment();
    }

    @Provides
    public MovieDetailFragment provideMovieDetailFragment(){
        return new MovieDetailFragment();
    }

}

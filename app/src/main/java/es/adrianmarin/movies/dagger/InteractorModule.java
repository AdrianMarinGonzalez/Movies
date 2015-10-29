package es.adrianmarin.movies.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.domain.interactors.movie_detail.GetMovieDetail;
import es.adrianmarin.movies.domain.interactors.movie_detail.GetMovieDetailImp;
import es.adrianmarin.movies.domain.interactors.movies.GetMovies;
import es.adrianmarin.movies.domain.interactors.movies.GetMoviesImp;
import es.adrianmarin.movies.domain.repository.MoviesRepository;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
@Module(
        complete = false,
        library = true
)
public class InteractorModule {

    @Provides
    public GetMovies provideGetMovies(Context context, MoviesRepository repository){
        return new GetMoviesImp(context, repository);
    }

    @Provides
    public GetMovieDetail provideGetMovieDetail(Context context, MoviesRepository repository){
        return new GetMovieDetailImp(context, repository);
    }

}

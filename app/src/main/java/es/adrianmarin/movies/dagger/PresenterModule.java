package es.adrianmarin.movies.dagger;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.domain.interactors.movie_detail.GetMovieDetailImp;
import es.adrianmarin.movies.domain.interactors.movies.GetMoviesImp;
import es.adrianmarin.movies.presentation.presenter.NavigationHelper;
import es.adrianmarin.movies.presentation.presenter.movie.MovieDetailPresenter;
import es.adrianmarin.movies.presentation.presenter.movie.MovieDetailPresenterImp;
import es.adrianmarin.movies.presentation.presenter.movies.MoviesPresenter;
import es.adrianmarin.movies.presentation.presenter.movies.MoviesPresenterImp;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailFragment;
import es.adrianmarin.movies.presentation.view.movies.MoviesFragment;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
@Module(
        complete = false,
        library = true,
        injects =
                {MoviesFragment.class,
                        MovieDetailFragment.class
                }
)
public class PresenterModule {

    @Provides
    @Named("api_key")
    public String provideApiKey(){
        return "7c2c03814415055e8a0a658fd91bfe54";
    }

    @Provides
    public MoviesPresenter provideMoviesPresenter(Context context, GetMoviesImp getMovies, NavigationHelper navigationHelper){
        return new MoviesPresenterImp(context, getMovies, navigationHelper);
    }

    @Provides
    public MovieDetailPresenter provideMovieDetailPresenter(Context context, GetMovieDetailImp getMovieDetail){
        return new MovieDetailPresenterImp(context, getMovieDetail);
    }

}

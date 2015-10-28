package es.adrianmarin.movies.presentation.presenter.movies;

import java.util.List;

import es.adrianmarin.movies.base.Presenter;
import es.adrianmarin.movies.presentation.presenter.movies.models.BusinessMovie;
import es.adrianmarin.movies.presentation.view.movies.MoviesFragment;
import es.adrianmarin.movies.presentation.view.movies.MoviesView;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public interface MoviesPresenter extends Presenter {

    void getMovies(int page);

    void onEvent(List<BusinessMovie> businessMovies);

    void setView(MoviesFragment moviesFragment);

    void presentMovieDetail(MovieViewModel movie);
}

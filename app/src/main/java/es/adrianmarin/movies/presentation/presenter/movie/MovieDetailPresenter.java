package es.adrianmarin.movies.presentation.presenter.movie;

import java.util.List;

import es.adrianmarin.movies.base.Presenter;
import es.adrianmarin.movies.presentation.presenter.models.BusinessMovieDetail;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailView;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public interface MovieDetailPresenter extends Presenter{

    void setView(MovieDetailView view);

    void onEvent(BusinessMovieDetail businessMovies);

    void getMovieDetail(Long id);
}

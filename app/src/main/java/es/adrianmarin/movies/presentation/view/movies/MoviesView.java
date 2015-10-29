package es.adrianmarin.movies.presentation.view.movies;

import java.util.List;

import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public interface MoviesView {

    void showLoading();
    void hideLoading();

    void add(MovieViewModel movieViewModel);
    void addAll(List<MovieViewModel> movieViewModels);
    void clear();

}

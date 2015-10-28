package es.adrianmarin.movies.base;

import es.adrianmarin.movies.presentation.view.movies.MoviesView;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public interface Presenter {

    void subscribeEvents();
    void unSubscribeEvents();

}

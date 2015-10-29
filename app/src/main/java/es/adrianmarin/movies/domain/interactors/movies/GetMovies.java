package es.adrianmarin.movies.domain.interactors.movies;

import es.adrianmarin.movies.domain.model.movies.MovieList;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public interface GetMovies {

    void execute(int page);

    void onEvent(MovieList movieList);

    void subscribeEvents();

    void unSubscriveEvents();
}

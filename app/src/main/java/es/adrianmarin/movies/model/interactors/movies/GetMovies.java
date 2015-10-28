package es.adrianmarin.movies.model.interactors.movies;

import es.adrianmarin.movies.model.model.movies.MovieList;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public interface GetMovies {

    void execute(int page);

    void onEvent(MovieList movieList);

}

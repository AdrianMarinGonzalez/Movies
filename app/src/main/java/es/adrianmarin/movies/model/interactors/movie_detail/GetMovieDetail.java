package es.adrianmarin.movies.model.interactors.movie_detail;

import es.adrianmarin.movies.model.model.movie_detail.MovieDetail;
import es.adrianmarin.movies.model.model.movies.MovieList;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public interface GetMovieDetail {

    void execute(Long id);

    void onEvent(MovieDetail moviedetail);

}

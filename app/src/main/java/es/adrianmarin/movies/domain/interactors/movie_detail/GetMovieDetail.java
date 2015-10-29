package es.adrianmarin.movies.domain.interactors.movie_detail;

import es.adrianmarin.movies.domain.model.movie_detail.MovieDetail;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public interface GetMovieDetail {

    void execute(Long id);

    void onEvent(MovieDetail moviedetail);

    void subscribeEvents();

    void unSubscriveEvents();
}

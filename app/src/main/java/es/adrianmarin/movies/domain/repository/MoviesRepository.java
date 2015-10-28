package es.adrianmarin.movies.domain.repository;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public interface MoviesRepository {

    void getMovies(int page);
    void getMovieDetail(Long id);
}

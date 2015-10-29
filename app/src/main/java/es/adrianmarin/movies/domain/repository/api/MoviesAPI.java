package es.adrianmarin.movies.domain.repository.api;

import es.adrianmarin.movies.domain.model.movie_detail.MovieDetail;
import es.adrianmarin.movies.domain.model.movies.MovieList;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public interface MoviesAPI {

    @GET(APIGlobals.GET_MOVIES_PATH)
    void getMovies(@Query(APIGlobals.GET_MOVIES_PAGE_KEY) int page,
                   @Query(APIGlobals.GET_MOVIES_PAGESIZE_KEY) int size,
                   @Query(APIGlobals.GET_MOVIES_SORT_KEY) String sort,
                   @Query(APIGlobals.API_KEY) String apiKey,
                   Callback<MovieList> callback);

    @GET("/{path}")
    void getMovieDetail(@Path(value = "path", encode = false) String path,
                   @Query(APIGlobals.API_KEY) String apiKey,
                   Callback<MovieDetail> callback);
}

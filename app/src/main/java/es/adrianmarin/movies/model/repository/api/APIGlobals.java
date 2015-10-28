package es.adrianmarin.movies.model.repository.api;

/**
 * @author Adrián Marín González
 * @since 21/10/15.
 */
public class APIGlobals {

    public static final String ENDPOINT = "http://api.themoviedb.org";
    public static final String IMAGES_ENDPOINT = "http://image.tmdb.org/";

    public static final String GET_MOVIES_PATH = "/3/discover/movie";
    public static final String GET_MOVIE_DETAIL_PATH = "/3/movie";
    public static final String MOVIE_POSTER_PATH = "/t/p/w500";

    public static final String GET_MOVIES_PAGE_KEY = "page";
    public static final String GET_MOVIES_PAGESIZE_KEY = "size";
    public static final String GET_MOVIES_SORT_KEY = "sort_by";


    public static final String API_KEY = "api_key";

    public static final int DEFAULT_GET_MOVIES_PAGE_SIZE = 20;

    public static String getMoviePosterURI(String posterPath){
        return IMAGES_ENDPOINT+MOVIE_POSTER_PATH+posterPath;
    }

    public static String getMovieDetailPath(Long id) {
        return GET_MOVIE_DETAIL_PATH+"/"+id;
    }
}

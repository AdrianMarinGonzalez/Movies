package es.adrianmarin.movies.domain.repository.api;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.domain.model.movie_detail.MovieDetail;
import es.adrianmarin.movies.domain.model.movies.MovieList;
import es.adrianmarin.movies.domain.repository.MoviesRepository;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
@Singleton
public class MoviesAPIRepository implements MoviesRepository {

    private RestAdapter mAdapter;
    private MoviesAPI mApi;
    private APIEndpoint mEndpoint;

    @Inject
    public MoviesAPIRepository(){

        mEndpoint = new APIEndpoint();
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(mEndpoint)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
                    public void log(String msg) {
                        Log.i("RETROFIT", msg);
                    }
                });
        mAdapter = builder.build();
        mApi = mAdapter.create(MoviesAPI.class);

    }

    @Override
    public void getMovies(int page){
        mApi.getMovies(page, APIGlobals.DEFAULT_GET_MOVIES_PAGE_SIZE, "popularity.desc", "7c2c03814415055e8a0a658fd91bfe54", new Callback<MovieList>() {
            @Override
            public void success(MovieList movieList, Response response) {
                EventBus.getDefault().post(movieList);
            }

            @Override
            public void failure(RetrofitError error) {
                EventBus.getDefault().post(error);
            }
        });
    }

    @Override
    public void getMovieDetail(Long id) {
        mApi.getMovieDetail(APIGlobals.getMovieDetailPath(id), "7c2c03814415055e8a0a658fd91bfe54",
                new Callback<MovieDetail>() {

                    @Override
                    public void success(MovieDetail movieDetail, Response response) {
                        EventBus.getDefault().post(movieDetail);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        EventBus.getDefault().post(error);
                    }
        });
    }

}

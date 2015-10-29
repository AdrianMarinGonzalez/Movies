package es.adrianmarin.movies.presentation.presenter;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.adrianmarin.movies.R;
import es.adrianmarin.movies.base.BaseActivity;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailActivity;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailFragment;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;
import es.adrianmarin.movies.utils.ScreenUtils;

/**
 * @author Adrián Marín González
 * @since 27/10/15.
 */
@Singleton
public class NavigationHelper {

    Context mContext;
    @Inject MovieDetailFragment mMovieDetailFragment;

    @Inject
    public NavigationHelper(Context context, MovieDetailFragment movieDetailFragment){
        mContext = context;
        mMovieDetailFragment = movieDetailFragment;
    }

    public void navigateToMovieDetail(MovieViewModel movie) {
        if (ScreenUtils.isLandscape(mContext)) {
            mMovieDetailFragment.setMovieViewModel(movie);
            ((BaseActivity)mContext).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.movie_detail_fragment,
                            mMovieDetailFragment)
                    .commit();
        } else {
            Intent intent = new Intent(mContext, MovieDetailActivity.class);
            intent.putExtra(MovieDetailActivity.MOVIE_VIEW_MODEL_KEY, movie);
            mContext.startActivity(intent);
        }
    }

}

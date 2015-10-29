package es.adrianmarin.movies.presentation.presenter.movies;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.greenrobot.event.EventBus;
import es.adrianmarin.movies.commons.MovieModelMapper;
import es.adrianmarin.movies.domain.interactors.movies.GetMovies;
import es.adrianmarin.movies.presentation.presenter.NavigationHelper;
import es.adrianmarin.movies.presentation.presenter.movies.models.BusinessMovie;
import es.adrianmarin.movies.presentation.view.movies.MoviesFragment;
import es.adrianmarin.movies.presentation.view.movies.MoviesView;
import es.adrianmarin.movies.presentation.view.movies.models.MovieViewModel;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
@Singleton
public class MoviesPresenterImp implements MoviesPresenter {

    private Context mContext;
    private MoviesView mView;
    private GetMovies mGetMovies;
    private NavigationHelper mNavigationHelper;

    @Inject
    public MoviesPresenterImp(Context context, GetMovies getMovies, NavigationHelper navigationHelper) {
        mContext = context;
        mGetMovies = getMovies;
        mNavigationHelper = navigationHelper;
    }

    @Override
    public void subscribeEvents() {
        EventBus.getDefault().register(this);
        mGetMovies.subscribeEvents();
    }

    @Override
    public void unSubscribeEvents() {
        EventBus.getDefault().unregister(this);
        mGetMovies.unSubscriveEvents();
    }

    @Override
    public void getMovies(int page) {
        if (page==1){
            mView.clear();
        }else {
            mView.showLoading();
        }
        mGetMovies.execute(page);
    }

    @Override
    public void onEvent(List<BusinessMovie> businessMoviesMovies){
        List<MovieViewModel> viewModels = MovieModelMapper.businessToViewMovie(businessMoviesMovies);
        mView.addAll(viewModels);
        mView.hideLoading();
    }

    @Override
    public void setView(MoviesFragment moviesFragment) {
        this.mView = moviesFragment;
    }

    @Override
    public void presentMovieDetail(MovieViewModel movie) {
        mNavigationHelper.navigateToMovieDetail(movie);
    }

}

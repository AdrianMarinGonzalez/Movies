package es.adrianmarin.movies.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.base.MoviesApplication;
import es.adrianmarin.movies.domain.interactors.movie_detail.GetMovieDetailImp;
import es.adrianmarin.movies.domain.interactors.movies.GetMoviesImp;
import es.adrianmarin.movies.domain.repository.api.MoviesAPIRepository;
import es.adrianmarin.movies.presentation.presenter.NavigationHelper;
import es.adrianmarin.movies.presentation.presenter.movie.MovieDetailPresenterImp;
import es.adrianmarin.movies.presentation.presenter.movies.MoviesPresenterImp;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailActivity;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailFragment;
import es.adrianmarin.movies.presentation.view.movies.MoviesActivity;
import es.adrianmarin.movies.presentation.view.movies.MoviesFragment;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
@Module(includes = {
            RepositoryModule.class,
            InteractorModule.class,
            FragmentModule.class,
            PresenterModule.class,
            NavigatorModule.class
        },
        injects = {
                MoviesAPIRepository.class,
                GetMoviesImp.class,
                GetMovieDetailImp.class,
                MoviesPresenterImp.class,
                MovieDetailPresenterImp.class,
                MoviesFragment.class,
                MovieDetailFragment.class,
                MoviesActivity.class,
                MovieDetailActivity.class,
                NavigationHelper.class,
                MoviesApplication.class
        },
        library = true
)
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideApplicationContext(){
        return context;
    }

}

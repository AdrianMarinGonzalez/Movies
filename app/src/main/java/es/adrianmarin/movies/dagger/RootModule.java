package es.adrianmarin.movies.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.base.MoviesApplication;
import es.adrianmarin.movies.model.interactors.movie_detail.GetMovieDetailImp;
import es.adrianmarin.movies.model.interactors.movies.GetMoviesImp;
import es.adrianmarin.movies.model.repository.api.MoviesAPIRepository;
import es.adrianmarin.movies.presentation.presenter.NavigationHelper;
import es.adrianmarin.movies.presentation.presenter.movie.MovieDetailPresenterImp;
import es.adrianmarin.movies.presentation.presenter.movies.MoviesPresenterImp;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailActivity;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailFragment;
import es.adrianmarin.movies.presentation.view.movies.MoviesActivity;
import es.adrianmarin.movies.presentation.view.movies.MoviesFragment;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
@Module(includes = {
        RepositoryModule.class,
        InteractorModule.class,
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
        library = true,
        complete  = false)
public class RootModule {

    private Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideApplicationContext(){
        return context;
    }

}

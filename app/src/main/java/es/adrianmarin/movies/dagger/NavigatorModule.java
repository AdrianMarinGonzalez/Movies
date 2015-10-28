package es.adrianmarin.movies.dagger;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.base.BaseActivity;
import es.adrianmarin.movies.model.interactors.movie_detail.GetMovieDetail;
import es.adrianmarin.movies.model.interactors.movie_detail.GetMovieDetailImp;
import es.adrianmarin.movies.model.interactors.movies.GetMovies;
import es.adrianmarin.movies.model.interactors.movies.GetMoviesImp;
import es.adrianmarin.movies.model.repository.MoviesRepository;
import es.adrianmarin.movies.presentation.presenter.NavigationHelper;

/**
 * @author Adrián Marín González
 * @since 26/10/15.
 */
@Module(
        complete = false,
        library = true
)
public class NavigatorModule {

    @Provides
    public NavigationHelper provideNavigator(Context context){
        return new NavigationHelper(context);
    }

}

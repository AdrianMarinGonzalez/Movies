package es.adrianmarin.movies.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import es.adrianmarin.movies.presentation.presenter.NavigationHelper;
import es.adrianmarin.movies.presentation.view.movie.MovieDetailFragment;

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
    public NavigationHelper provideNavigator(Context context, MovieDetailFragment movieDetailFragment){
        return new NavigationHelper(context, movieDetailFragment);
    }

}

package es.adrianmarin.movies.dagger;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
@Module(library = true, complete = false)
public class BaseModule {

    private Context mContext;

    public BaseModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Named("ActivityContext")
    Context provideApplicationContext(){
        return mContext;
    }

}
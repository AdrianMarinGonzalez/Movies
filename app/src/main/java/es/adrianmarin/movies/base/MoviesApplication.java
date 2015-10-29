package es.adrianmarin.movies.base;

import android.app.Application;

import java.util.List;

import dagger.ObjectGraph;
import es.adrianmarin.movies.dagger.RootModule;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public class MoviesApplication extends Application{

    private ObjectGraph mGraph;


    @Override
    public void onCreate() {
        super.onCreate();
        mGraph = ObjectGraph.create(getModules());
        mGraph.inject(this);
        mGraph.injectStatics();
    }

    private Object[] getModules() {
        return new Object[]{
                new RootModule(this)
        };
    }

    public void inject(Object object) {
        mGraph.inject(object);
    }

    public ObjectGraph plus(List<Object> modules) {
        return mGraph.plus(modules.toArray());
    }
}

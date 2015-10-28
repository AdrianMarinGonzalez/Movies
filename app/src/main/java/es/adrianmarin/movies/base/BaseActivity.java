package es.adrianmarin.movies.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import dagger.ObjectGraph;
import es.adrianmarin.movies.dagger.ActivityModule;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public abstract class BaseActivity extends FragmentActivity {

    private ObjectGraph mGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MoviesApplication application = (MoviesApplication)getApplication();
//        List<Object> modules = getModules();
        List<Object> modules = new ArrayList<Object>();
        modules.add(new ActivityModule(this));
        mGraph = application.plus(modules);
        inject(this);

    }

    public void inject(Object object){
        mGraph.inject(object);
    }

    protected abstract List<Object> getModules();
}

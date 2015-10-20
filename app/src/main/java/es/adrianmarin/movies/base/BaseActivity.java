package es.adrianmarin.movies.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

import dagger.ObjectGraph;
import es.adrianmarin.movies.R;
import es.adrianmarin.movies.dagger.BaseModule;

/**
 * @author Adrián Marín González
 * @since 20/10/15.
 */
public abstract class BaseActivity extends FragmentActivity {

    private ObjectGraph mGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        MoviesApplication application = (MoviesApplication)getApplication();
        List<Object> modules = getModules();
        modules.add(new BaseModule(this));
        mGraph = application.plus(modules);
        mGraph.inject(this);

    }

    private void initView(){
        View rootView = LayoutInflater.from(this).inflate(R.layout.main_view, null);
        setContentView(rootView);
    }

    protected abstract List<Object> getModules();
}

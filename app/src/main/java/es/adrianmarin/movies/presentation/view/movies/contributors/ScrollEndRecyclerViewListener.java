package es.adrianmarin.movies.presentation.view.movies.contributors;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public abstract class ScrollEndRecyclerViewListener extends RecyclerView.OnScrollListener{

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem;
    int visibleItemCount;
    int totalItemCount;

    private int currentPage = 1;

    private LinearLayoutManager mLinearLayoutManager;

    public ScrollEndRecyclerViewListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold)) {

            currentPage++;

            onLoadMore(currentPage);

            loading = true;
        }
    }

    public void resetPageCounter(){
        currentPage = 0;
    }

    public abstract void onLoadMore(int current_page);

}

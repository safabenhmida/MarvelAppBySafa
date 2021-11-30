package com.marvel.digital.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.SearchView;
import com.marvel.digital.R;
import com.marvel.digital.presenter.GridMarvelPresenter;
import com.marvel.digital.task.response.MarvelComicsResponse;
import com.marvel.digital.view.GridMarvelComicsAdapter;
import java.util.ArrayList;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BENHMIDA SAFA
 */

public class MarvelComicsActivity extends BaseActivity {

    @Inject
    GridMarvelPresenter mGridMarvelPresenter;
    MarvelComicsResponse mMarvelComicsResponse ;
    GridMarvelComicsAdapter mGridMarvelComicsAdapter ;
    String next , prev  ;
    @BindView(R.id.grid)
    GridView GridView;
    private ArrayList<MarvelComicsResponse> mMarvelComicsResponseList;
    int myLastVisiblePos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInjector().inject(this);
        ButterKnife.bind(this);
        mGridMarvelPresenter.setmMarvelComicsActivity(this);
        mGridMarvelPresenter.GetAllMarvelComics();
        showProgress();
        myLastVisiblePos = GridView.getFirstVisiblePosition();


        GridView.setOnScrollListener( new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int currentFirstVisPos = view.getFirstVisiblePosition();
                if(currentFirstVisPos > myLastVisiblePos) {
                    //scroll down
                    if (next != null) {
                        int i = Integer.parseInt(next.replaceAll("[\\D]", ""));
                        mGridMarvelPresenter.GetAllMarvelComicPage(i);
                        progressAlert(MarvelComicsActivity.this, getResources().getString(R.string.wait_plz));
                    }
                }
            }
        });


    }

    public void GetMarveComicsResults(MarvelComicsResponse MarveComicsResults) {
        this.mMarvelComicsResponse = MarveComicsResults;
        mGridMarvelComicsAdapter= new GridMarvelComicsAdapter(this,MarveComicsResults.getResults());
        GridView.setAdapter(mGridMarvelComicsAdapter);
        next= MarveComicsResults.getInfo().getNext();
        prev= MarveComicsResults.getInfo().getPrev();

    }    public void GetMarveComicsResultsp(MarvelComicsResponse MarveComicsResults) {
        this.mMarvelComicsResponse = MarveComicsResults;
        mGridMarvelComicsAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    mGridMarvelComicsAdapter.filter("");
                    GridView.clearTextFilter();
                }
                else {
                    mGridMarvelComicsAdapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}

package com.marvel.digital.presenter;

import com.marvel.digital.activity.MarvelComicsActivity;
import com.marvel.digital.event.MarvelComicsSuccesLoadEvent;
import com.marvel.digital.task.GetAllMarvelComicPageTask;
import com.marvel.digital.task.GridMarvelTask;
import com.marvel.digital.task.response.OperationResult;
import org.greenrobot.eventbus.Subscribe;
import javax.inject.Inject;

/**
 * Created by BENHMIDA SAFA
 */
public class GridMarvelPresenter extends BankOperationPresenter {

    MarvelComicsActivity mMarvelComicsActivity;

    @Inject
    public GridMarvelPresenter() {

    }


    public MarvelComicsActivity getmMarvelComicsActivity() {
        return mMarvelComicsActivity;
    }

    public void setmMarvelComicsActivity(MarvelComicsActivity mMarvelComicsActivity) {
        this.mMarvelComicsActivity = mMarvelComicsActivity;
    }

    public void GetAllMarvelComics() {
        GridMarvelTask mGridMarvelTask = new GridMarvelTask();
        mGridMarvelTask.execute();
    }

    public void GetAllMarvelComicPage(Integer i) {
        GetAllMarvelComicPageTask mGetAllMarvelComicPageTask = new GetAllMarvelComicPageTask();
        mGetAllMarvelComicPageTask.execute(i);
    }

    @Subscribe
    public void onMarvelComicsSuccesLoadEvent(MarvelComicsSuccesLoadEvent event) {
        getmMarvelComicsActivity().GetMarveComicsResults(event.getListMarvelComics());
        getmMarvelComicsActivity().dismissAlert();
    }


    @Subscribe
    public void onMarvelComicPageSuccesLoadEvent(MarvelComicsSuccesLoadEvent event) {
        getmMarvelComicsActivity().GetMarveComicsResultsp(event.getListMarvelComics());
        getmMarvelComicsActivity().dismissAlert();
    }
}


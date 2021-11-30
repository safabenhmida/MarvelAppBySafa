package com.marvel.digital.injection;

import com.marvel.digital.activity.BaseActivity;
import com.marvel.digital.activity.DetailsPersonelActivity;
import com.marvel.digital.activity.MarvelComicsActivity;
import com.marvel.digital.presenter.BankOperationPresenter;
import com.marvel.digital.presenter.GridMarvelPresenter;
import com.marvel.digital.task.DetailsPersonalTask;
import com.marvel.digital.task.GetAllMarvelComicPageTask;
import com.marvel.digital.task.GridMarvelTask;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by BENHMIDA SAFA
 */

@Singleton
@Component(modules = {GeneralModule.class, ServiceModule.class})
public interface Injector {

    void inject(BankOperationPresenter bankOperationPresenter);
    void inject(MarvelComicsActivity marvelComicsActivity);
    void inject(GridMarvelTask gridMarvelTask);
    void inject(BaseActivity baseActivity);
    void inject(GridMarvelPresenter gridMarvelPresenter);
    void inject(DetailsPersonelActivity detailsPersonelActivity);
    void inject(DetailsPersonalTask detailsPersonalTask);
    void inject(GetAllMarvelComicPageTask getAllMarvelComicPageTask);



}

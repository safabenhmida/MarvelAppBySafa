package com.marvel.digital.task;

import android.os.AsyncTask;
import com.marvel.digital.app.FrontOfficeMobileApp;
import com.marvel.digital.service.FrontOfficeMobileService;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;


/**
 * Created by BENHMIDA SAFA
 */public class GridMarvelTask extends AsyncTask<Void, Void, Void> {

    @Inject
    FrontOfficeMobileService frontOfficeMobileService;
    @Inject
    EventBus eventBus;


    public GridMarvelTask() {
        FrontOfficeMobileApp.getInstance().getInjector().inject(this);
    }


    @Override
    protected Void doInBackground(Void... params) {
        frontOfficeMobileService.GetAllMarvelComics();
        return null;
    }


}

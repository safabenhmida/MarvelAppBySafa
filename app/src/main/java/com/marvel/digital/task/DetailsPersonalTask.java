package com.marvel.digital.task;

import android.os.AsyncTask;
import com.marvel.digital.app.FrontOfficeMobileApp;
import com.marvel.digital.service.FrontOfficeMobileService;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;

/**
 * Created by BENHMIDA SAFA
 */

public class DetailsPersonalTask extends AsyncTask<Integer, Void, Void> {

    @Inject
    FrontOfficeMobileService frontOfficeMobileService;


    @Inject
    EventBus eventBus;

    public DetailsPersonalTask() {
        FrontOfficeMobileApp.getInstance().getInjector().inject(this);
    }


    @Override
    protected Void doInBackground(Integer... params) {
        frontOfficeMobileService.GetDetailsPersonnel(params[0]);
        return null;
    }


}

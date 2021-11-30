package com.marvel.digital.presenter;

import com.marvel.digital.activity.DetailsPersonelActivity;
import com.marvel.digital.event.DetailsPersonlSuccesLoadEvent;
import com.marvel.digital.task.DetailsPersonalTask;
import com.marvel.digital.task.response.OperationResult;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * Created by BENHMIDA SAFA
 */

public class DetailsPersonelPresenter extends BankOperationPresenter {

    DetailsPersonelActivity mDetailsPersonelActivity;

    @Inject
    public DetailsPersonelPresenter() {

    }



    public DetailsPersonelActivity getmDetailsPersonelActivity() {
        return mDetailsPersonelActivity;
    }

    public void setmDetailsPersonelActivity(DetailsPersonelActivity mDetailsPersonelActivity) {
        this.mDetailsPersonelActivity = mDetailsPersonelActivity;
    }

    public void GetDetailsPersonnel(int ID) {
        DetailsPersonalTask mDetailsPersonalTask = new DetailsPersonalTask();
        mDetailsPersonalTask.execute(ID);
    }


    @Subscribe
    public void onDetailsPersonlSuccesLoadEvent(DetailsPersonlSuccesLoadEvent event) {
        getmDetailsPersonelActivity().GetMarvelDetailsPersonal(event.getMarvelDetailsResponse());
        getmDetailsPersonelActivity().dismissAlert();
    }
}


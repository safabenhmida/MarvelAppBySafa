package com.marvel.digital.presenter;

import com.marvel.digital.app.Config;
import com.marvel.digital.app.FrontOfficeMobileApp;
import com.marvel.digital.task.response.OperationResult;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by BENHMIDA SAFA
 */
@Singleton
public abstract class BankOperationPresenter {

    @Inject
    EventBus eventBus;

    @Inject
    Config config;


    public BankOperationPresenter() {
        FrontOfficeMobileApp.getInstance().getInjector().inject(this);
        eventBus.register(this);
    }


    public EventBus getEventBus() {
        return eventBus;
    }


}

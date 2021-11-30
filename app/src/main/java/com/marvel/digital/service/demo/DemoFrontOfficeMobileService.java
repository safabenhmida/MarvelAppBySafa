package com.marvel.digital.service.demo;

import com.marvel.digital.service.FrontOfficeMobileService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;


/**
 * Created by BENHMIDA SAFA
 */

public class DemoFrontOfficeMobileService implements FrontOfficeMobileService {

    @Inject
    EventBus eventBus;

    @Inject
    public DemoFrontOfficeMobileService() {
    }


    @Override
    public void GetAllMarvelComics() {

    }

    @Override
    public void GetDetailsPersonnel(int ID) {

    }

    @Override
    public void GetAllMarvelComicPage(int PAGE) {

    }
}

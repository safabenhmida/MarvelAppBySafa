package com.marvel.digital.injection;

import com.marvel.digital.app.Config;
import com.marvel.digital.service.FrontOfficeMobileService;
import com.marvel.digital.service.demo.DemoFrontOfficeMobileService;
import com.marvel.digital.service.remote.RemoteFrontOfficeOperationService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BENHMIDA SAFA
 */
@Module
public class ServiceModule {

    @Provides
    @Singleton
    public FrontOfficeMobileService provideBankOperationService(DemoFrontOfficeMobileService demoFrontOfficeMobileService, RemoteFrontOfficeOperationService remoteFrontOfficeOperationService, Config config) {
        {
            if (config.getUseDemoServer()) {
               return demoFrontOfficeMobileService;
           } else {
               return remoteFrontOfficeOperationService;
           }

        }
    }



}

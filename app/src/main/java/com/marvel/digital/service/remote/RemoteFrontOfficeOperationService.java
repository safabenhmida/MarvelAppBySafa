package com.marvel.digital.service.remote;

import com.marvel.digital.event.DetailsPersonalFailLoadedEvent;
import com.marvel.digital.event.DetailsPersonalIlligalEvent;
import com.marvel.digital.event.DetailsPersonlSuccesLoadEvent;
import com.marvel.digital.event.MarvelComicsFailLoadedEvent;
import com.marvel.digital.event.MarvelComicsIlligalEvent;
import com.marvel.digital.event.MarvelComicsSuccesLoadEvent;
import com.marvel.digital.service.Api;
import com.marvel.digital.service.FrontOfficeMobileService;
import com.marvel.digital.task.response.MarvelComicsResponse;
import com.marvel.digital.task.response.MarvelDetailsResponse;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by BENHMIDA SAFA
 */
public  class RemoteFrontOfficeOperationService implements FrontOfficeMobileService {

    @Inject
    EventBus eventBus;
    @Inject
    Api api;

    @Inject
    public  RemoteFrontOfficeOperationService() {
        //Inject}
    }

    @Override
    public void GetAllMarvelComics() {
        api.GetAllMarvelComics().enqueue(new Callback<MarvelComicsResponse>() {
            @Override
            public void onResponse(Call<MarvelComicsResponse> call, Response<MarvelComicsResponse> response) {
                if (response.code() == 200) {
                    MarvelComicsSuccesLoadEvent event = new MarvelComicsSuccesLoadEvent(response.body());
                    eventBus.post(event);
                } else if (response.code() == 401) {
                    try {
                        JSONObject reader = new JSONObject(response.errorBody().string());
                        MarvelComicsFailLoadedEvent event = new MarvelComicsFailLoadedEvent(reader.getString("message"), response.code());
                        eventBus.post(event);
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                    MarvelComicsIlligalEvent event = new MarvelComicsIlligalEvent();
                    eventBus.post(event);
                } else {
                    MarvelComicsIlligalEvent event = new MarvelComicsIlligalEvent();
                    eventBus.post(event);
                }
            }

            @Override
            public void onFailure(Call<MarvelComicsResponse> call, Throwable t) {
                MarvelComicsIlligalEvent event = new MarvelComicsIlligalEvent();
                eventBus.post(event);
            }
        });
    }

    @Override
    public void GetDetailsPersonnel(int ID) {
        api.GetDetailsPersonnel(ID).enqueue(new Callback<MarvelDetailsResponse>() {
            @Override
            public void onResponse(Call<MarvelDetailsResponse> call, Response<MarvelDetailsResponse> response) {
                if (response.code() == 200) {
                    DetailsPersonlSuccesLoadEvent event = new DetailsPersonlSuccesLoadEvent(response.body());
                    eventBus.post(event);
                } else if (response.code() == 401) {
                    DetailsPersonalIlligalEvent event = new DetailsPersonalIlligalEvent();
                    eventBus.post(event);
                } else {
                    DetailsPersonalFailLoadedEvent event = new DetailsPersonalFailLoadedEvent();
                    eventBus.post(event);
                }
            }

            @Override
            public void onFailure(Call<MarvelDetailsResponse> call, Throwable t) {
                DetailsPersonalFailLoadedEvent event = new DetailsPersonalFailLoadedEvent();
                eventBus.post(event);
            }
        });
    }


    @Override
    public void GetAllMarvelComicPage(int PAGE) {
        api.GetAllMarvelComicPage(String.valueOf(PAGE)).enqueue(new Callback<MarvelComicsResponse>() {
            @Override
            public void onResponse(Call<MarvelComicsResponse> call, Response<MarvelComicsResponse> response) {
                if (response.code() == 200) {
                    MarvelComicsSuccesLoadEvent event = new MarvelComicsSuccesLoadEvent(response.body());
                    eventBus.post(event);
                } else if (response.code() == 401) {
                    try {
                        JSONObject reader = new JSONObject(response.errorBody().string());
                        MarvelComicsFailLoadedEvent event = new MarvelComicsFailLoadedEvent(reader.getString("message"), response.code());
                        eventBus.post(event);
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                    MarvelComicsIlligalEvent event = new MarvelComicsIlligalEvent();
                    eventBus.post(event);
                } else {
                    MarvelComicsIlligalEvent event = new MarvelComicsIlligalEvent();
                    eventBus.post(event);
                }
            }

            @Override
            public void onFailure(Call<MarvelComicsResponse> call, Throwable t) {
                MarvelComicsIlligalEvent event = new MarvelComicsIlligalEvent();
                eventBus.post(event);
            }
        });
    }

}

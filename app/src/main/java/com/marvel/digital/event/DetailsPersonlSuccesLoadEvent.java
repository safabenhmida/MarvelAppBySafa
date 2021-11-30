package com.marvel.digital.event;

import com.marvel.digital.task.response.MarvelDetailsResponse;

/**
 * Created by BENHMIDA SAFA
 */

public class DetailsPersonlSuccesLoadEvent {
    MarvelDetailsResponse marvelDetailsResponse;

    public DetailsPersonlSuccesLoadEvent(MarvelDetailsResponse marvelDetailsResponse) {
        this.marvelDetailsResponse = marvelDetailsResponse;
    }

    public MarvelDetailsResponse getMarvelDetailsResponse() {
        return marvelDetailsResponse;
    }

    public void setMarvelDetailsResponse(MarvelDetailsResponse marvelDetailsResponse) {
        this.marvelDetailsResponse = marvelDetailsResponse;
    }
}

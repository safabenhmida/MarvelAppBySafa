package com.marvel.digital.event;

import com.marvel.digital.task.response.MarvelComicsResponse;

/**
 * Created by BENHMIDA SAFA
 */

public class MarvelComicsSuccesLoadEvent {

   MarvelComicsResponse ListMarvelComics;

    public MarvelComicsSuccesLoadEvent(MarvelComicsResponse listMarvelComics) {
        ListMarvelComics = listMarvelComics;
    }

    public MarvelComicsResponse getListMarvelComics() {
        return ListMarvelComics;
    }

    public void setListMarvelComics(MarvelComicsResponse listMarvelComics) {
        ListMarvelComics = listMarvelComics;
    }
}

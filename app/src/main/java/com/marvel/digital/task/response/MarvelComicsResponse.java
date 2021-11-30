package com.marvel.digital.task.response;

import com.marvel.digital.domain.Infos;

import java.util.List;

/**
 * Created by BENHMIDA SAFA
 */
public class MarvelComicsResponse {

    List<Results> results ;
    Infos info ;

    public MarvelComicsResponse() {
        this.results = results;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public Infos getInfo() {
        return info;
    }

    public void setInfo(Infos info) {
        this.info = info;
    }
}

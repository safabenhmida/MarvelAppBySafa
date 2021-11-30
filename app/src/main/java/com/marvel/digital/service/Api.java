package com.marvel.digital.service;

import com.marvel.digital.task.response.MarvelComicsResponse;
import com.marvel.digital.task.response.MarvelDetailsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by BENHMIDA SAFA
 */
public interface Api {

    @GET("character")
    Call<MarvelComicsResponse>GetAllMarvelComics();

    @GET("character/{id}")
    Call<MarvelDetailsResponse>GetDetailsPersonnel(@Path("id") int id);

    @GET("character")
    Call<MarvelComicsResponse>GetAllMarvelComicPage(@Query("page") String page);

}
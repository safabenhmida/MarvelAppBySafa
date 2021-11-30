package com.marvel.digital.event;

/**
 * Created by BENHMIDA SAFA
 */

public class MarvelComicsFailLoadedEvent {

    String message;
    int code;

    public MarvelComicsFailLoadedEvent(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

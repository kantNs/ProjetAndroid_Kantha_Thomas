package com.example.kentha.projetandroid_kantha_thomas;

/**
 * Created by Kentha on 09/04/2018.
 */

class MonFilm {
    private String text;
    private String url_Image;

    public MonFilm(String text, String url_Image) {
        this.text = text;
        this.url_Image = url_Image;
    }

    public String getText() {
        return text;
    }

    public String getUrl_Image() {
        return url_Image;
    }
}

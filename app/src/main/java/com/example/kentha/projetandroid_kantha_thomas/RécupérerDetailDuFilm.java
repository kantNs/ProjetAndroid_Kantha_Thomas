package com.example.kentha.projetandroid_kantha_thomas;

import org.json.JSONException;
import org.json.JSONObject;


public class RécupérerDetailDuFilm {
    public String movieName,movieYear,genre,director,writer,actors,plot,language,imdbRating;

    public void mapJson(String jsonData) throws JSONException {
        JSONObject movieData = new JSONObject(jsonData);
        movieName = "Film: " + movieData.getString("Title");
        movieYear = "Année: " + movieData.getString("Year");
        genre = "Genre: " + movieData.getString("Genre");
        director = "Realisateur: " + movieData.getString("Director");
        writer = "Scenariste:" + movieData.getString("Writer");
        actors = "Casting: " + movieData.getString("Actors");
        plot = "Synopsis: " + movieData.getString("Plot");
        language = "Langage: " + movieData.getString("Language");
        imdbRating = "IMDB Note: " + movieData.getString("imdbRating");
    }
}

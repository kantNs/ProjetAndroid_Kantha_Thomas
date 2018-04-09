package com.example.kentha.projetandroid_kantha_thomas;

import org.json.JSONException;
import org.json.JSONObject;


public class RécupérerDetailDuFilm {
    public String movieName,movieYear,genre,director,writer,actors,plot,language,imdbRating;

    public void mapJson(String jsonData) throws JSONException {
        JSONObject movieData = new JSONObject(jsonData);
        movieName = "Movie: " + movieData.getString("Title");
        movieYear = "Year: " + movieData.getString("Year");
        genre = "Genre: " + movieData.getString("Genre");
        director = "Director: " + movieData.getString("Director");
        writer = "Writer:" + movieData.getString("Writer");
        actors = "Actors: " + movieData.getString("Actors");
        plot = "Plot: " + movieData.getString("Plot");
        language = "Language: " + movieData.getString("Language");
        imdbRating = "IMDB Rating: " + movieData.getString("imdbRating");
    }
}

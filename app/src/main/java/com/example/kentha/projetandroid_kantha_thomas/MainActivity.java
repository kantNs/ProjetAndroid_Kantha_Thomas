package com.example.kentha.projetandroid_kantha_thomas;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText zoneEdition;
    String jsonData;
    RécupérerDetailDuFilm film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LancerRecherche(View v){
        zoneEdition = (EditText) findViewById(R.id.editText);
        String api_url = getResources().getString(R.string.api_url) + zoneEdition.getText().toString()+"&apikey=ab007825";
        RecupJson(api_url);
    }

    public void Traitement(){
        film = new RécupérerDetailDuFilm();
        try {
            film.mapJson(this.jsonData);
            TextView textView = (TextView) findViewById(R.id.nomF);
            textView.setText(film.movieName);

            textView = (TextView) findViewById(R.id.anneeF);
            textView.setText(film.movieYear);

            textView = (TextView) findViewById(R.id.stryleF);
            textView.setText(film.genre);

            textView = (TextView) findViewById(R.id.scenariste);
            textView.setText(film.writer);

            textView = (TextView) findViewById(R.id.realisateurF);
            textView.setText(film.director);

            textView = (TextView) findViewById(R.id.synopsis);
            textView.setText(film.plot);

            textView = (TextView) findViewById(R.id.casting);
            textView.setText(film.actors);

            textView = (TextView) findViewById(R.id.langue);
            textView.setText(film.language);

            textView = (TextView) findViewById(R.id.noteImdb);
            textView.setText(film.imdbRating);

        } catch (JSONException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void RecupJson(String api_url){
        @SuppressLint("StaticFieldLeak") AsyncTask<String,String,String> task = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                String response = "";
                try{
                    URL url = new URL(params[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    BufferedReader
                            reader = new
                            BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String line = "";
                    while((line = reader.readLine()) != null){
                        response += line + "\n";
                    }
                } catch (Exception e){
                    return "Exception";
                }
                return response;
            }

            @Override
            protected void onPostExecute(String result) {
                MainActivity.this.jsonData = result;
                Traitement();
            }
        };

        task.execute(api_url);
    }
}
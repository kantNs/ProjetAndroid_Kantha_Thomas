package com.example.kentha.projetandroid_kantha_thomas;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private List<MonFilm> films = new ArrayList<>();
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

    public void Randomiser(View view) {
        setContentView(R.layout.activity2);
        ajouterFilm();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new MyAdapter(films));
    }

    private void ajouterFilm() {
        films.add(new MonFilm("Pirates des Caraibes","http://www.google.fr/intl/en_com/images/srpr/logo1w.png"));
        films.add(new MonFilm("Star Trek","http://flags.fmcdn.net/data/flags/w580/fr.png"));
        films.add(new MonFilm("Ok","http://flags.fmcdn.net/data/flags/w580/fr.png"));
        films.add(new MonFilm("Up","http://flags.fmcdn.net/data/flags/w580/fr.png"));
        films.add(new MonFilm("Avatar","http://www.google.fr/intl/en_com/images/srpr/logo1w.png"));
        films.add(new MonFilm("Mars","http://www.google.fr/intl/en_com/images/srpr/logo1w.png"));
    }

}
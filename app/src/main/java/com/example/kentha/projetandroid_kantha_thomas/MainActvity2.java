package com.example.kentha.projetandroid_kantha_thomas;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kentha on 10/04/2018.
 */

public class MainActvity2 extends AppCompatActivity {
    final String KEY_NOTIFICATION_REPLY = "KEY_NOTIFICATION_REPLY"; ;
    private RecyclerView recyclerView;

    private List<MonFilm> films = new ArrayList<>();
    private String jsonData;
    private RécupérerDetailDuFilm film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.quit:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Traitement2() {
        film = new RécupérerDetailDuFilm();
        try {
            film.mapJson(this.jsonData);
            films.add(new MonFilm("" + film.movieName + "", "https://www.gannett-cdn.com/-mm-/cabc9efca16c634c6659905c4fceb5d197388a0b/c=0-68-1399-1120&r=x393&c=520x390/local/-/media/2015/12/08/USATODAY/USATODAY/635851909778644878-XXX-d-Star-Wars-CDs-ZX24463.jpg"));

        } catch (JSONException e) {
            Toast.makeText(MainActvity2.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void RecupJson2(String api_url) {
        @SuppressLint("StaticFieldLeak") AsyncTask<String, String, String> task = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                String response = "";
                try {
                    URL url = new URL(params[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    BufferedReader
                            reader = new
                            BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        response += line + "\n";
                    }
                } catch (Exception e) {
                    return "Exception";
                }
                return response;
            }

            @Override
            protected void onPostExecute(String result) {
                MainActvity2.this.jsonData = result;
                Traitement2();
            }
        };

        task.execute(api_url);
    }

    private void ajouterFilm() {
        String api_url = getResources().getString(R.string.api_url) + "Star Wars" + "&apikey=ab007825";
        RecupJson2(api_url);

        films.add(new MonFilm("Star Trek", "http://www.startrekmovie.com/images/share.jpg"));
        films.add(new MonFilm("Ok", "http://flags.fmcdn.net/data/flags/w580/fr.png"));
        films.add(new MonFilm("Up", "http://flags.fmcdn.net/data/flags/w580/fr.png"));
        films.add(new MonFilm("Avatar", "http://flags.fmcdn.net/data/flags/w580/fr.png"));
        films.add(new MonFilm("Mars", "http://flags.fmcdn.net/data/flags/w580/fr.png"));
    }




}

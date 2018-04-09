package com.example.kentha.projetandroid_kantha_thomas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kentha on 09/04/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<MonFilm> list;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<MonFilm> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.film_au_hasard,viewGroup,false);
        return new MyViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        MonFilm monFilm = list.get(position);
        myViewHolder.bind(monFilm);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

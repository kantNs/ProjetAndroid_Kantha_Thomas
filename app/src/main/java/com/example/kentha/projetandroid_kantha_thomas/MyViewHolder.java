package com.example.kentha.projetandroid_kantha_thomas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kentha on 09/04/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewView;
    private ImageView imageView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }
    public void bind(MonFilm monFilm){
        textViewView.setText(monFilm.getText());
        Picasso.with(imageView.getContext()).load(monFilm.getUrl_Image()).centerCrop().fit().into(imageView);
    }

}

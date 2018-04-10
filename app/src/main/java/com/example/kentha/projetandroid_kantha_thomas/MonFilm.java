package com.example.kentha.projetandroid_kantha_thomas;

/**
 * Created by Kentha on 09/04/2018.
 */

class MonFilm {
    private String text;
    private String url_Image;
    private String nomFilm;
    private String anneeF;
    private String stryleF;
    private String scenariste;
    private String realisateurF;
    private String synopsis;
    private String casting;
    private String langue;
    private String noteImdb;

    public MonFilm(String text, String url_Image, String nomFilm, String anneeF, String stryleF, String scenariste, String realisateurF, String synopsis, String casting, String langue, String noteImdb) {
        this.text = text;
        this.url_Image = url_Image;
        this.nomFilm = nomFilm;
        this.anneeF = anneeF;
        this.stryleF = stryleF;
        this.scenariste = scenariste;
        this.realisateurF = realisateurF;
        this.synopsis = synopsis;
        this.casting = casting;
        this.langue = langue;
        this.noteImdb = noteImdb;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUrl_Image(String url_Image) {
        this.url_Image = url_Image;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public String getAnneeF() {
        return anneeF;
    }

    public void setAnneeF(String anneeF) {
        this.anneeF = anneeF;
    }

    public String getStryleF() {
        return stryleF;
    }

    public void setStryleF(String stryleF) {
        this.stryleF = stryleF;
    }

    public String getScenariste() {
        return scenariste;
    }

    public void setScenariste(String scenariste) {
        this.scenariste = scenariste;
    }

    public String getRealisateurF() {
        return realisateurF;
    }

    public void setRealisateurF(String realisateurF) {
        this.realisateurF = realisateurF;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCasting() {
        return casting;
    }

    public void setCasting(String casting) {
        this.casting = casting;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getNoteImdb() {
        return noteImdb;
    }

    public void setNoteImdb(String noteImdb) {
        this.noteImdb = noteImdb;
    }

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

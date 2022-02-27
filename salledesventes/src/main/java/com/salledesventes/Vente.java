package com.salledesventes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Vente {
    private Vente() {
        Encherisseurs = new HashSet<Encherisseur>();
    }

    private static Vente instance;

    private Article Article;

    private Chronometre Chronometre;

    private HashSet<Encherisseur> Encherisseurs;

    public final static Vente getInstance() {
        if (Vente.instance == null) {
            Vente.instance = new Vente();
        }
        return instance;
    }

    public Article getArticle() {
        return Article;
    }

    public void setArticle(Article article) {
        Article = article;
    }

    public void setDureeVente(int Duree) {

    }

    public boolean addEncherisseur(Encherisseur encherisseur) {
        return this.Encherisseurs.add(encherisseur);
    }

}

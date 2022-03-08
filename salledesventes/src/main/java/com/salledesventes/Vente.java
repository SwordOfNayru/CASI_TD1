package com.salledesventes;

import java.util.ArrayList;
import java.util.HashSet;

public class Vente {

    private static Vente instance;

    private Article Article;

    private Chronometre Chronometre;

    private HashSet<Encherisseur> Encherisseurs;

    private ArrayList<Enchere> ListEchere;

    private boolean started = false;

    private Vente() {
        Encherisseurs = new HashSet<Encherisseur>();
        ListEchere = new ArrayList<Enchere>();
    }

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

    public Chronometre getChronometre() {
        return Chronometre;
    }

    public void setDureeVente(long Duree) {
        if (Chronometre == null) {
            Chronometre = new Chronometre(Duree);
            started = true;
        }
    }

    public boolean addEncherisseur(Encherisseur encherisseur) {
        for (Encherisseur e : Encherisseurs) {
            if (e.equals(encherisseur)) {
                return false;
            }
        }

        return this.Encherisseurs.add(encherisseur);
    }

    public boolean encherir(Encherisseur encherisseur, Float prix) {
        if (!started) {
            return false;
        }

        float minimunArticle = this.getHighestPrice();

        if (prix <= minimunArticle) {
            return false;
        }

        ListEchere.add(new Enchere(encherisseur, prix));

        return true;
    }

    private float getHighestPrice() {
        if (ListEchere.size() == 0) {
            return Article.getPrix();
        } else {
            return ListEchere.get(ListEchere.size() - 1).getPrix();
        }
    }

    public void cloture() {
        this.started = false;
        System.out.println("Vente close");
    }

}

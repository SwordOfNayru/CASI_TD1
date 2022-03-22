package com.salledesventes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow.Subscriber;

public class Vente {

    private static Vente instance;

    private Article Article;

    private Chronometre Chronometre;

    private HashSet<Encherisseur> Encherisseurs;

    private ArrayList<Enchere> ListEchere;

    private SubmissionPublisher<Notification> submissionFlux;

    private boolean started = false;

    private Vente() {
        Encherisseurs = new HashSet<Encherisseur>();
        ListEchere = new ArrayList<Enchere>();
        submissionFlux = new SubmissionPublisher<Notification>();

        this.ListEchere.add(new Enchere(new Encherisseur("personne"), 0f));
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

    public void subscribe(Subscriber<Notification> subscriber) {
        this.submissionFlux.subscribe(subscriber);
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
        this.sendNotification();
        return true;
    }

    public void tick() {
        System.out.println("tack");
        sendNotification();
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
        this.sendNotification();
    }

    private void sendNotification() {
        System.out.println("J'envoie");
        if (submissionFlux != null) {
            Enchere LastEnchere = this.ListEchere.get(this.ListEchere.size() - 1);
            submissionFlux.submit(new Notification(this.Chronometre.getTempsRestant(), LastEnchere.getPrix(),
                    LastEnchere.getOwner().getPseudo()));
        }
    }

}

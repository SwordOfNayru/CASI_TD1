package com.salledesventes;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class SalleDesVentes {
    public static void main(String[] args) {
        Article articleAVendre = new Article(1, "Tableau de maître", 1f);
        Vente vente = Vente.getInstance();
        List<Encherisseur> encherisseurs = new ArrayList<Encherisseur>();
        encherisseurs.add(new Encherisseur("Marcel"));
        encherisseurs.add(new Encherisseur("Marcel"));
        encherisseurs.add(new Encherisseur("Michelle"));
        encherisseurs.add(new Encherisseur("Micheline"));

        vente.setArticle(articleAVendre);
        vente.setDureeVente(20000);

        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(vente.getChronometre(), 0, 1000);

        for (Encherisseur e : encherisseurs) {
            System.out.println(String.format("Ajout de %s", e.getPseudo()));
            while (!vente.addEncherisseur(e)) {
                e.setPseudo(e.getPseudo() + 1);
                System.out.println(String.format("Le pseudo de l'enchérisseur existe déjà. Pseudo transformé en %s",
                        e.getPseudo()));
            }
            System.out.println(String.format("%s à été ajouter dans la vente", e.getPseudo()));
        }

        addEnchere(encherisseurs.get(0), 20f);
        wait(3);
        addEnchere(encherisseurs.get(2), 10f);
        wait(1);
        addEnchere(encherisseurs.get(3), 30f);
        wait(10);
        addEnchere(encherisseurs.get(0), 100f);
        wait(10);
        addEnchere(encherisseurs.get(2), 110f);
    }

    private static void addEnchere(Encherisseur e, float m) {
        if (Vente.getInstance().encherir(e, m)) {
            System.out.println(String.format("%s mène l'enchère avec %f €", e.getPseudo(), m));
        } else {
            System.out.println(String.format("L'enchère de %f de %s a été rejetée", m,
                    e.getPseudo()));
        }
    }

    private static void wait(int secondes) {
        try {
            TimeUnit.SECONDS.sleep(secondes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

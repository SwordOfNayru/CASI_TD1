package com.salledesventes;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Article articleAVendre = new Article(1, "Tableau de maître", 1);
        Vente vente = Vente.getInstance();

        vente.setDureeVente(5000);

        Encherisseur encherisseur = new Encherisseur("Marcel");

        if (vente.addEncherisseur(encherisseur)) {
            System.out.println(String.format("%s à été ajouter dans la vente", encherisseur.getPseudo()));
        } else {
            encherisseur.setPseudo(encherisseur.getPseudo() + 1);
            System.out.println(String.format("Le pseudo de l'enchérisseur existe déjà. Pseudo transformé en %s",
                    encherisseur.getPseudo()));

            vente.addEncherisseur(encherisseur);
        }

        float montant = 20f;

        // A finir

    }
}

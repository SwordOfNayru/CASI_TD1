package com.salledesventes;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import com.salledesventes.front.EncherisseurGUI;

/**
 * Hello world!
 *
 */
public class SalleDesVentes {
    public static void main(String[] args) {
        Article articleAVendre = new Article(1, "Tableau de maître", 1f);
        Vente vente = Vente.getInstance();
        ArrayList<EncherisseurGUI> guis = new ArrayList<EncherisseurGUI>();

        vente.setArticle(articleAVendre);
        vente.setDureeVente(200000);

        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(vente.getChronometre(), 0, 1000);

        for (int i = 3; i > 0; i--) {
            EncherisseurGUI gui = new EncherisseurGUI();
            gui.setVisible(true);
            guis.add(gui);
        }

    }
}

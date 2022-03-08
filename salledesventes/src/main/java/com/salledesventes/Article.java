package com.salledesventes;

public class Article {

    private int Numero;

    private String Nom;

    private float Prix;

    public Article(int numero, String nom, float prix) {
        this.Numero = numero;
        this.Nom = nom;
        this.Prix = prix;
    }

    public int getNumero() {
        return Numero;
    }

    public String getNom() {
        return Nom;
    }

    public float getPrix() {
        return Prix;
    }

    public void setPrix(float prix) {
        Prix = prix;
    }

}

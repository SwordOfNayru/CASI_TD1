package com.salledesventes;

public class Article {

    private int Numero;

    private String Nom;

    private double Prix;

    public Article(int numero, String nom, double prix) {
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

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

}

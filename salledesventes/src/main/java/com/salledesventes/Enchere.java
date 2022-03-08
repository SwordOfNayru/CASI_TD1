package com.salledesventes;

public class Enchere {

    private Encherisseur Owner;

    private float Prix;

    public Enchere(Encherisseur owner, float prix) {
        Owner = owner;
        Prix = prix;
    }

    public Encherisseur getOwner() {
        return Owner;
    }

    public float getPrix() {
        return Prix;
    }

}

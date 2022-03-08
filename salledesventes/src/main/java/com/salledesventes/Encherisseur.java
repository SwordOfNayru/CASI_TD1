package com.salledesventes;

public class Encherisseur {

    private String Pseudo;

    public Encherisseur(String pseudo) {
        this.Pseudo = pseudo;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Encherisseur)) {
            return false;
        }

        Encherisseur e = (Encherisseur) o;

        return this.Pseudo == e.getPseudo();

    }

}

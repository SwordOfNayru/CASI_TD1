package com.salledesventes;

public class Notification {

    private long Timer;

    private float LastPrice;

    private String LastEncherisseur;

    public Notification(long timer, float lastPrice, String lastEncherisseur) {
        this.Timer = timer;
        this.LastPrice = lastPrice;
        this.LastEncherisseur = lastEncherisseur;
    }

    public String getLastEncherisseur() {
        return LastEncherisseur;
    }

    public float getLastPrice() {
        return LastPrice;
    }

    public long getTimer() {
        return Timer;
    }

}

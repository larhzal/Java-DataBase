package com.example;

public class Devise {
    String devise;
    double taux;
    
    public Devise(String devise, double taux) {
        this.devise = devise;
        this.taux = taux;
    }
    public String getdevise() {
        return devise;
    }
    public void setdevise(String devise) {
        this.devise = devise;
    }
    public double getTaux() {
        return taux;
    }
    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString(){
        return devise;
    }
    
}

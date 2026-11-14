package com.tuton;

public class Diskon extends MenuItem{
private double persentaseDiskon;

    public Diskon(String nama, double hargaPotongan, double persentaseDiskon) {
        super(nama, hargaPotongan, "Diskon");
        this.persentaseDiskon = persentaseDiskon;
    }

    public double getPersentaseDiskon() {
        return persentaseDiskon;
    }

    @Override 
    public void tampilMenu() {
        System.out.println("Diskon: " + getNama() + ", Persentase Diskon: " + persentaseDiskon + "%");
    }

    
}

package com.tuton;

public class Makanan extends MenuItem {

    private string jenisMakanan; // misal: main course, dessert
    (String nama, double harga, String jenisMakanan){
        super(nama, harga, 
        this.jenisMakanan = jenisMakanan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    publicvoid setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }
    @Override
    public void tampilMenu() {
        System.out.println("Makanan: " + getNama() + ", Harga: " + getHarga() + ", Jenis: " + getJenisMakanan());
    }

}

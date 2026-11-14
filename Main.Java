  package com.tuton;
import java.util.*;
import java.io.*;

public class Data {
    public static void main(String[] args) {
        MenuRestoran menuRestoran = new daftarMenu();
        Scanner scanner = new Scanner(System.in);
        Pesanan orderList = null;

        int pilihan= 0;
        do {
            System.out.println("=== Aplikasi Pemesanan Restoran ===");
            System.out.println("1. Lihat Daftar Menu");
            System.out.println("2. Tambah Menu Item");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Simpan menu ke file");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            try{
                pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        menuRestoran.tampilkanDaftarMenu();
                        break;
                    case 2:
                        System.out.print("Tambah menu baru: ");
                        System.out.println(" pilih jenis (1. Makanan, 2. Minuman, 3.Diskon): ");
                        int jenis = Integer.parseInt(scanner.nextLine());

                        System.out.print("Masukkan nama menu: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan harga menu: ");
                        double harga = Double.parseDouble(scanner.nextLine());

                        if (jenis == 1) {
                            System.out.print("Masukkan kategori makanan: ");
                            String kategoriMakanan = scanner.nextLine();
                            MenuItem.tambahMenuItem(new MenuItem(nama, harga, kategoriMakanan));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan kategori minuman: ");
                            String kategoriMinuman = scanner.nextLine();
                            MenuItem.tambahMenuItem(new Minuman(nama, harga, kategoriMinuman));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan persentase diskon: ");
                            double persentaseDiskon = Double.parseDouble(scanner.nextLine());
                            MenuItem.tambahMenuItem(new Diskon(nama, harga, persentaseDiskon));
                        } else {
                            System.out.println("Jenis yang dimasukkan tidak valid.");
                        }
                        break;

                    case 3:
                        orderList = new Pesanan();
                        boolean lanjutPesan = true;

                        while (lanjutPesan) {
                            menuRestoran.tampilkanDaftarMenu();
                            System.out.print("Masukkan nama menu yang ingin dipesan (atau ketik 'selesai' untuk selesai): ");
                            String namaPesanan = scanner.nextLine();

                            if (namaPesanan.equalsIgnoreCase("selesai")) {
                                lanjutPesan = false;
                                break;
                            }

                            try {
                                //jika menu tidak ditemukan, getMenuItem akan mengembalikan null
                                MenuItem item = menuRestoran.getMenuItem(namaPesanan);
                                System.out.println(" masukkan jumlah : ");
                                int qty = Integer.parseInt(scanner.nextLine());

                                orderList.tambahPesanan(item, qty);
                                System.out.println(item.getNama() + " x" + qty);
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Menu tersebut tidak tersedia. Silakan pilih menu yang tersedia.");
                            }
                        }

                        //cetak struk pesanan
                        orderList.cetakStruk("struk_pesanan.txt");
                        break;

                    case 4:
                        menuRestoran.simpanMenuKeFile("namaFile.txt");
                        break;

                    case 5:
                        System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-5.");
                }   
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka.");
        }
        } while (pilihan != 5);

        scanner.close();
    }
}

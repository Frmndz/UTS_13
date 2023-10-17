package UTS_13;
import java.util.Scanner;

import java.util.Scanner;

public class Toko13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String namaPelanggan, namaProduk;
        String lanjut;
        double totalPembelian = 0.0;
        double hargaSatuan = 0.0;
        double diskon = 0.0;
        double totalHargaProduk = 0.0;
        double diskonProduk = 0.0;
        double diskonMember = 0.0;
        double totalDiskonAkhir = 0.0;
        double totalDiskon = 0.0;
        double totalAkhir = 0.0;
        int totalItemBarang = 0;
        boolean isMember;
        
        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan = input.nextLine();
        System.out.print("Apakah pelanggan adalah member? (y/n): ");
        isMember = input.nextLine().equalsIgnoreCase("y");

        while (true) {
            System.out.print("Masukkan nama produk: ");
            namaProduk = input.nextLine();
            System.out.print("Masukkan harga satuan produk: ");
            hargaSatuan = input.nextDouble();
            System.out.print("Masukkan kuantitas produk yang dibeli: ");
            int kuantitas = input.nextInt();
            System.out.print("Masukkan diskon produk (dalam persen): ");
            diskon = input.nextDouble();

            totalHargaProduk = hargaSatuan * kuantitas;
            totalItemBarang += kuantitas;

            diskon /= 100;
            diskonProduk = totalHargaProduk * diskon;

            totalPembelian += totalHargaProduk - diskonProduk;

            totalDiskon += diskonProduk;

            System.out.print("Apakah ingin menambahkan produk lagi? (y/n): ");
            lanjut = input.next();
            if (!lanjut.equalsIgnoreCase("y")) {
                break;
            }
        }

        diskonMember = isMember && totalPembelian >= 200000 ? 0.1 * totalPembelian : 0.05 * totalPembelian;

        totalDiskonAkhir = totalDiskon + diskonMember;

        totalAkhir = totalPembelian - totalDiskonAkhir;

        System.out.println("\n===== Struk Pembelian =====");
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Tipe Pelanggan: " + (isMember ? "Member" : "Non-Member"));
        System.out.println("Total Item Barang: " + totalItemBarang);
        System.out.println("Total Harga Sebelum Diskon: Rp " + totalPembelian);
        System.out.println("Total Diskon: Rp " + totalDiskonAkhir);
        System.out.println("Total Akhir yang Harus Dibayar: Rp " + totalAkhir);
        System.out.println("===========================");
    }
}
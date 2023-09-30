import java.util.Scanner;
public class formTransaksiPasien {
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);

        //membuat variable sting atau karakter
        String noKtp;
        String noBpjs;
        String namaPasien;
        String KeluhanPasien;
        
        //membuat varible int berupa angka yang memerlukan perhitungan
        int usiaPasien;
        int potonganBpjs;
        int harga;
        int hargaAkhir;

        System.out.println("Selamat Datang Di Rumah Sakit X - Admin");
        System.out.println("Masukkan Data Pasien");
        System.out.println("");

        //membuat inputan data pasien untuk admin
        System.out.print("No KTP                      :");
        noKtp = sc.nextLine();
        System.out.print("NO BPJS (Jika ada)          :");
        noBpjs = sc.nextLine();
        System.out.print("Nama                        :");
        namaPasien = sc.nextLine();
        System.out.print("Usia                        :");
        usiaPasien = sc.nextInt();
        KeluhanPasien = sc.nextLine();
        System.out.print("Keluhan                     :");
        KeluhanPasien = sc.nextLine();
    
        System.out.println("--------------------------------------------------");
        
        System.out.print("Potongan BPJS(%)            :");
        potonganBpjs = sc.nextInt();
        System.out.print("Harga                       :");
        harga = sc.nextInt();
        
        //memproses perhitungan pembayaran
        hargaAkhir = harga - (harga*potonganBpjs/100);
        System.out.println("--------------------------------------------------");
        System.out.print("Harga Akhir                   :" + hargaAkhir);
    }
}

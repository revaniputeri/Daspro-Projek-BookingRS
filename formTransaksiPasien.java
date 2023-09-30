import java.util.Scanner;
public class formTransaksiPasien {
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);

        //membuat variable sting atau karakter
        String noKtp;
        String noBpjs;
        String namaPasien;
        String KeluhanPasien;
        char statusbpjs;
        String kategoriPasien;
        String nokartu;
        char pembayaran;
        
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
        
        //penambahan fitur pasien BPJS 
        System.out.println("Apakah pasien memiliki kartu BPJS (0 = ya, 1 = tidak)? ");
        statusbpjs = sc.next().charAt(0);

        if (statusbpjs == '0') {
            noBpjs = sc.nextLine();
            System.out.print("Masukkan No.BPJS pasien     : ");
            noBpjs = sc.nextLine();
            potonganBpjs = 100;
        } else {
            potonganBpjs = 0;
            namaPasien = sc.nextLine();
        }

        System.out.print("Nama                        : ");
        namaPasien = sc.nextLine();

        //usia menggunakan ifelse menentukan biaya konsultasi atau berobat
        System.out.print("Usia                        : ");
        usiaPasien = sc.nextInt();
        if (usiaPasien <= 17) {
            kategoriPasien = "A-Anak";
            harga = 5000;
        } else {
            kategoriPasien = "D-Dewasa";
            harga = 10000;
        }

        KeluhanPasien = sc.nextLine();
        System.out.print("Keluhan                     : ");
        KeluhanPasien = sc.nextLine();
        System.out.println("--------------------------------------------------");

        //potongan BPJS pada puskesmas 100%
        System.out.println("Potongan BPJS(%)            : " +potonganBpjs);
        //harga di tentukan sesuai kategori usia pasien
        System.out.println("Harga                       : " +harga);
        
        //memproses perhitungan pembayaran
        hargaAkhir = harga - (harga*potonganBpjs/100);
        System.out.println("--------------------------------------------------");
        System.out.println("Harga Akhir                 :" + hargaAkhir);

        //pembayaran debit atau tunai by fauzi
        System.out.println("Metode pembayaran menggunakan(1 = debit, 2 = tunai)? ");
        pembayaran = sc.next().charAt(0);

        if (pembayaran == '1') {
            nokartu = sc.nextLine();
            System.out.print("Masukan nomor kartu debit :");
            nokartu = sc.nextLine();
            
        } else {
            System.out.println("Pembayaran menggunakan uang tunai");
        }



    }
}

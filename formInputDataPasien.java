import java.util.Scanner;
public class formInputDataPasien {
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
        System.out.println("No KTP                      :");
        noKtp = sc.nextLine();
        System.out.println("NO BPJS (Jika ada)          :");
        noBpjs = sc.nextLine();
        System.out.println("Nama                        :");
        namaPasien = sc.nextLine();
        System.out.println("Usia                        :");
        usiaPasien = sc.nextInt();
        KeluhanPasien = sc.nextLine();
        System.out.println("Keluhan                     :");
        KeluhanPasien = sc.nextLine();
    
        System.out.println("--------------------------------------------------");
        
        System.out.println("Potongan BPJS(%)            :");
        potonganBpjs = sc.nextInt();
        System.out.println("Harga                       :");
        harga = sc.nextInt();
        
        //memproses perhitungan pembayaran
        hargaAkhir = harga - (harga*potonganBpjs/100);
        System.out.println("--------------------------------------------------");
        System.out.println("Harga Akhir        :" + hargaAkhir);
    }
}

import java.util.Scanner;
public class DokterPuskesmas {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat Datang Di Rumah Sakit X - Admin");
        System.out.println("Pilih dokter yang ingin Anda temui:");
        System.out.println("==============Daftar Dokter=============");
        System.out.println("| 1. Dokter Umum                        |"); 
        System.out.println("| 2. Dokter Gigi                        |"); 
        System.out.println("| 3. Bidan                              |");
        System.out.println("| 4. perawat                            |"); 
        System.out.println("| 5. petugas lab                        |"); 
        System.out.println("| 6. tenaga gizi                        |"); 
        System.out.println("Pilih nomor dokter yang dibutuhkan pasien : ");
        int pemilihan = input.nextInt();
        String keluhan;

        switch (pemilihan) {
            case 1:
                keluhan = "Keluhan Dokter Umum";
                System.out.println("Dokter Umum - Konsultansi " + keluhan);
                break;
            case 2:
                keluhan = "Keluhan Dokter Gigi";
                System.out.println("Dokter Gigi - Konsultansi " + keluhan);
                break;
            case 3:
                keluhan = "Keluhan Bidan";
                System.out.println("Bidan - Konsultansi " + keluhan);
                break;
            case 4:
                keluhan = "Keluhan Perawat";
                System.out.println("Perawat - Konsultansi " + keluhan);
                break;
            case 5:
                keluhan = "Keluhan Petugas Lab";
                System.out.println("Petugas Lab - Konsultansi " + keluhan);
                break;
            case 6:
                keluhan = "Keluhan Tenaga Gizi";
                System.out.println("Tenaga Gizi - Konsultansi " + keluhan);
                break;

            default:
                System.out.println("Inputan tidak valid!");
                break;
        }
    }
}
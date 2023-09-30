import java.util.Scanner;

public class formRegistrasiPasien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char status;

        System.out.println("Apakah pasien memiliki kartu berobat? (0 = tidak, 1 = ya)");
        status = sc.next().charAt(0);

        if (status == '0') {
            System.out.println("Silahkan melakukan registrasi dibawah ini :");
            String noKartu = sc.nextLine();
            System.out.print("No.Kartu  : ");
            noKartu = sc.nextLine();
            System.out.print("NIK       : ");
            noKartu = sc.nextLine();
            System.out.print("Nama      : ");
            String nama = sc.nextLine();
            System.out.print("Alamat    : ");
            String alamat = sc.nextLine();
            System.out.print("No.Telp   : ");
            String noTelp = sc.nextLine();
            //menyimpan data
            System.out.println("Data berhasil disimpan");
        }else{
            System.out.print("pasien sudah memiliki kartu berobat");
            //lanjut ke form transaksi
        }
    }
}
import java.util.Scanner;

public class formRegistrasiPasien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char status, statusKartu;

        System.out.println("Apakah pasien memiliki kartu berobat? (0 = tidak, 1 = ya)");
        status = sc.next().charAt(0);
        String noKartu[] = new String[100];
        String namaPasien[] = new String[100];
        String alamatPasien[] = new String[100];
        String noTelp[] = new String[100];
        if (status == '0') {
            for(int i=0;i<=noKartu.length;i++){
                System.out.println("Silahkan melakukan registrasi di bawah ini :");
                noKartu[i] = sc.nextLine();
                System.out.print("No Kartu  : ");
                noKartu[i] = sc.nextLine();
                System.out.print("Nama      : ");
                namaPasien[i] = sc.nextLine();
                System.out.print("Alamat    : ");
                alamatPasien[i] = sc.nextLine();
                System.out.print("No. Telp    : ");
                noTelp[i] = sc.nextLine();
                //menyimpan data
                break;
            }
            System.out.println("Data berhasil disimpan");
            System.out.println("No kartu: "+noKartu[i]);
            System.out.println("Nama: "+namaPasien[i]);
            System.out.println("alamat: "+alamatPasien[i]);
            System.out.println("no telp: "+noTelp[i]);
            System.out.println("Ingin melihat daftar kartu? (0 = tidak, 1 = ya)");
            // if (statusKartu == 1) {
            //     System.out.println("No kartu: ");
            //     System.out.println("Nama: ");
            //     System.out.println("alamat: ");
            //     System.out.println("no telp: ");
            // }
            // for(String a : noKartu){
            //     System.out.println(a);
            // }

        }else{
            System.out.print("pasien sudah memiliki kartu berobat ");
            //lanjut ke form transaksi
        }

        // System.out.println("Nama Pasien: "+namaPasien.length);
    }
}
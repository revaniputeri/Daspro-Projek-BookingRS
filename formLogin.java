import java.util.Scanner;

public class formLogin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mainChoice;       

        System.out.println("===============================================");
        System.out.println("| Selamat datang di Sistem Reservasi Puskesmas |");
        System.out.println("===============================================");
        System.out.println("| 1. Admin                                     |");
        System.out.println("| 2. Keluar                                    |");
        System.out.println("===============================================");
        System.out.print("Pilih tipe pengguna: ");
        mainChoice = input.nextInt();

        if (mainChoice == 1) {
            System.out.print("Masukkan username admin: ");
            String username = input.next();
            System.out.print("Masukkan password admin: ");
            String password = input.next();
        } else if (mainChoice == 2) {
            // Keluar dari program
            System.out.println("Terima kasih! Program selesai.");
        } else {
            // Jika input tidak valid
            System.out.println("Pilihan tidak valid. Silakan pilih tipe pengguna yang benar.");
        }
    }
}

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
            if (username.equals("admin1") && password.equals("adminsatu")) {
                int adminChoice;

                System.out.println("Login berhasil.");
                System.out.println("==========================================================");
                System.out.println("|    Selamat datang " + username + " di Sistem Reservasi Puskesmas  |");
                System.out.println("==========================================================");
                System.out.println("| 1. Reservasi Baru                                       |");
                System.out.println("| 2. Lihat History Reservasi                              |");
                System.out.println("| 3. Keluar                                               |");
                System.out.println("==========================================================");

                System.out.print("Pilih menu: ");
                adminChoice = input.nextInt();

                if (adminChoice == 1) {
                    // Menu Reservasi Baru
                    System.out.println("Anda memilih menu Reservasi Baru.");
                    // Tambahkan nested if untuk langkah-langkah reservasi baru
                } else if (adminChoice == 2) {
                    // Menu Lihat Jadwal Reservasi
                    System.out.println("Anda memilih menu Lihat History Reservasi.");
                    // Tambahkan kode untuk melihat jadwal reservasi
                } else if (adminChoice == 3) {
                    // Keluar dari akun admin
                    System.out.println("Anda telah keluar dari akun admin.");
                } else {
                    // Jika input tidak valid
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
                }
            } else {
                // Jika login gagal
                System.out.println("Login gagal. Username atau password salah.");
            }
        } else if (mainChoice == 2) {
            // Keluar dari program
            System.out.println("Terima kasih! Program selesai.");
        } else {
            // Jika input tidak valid
            System.out.println("Pilihan tidak valid. Silakan pilih tipe pengguna yang benar.");
        }
    }
}

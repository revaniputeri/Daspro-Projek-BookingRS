import java.util.Scanner;

public class formLogin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        // variable
        int mainChoice, usiaPasien, potonganBpjs, harga, hargaAkhir;
        String noKtp[] = new String[100], noBpjs[] = new String[100], KeluhanPasien[] = new String[100],
                namaPasien[] = new String[100], noKartu[] = new String[100], usernameadmn[] = { "admin1", "admin2" },
                pass[] = { "adminsatuu", "admindua" }, alamatPasien[] = new String[100], noTelp[] = new String[100],
                noKartuTransaksi[] = new String[100];
        char statusbpjs, pembayaran, status;
        boolean isLoggedin = false;
        while (isLoggedin == false) {
            System.out.println("===============================================");
            System.out.println("| Selamat datang di Sistem Reservasi Klinik    |");
            System.out.println("===============================================");
            System.out.println("| 1. Admin                                     |");
            System.out.println("| 2. Keluar                                    |");
            System.out.println("===============================================");
            System.out.print("Pilih tipe pengguna: ");
            mainChoice = input.nextInt();
            if (mainChoice == 1) {
                System.out.print("Masukkan username admin: ");
                String inputUsername = input.next();
                System.out.print("Masukkan password admin: ");
                String inputPass = input.next();
                if ((inputUsername.equals(usernameadmn[0]) && inputPass.equals(pass[0]))
                        || (inputUsername.equals(usernameadmn[1]) && inputPass.equals(pass[1]))) {
                    int adminChoice;
                    System.out.println("Login berhasil.");
                    boolean isNewData = false;
                    while (isNewData == false) {
                        System.out.println("==========================================================");
                        System.out
                                .println("|    Selamat datang " + inputUsername + " di Sistem Reservasi Klinik      |");
                        System.out.println("==========================================================");
                        System.out.println("| 1. Reservasi Baru                                       |");
                        System.out.println("| 2. Lihat History Reservasi                              |");
                        System.out.println("| 3. Sewa Kamar                                           |");
                        System.out.println("| 4. Lihat Daftar Kamar                                   |");
                        System.out.println("| 5. Rujuk Pasien                                         |");
                        System.out.println("| 6. Keluar                                               |");
                        System.out.println("==========================================================");
                        isLoggedin = true;
                        System.out.print("Pilih menu: ");
                        adminChoice = input.nextInt();

                        if (adminChoice == 1) {
                            // Menu Reservasi Baru
                            for (int i = 0; i < noKartu.length; i++) {
                                System.out.println("Anda memilih menu Reservasi Baru.");
                                System.out.println("==========================================================");
                                System.out.println("Selamat Datang Di Klinik X - " + inputUsername);
                                System.out.println("Masukkan Data Pasien");
                                System.out.println("");
                                System.out.println("Apakah pasien memiliki kartu berobat? (0 = tidak, 1 = ya)");
                                status = input.next().charAt(0);

                                if (status == '0') {
                                    for (int j = 0; j <= noKartu.length; j++) {
                                        System.out.println("Silahkan melakukan registrasi di bawah ini :");
                                        System.out.print("No Kartu  : ");
                                        noKartu[j] = sc.nextLine();
                                        System.out.print("Nama      : ");
                                        namaPasien[j] = sc.nextLine();
                                        System.out.print("Alamat    : ");
                                        alamatPasien[j] = sc.nextLine();
                                        System.out.print("No. Telp  : ");
                                        noTelp[j] = sc.nextLine();
                                        // menyimpan data
                                        System.out.println("--------------------------------------------------");
                                        System.out.println("Data berhasil disimpan");
                                        System.out.println("No kartu    : " + noKartu[j]);
                                        System.out.println("Nama        : " + namaPasien[j]);
                                        System.out.println("alamat      : " + alamatPasien[j]);
                                        System.out.println("no telp     : " + noTelp[j]);
                                        System.out.println("--------------------------------------------------");
                                        break;
                                    }
                                } else {
                                    System.out.println("pasien sudah memiliki kartu berobat");
                                    System.out.print("No Kartu                   :");
                                    noKartuTransaksi[i] = sc.nextLine();
                                    // lanjut ke form transaksi
                                }

                                // penambahan fitur pasien BPJS
                                System.out.println("Apakah pasien memiliki kartu BPJS (0 = ya, 1 = tidak)? ");
                                statusbpjs = input.next().charAt(0);

                                if (statusbpjs == '0') {
                                    System.out.print("Masukkan No.BPJS pasien     : ");
                                    noBpjs[i] = sc.nextLine();
                                    potonganBpjs = 100;
                                } else {
                                    potonganBpjs = 0;
                                }
                                System.out.print("Nama                        : ");
                                namaPasien[i] = sc1.nextLine();

                                // usia menggunakan ifelse menentukan biaya konsultasi atau berobat
                                System.out.print("Usia                        : ");
                                usiaPasien = input.nextInt();
                                // if (usiaPasien <= 17) {
                                // kategoriPasien = "A-Anak";
                                // harga = 5000;
                                // } else {
                                // kategoriPasien = "D-Dewasa";
                                // harga = 10000;
                                // }

                                System.out.print("Keluhan                     : ");
                                KeluhanPasien[i] = sc1.nextLine();
                                boolean isDokter = false;
                                do {
                                    System.out.println("==============Daftar Dokter=============");
                                    System.out.println("| 1. Dokter Umum                        |");
                                    System.out.println("| 2. Dokter Gigi                        |");
                                    System.out.println("| 3. Bidan                              |");
                                    System.out.println("| 4. perawat                            |");
                                    System.out.println("| 5. petugas lab                        |");
                                    System.out.println("| 6. tenaga gizi                        |");
                                    System.out.println("Pilih nomor dokter yang dibutuhkan pasien : ");
                                    int pemilihan = sc.nextInt();

                                    switch (pemilihan) {
                                        case 1:
                                            System.out.println("Dokter Umum - Konsultansi " + KeluhanPasien[i]);
                                            isDokter = true;
                                            break;
                                        case 2:
                                            System.out.println("Dokter Gigi - Konsultansi " + KeluhanPasien[i]);
                                            isDokter = true;
                                            break;
                                        case 3:
                                            System.out.println("Bidan - Konsultansi " + KeluhanPasien[i]);
                                            isDokter = true;
                                            break;
                                        case 4:
                                            System.out.println("Perawat - Konsultansi " + KeluhanPasien[i]);
                                            isDokter = true;
                                            break;
                                        case 5:
                                            System.out.println("Petugas Lab - Konsultansi " + KeluhanPasien[i]);
                                            isDokter = true;
                                            break;
                                        case 6:
                                            System.out.println("Tenaga Gizi - Konsultansi " + KeluhanPasien[i]);
                                            isDokter = true;
                                            break;

                                        default:
                                            System.out.println("Inputan tidak valid!");
                                            isDokter = false;
                                            break;
                                    }
                                } while (!isDokter);
                                System.out.println("--------------------------------------------------");

                                // potongan BPJS pada klinik 100%
                                System.out.println("Potongan BPJS(%)              :     " + potonganBpjs);
                                // harga di tentukan sesuai kategori usia pasien
                                System.out.print("Harga                         : Rp. ");
                                harga = sc.nextInt();

                                // memproses perhitungan pembayaran
                                hargaAkhir = harga - (harga * potonganBpjs / 100);
                                System.out.println("--------------------------------------------------");
                                System.out.println("Harga Akhir                     : Rp. " + hargaAkhir);

                                // pembayaran debit atau tunai by fauzi
                                System.out.println("Metode pembayaran menggunakan(1 = debit, 2 = tunai)? ");
                                pembayaran = sc.next().charAt(0);
                                if (hargaAkhir == 0) {
                                    System.out.println("Pembayaran Gratis");
                                } else {
                                    if (pembayaran == '1') {
                                        System.out.print("Masukan pin kartu debit:");
                                        noKartu[i] = input.nextLine();
                                        System.out.println("Pembayaran menggunakan Debit - Lunas");
                                        break;
                                    } else {
                                        System.out.println("Pembayaran menggunakan uang tunai - Lunas");
                                        break;
                                    }
                                }
                            }
                            isNewData = false;

                        } else if (adminChoice == 2) {
                            // Menu Lihat Jadwal Reservasi
                            System.out.println("Anda memilih menu Lihat History Reservasi.");
                            // Tambahkan kode untuk melihat jadwal reservasi
                        } else if (adminChoice == 6) {
                            // Keluar dari akun admin
                            System.out.println("Anda telah keluar dari akun " + usernameadmn[0]);
                            isLoggedin = false;
                            isNewData = true;
                        } else {
                            // Jika input tidak valid
                            isLoggedin = false;
                            System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
                        }
                    }
                } else {
                    // Jika login gagal
                    System.out.println("Login gagal. Username atau password salah.");
                    isLoggedin = false;
                }
            } else if (mainChoice == 2) {
                // Keluar dari program
                System.out.println("Terima kasih! Program selesai.");
                break;
            } else {
                // Jika input tidak valid
                System.out.println("Pilihan tidak valid. Silakan pilih tipe pengguna yang benar.");
            }
        }
    }
}

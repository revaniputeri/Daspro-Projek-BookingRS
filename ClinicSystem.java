import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicSystem {
    static Scanner input = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    static Scanner sc1 = new Scanner(System.in);
    static String registrasiPasien[][] = new String[5][30],
            transaksiPasien[][] = new String[7][30],
            transaksiRujukPasien[][] = new String[5][30],
            transaksiSewaKamar[][] = new String[4][30],
            usernameAdmin[] = { "admin1", "admin2" },
            passwordAdmin[] = { "adminsatuu", "admindua" },
            daftarRs[] = { "RS-Panti Nirmala", "RS-Islam Aisyiyah", "RS-UD Saiful Anwar" },
            daftarDokter[] = { "Dokter Umum", "Dokter Gigi", "Bidan" },
            key = "",
            inputUsername,
            inputPassword;
    static int transaksiPasien2[][] = new int[4][30],
            transaksiSewaKamar2[][] = new int[6][20],
            mainChoice,
            potonganBpjs,
            jumlahTransaksi = 0,
            jumlahTransaksiSewa = 0,
            jumlahTransaksiRujuk = 0,
            jumlahPasien = 0,
            statusRs,
            statusKm,
            hargaKamar = 100_000,
            hasil = 0,
            usiaPasienRujuk[] = new int[30],
            idOtomatis = 11;
    static char statusbpjs,
            pembayaran,
            status;
    static boolean isLoggedin = false,
            statusKamar[] = { true, true, true, true, true };
    static LocalDate[] transactionDates = new LocalDate[30];

    public static void main(String[] args) {
        while (true) {
            System.out.println("==========================================================================");
            System.out.println("| Selamat datang di Sistem Reservasi Klinik                              |");
            System.out.println("==========================================================================");
            System.out.println("| 1. Admin                                                               |");
            System.out.println("| 2. Keluar                                                              |");
            System.out.println("==========================================================================");
            System.out.print("Pilih tipe pengguna (1-2): ");
            int mainChoice = input.nextInt();
            input.nextLine();

            if (mainChoice == 1) {
                boolean isLoggedIn = adminLogin();
                if (isLoggedIn) {
                    handleAdminTasks();
                }
            } else if (mainChoice == 2) {
                System.out.println("Terima kasih! Program selesai.");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static boolean adminLogin() {
        System.out.println("==========================================================================");
        System.out.print("Masukkan username admin: ");
        inputUsername = input.nextLine();
        System.out.print("Masukkan password admin: ");
        String inputPassword = input.nextLine();
        System.out.println("==========================================================================");

        for (int i = 0; i < usernameAdmin.length; i++) {
            if (inputUsername.equals(usernameAdmin[i]) && inputPassword.equals(passwordAdmin[i])) {
                System.out.println("LOGIN BERHASIL!");
                return true;
            }
        }
        System.out.println("Login gagal. Username atau password salah.");
        return false;
    }

    static void handleAdminTasks() {
        while (true) {
            System.out.println("==========================================================================");
            System.out.println("| Selamat datang di menu admin                                           |");
            System.out.println("==========================================================================");
            System.out.println("| 1. Registrasi Pasien Baru                                              |");
            System.out.println("| 2. Transaksi Berobat                                                   |");
            System.out.println("| 3. Transaksi Sewa Kamar                                                |");
            System.out.println("| 4. Transaksi Rujuk Pasien                                              |");
            System.out.println("| 5. Daftar Kamar                                                        |");
            System.out.println("| 6. Daftar Pasien                                                       |");
            System.out.println("| 7. History Transaksi Berobat                                           |");
            System.out.println("| 8. Cetak Laporan Transaksi Berobat                                     |");
            System.out.println("| 9. Keluar                                                              |");
            System.out.println("==========================================================================");
            System.out.print("Pilih menu (1-9): ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    registrasiPasienBaru();
                    break;
                case 2:
                    transaksiBerobat();
                    break;
                case 3:
                    transaksiSewaKamar();
                    break;
                case 4:
                    transaksiRujukPasien();
                    break;
                case 5:
                    daftarKamar();
                    break;
                case 6:
                    dataMasterPasien();
                    break;
                case 7:
                    historyTransaksiBerobat();
                    break;
                case 8:
                    System.out.println("Pilih Jenis Laporan: ");
                    System.out.println("1. Laporan Harian");
                    System.out.println("2. Laporan Bulanan");
                    System.out.print("Masukkan Pilihan (1/2): ");
                    int pilihLaporan = input.nextInt();
                    if (pilihLaporan == 1) {
                        cetakLaporanHarian();
                    } else if (pilihLaporan == 2) {
                        cetakLaporanBulanan();
                    } else {
                        System.out.println("Inputan Tidak Valid");
                    }
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    static void registrasiPasienBaru() {
        System.out.println("");
        System.out.println("");
        System.out.println("KLINIK X - REGISTRASI PASIEN");
        if (jumlahPasien >= registrasiPasien[0].length) {
            return;
        }
        String noKartu = "P" + String.format("%04d", idOtomatis);
        System.out.println("==========================================================================");
        System.out.println("No Kartu  : " + noKartu);
        registrasiPasien[0][jumlahPasien] = noKartu;
        System.out.print("Nama      : ");
        registrasiPasien[1][jumlahPasien] = sc1.nextLine();
        System.out.print("No KTP    : ");
        registrasiPasien[2][jumlahPasien] = sc1.nextLine();
        System.out.print("Alamat    : ");
        registrasiPasien[3][jumlahPasien] = sc1.nextLine();
        System.out.print("No. Telp  : ");
        registrasiPasien[4][jumlahPasien] = sc1.nextLine();
        System.out.println("--------------------------------------------------");
        System.out.println("DATA BERHASIL DISIMPAN!");
        System.out.println("No kartu    : " + registrasiPasien[0][jumlahPasien]);
        System.out.println("Nama        : " + registrasiPasien[1][jumlahPasien]);
        System.out.println("No KTP      : " + registrasiPasien[2][jumlahPasien]);
        System.out.println("Alamat      : " + registrasiPasien[3][jumlahPasien]);
        System.out.println("No. Telp    : " + registrasiPasien[4][jumlahPasien]);
        System.out.println(
                "==========================================================================");
        jumlahPasien++;
    }

    static void transaksiBerobat() {
        for (int i = 0; i < transaksiPasien.length; i++) {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = currentDate.format(formatter);
            transactionDates[jumlahTransaksi] = currentDate;
            System.out.println("");
            System.out.println("");
            System.out.println("KLINIK X - TRANSAKSI BEROBAT");
            System.out.println("==========================================================================");
            System.out.println("ADMIN   : " + inputUsername);
            System.out.println("Tgl     : " + formattedDate);
            System.out.println("");
            System.out.println("Apakah pasien memiliki kartu berobat? (0 = tidak, 1 = ya)");
            status = input.next().charAt(0);

            if (status == '0') {
                System.out.println("Silahkan lakukan registrasi pasien baru");
                registrasiPasienBaru();
            } else {
                System.out.println("Masukkan No. Kartu pasien");
                System.out.print("No Kartu                   :");
                transaksiPasien[0][jumlahTransaksi] = sc1.nextLine();
                // lanjut ke form transaksi
            }

            // penambahan fitur pasien BPJS
            System.out.println("Apakah pasien memiliki kartu BPJS (0 = tidak, 1 = ya)? ");
            statusbpjs = input.next().charAt(0);

            if (statusbpjs == '0') {
                transaksiPasien2[3][jumlahTransaksi] = 0;
                transaksiPasien[1][jumlahTransaksi] = "-";
            } else {
                System.out.print("Masukkan No.BPJS pasien     : ");
                transaksiPasien[1][jumlahTransaksi] = sc1.nextLine();
                transaksiPasien2[3][jumlahTransaksi] = 100;
            }
            System.out.println("Nama                        : " + registrasiPasien[1][i]);
            transaksiPasien[2][jumlahTransaksi] = registrasiPasien[1][i];

            // usia menggunakan ifelse menentukan biaya konsultasi atau berobat
            System.out.print("Usia                        : ");
            transaksiPasien2[0][jumlahTransaksi] = input.nextInt();
            System.out.print("Keluhan                     : ");
            transaksiPasien[3][jumlahTransaksi] = sc1.nextLine();
            boolean isDokter = false;
            // looping do-while untuk menampilkan daftar dokter dan validasi
            do {
                System.out.println("==========================================================================");
                System.out.println("| No. |   Daftar Dokter                                                   |");
                System.out.println("==========================================================================");
                for (int j = 0; j < daftarDokter.length; j++) {
                    System.out.printf("| %-3d | %-65s |%n", (j + 1), daftarDokter[j]);
                }
                System.out.println("==========================================================================");
                System.out.println("Pilih nomor dokter yang dibutuhkan pasien (1 - 6): ");
                int pemilihan = sc.nextInt();

                if (pemilihan >= 1 && pemilihan <= daftarDokter.length) {
                    String dokterPilihan = daftarDokter[pemilihan - 1];
                    System.out.println("Anda telah memilih dokter   : " + dokterPilihan);
                    transaksiPasien[6][jumlahTransaksi] = dokterPilihan;
                    System.out.println("Dengan Keluhan              : " + transaksiPasien[3][jumlahTransaksi]);
                    isDokter = true;
                    break;
                } else {
                    // User input is not within the valid range
                    System.out.println("Nomor dokter tidak valid. Silakan coba lagi.");
                    continue;
                }
            } while (!isDokter);
            // potongan BPJS pada klinik 100%
            System.out.println("Potongan BPJS(%)            :     " + transaksiPasien2[3][jumlahTransaksi]);
            // harga di tentukan sesuai kategori usia pasien
            System.out.print("Harga                       : Rp. ");
            transaksiPasien2[1][jumlahTransaksi] = sc.nextInt();

            // memproses perhitungan pembayaran
            transaksiPasien2[2][jumlahTransaksi] = transaksiPasien2[1][jumlahTransaksi]
                    - (transaksiPasien2[1][jumlahTransaksi] * transaksiPasien2[3][jumlahTransaksi] / 100);
            System.out.println(
                    "--------------------------------------------------------------------------");
            System.out.println("Harga Akhir                  : Rp. " + transaksiPasien2[2][jumlahTransaksi]);
            if (transaksiPasien2[2][jumlahTransaksi] == 0) {
                System.out.println("Pembayaran Gratis");
                transaksiPasien[5][jumlahTransaksi] = "BPJS";
                System.out.println(
                        "==========================================================================");
                // jumlahTransaksi++;
            } else {

                // pembayaran debit atau tunai by fauzi
                System.out.print("Metode pembayaran menggunakan(1 = debit, 2 = tunai)? ");
                pembayaran = sc.next().charAt(0);
                if (pembayaran == '1') {
                    System.out.print("Masukan No kartu debit:");
                    transaksiPasien[4][jumlahTransaksi] = input.nextLine();
                    transaksiPasien[5][jumlahTransaksi] = "Debit";
                    System.out.println("Pembayaran menggunakan Debit - Lunas");
                } else {
                    transaksiPasien[5][jumlahTransaksi] = "Tunai";
                    transaksiPasien[4][jumlahTransaksi] = "-";
                    System.out.println("Pembayaran menggunakan uang tunai - Lunas");
                }
            }
            System.out.println("==========================================================================");
            System.out.println("|                   Struk Transaksi Berobat ke Klinik X                   |");
            System.out.println("==========================================================================");
            System.out.printf("| %-20s: %-48s |%n", "Tanggal", formattedDate);
            System.out.printf("| %-20s: %-48s |%n", "Metode Pembayaran", transaksiPasien[5][jumlahTransaksi]);
            System.out.printf("| %-20s: %-48s |%n", "Konsultasi", transaksiPasien[6][jumlahTransaksi]);
            System.out.printf("| %-20s: %-48s |%n", "No Kartu Berobat", transaksiPasien[0][jumlahTransaksi]);
            System.out.printf("| %-20s: %-48s |%n", "No BPJS", transaksiPasien[1][jumlahTransaksi]);
            System.out.printf("| %-20s: %-48s |%n", "Nama Pasien", transaksiPasien[2][jumlahTransaksi]);
            System.out.printf("| %-20s: %-48s |%n", "Usia Pasien", transaksiPasien2[0][jumlahTransaksi]);
            System.out.printf("| %-20s: %-48s |%n", "Keluhan Pasien", transaksiPasien[3][jumlahTransaksi]);
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("| %-20s: %-48s |%n", "Potongan BPJS", transaksiPasien2[3][jumlahTransaksi]);
            System.out.printf("| %-20s: %-48s |%n", "Harga", transaksiPasien2[1][jumlahTransaksi]);
            System.out.println("==========================================================================");
            System.out.printf("| %-20s: %-48s |%n", "TOTAL", transaksiPasien2[2][jumlahTransaksi]);
            System.out.println("==========================================================================");
            System.out.println("");
            jumlahTransaksi++;
            handleAdminTasks();
        }
    }

    static void transaksiSewaKamar() {
        for (int j = 0; j < transaksiSewaKamar.length; j++) {
            System.out.println("");
            System.out.println("");
            System.out.println("KLINIK X - TRANSAKSI SEWA KAMAR");
            System.out.println("==========================================================================");
            System.out.printf("| %-10s | %-20s |%n", "No Kamar", "Status");
            System.out.println("==========================================================================");
            for (int i = 0; i < statusKamar.length; i++) {
                System.out.printf("| %-10d | %-20s |%n", (i + 1), (statusKamar[i] ? "Tersedia" : "Tidak Tersedia"));
            }
            System.out.println("==========================================================================");

            boolean isAvailable = false;
            // looping untuk validasi ketersediaan kamar
            while (isAvailable != true) {
                System.out.print("Masukkan nomor kamar yang ingin Anda sewa: ");
                int nomorKamar = sc.nextInt();
                if (nomorKamar > 0 && nomorKamar <= statusKamar.length) {
                    if (statusKamar[nomorKamar - 1]) {
                        statusKamar[nomorKamar - 1] = false;
                        System.out.println("Anda memilih Kamar no " + nomorKamar);
                        transaksiSewaKamar2[0][jumlahTransaksiSewa] = nomorKamar;
                        isAvailable = true;
                        break;
                    }
                } else {
                    System.out.println("Inputan tidak valid");
                    isAvailable = false;
                }
            }
            boolean dataDitemukan = false;
            // looping untuk validasi data pasien ditemukan
            while (!dataDitemukan) {
                // looping untuk mencari index pasien
                for (int i = 0; i < transaksiSewaKamar.length; i++) {
                    System.out.print("No Kartu Pasien             : ");
                    String cariIndex = sc.next();
                    int a = 0;
                    do {
                        if (cariIndex.equalsIgnoreCase(transaksiPasien[0][i])) {
                            hasil = a;

                            System.out.printf("No Kartu Pasien : %s%n", transaksiPasien[0][hasil]);
                            transaksiSewaKamar[0][jumlahTransaksiSewa] = transaksiPasien[0][hasil];
                            System.out.printf("Nama Pasien     : %s%n", transaksiPasien[2][hasil]);
                            transaksiSewaKamar[1][jumlahTransaksiSewa] = transaksiPasien[2][hasil];
                            System.out.printf("Usia Pasien     : %s%n", transaksiPasien2[0][hasil]);
                            transaksiSewaKamar2[1][jumlahTransaksiSewa] = transaksiPasien2[0][hasil];
                            System.out.printf("Keluhan Pasien  : %s%n", transaksiPasien[3][hasil]);
                            transaksiSewaKamar[2][jumlahTransaksiSewa] = transaksiPasien[3][hasil];
                            dataDitemukan = true;
                            a++;
                            break;
                        } else {
                            dataDitemukan = false;
                        }
                    } while (a < jumlahTransaksiSewa);
                }
                if (!dataDitemukan) {
                    System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                    dataDitemukan = false;
                    continue;
                }
                System.out.println("Apakah pasien memiliki kartu BPJS (0 = tidak, 1 = ya)? ");
                statusbpjs = input.next().charAt(0);

                if (statusbpjs == '0') {
                    transaksiSewaKamar[3][jumlahTransaksiSewa] = "-";
                    transaksiSewaKamar2[5][jumlahTransaksiSewa] = 0;
                } else {
                    System.out.print("Masukkan No.BPJS pasien     : ");
                    transaksiPasien[1][jumlahTransaksiSewa] = sc1.nextLine();
                    transaksiSewaKamar2[5][jumlahTransaksiSewa] = 100;
                }
                System.out.print("Masukkan lama menginap (hari) : ");
                transaksiSewaKamar2[2][jumlahTransaksiSewa] = sc.nextInt();
                System.out.println("Harga kamar/malam           : " + hargaKamar);
                transaksiSewaKamar2[3][jumlahTransaksiSewa] = hargaKamar;
                transaksiSewaKamar2[4][jumlahTransaksiSewa] = (hargaKamar
                        * transaksiSewaKamar2[2][jumlahTransaksiSewa])
                        - ((hargaKamar
                                * transaksiSewaKamar2[2][jumlahTransaksiSewa])
                                * transaksiSewaKamar2[5][jumlahTransaksiSewa] / 100);
                System.out.println("Total Sewa Kamar            : "
                        + transaksiSewaKamar2[4][jumlahTransaksiSewa]);

                System.out.println("==========================================================================");
                System.out.println("                        Struk Transaksi - Sewa Kamar                      ");
                System.out.println("==========================================================================");
                System.out.printf("No Kartu Berobat    : %s%n", transaksiSewaKamar[0][jumlahTransaksiSewa]);
                System.out.printf("Nama Pasien         : %s%n", transaksiSewaKamar[1][jumlahTransaksiSewa]);
                System.out.printf("Usia Pasien         : %s%n", transaksiSewaKamar2[1][jumlahTransaksiSewa]);
                System.out.printf("Keluhan Pasien      : %s%n", transaksiSewaKamar[2][jumlahTransaksiSewa]);
                System.out.printf("No Kamar yang disewa: %s%n", transaksiSewaKamar2[0][jumlahTransaksiSewa]);
                System.out.printf("Lama sewa kamar     : %s%n", transaksiSewaKamar2[2][jumlahTransaksiSewa]);
                System.out.printf("Harga sewa/malam    : Rp. %s%n", transaksiSewaKamar2[3][jumlahTransaksiSewa]);
                System.out.printf("Total Harga Sewa    : Rp. %s%n", transaksiSewaKamar2[4][jumlahTransaksiSewa]);
                System.out.println("==========================================================================");
                jumlahTransaksiSewa++;
            }
        }
    }

    static void transaksiRujukPasien() {
        boolean dataDitemukan = false;
        System.out.println("");
        System.out.println("");
        System.out.println("KLINIK X - TRANSAKSI RUJUK PASIEN");
        System.out.println("==========================================================================");

        for (int i = 0; i < daftarRs.length; i++) {
            System.out.println((i + 1) + ". " + daftarRs[i]);
        }

        boolean isValid = false;
        // Looping untuk validasi inputan RS Rujukan
        int selectedRsIndex = 0;
        while (isValid != true) {
            System.out.println("==========================================================================");
            System.out.print("Masukkan nomor (1 - " + daftarRs.length + ") (0 for exit): ");
            selectedRsIndex = sc.nextInt();
            System.out.println("");
            if (selectedRsIndex == 0) {
                dataDitemukan = true;
                break;
            }
            if (selectedRsIndex >= 1 && selectedRsIndex <= daftarRs.length) {
                statusRs = selectedRsIndex - 1; // Mengonversi nomor RS ke indeks dalam array
                System.out.println("Anda telah memilih " + daftarRs[statusRs]);
                transaksiRujukPasien[0][jumlahTransaksiRujuk] = daftarRs[statusRs];
                isValid = true;
                break;
            } else {
                System.out.println("data tidak valid");
                isValid = false;
                continue;
            }
        }

        while (!dataDitemukan) {
            System.out.print("No Kartu Pasien (0 for exit): ");
            String cariIndex = sc.next();
            System.out.println("-------------------------------------------");
            int a = 0;
            // Looping untuk validasi data pasien yang ingin dirujuk ditemukan
            for (int i = 0; i < transaksiRujukPasien.length; i++) {
                if (cariIndex.equalsIgnoreCase(transaksiPasien[0][i])) {
                    hasil = a;
                    System.out.println(
                            "No Kartu Pasien             : " + transaksiPasien[0][hasil]);
                    transaksiRujukPasien[1][jumlahTransaksiSewa] = transaksiPasien[0][hasil];
                    System.out.println(
                            "Nama Pasien                 : " + transaksiPasien[2][hasil]);
                    transaksiRujukPasien[2][jumlahTransaksiSewa] = transaksiPasien[2][hasil];
                    System.out
                            .println("Usia Pasien                 : "
                                    + transaksiPasien2[0][hasil]);
                    usiaPasienRujuk[jumlahTransaksiSewa] = transaksiPasien2[0][hasil];
                    dataDitemukan = true;
                    a++;
                } else if (cariIndex.equalsIgnoreCase("0")) {
                    dataDitemukan = true;
                    break;
                } else {
                    dataDitemukan = false;
                }
            }
            if (!dataDitemukan) {
                System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                dataDitemukan = false;
                continue;
            } else if (cariIndex.equalsIgnoreCase("0")) {
                break;
            }

            System.out.println("Apakah pasien memiliki kartu BPJS (0 = tidak, 1 = ya)? ");
            statusbpjs = input.next().charAt(0);

            if (statusbpjs == '0') {
                transaksiRujukPasien[3][jumlahTransaksi] = "-";
            } else {
                System.out.print("Masukkan No.BPJS pasien     : ");
                transaksiRujukPasien[3][jumlahTransaksi] = sc1.nextLine();
            }

            System.out.print("Alasan Rujuk                :");
            transaksiRujukPasien[4][jumlahTransaksiRujuk] = sc1.nextLine();
            System.out.println("==========================================================================");
            System.out.println("                       Struk Transaksi - Rujuk Pasien                     ");
            System.out.println("==========================================================================");
            System.out.printf("RS Rujukan          : %s%n", transaksiRujukPasien[0][jumlahTransaksiRujuk]);
            System.out.printf("No Kartu Berobat    : %s%n", transaksiRujukPasien[1][jumlahTransaksiRujuk]);
            System.out.printf("No BPJS             : %s%n", transaksiRujukPasien[3][jumlahTransaksiRujuk]);
            System.out.printf("Nama Pasien         : %s%n", transaksiRujukPasien[2][jumlahTransaksiRujuk]);
            System.out.printf("Usia Pasien         : %s%n", usiaPasienRujuk[jumlahTransaksiRujuk]);
            System.out.printf("Alasan Rujuk        : %s%n", transaksiRujukPasien[4][jumlahTransaksiRujuk]);
            System.out.println("==========================================================================");
            System.out.println("Transaksi Selesai - Status Pending");
            System.out.println("");

            jumlahTransaksiRujuk++;
        }
    }

    static void daftarKamar() {
        System.out.println("");
        System.out.println("");
        System.out.println("KLINIK X - DATA DAFTAR KAMAR");
        System.out.println("==========================================================================");
        // looping untuk menampilkan daftar kamar
        for (int i = 0; i < statusKamar.length; i++) {
            System.out.println("Kamar no " + (i + 1) + ": "
                    + (statusKamar[i] ? "Tersedia" : "Tidak Tersedia"));
        }
        System.out.println("==========================================================================");
    }

    static void dataMasterPasien() {
        System.out.println("");
        System.out.println("");
        System.out.println("KLINIK X - DATA MASTER PASIEN");
        System.out.println("========================================================================================================================================");
        System.out.println("| No Kartu                 | Nama                     | No KTP                   | Alamat                   | No. Telp                 |");
        System.out.println("========================================================================================================================================");

        if (jumlahPasien == 0) {
            System.out.println("Belum ada data master pasien");
        } else {
            for (int i = 0; i < jumlahPasien; i++) {
                System.out.printf("| %-25s| %-25s| %-25s| %-25s| %-25s|\n",
                        registrasiPasien[0][i],
                        registrasiPasien[1][i],
                        registrasiPasien[2][i],
                        registrasiPasien[3][i],
                        registrasiPasien[4][i]);
            }
        }
        System.out.println("========================================================================================================================================");
        System.out.println("");
        System.out.println("");
    }

    static void historyTransaksiBerobat() {
        System.out.println("");
        System.out.println("");
        System.out.println("KLINIK X - DATA MASTER PASIEN");
        System.out.println("==========================================================================");
        int j = 0;
        // looping do-while untuk mencetak history transaksi
        do {
            System.out.println("TRANSAKSI KE-" + (j + 1));
            System.out.println("- Metode Pembayaran : " + transaksiPasien[5][j]);
            System.out.println("- Konsultasi        : " + transaksiPasien[6][j]);
            System.out.println("- No Kartu Berobat  : " + transaksiPasien[0][j]);
            System.out.println("- No Kartu BPJS     : " + transaksiPasien[1][j]);
            System.out.println("- Nama Pasien       : " + transaksiPasien[2][j]);
            System.out.println("- Usia Pasien       : " + transaksiPasien2[0][j]);
            System.out.println("- Keluhan Pasien    : " + transaksiPasien[3][j]);
            System.out.println("- Total Biaya       : Rp. " + transaksiPasien2[2][j]);
            System.out.println(
                    "==========================================================================");
            j++;
        } while (j < jumlahTransaksi);

        boolean isValid = false;
        // looping untuk validasi fitur search data pasien berdasarkan noKartu yang
        // dimasukkan
        while (!isValid) {
            System.out.print("Masukkan No Kartu Pasien ('-' for exit): ");
            key = sc1.nextLine();
            if (key.equalsIgnoreCase("-")) {
                break;
            }

            // looping untuk mencari data sesuai key
            for (int i = 0; i < transaksiPasien.length; i++) {
                if (key.equalsIgnoreCase(transaksiPasien[0][i])) {
                    hasil = i;
                    System.out.println(
                            "No Kartu Pasien " + key + " terdapat di index ke-" + hasil);
                    isValid = true;
                    continue;
                }
            }
            if (!isValid) {
                System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                isValid = false;
                continue;
            }
        }
    }

    static void cetakLaporanHarian() {
        System.out.println("");
        System.out.println("");
        System.out.println("KLINIK X - LAPORAN TRANSAKSI HARIAN");

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Print table header
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                "Tanggal Transaksi", "No Kartu Berobat", "No BPJS", "Nama Pasien", "Usia Pasien", "Keluhan Pasien",
                "Metode Pembayaran");
        System.out.println(
                "================================================================================================================================================================");

        for (int i = 0; i < jumlahTransaksi; i++) {
            if (transactionDates[i].equals(today)) {
                // Print table rows
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                        transactionDates[i].format(formatter),
                        transaksiPasien[0][i], transaksiPasien[1][i], transaksiPasien[2][i],
                        transaksiPasien2[0][i], transaksiPasien[3][i], transaksiPasien[5][i]);
            }
        }

        // Print table footer
        System.out.println(
                "================================================================================================================================================================");
    }

    static void cetakLaporanBulanan() {
        System.out.println("");
        System.out.println("");
        System.out.println("KLINIK X - LAPORAN TRANSAKSI BULANAN");

        System.out.print("Masukkan bulan (1-12): ");
        int selectedMonth = input.nextInt();
        System.out.println(
                "================================================================================================================================================================");

        LocalDate thisMonth = LocalDate.now().withMonth(selectedMonth).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                "Tanggal Transaksi", "No Kartu Berobat", "No BPJS", "Nama Pasien", "Usia Pasien", "Keluhan Pasien",
                "Metode Pembayaran");
        System.out.println(
                "================================================================================================================================================================");

        for (int i = 0; i < jumlahTransaksi; i++) {
            if (transactionDates[i].getMonth().equals(thisMonth.getMonth())) {
                // Print table rows
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                        transactionDates[i].format(formatter),
                        transaksiPasien[0][i], transaksiPasien[1][i], transaksiPasien[2][i],
                        transaksiPasien2[0][i], transaksiPasien[3][i], transaksiPasien[5][i]);
            } else {
                System.out.println("Tidak ada transaksi");
            }
        }
        // Print table footer
        System.out.println(
                "================================================================================================================================================================");
    }
}
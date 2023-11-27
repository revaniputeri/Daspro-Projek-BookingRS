import java.util.Scanner;

public class formLogin {
    static Scanner input = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    static Scanner sc1 = new Scanner(System.in);

    static void registrasiPasien(String[][] registrasiPasien, String[][] transaksiPasien, int jumlahTransaksi) {
        // melakukan looping untuk melakukan registrasi
        for (int j = 0; j <= registrasiPasien.length; j++) {
            System.out.println(
                    "==========================================================================");
            System.out.println("Silahkan melakukan registrasi di bawah ini :");
            System.out.print("No Kartu  : ");
            registrasiPasien[0][j] = sc1.nextLine();
            transaksiPasien[0][jumlahTransaksi] = registrasiPasien[0][j];
            System.out.print("Nama      : ");
            registrasiPasien[1][j] = sc1.nextLine();
            System.out.print("No KTP    : ");
            registrasiPasien[2][j] = sc1.nextLine();
            System.out.print("Alamat    : ");
            registrasiPasien[3][j] = sc1.nextLine();
            System.out.print("No. Telp  : ");
            registrasiPasien[4][j] = sc1.nextLine();
            // menyimpan data
            System.out.println("--------------------------------------------------");
            System.out.println("DATA BERHASIL DISIMPAN!");
            System.out.println("No kartu    : " + registrasiPasien[0][j]);
            System.out.println("Nama        : " + registrasiPasien[1][j]);
            System.out.println("No KTP      : " + registrasiPasien[2][j]);
            System.out.println("Alamat      : " + registrasiPasien[3][j]);
            System.out.println("No. Telp    : " + registrasiPasien[4][j]);
            System.out.println(
                    "==========================================================================");
            break;
        }
    }

    static void daftarTransaksi(String transaksiPasien[][], int transaksiPasien2[][], int jumlahTransaksi, String key, int hasil) {
        int j = 0;
        // looping do-while untuk mencetak history transaksi
        do {
            System.out.println("TRANSAKSI KE-" + (j + 1));
            System.out.println("- No Kartu Berobat  : " + transaksiPasien[0][j]);
            System.out.println("- No Kartu BPJS     : " + transaksiPasien[1][j]);
            System.out.println("- Nama Pasien       : " + transaksiPasien[2][j]);
            System.out.println("- Usia Pasien       : " + transaksiPasien2[0][j]);
            System.out.println("- Keluhan Pasien    : " + transaksiPasien[3][j]);
            System.out.println("- Total Biaya       : " + transaksiPasien2[2][j]);
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
                    isValid = false;
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

    public static void main(String[] args) {

        // variable
        int transaksiPasien2[][] = new int[3][20],
                transaksiSewaKamar2[][] = new int[5][20],
                mainChoice,
                potonganBpjs,
                jumlahTransaksi = 0,
                jumlahTransaksiSewa = 0,
                grandTotal[] = new int[100],
                jumlahPasien = 0,
                statusRs,
                statusKm,
                hargaKamar = 100_000,
                hasil = 0,
                usiaPasienRujuk[] = new int[30];
        String registrasiPasien[][] = new String[5][30],
                transaksiPasien[][] = new String[5][30],
                transaksiRujukPasien[][] = new String[5][30],
                transaksiSewaKamar[][] = new String[4][30],
                usernameadmn[] = { "admin1", "admin2" },
                pass[] = { "adminsatuu", "admindua" },
                daftarRs[] = { "RS-Panti Nirmala", "RS-Islam Aisyiyah", "RS-UD Saiful Anwar" },
                key = "";
        char statusbpjs,
                pembayaran,
                status;
        boolean isLoggedin = false,
                statusKamar[] = { true, true, true, true, true };
        // melakukan looping untuk menampilkan menu pilihan
        while (isLoggedin == false) {
            System.out.println("==========================================================================");
            System.out.println("|               Selamat datang di Sistem Reservasi Klinik                |");
            System.out.println("==========================================================================");
            System.out.println("| 1. Admin                                                               |");
            System.out.println("| 2. Keluar                                                              |");
            System.out.println("==========================================================================");
            System.out.print("Pilih tipe pengguna (1 - 2): ");
            mainChoice = input.nextInt();
            if (mainChoice == 1) {
                System.out.println("==========================================================");
                System.out.print("Masukkan username admin: ");
                String inputUsername = input.next();
                System.out.print("Masukkan password admin: ");
                String inputPass = input.next();
                System.out.println("==========================================================");
                if ((inputUsername.equals(usernameadmn[0]) && inputPass.equals(pass[0]))
                        || (inputUsername.equals(usernameadmn[1]) && inputPass.equals(pass[1]))) {
                    int adminChoice;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("LOGIN BERHASIL!");
                    boolean isNewData = false;

                    // melakukan looping untuk menampulkan menu awal
                    while (isNewData == false) {
                        System.out
                                .println("==========================================================================");
                        System.out
                                .println("|    Selamat datang " + inputUsername
                                        + " di Sistem Reservasi Klinik                     |");
                        System.out
                                .println("==========================================================================");
                        System.out
                                .println("| 1. Transaksi Baru                                                       |");
                        System.out
                                .println("| 2. Lihat History Reservasi                                              |");
                        System.out
                                .println("| 3. Sewa Kamar                                                           |");
                        System.out
                                .println("| 4. Lihat Daftar Kamar                                                   |");
                        System.out
                                .println("| 5. Rujuk Pasien                                                         |");
                        System.out
                                .println("| 6. Keluar                                                               |");
                        System.out
                                .println("==========================================================================");
                        isLoggedin = true;
                        System.out.print("Pilih Menu (1 - 6): ");
                        adminChoice = input.nextInt();

                        if (adminChoice == 1) {
                            // Menu Reservasi Baru
                            System.out.println("");
                            System.out.println("");
                            // melakukan looping untuk transaksi baru
                            for (int i = 0; i < transaksiPasien.length; i++) {
                                System.out.println(
                                        "==========================================================================");
                                System.out.println("Anda memilih menu Transaksi Baru.");
                                System.out.println(
                                        "==========================================================================");
                                System.out.println("Selamat Datang Di Klinik X - " + inputUsername);
                                System.out.println("Masukkan Data Pasien");
                                System.out.println("");
                                System.out.println("Apakah pasien memiliki kartu berobat? (0 = tidak, 1 = ya)");
                                status = input.next().charAt(0);

                                if (status == '0') {
                                    // memanggil fungsi untuk registrasi pasien
                                    registrasiPasien(registrasiPasien, transaksiPasien, jumlahTransaksiSewa);

                                    // increment jumlah pasien
                                    jumlahPasien++;
                                } else {
                                    System.out.println("PASIEN SUDAH MEMILIKI KARTU BEROBAT");
                                    System.out.print("No Kartu                   :");
                                    transaksiPasien[0][jumlahTransaksi] = sc1.nextLine();
                                    // lanjut ke form transaksi
                                }

                                // penambahan fitur pasien BPJS
                                System.out.println("Apakah pasien memiliki kartu BPJS (0 = ya, 1 = tidak)? ");
                                statusbpjs = input.next().charAt(0);

                                if (statusbpjs == '0') {
                                    System.out.print("Masukkan No.BPJS pasien     : ");
                                    transaksiPasien[1][jumlahTransaksi] = sc1.nextLine();
                                    potonganBpjs = 100;
                                } else {
                                    potonganBpjs = 0;
                                }
                                System.out.print("Nama                        : ");
                                transaksiPasien[2][jumlahTransaksi] = sc1.nextLine();

                                // usia menggunakan ifelse menentukan biaya konsultasi atau berobat
                                System.out.print("Usia                        : ");
                                transaksiPasien2[0][jumlahTransaksi] = input.nextInt();
                                System.out.print("Keluhan                     : ");
                                transaksiPasien[3][jumlahTransaksi] = sc1.nextLine();
                                boolean isDokter = false;
                                // looping do-while untuk menampilkan daftar dokter dan validasi
                                do {

                                    System.out.println(
                                            "==========================================================================");
                                    System.out.println(
                                            "|                        Daftar Dokter di Klinik                         |");
                                    System.out.println(
                                            "==========================================================================");
                                    System.out.println(
                                            "| 1. Dokter Umum                                                         |");
                                    System.out.println(
                                            "| 2. Dokter Gigi                                                         |");
                                    System.out.println(
                                            "| 2. Bidan                                                               |");
                                    System.out.println(
                                            "| 2. Perawat                                                             |");
                                    System.out.println(
                                            "| 2. Petugas LAB                                                         |");
                                    System.out.println(
                                            "| 2. Tenaga Gizi                                                         |");
                                    System.out.println(
                                            "==========================================================================");
                                    System.out.println("Pilih nomor dokter yang dibutuhkan pasien (1 - 6): ");
                                    int pemilihan = sc.nextInt();

                                    switch (pemilihan) {
                                        case 1:
                                            System.out.println("Dokter Umum - Konsultansi " + transaksiPasien[3][i]);
                                            isDokter = true;
                                            break;
                                        case 2:
                                            System.out.println("Dokter Gigi - Konsultansi " + transaksiPasien[3][i]);
                                            isDokter = true;
                                            break;
                                        case 3:
                                            System.out.println("Bidan - Konsultansi " + transaksiPasien[3][i]);
                                            isDokter = true;
                                            break;
                                        case 4:
                                            System.out.println("Perawat - Konsultansi " + transaksiPasien[3][i]);
                                            isDokter = true;
                                            break;
                                        case 5:
                                            System.out.println("Petugas Lab - Konsultansi " + transaksiPasien[3][i]);
                                            isDokter = true;
                                            break;
                                        case 6:
                                            System.out.println("Tenaga Gizi - Konsultansi " + transaksiPasien[3][i]);
                                            isDokter = true;
                                            break;

                                        default:
                                            System.out.println("Inputan tidak valid!");
                                            isDokter = false;
                                            break;
                                    }
                                } while (!isDokter);
                                System.out.println(
                                        "==========================================================================");
                                System.out.println(
                                        "|                    Struk Transaksi Berobat ke Klinik                   |");
                                System.out.println(
                                        "==========================================================================");
                                System.out.println("No Kartu Berobat    :" + transaksiPasien[0][jumlahTransaksi]);
                                System.out.println("No BPJS             :" + transaksiPasien[1][jumlahTransaksi]);
                                System.out.println("Nama Pasien         :" + transaksiPasien[2][jumlahTransaksi]);
                                System.out.println("Usia Pasien         :" + transaksiPasien2[0][jumlahTransaksi]);
                                System.out.println("Keluhan Pasien      :" + transaksiPasien[3][jumlahTransaksi]);
                                System.out.println(
                                        "--------------------------------------------------------------------------");
                                // potongan BPJS pada klinik 100%
                                System.out.println("Potongan BPJS(%)    :     " + potonganBpjs);
                                // harga di tentukan sesuai kategori usia pasien
                                System.out.print("Harga               : Rp. ");
                                transaksiPasien2[1][jumlahTransaksi] = sc.nextInt();

                                // memproses perhitungan pembayaran
                                transaksiPasien2[2][jumlahTransaksi] = transaksiPasien2[1][jumlahTransaksi]
                                        - (transaksiPasien2[1][jumlahTransaksi] * potonganBpjs / 100);
                                System.out.println(
                                        "--------------------------------------------------------------------------");
                                System.out.println("Harga Akhir         : Rp. " + transaksiPasien2[2][jumlahTransaksi]);
                                grandTotal[jumlahTransaksi] = transaksiPasien2[2][jumlahTransaksi];
                                if (transaksiPasien2[2][jumlahTransaksi] == 0) {
                                    System.out.println("Pembayaran Gratis");
                                    System.out.println(
                                            "==========================================================================");
                                    jumlahTransaksi++;
                                    break;
                                } else {
                                    jumlahTransaksi++;
                                    // pembayaran debit atau tunai by fauzi
                                    System.out.print("Metode pembayaran menggunakan(1 = debit, 2 = tunai)? ");
                                    pembayaran = sc.next().charAt(0);
                                    if (pembayaran == '1') {
                                        System.out.print("Masukan pin kartu debit:");
                                        transaksiPasien[4][jumlahTransaksi] = input.nextLine();
                                        System.out.println("Pembayaran menggunakan Debit - Lunas");
                                        System.out.println(
                                                "==========================================================================");
                                        break;
                                    } else {
                                        System.out.println("Pembayaran menggunakan uang tunai - Lunas");
                                        System.out.println(
                                                "==========================================================================");
                                        break;
                                    }
                                }
                            }
                            isNewData = false;

                        } else if (adminChoice == 2) {
                            System.out.println("");
                            System.out.println("");
                            // Menu Lihat History Reservasi / transaksi klinik
                            System.out.println(
                                    "==========================================================================");
                            System.out.println("Anda memilih menu Lihat History Transaksi.");
                            System.out.println(
                                    "==========================================================================");
                            if (jumlahTransaksi == 0) {
                                System.out.println("Belum ada transaksi");
                            } else {
                                System.out.println(
                                        "==========================================================================");
                                System.out.println(
                                        "|                           History Transaksi                             |");
                                System.out.println(
                                        "==========================================================================");
                                daftarTransaksi(transaksiPasien, transaksiPasien2, jumlahTransaksi, key, hasil);
                            }
                        } else if (adminChoice == 3) {
                            System.out.println("");
                            System.out.println("");
                            // Menu Sewa Kamar

                            // looping untuk melakukan transaksi sewa kamar
                            for (int j = 0; j < transaksiSewaKamar.length; j++) {
                                System.out.println("==========================================================");
                                System.out.println("Anda memilih menu Sewa Kamar");
                                System.out.println("");
                                System.out.println("=================================");
                                System.out.println("|Daftar Kamar Rawat Inap Klinik X");
                                System.out.println("=================================");

                                // looping untuk menampilkan daftar kamar
                                for (int i = 0; i < statusKamar.length; i++) {
                                    System.out.println("Kamar no " + (i + 1) + ": "
                                            + (statusKamar[i] ? "Tersedia" : "Tidak Tersedia"));
                                }
                                System.out.println("=================================");
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

                                                System.out.println("No Kartu Pasien : " + transaksiPasien[0][hasil]);
                                                transaksiSewaKamar[0][jumlahTransaksiSewa] = transaksiPasien[0][hasil];
                                                System.out.println("Nama Pasien     :" + transaksiPasien[2][hasil]);
                                                transaksiSewaKamar[1][jumlahTransaksiSewa] = transaksiPasien[2][hasil];
                                                System.out.println("Usia Pasien     :" + transaksiPasien2[0][hasil]);
                                                transaksiSewaKamar2[1][jumlahTransaksiSewa] = transaksiPasien2[0][hasil];
                                                System.out.println("Keluhan Pasien  : " + transaksiPasien[3][hasil]);
                                                transaksiSewaKamar[2][jumlahTransaksiSewa] = transaksiPasien[3][hasil];
                                                dataDitemukan = true;
                                                a++;
                                                break;
                                            } else {
                                                dataDitemukan = false;
                                            }
                                        } while (a < jumlahTransaksiSewa);
                                        break;
                                    }
                                    if (!dataDitemukan) {
                                        System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                                        dataDitemukan = false;
                                        continue;
                                    }
                                    System.out.print("Masukkan lama menginap (hari) : ");
                                    transaksiSewaKamar2[2][jumlahTransaksiSewa] = sc.nextInt();
                                    System.out.println("Harga kamar/malam           : " + hargaKamar);
                                    transaksiSewaKamar2[3][jumlahTransaksiSewa] = hargaKamar;
                                    transaksiSewaKamar2[4][jumlahTransaksiSewa] = hargaKamar
                                            * transaksiSewaKamar2[2][jumlahTransaksiSewa];
                                    System.out.println("Total Sewa Kamar            : "
                                            + transaksiSewaKamar2[4][jumlahTransaksiSewa]);

                                    System.out.println("--------------------------------------------------");
                                    System.out.println("         Struk Transaksi - Sewa Kamar             ");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println(
                                            "No Kartu Berobat    :" + transaksiSewaKamar[0][jumlahTransaksiSewa]);
                                    System.out.println(
                                            "Nama Pasien         :" + transaksiSewaKamar[1][jumlahTransaksiSewa]);
                                    System.out.println(
                                            "Usia Pasien         :" + transaksiSewaKamar2[1][jumlahTransaksiSewa]);
                                    System.out.println(
                                            "Keluhan Pasien      :" + transaksiSewaKamar[2][jumlahTransaksiSewa]);
                                    System.out.println(
                                            "No Kamar yang disewa:" + transaksiSewaKamar2[0][jumlahTransaksiSewa]);
                                    System.out.println(
                                            "Lama sewa kamar     :" + transaksiSewaKamar2[2][jumlahTransaksiSewa]);
                                    System.out.println(
                                            "Harga sewa/malam    :" + transaksiSewaKamar2[3][jumlahTransaksiSewa]);
                                    System.out.println(
                                            "Total Harga Sewa    :" + transaksiSewaKamar2[4][jumlahTransaksiSewa]);
                                    System.out.println("--------------------------------------------------");
                                    jumlahTransaksiSewa++;
                                    break;
                                }
                                break;
                            }
                        } else if (adminChoice == 4) {
                            System.out.println("");
                            System.out.println("");
                            // Menu Lihat Daftar kamar
                            System.out.println("==========================================================");
                            System.out.println("Anda memilih menu Lihat Daftar Kamar");
                            int noKamar;
                            System.out.println("");
                            System.out.println("=================================");
                            System.out.println("|Daftar Kamar Rawat Inap Klinik X");
                            System.out.println("=================================");

                            // looping untuk menampilkan daftar kamar
                            for (int i = 0; i < statusKamar.length; i++) {
                                System.out.println("Kamar no " + (i + 1) + ": "
                                        + (statusKamar[i] ? "Tersedia" : "Tidak Tersedia"));
                            }
                            System.out.println("=================================");
                        } else if (adminChoice == 5) {
                            System.out.println("");
                            System.out.println("");
                            int jumlahTransaksiRujuk = 0;
                            // Menu Rujuk Pasien
                            System.out.println("==================================");
                            System.out.println("    Daftar RS Rujukan Klinik X    ");
                            System.out.println("==================================");

                            // looping untuk menampilkan daftar RS rujukan
                            for (int i = 0; i < daftarRs.length; i++) {
                                System.out.println((i + 1) + ". " + daftarRs[i]);
                            }

                            boolean isValid = false;
                            // Looping untuk validasi inputan RS Rujukan
                            while (isValid != true) {
                                System.out.println("==================================");
                                System.out.print("Masukkan nomor (1 - " + daftarRs.length + ") (0 for exit): ");
                                int selectedRsIndex = sc.nextInt();
                                if (selectedRsIndex == 0) {
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
                            boolean dataDitemukan = false;
                            // Looping untuk validasi data pasien yang ingin dirujuk ditemukan
                            while (!dataDitemukan) {
                                // looping untuk mencari index pasien
                                for (int i = 0; i < transaksiRujukPasien.length; i++) {
                                    System.out.print("No Kartu Pasien             : ");
                                    String cariIndex = sc.next();
                                    System.out.println("-------------------------------------------");
                                    int a = 0;
                                    // looping untuk menampilkan data
                                    do {
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
                                            break;
                                        } else {
                                            dataDitemukan = false;
                                        }
                                    } while (a < jumlahTransaksiRujuk);
                                    break;
                                }
                                if (!dataDitemukan) {
                                    System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                                    dataDitemukan = false;
                                    continue;
                                }

                                System.out.print("Apakah pasien memiliki kartu BPJS (0 = ya, 1 = tidak)? ");
                                statusbpjs = sc.next().charAt(0);
                                if (statusbpjs == '0') {
                                    System.out.print("Masukkan no BPJS            : ");
                                    transaksiRujukPasien[3][jumlahTransaksiRujuk] = sc1.nextLine();
                                } else {
                                    transaksiRujukPasien[3][jumlahTransaksiRujuk] = "-";
                                }

                                System.out.print("Alasan Rujuk                :");
                                transaksiRujukPasien[4][jumlahTransaksiRujuk] = sc1.nextLine();
                                System.out.println("--------------------------------------------------");
                                System.out.println("         Struk Transaksi - Rujuk Pasien           ");
                                System.out.println("--------------------------------------------------");
                                System.out.println(
                                        "RS Rujukan          :" + transaksiRujukPasien[0][jumlahTransaksiRujuk]);
                                System.out.println(
                                        "No Kartu Berobat    :" + transaksiRujukPasien[1][jumlahTransaksiRujuk]);
                                System.out.println(
                                        "No BPJS             :" + transaksiRujukPasien[3][jumlahTransaksiRujuk]);
                                System.out.println(
                                        "Nama Pasien         :" + transaksiRujukPasien[2][jumlahTransaksiRujuk]);
                                System.out.println("Usia Pasien         :" + usiaPasienRujuk[jumlahTransaksiRujuk]);
                                System.out.println(
                                        "Alasan Rujuk        :" + transaksiRujukPasien[4][jumlahTransaksiRujuk]);
                                System.out.println("--------------------------------------------------");
                                System.out.println("Transaksi Selesai - Status Pending");
                                jumlahTransaksiRujuk++;
                            }
                        } else if (adminChoice == 6) {
                            System.out.println("");
                            System.out.println("");
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
                    System.out.println("");
                    System.out.println("");
                    // Jika login gagal
                    System.out.println("Login gagal. Username atau password salah.");
                    isLoggedin = false;
                }
            } else if (mainChoice == 2) {
                System.out.println("");
                System.out.println("");
                // Keluar dari program
                System.out.println("Terima kasih! Program selesai.");
                break;
            } else {
                // Jika input tidak valid
                System.out.println("");
                System.out.println("");
                System.out.println("Pilihan tidak valid. Silakan pilih tipe pengguna yang benar.");
            }
        }
    }
}

import java.util.Scanner;

public class formLogin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        // variable
        int transaksiPasien2[][] = new int[3][20],
            mainChoice, usiaPasien[] = new int[100], potonganBpjs, harga[] = new int[100], hargaAkhir,
            jumlahTransaksi = 0, usiaPasienRujuk[] = new int[100],
            grandTotal[] = new int[100], jumlahPasien = 0, statusRs, hasil = 0;
        String registrasiPasien[][] = new String[5][30], 
                transaksiPasien[][] = new String[5][30], 
                transaksiRujukPasien[][] = new String[5][30],
                transaksiSewaKamar[][] = new String[4][30],
                noKtp[] = new String[100], noBpjs[] = new String[100], KeluhanPasien[] = new String[100],
                namaPasien[] = new String[100], noKartu[] = new String[100], usernameadmn[] = { "admin1", "admin2" },
                pass[] = { "adminsatuu", "admindua" }, alamatPasien[] = new String[100], noTelp[] = new String[100],
                noKartuTransaksi[] = new String[100],
                statusKamar[] = { "Penuh", "Tersedia", "Tersedia", "Tersedia", "Penuh" },
                daftarRs[] = { "RS-Panti Nirmala", "RS-Islam Aisyiyah", "RS-UD Saiful Anwar" }, key = "",
                rsRujukan[] = new String[100], noKartuDebit[] = new String[100], noBpjsRujuktemp, noKartuRujuktemp,
                alasanRujuk[] = new String[100], namaPasienRujuk[] = new String[100], noBpjsRujuk[] = new String[100],
                noKartuRujuk[] = new String[100];
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
                        System.out.println("| 1. Transaksi Baru                                       |");
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
                            for (int i = 0; i < transaksiPasien.length; i++) {
                                System.out.println("Anda memilih menu Transaksi Baru.");
                                System.out.println("==========================================================");
                                System.out.println("Selamat Datang Di Klinik X - " + inputUsername);
                                System.out.println("Masukkan Data Pasien");
                                System.out.println("");
                                System.out.println("Apakah pasien memiliki kartu berobat? (0 = tidak, 1 = ya)");
                                status = input.next().charAt(0);

                                if (status == '0') {
                                    for (int j = 0; j <= registrasiPasien.length; j++) {
                                        System.out.println("Silahkan melakukan registrasi di bawah ini :");
                                        System.out.print("No Kartu  : ");
                                        registrasiPasien[0][j] = sc1.nextLine();
                                        // noKartuTransaksi[jumlahTransaksi] = noKartu[j];
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
                                        System.out.println("Data berhasil disimpan");
                                        System.out.println("No kartu    : " + registrasiPasien[0][j]);
                                        System.out.println("Nama        : " + registrasiPasien[1][j]);
                                        System.out.println("No KTP      : " + registrasiPasien[2][j]);
                                        System.out.println("alamat      : " + registrasiPasien[3][j]);
                                        System.out.println("no telp     : " + registrasiPasien[4][j]);
                                        System.out.println("--------------------------------------------------");
                                        break;
                                    }
                                    jumlahPasien++;
                                } else {
                                    System.out.println("pasien sudah memiliki kartu berobat");
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
                                // if (usiaPasien <= 17) {
                                // kategoriPasien = "A-Anak";
                                // harga = 5000;
                                // } else {
                                // kategoriPasien = "D-Dewasa";
                                // harga = 10000;
                                // }

                                System.out.print("Keluhan                     : ");
                                transaksiPasien[3][jumlahTransaksi] = sc1.nextLine();
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
                                System.out.println("               Struk Transaksi                    ");
                                System.out.println("--------------------------------------------------");
                                System.out.println("No Kartu Berobat    :" + transaksiPasien[0][jumlahTransaksi]);
                                System.out.println("No BPJS             :" + transaksiPasien[1][jumlahTransaksi]);
                                System.out.println("Nama Pasien         :" + transaksiPasien[2][jumlahTransaksi]);
                                System.out.println("Usia Pasien         :" + transaksiPasien2[0][jumlahTransaksi]);
                                System.out.println("Keluhan Pasien      :" + transaksiPasien[3][jumlahTransaksi]);
                                System.out.println("--------------------------------------------------");
                                // potongan BPJS pada klinik 100%
                                System.out.println("Potongan BPJS(%)    :     " + potonganBpjs);
                                // harga di tentukan sesuai kategori usia pasien
                                System.out.print("Harga               : Rp. ");
                                transaksiPasien2[1][jumlahTransaksi] = sc.nextInt();

                                // memproses perhitungan pembayaran
                                transaksiPasien2[2][jumlahTransaksi] = transaksiPasien2[1][jumlahTransaksi] - (transaksiPasien2[1][jumlahTransaksi] * potonganBpjs / 100);
                                System.out.println("--------------------------------------------------");
                                System.out.println("Harga Akhir         : Rp. " + transaksiPasien2[2][jumlahTransaksi]);
                                grandTotal[jumlahTransaksi] = transaksiPasien2[2][jumlahTransaksi];
                                if (transaksiPasien2[2][jumlahTransaksi] == 0) {
                                    System.out.println("Pembayaran Gratis");
                                    jumlahTransaksi++;
                                    break;
                                } else {
                                    // pembayaran debit atau tunai by fauzi
                                    System.out.print("Metode pembayaran menggunakan(1 = debit, 2 = tunai)? ");
                                    pembayaran = sc.next().charAt(0);
                                    jumlahTransaksi++;
                                    if (pembayaran == '1') {
                                        System.out.print("Masukan pin kartu debit:");
                                        transaksiPasien[4][jumlahTransaksi] = input.nextLine();
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
                            // Menu Lihat History Reservasi / transaksi klinik
                            System.out.println("==========================================================");
                            System.out.println("Anda memilih menu Lihat History Transaksi.");
                            if (jumlahTransaksi == 0) {
                                System.out.println("Belum ada transaksi");
                            } else {
                                System.out.println("Histori Transaksi");
                                for (int j = 0; j < jumlahTransaksi; j++) {
                                    System.out.println("TRANSAKSI KE-" + (j + 1));
                                    System.out.println("- No Kartu Berobat  : " + registrasiPasien[0][jumlahPasien]);
                                    System.out.println("- No Kartu BPJS     : " + transaksiPasien[1][j]);
                                    System.out.println("- Nama Pasien       : " + transaksiPasien[2][j]);
                                    System.out.println("- Usia Pasien       : " + transaksiPasien2[0][j]);
                                    System.out.println("- Keluhan Pasien    : " + transaksiPasien[3][j]);
                                    System.out.println("- Total Biaya       : " + transaksiPasien2[2][j]);
                                    System.out.println("--------------------------------------------------");
                                }
                                boolean isValid = false;
                                while (!isValid) {
                                    System.out.print("Masukkan No Kartu Pasien: ");
                                    key = sc1.nextLine();
                                    for (int i = 0; i < noKartuTransaksi.length; i++) {
                                        if (key.equalsIgnoreCase(noKartuTransaksi[i])) {
                                            hasil = i;
                                            System.out.println(
                                                    "No Kartu Pasien " + key + " terdapat di index ke-" + hasil);
                                            isValid = true;
                                            break;
                                        }
                                    }
                                    if (!isValid) {
                                        System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                                        isValid = false;
                                        continue;
                                    }
                                }

                            }
                        } else if (adminChoice == 3) {
                            // Menu Sewa Kamar
                        } else if (adminChoice == 4) {
                            // Menu Lihat Daftar kamar
                            System.out.println("==========================================================");
                            System.out.println("Anda memilih menu Lihat Daftar Kamar");
                            int noKamar;
                            System.out.println("");
                            System.out.println("=================================");
                            System.out.println("|Daftar Kamar Rawat Inap Klinik X");
                            System.out.println("=================================");
                            for (int i = 1; i <= statusKamar.length; i++) {
                                System.out.println("| Kamar no " + i + ": " + statusKamar[i - 1]);
                            }
                            System.out.println("=================================");
                        } else if (adminChoice == 5) {
                            int jumlahTransaksiRujuk = 0;
                            // Menu Rujuk Pasien
                            System.out.println("==================================");
                            System.out.println("    Daftar RS Rujukan Klinik X    ");
                            System.out.println("==================================");
                            for (int i = 0; i < daftarRs.length; i++) {
                                System.out.println((i + 1) + ". " + daftarRs[i]);
                            }

                            boolean isValid = false;
                            while (isValid != true) {
                                System.out.println("==================================");
                                System.out.print("Masukkan nomor (1 - " + daftarRs.length + "): ");
                                int selectedRsIndex = sc.nextInt();
                                if (selectedRsIndex >= 1 && selectedRsIndex <= daftarRs.length) {
                                    statusRs = selectedRsIndex - 1; // Mengonversi nomor RS ke indeks dalam array
                                    System.out.println("Anda telah memilih " + daftarRs[statusRs]);
                                    rsRujukan[statusRs] = daftarRs[statusRs];
                                    isValid = true;
                                    break;
                                } else {
                                    System.out.println("data tidak valid");
                                    isValid = false;
                                    continue;
                                }
                            }

                            // System.out.print("No Kartu Pasien : ");
                            // noKartuRujuk = sc.next();
                            boolean dataDitemukan = false;
                            while (!dataDitemukan) {
                                for (int i = 0; i < noKartuTransaksi.length; i++) {
                                    System.out.print("No Kartu Pasien             : ");
                                    noKartuRujuk[i] = sc.next();
                                    if (noKartuRujuk[i].equalsIgnoreCase(noKartuTransaksi[i])) {
                                        statusRs = i;
                                        System.out.println("No Kartu Pasien : " + noKartuRujuk[statusRs]);
                                        System.out.println("Nama Pasien     : " + namaPasien[statusRs]);
                                        System.out.println("Usia Pasien     : " + usiaPasien[statusRs]);
                                        namaPasienRujuk[statusRs] = namaPasien[statusRs];
                                        usiaPasienRujuk[statusRs] = usiaPasien[statusRs];
                                        dataDitemukan = true;
                                        jumlahTransaksiRujuk++;
                                        break;
                                    }
                                }
                                if (!dataDitemukan) {
                                    System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                                    dataDitemukan = false;
                                    continue;
                                }

                                System.out.print("Apakah pasien memiliki kartu BPJS (0 = ya, 1 = tidak)? ");
                                statusbpjs = sc.next().charAt(0);

                                if (statusbpjs == '0') {
                                    boolean bpjsDataDitemukan = false;
                                    while (!bpjsDataDitemukan) {
                                        for (int i = 0; i < noBpjs.length; i++) {
                                            System.out.print("Masukkan No.BPJS pasien     : ");
                                            noBpjsRujuk[i] = sc.next();

                                            if (noBpjsRujuk[i].equalsIgnoreCase(noBpjs[i])) {
                                                statusRs = i;
                                                System.out.println("Nama Pasien     : " + namaPasien[statusRs]);
                                                bpjsDataDitemukan = true;
                                                break;
                                            }
                                        }
                                        if (!bpjsDataDitemukan) {
                                            System.out.println("Data Pasien tidak ditemukan. Silakan coba lagi.");
                                            bpjsDataDitemukan = false;
                                            continue;
                                        }
                                    }
                                } else {
                                    potonganBpjs = 0;
                                }
                                statusRs = 0;
                                System.out.print("Alasan Rujuk                :");
                                alasanRujuk[statusRs] = sc1.nextLine();
                                System.out.println("--------------------------------------------------");
                                System.out.println("         Struk Transaksi - Rujuk Pasien           ");
                                System.out.println("--------------------------------------------------");
                                System.out.println("No Kartu Berobat    :" + noKartuRujuk[statusRs]);
                                System.out.println("No BPJS             :" + noBpjsRujuk[statusRs]);
                                System.out.println("Nama Pasien         :" + namaPasienRujuk[statusRs]);
                                System.out.println("Usia Pasien         :" + usiaPasienRujuk[statusRs]);
                                System.out.println("Alasan Rujuk        :" + alasanRujuk[statusRs]);
                                System.out.println("--------------------------------------------------");
                                System.out.println("Transaksi Selesai - Status Pending");
                            }
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

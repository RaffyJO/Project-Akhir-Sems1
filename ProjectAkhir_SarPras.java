package projectakhir_sarpras;

import java.util.*;
import java.time.*;

public class ProjectAkhir_SarPras {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static LocalDate dateNow = LocalDate.now();
    static String tanggal = dateNow.getDayOfMonth() + "-" + dateNow.getMonthValue()
            + "-" + dateNow.getYear();

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    static void menu() {
        System.out.println("===================================================");
        System.out.println("|              Selamat Datang \t\t" + tanggal + "|");
        System.out.println("===================================================");
        System.out.println("[1] Cek SarPras & Barang");
        System.out.println("[2] Peminjaman Barang");
        System.out.println("[3] Data Peminjam");
        System.out.println("[4] Pengembalian Barang");
        System.out.println("[5] Exit");
        System.out.println("---------------------------------------------------");
        System.out.print("Pilih Menu: ");
        String selectMenu = input.next();

        switch (selectMenu) {
            case "1":
                menuCekBarang();
                break;
            case "2":
                pinjamBarang();;
                break;  
            case "3":
                tampilkanData();
                break;  
            case "4":
                pengembalianBarang();
                break;
            case "5":
                System.out.println("===================================================");
                System.out.println("|                   Terima Kasih                  |");
                System.out.println("===================================================");
                System.exit(0);
                break;
            default:
                System.out.println("Masukkan Menu Yang Benar!");
                break;
        }
    }

    static String sarana[] = {
        "Ruang Baca", "Ruang Kelas", "Lab Komputer", "Kamar Mandi", "Ruang Dosen"};
    static int jumlahSarana[] = {1, 18, 8, 6, 8};

    static String namaBarang[][] = {
            { "Buku", "Jurnal", "Skripsi" },
            { "AC", "Kursi", "Meja" },
            { "Monitor", "Keyboard", "CPU" }
    };
    
    static int jumlahBarang[][] = {
            { 00, 00, 00 },
            { 00, 00, 00 },
            { 00, 00, 00 }
    };

    static String barangBaru[] = new String[100];
    static int jumlahBaru[] = new int[100];

    static void cekBarang() {
        for (int i = 0; i < namaBarang.length; i++) {
            for (int j = 0; j < jumlahBarang[0].length; j++) {
                if (jumlahBarang[i][j] == 0) {
                    jumlahBarang[i][j] = rand.nextInt(99);
                } else {
                    break;
                }
            }
        }
        tampilkanBarang();
    }

    static void menuCekBarang() {
        System.out.println("===================================================");
        System.out.println("|                   Cek Barang                    |");
        System.out.println("===================================================");
        cekBarang();
        System.out.println("[1] Tambah Stok Barang");
        System.out.println("[2] Kurangi Stok Barang");
        System.out.println("[3] Input Barang Baru");
        System.out.println("[4] Kembali");
        System.out.println("---------------------------------------------------");
        System.out.print("Pilih Menu: ");
        String selectMenu = input.next();

        switch (selectMenu) {
            case "1":
                tambahbarang();
                break;
            case "2":
                kurangBarang();
                break;  
            case "3":
                inputBarangBaru();
                break;  
            case "4":
                menu();
                break;
            default:
                System.out.println("Masukkan Menu Yang Benar!");
                break;
        }
    }

    static void inputBarangBaru() {
        for (int i = 0; i < barangBaru.length; i++) {
            if (barangBaru[i] == null) {
                System.out.print("Masukkan Nama Barang Baru   : ");
                barangBaru[i] = input.next();
                System.out.print("Masukkan Jumlah Barang Baru : ");
                jumlahBaru[i] = input.nextInt();
    
                System.out.print("Tambahkan Barang Lagi? (y/t): ");
                String jawab = input.next();
                System.out.println("---------------------------------------------------");
                if (jawab.equalsIgnoreCase("t")) {
                    tampilkanBarang();
                    break;
                } else if (jawab.equalsIgnoreCase("y")) {
                    // continue;
                } else {
                    System.out.println("Masukkan Input Dengan Benar!");
                    break;
                }
            }
        }
    }

    static void operasiTambahBarang() {
        System.out.println("---------------------------------------------------");
        System.out.print("Ketik Nama Barang      : ");
        String nBarang = input.next();
        System.out.print("Masukkan Jumlah Barang : ");
        int jBarang = input.nextInt();
        System.out.println("---------------------------------------------------");
    
        if (nBarang.equalsIgnoreCase("Buku")) {
            jumlahBarang[0][0] += jBarang;
        } else if (nBarang.equalsIgnoreCase("Jurnal")) {
            jumlahBarang[0][1] += jBarang;
        } else if (nBarang.equalsIgnoreCase("Skripsi")) {
            jumlahBarang[0][2] += jBarang;
        } else if (nBarang.equalsIgnoreCase("AC")) {
            jumlahBarang[1][0] += jBarang;
        } else if (nBarang.equalsIgnoreCase("Kursi")) {
            jumlahBarang[1][1] += jBarang;
        } else if (nBarang.equalsIgnoreCase("Meja")) {
            jumlahBarang[1][2] += jBarang;
        } else if (nBarang.equalsIgnoreCase("Monitor")) {
            jumlahBarang[2][0] += jBarang;
        } else if (nBarang.equalsIgnoreCase("Keyboard")) {
            jumlahBarang[2][1] += jBarang;
        } else if (nBarang.equalsIgnoreCase("CPU")) {
            jumlahBarang[2][2] += jBarang;
        } else if (barangBaru[0] != null) {
            for (int i = 0; i < barangBaru.length; i++) {
                if (nBarang.equalsIgnoreCase(barangBaru[i])) {
                    jumlahBaru[i] += jBarang;
                }
            }
        } else {
            System.out.println("Masukkan Nama Barang Dengan Benar!");
        }
    } 

    static void tambahbarang() {
        while (true) {
            operasiTambahBarang();
                
            System.out.print("Tambahkan Barang Lagi? (y/t): ");
            String jawab = input.next();
            if (jawab.equalsIgnoreCase("t")) {
                tampilkanBarang();
                break;
            } else if (jawab.equalsIgnoreCase("y")) {
                // continue;
            } else {
                System.out.println("Masukkan Input Dengan Benar!");
                break;
            }
        }
    }

    static void operasiKurangBarang() {
        System.out.println("---------------------------------------------------");
        System.out.print("Ketik Nama Barang      : ");
        String nBarang = input.next();
        System.out.print("Masukkan Jumlah Barang : ");
        int jBarang = input.nextInt();
        System.out.println("---------------------------------------------------");
    
        if (nBarang.equalsIgnoreCase("Buku")) {
            jumlahBarang[0][0] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("Jurnal")) {
            jumlahBarang[0][1] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("Skripsi")) {
            jumlahBarang[0][2] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("AC")) {
            jumlahBarang[1][0] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("Kursi")) {
            jumlahBarang[1][1] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("Meja")) {
            jumlahBarang[1][2] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("Monitor")) {
            jumlahBarang[2][0] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("Keyboard")) {
            jumlahBarang[2][1] -= jBarang;
        } else if (nBarang.equalsIgnoreCase("CPU")) {
            jumlahBarang[2][2] -= jBarang;
        } else if (barangBaru[0] != null) {
            for (int i = 0; i < barangBaru.length; i++) {
                if (nBarang.equalsIgnoreCase(barangBaru[i])) {
                    jumlahBaru[i] -= jBarang;
                }
            }
        } else {
            System.out.println("Masukkan Nama Barang Dengan Benar!");
        }
    }
    
    static void kurangBarang() {
        while (true) {
            operasiKurangBarang();
                
            System.out.print("Kurangi Barang Lagi? (y/t): ");
            String jawab = input.next();
            if (jawab.equalsIgnoreCase("t")) {
                tampilkanBarang();
                break;
            } else if (jawab.equalsIgnoreCase("y")) {
                // continue;
            } else {
                System.out.println("Masukkan Input Dengan Benar!");
                break;
            }
        }
    }

    static String dataPinjam[][] = new String[100][4];
    static String barangDipinjam[][] = new String[100][4];
    static int jumlahDipinjam[][] = new int[100][4];
    
    static void tampilkanBarang() {
        int totalSarana = 0;
        System.out.println();
        System.out.println("|--------------Sarana Dan Prasarana---------------|");
        System.out.println();
        for (int i = 0; i < sarana.length; i++) {
            System.out.print(sarana[i] + " \t");
            System.out.println(jumlahSarana[i]);
            totalSarana += jumlahSarana[i];
            
        }
        
        System.out.println("Jumlah Seluruh Ruangan " + totalSarana);

        System.out.println();
        System.out.println("|----------Jumlah Barang Yang Tersedia------------|");
        System.out.println();
        int totalBarang = 0;
        for (int i = 0; i < namaBarang.length; i++) {
            for (int j = 0; j < jumlahBarang[0].length; j++) {
                System.out.print(namaBarang[i][j] + "       \t");
                System.out.println(jumlahBarang[i][j]);
                totalBarang += jumlahBarang[i][j];
            }
        }

        for (int i = 0; i < barangBaru.length; i++) {
            if (barangBaru[i] != null) {
                System.out.print(barangBaru[i] + "       \t");
                System.out.println(jumlahBaru[i]);
                totalBarang += jumlahBaru[i];
            }
        }
        System.out.println("Jumlah Seluruh Barang " + totalBarang);
        System.out.println("---------------------------------------------------");
    }

    static void pinjamBarang() {
        System.out.println("---------------------------------------------------");
        System.out.println("|-----Anda Hanya Bisa Meminjam 4 Jenis Barang-----|");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < dataPinjam.length; i++) {
            if (dataPinjam[i][0] == null) {
                System.out.print("Masukkan Nama\t: ");
                dataPinjam[i][0] = input.nextLine();
                dataPinjam[i][0] = input.nextLine();
                System.out.print("Masukkan NIM\t: ");
                dataPinjam[i][1] = input.next();
                System.out.print("Masukkan Prodi\t: ");
                dataPinjam[i][2] = input.next();
                System.out.print("Masukkan Kelas\t: ");
                dataPinjam[i][3] = input.next();

                for (int j = 0; j < barangDipinjam[0].length; j++) {
                    System.out.println("---------------------------------------------------");
                    System.out.print("Ketik Nama Barang      : ");
                    String nBarang = input.next();
                    barangDipinjam[i][j] = nBarang;

                    System.out.print("Masukkan Jumlah Barang : ");
                    int jBarang = input.nextInt();
                    jumlahDipinjam[i][j] = jBarang;
                    System.out.println("---------------------------------------------------");

                    if (nBarang.equalsIgnoreCase("Buku")) {
                        jumlahBarang[0][0] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("Jurnal")) {
                        jumlahBarang[0][1] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("Skripsi")) {
                        jumlahBarang[0][2] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("AC")) {
                        jumlahBarang[1][0] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("Kursi")) {
                        jumlahBarang[1][1] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("Meja")) {
                        jumlahBarang[1][2] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("Monitor")) {
                        jumlahBarang[2][0] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("Keyboard")) {
                        jumlahBarang[2][1] -= jBarang;
                    } else if (nBarang.equalsIgnoreCase("CPU")) {
                        jumlahBarang[2][2] -= jBarang;
                    } else {
                        int cek = 0;
                        for (int k = 0; k < barangBaru.length; k++) {
                            if (nBarang.equalsIgnoreCase(barangBaru[k])) {
                                jumlahBaru[k] -= jBarang;
                                cek += 1;
                                break;
                            }
                        }
                        if (cek != 1) {
                            barangDipinjam[i][j] = null;
                            jumlahDipinjam[i][j] = 0;
                            j = j - 1;
                            System.out.println("Masukkan Nama Barang Dengan Benar!");   
                        }
                    }
                    
                    System.out.print("Pinjam Barang Lain? (y/t): ");
                    String jawab = input.next();
                    if (jawab.equalsIgnoreCase("t")) {
                        tampilkanBarang();
                        break;
                    } else if (jawab.equalsIgnoreCase("y")) {
                        continue;
                    } else {
                        System.out.println("Masukkan Input Dengan Benar!");
                        System.out.println();
                        break;
                    }
                }

            } else {
                continue;
            }

            System.out.print("Pinjam Kembali? (y/t): ");
            String jawab = input.next();
            if (jawab.equalsIgnoreCase("t")) {
                break;
            } else if (jawab.equalsIgnoreCase("y")) {
                System.out.println("---------------------------------------------------");
                continue;
            } else {
                System.out.println("Masukkan Input Dengan Benar!");
                break;
            }
        }
        tampilkanData();
    }

    static void tampilkanData() {
        System.out.println("---------------------------------------------------");
        System.out.println("|                  Data Peminjam                  |");
        System.out.println("---------------------------------------------------");
        int cek = 0;
        for (int i = 0; i < dataPinjam.length; i++) {
            for (int j = 0; j < dataPinjam[0].length; j++) {
                if (dataPinjam[i][j] != null) {
                    if (dataPinjam[i][j] == dataPinjam[i][0]) {
                        System.out.println("Nama\t: " + dataPinjam[i][0]);
                    } else if (dataPinjam[i][j] == dataPinjam[i][1]) {
                        System.out.println("NIM\t: " + dataPinjam[i][1]);
                    } else if (dataPinjam[i][j] == dataPinjam[i][2]) {
                        System.out.println("Prodi\t: " + dataPinjam[i][2]);
                    } else if (dataPinjam[i][j] == dataPinjam[i][3]) {
                        System.out.println("Kelas\t: " + dataPinjam[i][3]);
                    }
                    cek++;
                }
            }
            
            if (barangDipinjam[i][0] != null) {
                System.out.println();
                System.out.println("Barang Yang Dipinjam : ");
                for (int j = 0; j < barangDipinjam[0].length; j++) {
                    if (barangDipinjam[i][j] != null) {
                        System.out.print(barangDipinjam[i][j] + " ");
                        System.out.println(jumlahDipinjam[i][j]);
                    }
                }
                System.out.println("---------------------------------------------------");
            }
        }

        if (cek == 0) {
            System.out.println();
            System.out.println(" <--------Belum Ada Yang Meminjam Barang!--------> ");
        }
    }
    
    static void pengembalianBarang() {
        System.out.println("---------------------------------------------------");
        System.out.println("|----Barang Harus Sesuai Dengan Yang Dipinjam!----|");
        System.out.println("---------------------------------------------------");
        System.out.print("Masukkan Nama Peminjam : ");
        String peminjam = input.nextLine();
        peminjam = input.nextLine();

        int cek = 0;
        for (int i = 0; i < dataPinjam.length; i++) {
            if (peminjam.equalsIgnoreCase(dataPinjam[i][0])) {
                for (int j = 0; j < barangDipinjam[0].length; j++) {
                    if ("Buku".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[0][0] += jumlahDipinjam[i][j];
                    } else if ("Jurnal".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[0][1] += jumlahDipinjam[i][j];
                    } else if ("Skripsi".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[0][2] += jumlahDipinjam[i][j];
                    } else if ("AC".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[1][0] += jumlahDipinjam[i][j];
                    } else if ("Kursi".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[1][1] += jumlahDipinjam[i][j];
                    } else if ("Meja".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[1][2] += jumlahDipinjam[i][j];
                    } else if ("Monitor".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[2][0] += jumlahDipinjam[i][j];
                    } else if ("Keyboard".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[2][1] += jumlahDipinjam[i][j];
                    } else if ("CPU".equalsIgnoreCase(barangDipinjam[i][j])) {
                        jumlahBarang[2][2] += jumlahDipinjam[i][j];
                    } else if (barangDipinjam[i][j] != null){
                        for (int n = 0; n < barangBaru.length; n++) {
                            if (barangDipinjam[i][j].equalsIgnoreCase(barangBaru[n])) {
                                jumlahBaru[n] += jumlahDipinjam[i][j];
                                break;
                            }
                        } 
                    }

                    dataPinjam[i][j] = null;
                    barangDipinjam[i][j] = null;
                    jumlahDipinjam[i][j] = 0;
                }
                System.out.println();
                System.out.println("Terima Kasih " + peminjam + ",");
                System.out.println("Telah Mengembalikan Barang :)");
                System.out.println("---------------------------------------------------");
                cek += 1;
                break;
            } 
        }

        if (cek != 1) {
            System.out.println();
            System.out.println("Data Tidak Ditemukan!");
        }
    }
}
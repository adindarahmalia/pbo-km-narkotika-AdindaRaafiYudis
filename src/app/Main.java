package app;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;

public class Main {

    public static void main(String[] args) {

        KnowledgeRepository repo = new KnowledgeRepository();

        // =========================
        // DATA TEST SEMENTARA
        // =========================

        repo.simpan(new Putusan(
                "0001/Pid.Sus/2024/PN Sby",
                "PN Surabaya",
                "2024-01-10",
                "Budi Santoso",
                32,
                "Sabu-sabu",
                2.5,
                "Pasal 112 UU No. 35 Tahun 2009",
                "Pengguna",
                60,
                500000000,
                "Hakim Ketua A"
        ));

        repo.simpan(new Putusan(
                "0002/Pid.Sus/2024/PN Sby",
                "PN Surabaya",
                "2024-01-15",
                "Andi Wijaya",
                28,
                "Ganja",
                5.0,
                "Pasal 111 UU No. 35 Tahun 2009",
                "Penyimpan",
                36,
                200000000,
                "Hakim Ketua B"
        ));

        repo.simpan(new Putusan(
                "0003/Pid.Sus/2024/PN Bdg",
                "PN Bandung",
                "2024-02-12",
                "Rudi Hartono",
                41,
                "Sabu-sabu",
                1.2,
                "Pasal 114 UU No. 35 Tahun 2009",
                "Kurir",
                72,
                800000000,
                "Hakim Ketua C"
        ));

        // =========================
        // TEST REPOSITORY
        // =========================

        System.out.println("=== SEMUA DATA ===");
        for (Putusan p : repo.getDaftarSemua()) {
            System.out.println(p);
        }

        System.out.println("\n=== TOTAL DATA ===");
        System.out.println(repo.getTotalData());

        System.out.println("\n=== CARI BY NOMOR ===");
        System.out.println(repo.cariByNomor("0001/Pid.Sus/2024/PN Sby"));

        System.out.println("\n=== CARI BY NAMA ===");
        System.out.println(repo.cariByNama("Andi"));

        System.out.println("\n=== FILTER JENIS SABU-SABU ===");
        System.out.println(repo.filterByJenis("Sabu-sabu"));

        System.out.println("\n=== FILTER PENGADILAN PN SURABAYA ===");
        System.out.println(repo.filterByPengadilan("PN Surabaya"));

        System.out.println("\n=== FILTER RENTANG VONIS 40 - 80 BULAN ===");
        System.out.println(repo.filterByRentangVonis(40, 80));

        // =========================
        // TEST STATISTIK
        // =========================

        System.out.println("\n=== STATISTIK PUTUSAN ===");

        StatistikPutusan stat = new StatistikPutusan(repo.getDaftarSemua());

        System.out.println("Total Putusan             : " + stat.getTotalPutusan());
        System.out.println("Rata-rata Vonis           : " + stat.getRataRataVonis());
        System.out.println("Rata-rata Denda           : " + stat.getRataRataDenda());
        System.out.println("Jenis Narkotika Terbanyak : " + stat.getJenisNarkotikaTerbanyak());
        System.out.println("Distribusi Peran          : " + stat.getDistribusiPeran());
        System.out.println("Distribusi Jenis          : " + stat.getDistribusiJenisNarkotika());

        // =========================
        // TEST HAPUS DATA
        // =========================

        System.out.println("\n=== HAPUS DATA 0002 ===");
        boolean berhasilHapus = repo.hapus("0002/Pid.Sus/2024/PN Sby");

        System.out.println("Berhasil hapus: " + berhasilHapus);
        System.out.println("Total setelah hapus: " + repo.getTotalData());

        System.out.println("\n=== DATA SETELAH HAPUS ===");
        for (Putusan p : repo.getDaftarSemua()) {
            System.out.println(p);
        }

        System.out.println("\n=== STATISTIK SETELAH HAPUS ===");
        StatistikPutusan statBaru = new StatistikPutusan(repo.getDaftarSemua());
        statBaru.tampilkanLaporan();
    }
}
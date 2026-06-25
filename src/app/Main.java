package app;

import controller.KnowledgeController;
import model.Putusan;
import model.StatistikPutusan;

public class Main {

    public static void main(String[] args) {

        KnowledgeController controller = new KnowledgeController();

        // =========================
        // INPUT DATA VIA CONTROLLER
        // =========================
        controller.tambahPutusan(new Putusan(
                "001",
                "PN Jakarta",
                "2024-01-10",
                "Budi Santoso",
                32,
                "Laki-laki",
                "Karyawan",
                "Sabu",
                2.5,
                "Pasal 112",
                "Pengguna",
                60,
                500000000,
                "Hakim A"
        ));

        controller.tambahPutusan(new Putusan(
                "002",
                "PN Bandung",
                "2024-02-12",
                "Andi Wijaya",
                28,
                "Laki-laki",
                "Wiraswasta",
                "Ganja",
                1.2,
                "Pasal 111",
                "Pengedar",
                36,
                200000000,
                "Hakim B"
        ));

        // =========================
        // TEST OUTPUT
        // =========================

        System.out.println("=== SEMUA DATA ===");
        System.out.println(controller.getAll());

        System.out.println("\n=== CARI ANDI ===");
        System.out.println(controller.cari("Andi"));

        System.out.println("\n=== FILTER SABU ===");
        System.out.println(controller.filterJenis("Sabu"));

        System.out.println("\n=== FILTER TAHUN 2024 ===");
        System.out.println(controller.filterTahun(2024));

        System.out.println("\n=== TOTAL DATA ===");
        System.out.println(controller.total());

        // =========================
        // STATISTIK (DARI MODEL LANGSUNG)
        // =========================
        StatistikPutusan stat = new StatistikPutusan(controller.getAll());

        stat.tampilkan();
    }
}
package app;

import model.KnowledgeRepository;
import model.Putusan;
import model.PutusanCsvLoader;
import model.StatistikPutusan;
import model.DataSeeder;

public class Main {

    public static void main(String[] args) {

        KnowledgeRepository repo = new KnowledgeRepository();

        PutusanCsvLoader.loadFromCsv("data/putusan_narkotika.csv", repo);
        DataSeeder.loadBonus(repo);

        System.out.println("=== TOTAL DATA ===");
        System.out.println("Data Utama     : " + repo.getTotalData());
        System.out.println("Data Bonus     : " + repo.getTotalBonus());
        System.out.println("Total Gabungan : " + repo.getTotalGabungan());

        System.out.println("\n=== DATA PUTUSAN ===");
        for (Putusan p : repo.getDaftarSemua()) {
            System.out.println(p);
        }

        System.out.println("\n=== STATISTIK DATA UTAMA ===");
        StatistikPutusan statUtama =
                new StatistikPutusan(repo.getDaftarSemua());
        statUtama.tampilkanLaporan();

        System.out.println("\n=== STATISTIK DATA BONUS ===");
        StatistikPutusan statBonus =
                new StatistikPutusan(repo.getDaftarBonus());
        statBonus.tampilkanLaporan();

        System.out.println("\n=== STATISTIK DATA GABUNGAN ===");
        StatistikPutusan statGabungan =
                new StatistikPutusan(repo.getDaftarGabungan());
        statGabungan.tampilkanLaporan();
    }
}
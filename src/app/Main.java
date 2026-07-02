package app;

import model.KnowledgeRepository;
import model.Putusan;
import model.PutusanCsvLoader;
import model.StatistikPutusan;

public class Main {

    public static void main(String[] args) {
        KnowledgeRepository repo = new KnowledgeRepository();

        PutusanCsvLoader.loadFromCsv("data/putusan_narkotika.csv", repo);

        System.out.println("=== TOTAL DATA ===");
        System.out.println(repo.getTotalData());

        System.out.println("\n=== DATA PUTUSAN ===");
        for (Putusan p : repo.getDaftarSemua()) {
            System.out.println(p);
        }

        System.out.println("\n=== STATISTIK ===");
        StatistikPutusan statUtama =
                new StatistikPutusan(repo.getDaftarSemua());

        statUtama.tampilkanLaporan();
    }
}
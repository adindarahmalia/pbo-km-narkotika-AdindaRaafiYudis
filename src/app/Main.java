package app;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;

public class Main {

    public static void main(String[] args){

        KnowledgeRepository repo = new KnowledgeRepository();
        repo.tambah(new Putusan("001", "Budi Santoso", "112", 2024, "Sabu", "5 tahun"));
        repo.tambah(new Putusan("002", "Andi Wijaya", "111", 2024, "Ganja", "3 tahun"));
        repo.tambah(new Putusan("003", "Rudi Gregor", "112", 2024, "Sabu", "6 tahun"));

        System.out.println("=== SEMUA DATA ===");
        System.out.println(repo.getSemua());

        System.out.println("\n=== FILTER SABU ====");
        System.out.println(repo.filterByJenis("Sabu"));

        System.out.println("\n=== FILTER TAHUN 2024 ===");
        System.out.println(repo.filterByTahun(2024));

        System.out.println("\n=== HAPUS 002 ===");
        repo.hapusByNomor("002");

        System.out.println("\n=== SETELAH HAPUS ===");
        System.out.println(repo.getSemua());

        System.out.println("\nTOTAL DATA: " + repo.getTotalData());

        StatistikPutusan stat = new StatistikPutusan(repo.getSemua());
        stat.tampilkan();
    }
}
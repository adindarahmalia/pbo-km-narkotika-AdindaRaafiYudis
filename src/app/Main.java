package app;

import model.KnowledgeRepository;
import model.Putusan;

public class Main {

    public static void main(String[] args){

        KnowledgeRepository repo = new KnowledgeRepository();
        repo.tambah(new Putusan("001", "Budi Santoso", "112", 2024, "Sabu", "5 tahun"));
        repo.tambah(new Putusan("002", "Andi Wijaya", "111", 2024, "Ganja", "3 tahun"));


        System.out.println("=== SEMUA DATA ===");
        System.out.println(repo.getSemua());

        System.out.println("=== CARI BUDI ===");
        System.out.println(repo.cari("Budi"));
    }
}

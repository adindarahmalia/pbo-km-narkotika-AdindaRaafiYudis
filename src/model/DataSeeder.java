package model;

public class DataSeeder {

    public static void loadBonus(KnowledgeRepository repo) {

        repo.simpanBonus(
                new Putusan(
                        "BONUS-001",
                        "PN Surabaya",
                        "2025-01-10",
                        "Andi",
                        29,
                        "Laki-laki",
                        "Wiraswasta",
                        "Sabu",
                        12.5,
                        "Pasal 112",
                        "Pengedar",
                        72,
                        1000000000,
                        "Hakim A"
                )
        );

        repo.simpanBonus(
                new Putusan(
                        "BONUS-002",
                        "PN Bandung",
                        "2025-02-20",
                        "Budi",
                        35,
                        "Laki-laki",
                        "Karyawan",
                        "Ekstasi",
                        5.2,
                        "Pasal 114",
                        "Perantara",
                        60,
                        800000000,
                        "Hakim B"
                )
        );
    }
}
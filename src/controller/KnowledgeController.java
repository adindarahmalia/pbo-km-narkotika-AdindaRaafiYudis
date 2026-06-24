package controller;

import model.KnowledgeRepository;
import model.Putusan;
import util.InputHandler;
import view.ConsoleView;

public class KnowledgeController {
    private KnowledgeRepository repository;
    private ConsoleView view;
    private InputHandler input;

    public KnowledgeController() {
        repository = new KnowledgeRepository();
        view = new ConsoleView();
        input = new InputHandler();
    }
    public void start() {
        int pilihan;
        do {
            view.tampilkanMenu();
            pilihan = input.inputInt("Masukkan Pilihan: ");
            switch (pilihan) {
                case 1:
                    tambahPutusan();
                    break;
                case 2:
                    tampilkanSemua();
                    break;
                case 3:
                    cariPutusan();
                    break;
                case 4:
                    filterPutusan();
                    break;
                case 5:
                    tampilkanStatistik();
                    break;
                case 6:
                    hapusPutusan();
                    break;
                case 0:
                    view.tampilkanKonfirmasiKeluar();
                    break;
                default:
                    view.tampilkanError("Menu tidak tersedia");
            }
        } while (pilihan != 0);
    }
    private void tambahPutusan() {
        view.tampilkanFormTambah();
        String nomorPerkara = input.inputString("Nomor Perkara: ");
        String namaTerdakwa = input.inputString("Nama Terdakwa: ");
        String pasal = input.inputString("Pasal: ");
        int tahun = input.inputInt("Tahun: ");
        String jenisNarkotika = input.inputString("Jenis Narkotika: ");
        String putusan = input.inputString("Putusan: ");
        Putusan data = new Putusan(nomorPerkara, namaTerdakwa, pasal, tahun, jenisNarkotika, putusan);
        repository.tambah(data);

        view.tampilkanSukses("Data putusan berhasil ditambahkan");
    }
    private void tampilkanSemua() {
        if (repository.getSemua().isEmpty()) {
            view.tampilkanError("Belum ada data putusan");
            return;
        }
        view.tampilkanPesan("=== DAFTAR PUTUSAN ===");
        for (Putusan p : repository.getSemua()) {
            System.out.println(p);
        }
    }
    private void cariPutusan() {
        String keyword = input.inputString("Masukkan keyword pencarian: ");
        var hasil = repository.cari(keyword);
        if (hasil.isEmpty()) {
            view.tampilkanError("Data tidak ditemukan");
            return;
        }
        view.tampilkanPesan("=== HASIL PENCARIAN ===");
        for (Putusan p : hasil) {
            System.out.println(p);
        }
    }
    private void filterPutusan() {
        int pilihanFilter = input.inputInt("Filter berdasarkan:\n" + "1. Jenis narkotika\n" + "2. Tahun\n" + "Pilih: ");
        switch (pilihanFilter) {
            case 1:
                String jenis = input.inputString("Jenis Narkotika: ");
                var hasilJenis = repository.filterByJenis(jenis);
                for (Putusan p : hasilJenis) {
                    System.out.println(p);
                }
                break;
            case 2:
                int tahun = input.inputInt("Tahun: ");
                var hasilTahun = repository.filterByTahun(tahun);
                for (Putusan p : hasilTahun) {
                    System.out.println(p);
                }
                break;
            default:
                view.tampilkanError("Pilihan filter tidak valid");
        }
    }
    private void tampilkanStatistik() {
        int total = repository.getTotalData();
        view.tampilkanStatistik(total, 0, 0, "Belum dihitung");
    }
    private void hapusPutusan() {
        String nomor = input.inputString("Masukkan Nomor Perkara yang akan dihapus: ");
        boolean berhasil = repository.hapusByNomor(nomor);
        if (berhasil) {
            view.tampilkanSukses("Data berhasil dihapus");
        } else {
            view.tampilkanError("Data tidak ditemukan");
        }
    }
}
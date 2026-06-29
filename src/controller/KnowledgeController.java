package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
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
            var data = repository.getDaftarSemua();
            view.tampilkanDashboard(
                    StatistikPutusan.totalPutusan(data),
                    StatistikPutusan.rataRataVonis(data),
                    StatistikPutusan.jenisNarkotikaTerbanyak(data));

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
                    String konfirmasi = input.inputString("Apakah anda ingin keluar aplikasi? (Y/N): ");
                    if (konfirmasi.equalsIgnoreCase("Y")) {
                        pilihan = 0;
                    } else {
                        pilihan = -1;
                    }
                    break;
                default:
                    view.tampilkanError("Menu tidak tersedia");
            }
        } while (pilihan != 0);
    }
    private void tambahPutusan() {
        view.tampilkanFormTambah();
        String nomorPerkara = input.inputString("Nomor Perkara: ");
        String pengadilan = input.inputHuruf("Pengadilan: ");
        String tanggalPutusan = input.inputString("Tanggal Putusan: ");

        String namaTerdakwa = input.inputHuruf("Nama Terdakwa: ");
        int umurTerdakwa = input.inputInt("Umur Terdakwa: ");
        String jenisKelamin = input.inputHuruf("Jenis Kelamin: ");
        String pekerjaan = input.inputHuruf("Pekerjaan: ");

        String jenisNarkotika = input.inputHuruf("Jenis Narkotika: ");
        double beratBarangBukti = input.inputDouble("Berat Barang Bukti: ");

        String pasalDilanggar = input.inputString("Pasal Dilanggar: ");
        String peranTerdakwa = input.inputHuruf("Peran Terdakwa: ");

        int vonisHukuman = input.inputInt("Vonis Hukuman (bulan): ");
        double vonisDenda = input.inputDouble("Vonis Denda: ");

        String namaHakim = input.inputHuruf("Nama Hakim: ");

        Putusan data = new Putusan(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa, umurTerdakwa, jenisKelamin, pekerjaan, jenisNarkotika, beratBarangBukti, pasalDilanggar, peranTerdakwa, vonisHukuman, vonisDenda, namaHakim);
        repository.simpan(data);

        view.tampilkanPesan("Data berhasil disimpan ke repository.");
        view.tampilkanSukses("Data putusan berhasil ditambahkan");
    }
    private void tampilkanSemua() {

        if (repository.getDaftarSemua().isEmpty()) {
            view.tampilkanError("Belum ada data putusan");
            return;
        }

        view.tampilkanHeaderRepository();

        int no = 1;

        for (Putusan p : repository.getDaftarSemua()) {

            view.tampilkanDaftarPutusan(
                    no++,
                    p.getNomorPerkara(),
                    p.getNamaTerdakwa(),
                    p.getJenisNarkotika(),
                    p.getVonisHukuman() + " Bulan",
                    p.getPengadilan()
            );
        }

        view.tampilkanFooterRepository(
                repository.getTotalData()
        );
        view.tekanEnter();
        input.tekanEnter();
    }
    private void cariPutusan() {

        view.tampilkanFormCari();
        int pilihanCari = input.inputInt("Pilih: ");

        if (pilihanCari == 1) {
            String nomor = input.inputString("Nomor Perkara: ");
            Putusan hasil = repository.cariByNomor(nomor);

            if (hasil == null) {
                view.tampilkanError("Data tidak ditemukan");
                return;
            }
            view.tampilkanHasilPencarian();

            view.tampilkanDetailPutusan(
                    hasil.getNomorPerkara(),
                    hasil.getPengadilan(),
                    hasil.getTanggalPutusan(),
                    hasil.getNamaTerdakwa(),
                    String.valueOf(hasil.getUmurTerdakwa()),
                    hasil.getJenisKelamin(),
                    hasil.getPekerjaan(),
                    hasil.getJenisNarkotika(),
                    String.valueOf(hasil.getBeratBarangBukti()),
                    hasil.getPasalDilanggar(),
                    hasil.getPeranTerdakwa(),
                    hasil.getVonisHukuman() + " Bulan",
                    String.valueOf(hasil.getVonisDenda()),
                    hasil.getNamaHakim()
            );
            view.tekanEnter();
            input.tekanEnter();
        } else if (pilihanCari == 2) {
            String nama = input.inputString("Nama Terdakwa: ");
            var hasil = repository.cariByNama(nama);
            if (hasil.isEmpty()) {
                view.tampilkanError("Data tidak ditemukan");
                return;
            }
            view.tampilkanHasilPencarian();
            view.tampilkanHeaderRepository();

            int no = 1;
            for (Putusan p : hasil) {
                view.tampilkanDaftarPutusan(
                        no++,
                        p.getNomorPerkara(),
                        p.getNamaTerdakwa(),
                        p.getJenisNarkotika(),
                        p.getVonisHukuman() + " Bulan",
                        p.getPengadilan()
                );
            }
            view.tampilkanFooterRepository(hasil.size());
            view.tekanEnter();
            input.tekanEnter();
        } else {
            view.tampilkanError("Pilihan tidak valid");
        }
    }
    private void filterPutusan() {
        view.tampilkanFormFilter();

        int pilih = input.inputInt("Pilih: ");
        var hasil = new java.util.ArrayList<Putusan>();

        switch (pilih) {
            case 1:
                String jenis = input.inputHuruf("Jenis Narkotika: ");
                hasil.addAll(repository.filterByJenisNarkotika(jenis));
                break;
            case 2:
                String pengadilan = input.inputHuruf("Pengadilan: ");
                hasil.addAll(repository.filterByPengadilan(pengadilan));
                break;
            case 3:
                int min = input.inputInt("Min Vonis: ");
                int max = input.inputInt("Max Vonis: ");
                hasil.addAll(repository.filterByRentangVonis(min, max));
                break;
            default:
                view.tampilkanError("Pilihan filter tidak valid");
                return;
        }
        if (hasil.isEmpty()) {
            view.tampilkanError("Data tidak ditemukan");
            return;
        }
        view.tampilkanHasilFilter();
        view.tampilkanHeaderRepository();
        int no = 1;

        for (Putusan p : hasil) {
            view.tampilkanDaftarPutusan(
                    no++,
                    p.getNomorPerkara(),
                    p.getNamaTerdakwa(),
                    p.getJenisNarkotika(),
                    p.getVonisHukuman() + " Bulan",
                    p.getPengadilan()
            );
        }
        view.tampilkanFooterRepository(hasil.size());
        view.tekanEnter();
        input.tekanEnter();
    }
    private void tampilkanStatistik() {
        var data = repository.getDaftarSemua();
        int total = StatistikPutusan.totalPutusan(data);
        double rataVonis = StatistikPutusan.rataRataVonis(data);
        double rataDenda = StatistikPutusan.rataRataDenda(data);
        String jenis = StatistikPutusan.jenisNarkotikaTerbanyak(data);
        view.tampilkanStatistik(total, rataVonis, rataDenda, jenis);
        view.tekanEnter();
        input.tekanEnter();
    }
    private void hapusPutusan() {
        String nomor = input.inputString("Masukkan Nomor Perkara yang akan dihapus: ");
        Putusan data = repository.cariByNomor(nomor);

        if (data == null) {
            view.tampilkanError("Data tidak ditemukan");
            return;
        }
        view.tampilkanKonfirmasiHapus(
                data.getNomorPerkara(),
                data.getNamaTerdakwa()
        );
        repository.hapusByNomor(nomor);

        view.tampilkanSukses("Data berhasil dihapuss");
    }
}
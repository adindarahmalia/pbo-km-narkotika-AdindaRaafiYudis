package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import model.PutusanCsvLoader;
import util.InputHandler;
import util.ExportTxt;
import view.ConsoleView;

public class KnowledgeController {
    private KnowledgeRepository repository;
    private ConsoleView view;
    private InputHandler input;

    public KnowledgeController() {
        repository = new KnowledgeRepository();
        PutusanCsvLoader.loadFromCsv("data/putusan_narkotika.csv", repository);
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
            pilihan = input.validasiPilihan("Masukkan Pilihan: ", 0, 7);
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
                case 7:
                    exportStatistik();
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
        String nomorPerkara = input.validasiString("Nomor Perkara: ");
        String pengadilan = input.inputHuruf("Pengadilan: ");
        String tanggalPutusan = input.validasiString("Tanggal Putusan: ");

        String namaTerdakwa = input.inputHuruf("\nNama Terdakwa: ");
        int umurTerdakwa = input.validasiInt("Umur Terdakwa: ");
        String jenisKelamin = input.inputHuruf("Jenis Kelamin: ");
        String pekerjaan = input.inputHuruf("Pekerjaan: ");

        String jenisNarkotika = input.inputHuruf("\nJenis Narkotika: ");
        double beratBarangBukti = input.validasiDouble("Berat Barang Bukti: ");

        String pasalDilanggar = input.validasiString("\nPasal Dilanggar: ");
        String peranTerdakwa = input.inputHuruf("Peran Terdakwa: ");

        int vonisHukuman = input.validasiInt("\nVonis Hukuman (bulan): ");
        double vonisDenda = input.validasiDouble("Vonis Denda: ");

        String namaHakim = input.inputHuruf("\nNama Hakim: ");

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

        tampilkanTabel(repository.getDaftarSemua());

        pause();
    }
    private void cariPutusan() {

        view.tampilkanFormCari();
        int pilihanCari = input.validasiPilihan("Pilih: ", 1, 2);

        if (pilihanCari == 1) {
            String nomor = input.validasiString("Nomor Perkara: ");
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
            pause();
        } else {
            String nama = input.validasiString("Nama Terdakwa: ");
            var hasil = repository.cariByNama(nama);

            if (hasil.isEmpty()) {
                view.tampilkanError("Data tidak ditemukan");
                return;
            }
            view.tampilkanHasilPencarian();
            tampilkanTabel(hasil);

            pause();
        }
    }
    private void filterPutusan() {
        view.tampilkanFormFilter();

        int pilih = input.validasiPilihan("Pilih: ", 1, 3);
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
                int min = input.validasiInt("Min Vonis: ");
                int max = input.validasiInt("Max Vonis: ");
                hasil.addAll(repository.filterByRentangVonis(min, max));
                break;
        }
        if (hasil.isEmpty()) {
            view.tampilkanError("Data tidak ditemukan");
            return;
        }
        view.tampilkanHasilFilter();
        tampilkanTabel(hasil);

        pause();
    }
    private void tampilkanStatistik() {
        var data = repository.getDaftarSemua();
        int total = StatistikPutusan.totalPutusan(data);
        double rataVonis = StatistikPutusan.rataRataVonis(data);
        double rataDenda = StatistikPutusan.rataRataDenda(data);
        String jenis = StatistikPutusan.jenisNarkotikaTerbanyak(data);
        view.tampilkanStatistik(total, rataVonis, rataDenda, jenis);
        pause();
    }
    private void exportStatistik() {
        StatistikPutusan statistik = new StatistikPutusan(repository.getDaftarSemua());
        ExportTxt.exportStatistik(statistik);
        view.tampilkanSukses("Statistik berhasil diekspor ke output/statistik_putusan.txt");
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

        view.tampilkanSukses("Data berhasil dihapus");
        pause();
    }
    private void tampilkanTabel(java.util.List<Putusan> daftarPutusan) {
        view.tampilkanHeaderRepository();
        int no = 1;

        for(Putusan p : daftarPutusan) {
            view.tampilkanDaftarPutusan(
                    no++,
                    p.getNomorPerkara(),
                    p.getNamaTerdakwa(),
                    p.getJenisNarkotika(),
                    p.getVonisHukuman() + " Bulan",
                    p.getPengadilan()
            );
        }
        view.tampilkanFooterRepository(daftarPutusan.size());
    }
    private void pause() {
        view.tekanEnter();
        input.tekanEnter();
    }
}
package src.view;

public class ConsoleView {
    public void tampilkanDashboard(int totalPutusan, double rataVonis, String jenisTerbanyak) {
        System.out.println();
        System.out.println("=======================================================");
        System.out.println("             KNOWLEDGE MANAGEMENT SYSTEM               ");
        System.out.println("             PUTUSAN PENGADILAN NARKOTIKA              ");
        System.out.println("=======================================================");

        System.out.println();
        System.out.println("          DASHBOARD UTAMA           ");
        System.out.println();

        System.out.printf("Total Putusan         : %d%n", totalPutusan);
        System.out.printf("Rata-rata Vonis       : %.2f Bulan%n", rataVonis);
        System.out.printf("Jenis Terbanyak       : %s%n", jenisTerbanyak);
        System.out.println();
        System.out.println("========================================================");
    }
    public void tampilkanMenu() {
        System.out.println("==================================================");
        System.out.println("       KMS PUTUSAN PENGADILAN NARKOTIKA       ");
        System.out.println("==================================================");
        System.out.println("1. Tambah Putusan");
        System.out.println("2. Tampilkan Semua");
        System.out.println("3. Cari Putusan");
        System.out.println("4. Filter Putusan");
        System.out.println("5. Statistik");
        System.out.println("6. Hapus Putusan");
        System.out.println("0. Keluar");

        System.out.println("\nPilih Menu: ");
    }


        public void tampilkanFormTambah () {
            System.out.println("=================================================");
            System.out.println("               INPUT DATA PUTUSAN                ");
            System.out.println("=================================================");

            System.out.println("\nIDENTITAS PERKARA");
            System.out.println("--------------------------------------------");
            System.out.println("Nomor Putusan          : ");
            System.out.println("Pengadilan             : ");
            System.out.println("Tanggal Putusan        : ");

            System.out.println("\nIDENTITAS TERDAKWA");
            System.out.println("--------------------------------------------");
            System.out.println("Nama Terdakwa          : ");
            System.out.println("Umur                   : ");
            System.out.println("Jenis Kelamin          : ");
            System.out.println("Pekerjaan              : ");

            System.out.println("\nDATA NARKOTIKA");
            System.out.println("--------------------------------------------");
            System.out.println("Jenis Narkotika        : ");
            System.out.println("Berat Barang Bukti     : ");

            System.out.println("\nDATA HUKUM");
            System.out.println("--------------------------------------------");
            System.out.println("Pasal Dilanggar        : ");
            System.out.println("Peran Terdakwa         : ");

            System.out.println("\nVONIS");
            System.out.println("--------------------------------------------");
            System.out.println("Vonis Hukuman          : ");
            System.out.println("Vonis Denda            : ");

            System.out.println("\nHAKIM");
            System.out.println("--------------------------------------------");
            System.out.println("Nama Hakim             : ");

            System.out.println();
            System.out.println("[S] Simpan   [R] Reset   [K] Kembali");
            System.out.println("Pilih: ");
    }

    public void tampilkanHeaderRepository() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("               REPOSITORY PUTUSAN                 ");
        System.out.println("==================================================");

        System.out.println("Cari Cepat : ");
        System.out.println();

        System.out.printf("%-4 %-15 %-20 %-12 %-10 %-15s%n",
                "No",
                "Nomor",
                "Nama",
                "Jenis",
                "Vonis", "Pengadilan");

        System.out.println("------------------------------------------------");
    }

    public void tampilkanFooterRepository(int totalData) {
        System.out.println("----------------------------------------------");
        System.out.println("Total Data : " + totalData);
        System.out.println();
        System.out.println("[ DETAIL ]  [ HAPUS ]  [ REFRESH ]  [ KEMBALI ]");
    }

    public void tampilkanDetailPutusan() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                 DETAIL PUTUSAN                   ");
        System.out.println("==================================================");

        System.out.println("Nomor Putusan          : ");
        System.out.println("Pengadilan             : ");
        System.out.println("Tanggal Putusan        : ");

        System.out.println("Nama Terdakwa          : ");
        System.out.println("Umur                   : ");
        System.out.println("Jenis Kelamin          : ");
        System.out.println("Pekerjaan              : ");

        System.out.println("Jenis Narkotika        : ");
        System.out.println("Berat Barang Bukti     : ");

        System.out.println("Pasal Dilanggar        : ");
        System.out.println("Peran Terdakwa         : ");

        System.out.println("Vonis Hukuman          : ");
        System.out.println("Vonis Denda            : ");

        System.out.println("Nama Hakim             : ");

        System.out.println();
        System.out.println("[ KEMBALI ]");
    }

    public void tampilkanFormCari() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                 PENCARIAN PUTUSAN                ");
        System.out.println("==================================================");

        System.out.println("1. Berdasarkan Nomor Perkara");
        System.out.println("2. Berdasarkan Nama Terdakwa");
        System.out.println("\nPilih : ");
    }
    public void tampilkanFormFilter() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                  FILTER PUTUSAN                  ");
        System.out.println("==================================================");

        System.out.println("Jenis Narkotika        : ");
        System.out.println("Pengadilan             : ");
        System.out.println("Min Vonis              : ");
        System.out.println("Max Vonis              : ");

        System.out.println();
        System.out.println("[ TERAPKAN FILTER ]");
        System.out.println("[ RESET FILTER ]");
    }

    public void tampilkanStatistik(int totalPutusan, double rataVonis, double rataDenda, String jenisTerbanyak) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("            STATISTIK PUTUSAN NARKOTIKA           ");
        System.out.println("==================================================");

        System.out.println("Total Putusan          : " + totalPutusan);
        System.out.println("Rata-rata Vonis        : " + rataVonis + " Bulan");
        System.out.println("Rata-rata Denda        : Rp " + rataDenda);
        System.out.println("Jenis Terbanyak        : " + jenisTerbanyak);

        System.out.println();
        System.out.println("[ KEMBALI ]");
    }

    public void tampilkanKonfirmasiHapus(String nomor, String nama) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                  KONFIRMASI HAPUS                ");
        System.out.println("==================================================");

        System.out.println("Nomor : " + nomor);
        System.out.println("Nama  : " + nama);

        System.out.println();
        System.out.println("Yakin ingin menghapus data ini?");
        System.out.println("[ YA ]    [ TIDAK ]");
    }

    public void tampilkanKonfirmasiKeluar() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                   KELUAR SISTEM                  ");
        System.out.println("==================================================");

        System.out.println("Apakah anda yakin ingin keluar?");
        System.out.println("[ YA ]    [ TIDAK ]");
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
    public void tampilkanError(String pesan) {
        System.out.println("[ ERROR ] " + pesan);
    }
    public void tampilkanSukses(String pesan) {
        System.out.println("[ SUKSES ] " + pesan);
    }

    public void tekanEnter() {
        System.out.println();
        System.out.println("Tekan ENTER untuk kembali...");
    }

}
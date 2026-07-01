package view;

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
        System.out.println("         KMS PUTUSAN PENGADILAN NARKOTIKA         ");
        System.out.println("==================================================");

        System.out.println("1. Tambah Putusan");
        System.out.println("2. Tampilkan Semua Putusan");
        System.out.println("3. Cari Putusan");
        System.out.println("4. Filter Putusan");
        System.out.println("5. Statistik");
        System.out.println("6. Hapus Putusan");
        System.out.println("7. Export Statistik");
        System.out.println("0. Keluar");

        System.out.println();

    }


        public void tampilkanFormTambah () {
            System.out.println();
            System.out.println("=================================================");
            System.out.println("               INPUT DATA PUTUSAN                ");
            System.out.println("=================================================");
            System.out.println();
    }

    public void tampilkanHeaderRepository() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("               REPOSITORY PUTUSAN                 ");
        System.out.println("==================================================");
        System.out.println();

        System.out.printf("%-4s %-15s %-20s %-15s %-10s %-15s%n",
                "No",
                "Nomor",
                "Terdakwa",
                "Narkotika",
                "Vonis", "Pengadilan");

        System.out.println("-----------------------------------------------------------------------------");
    }

    public void tampilkanDaftarPutusan (int no, String nomor, String nama, String narkotika, String vonis, String pengadilan) {
        System.out.printf("%-4d %-15s %-20s %-15s %-10s %-15s%n", no, nomor, nama, narkotika, vonis, pengadilan);
    }

    public void tampilkanFooterRepository(int totalData) {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Total Data : " + totalData);
        System.out.println();
    }

    public void tampilkanDetailPutusan(String nomor, String pengadilan, String tanggal, String nama, String umur, String jenisKelamin, String pekerjaan, String narkotika, String berat, String pasal, String peran, String vonis, String denda, String hakim) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                 DETAIL PUTUSAN                   ");
        System.out.println("==================================================");
        System.out.println();

        System.out.println("Nomor Putusan          : " + nomor);
        System.out.println("Pengadilan             : " + pengadilan);
        System.out.println("Tanggal Putusan        : " + tanggal);

        System.out.println("Nama Terdakwa          : " + nama);
        System.out.println("Umur                   : " + umur);
        System.out.println("Jenis Kelamin          : " + jenisKelamin);
        System.out.println("Pekerjaan              : " + pekerjaan);

        System.out.println("Jenis Narkotika        : " + narkotika);
        System.out.println("Berat Barang Bukti     : " + berat);

        System.out.println("Pasal Dilanggar        : " + pasal);
        System.out.println("Peran Terdakwa         : " + peran);

        System.out.println("Vonis Hukuman          : " + vonis);
        System.out.println("Vonis Denda            : " + denda);

        System.out.println("Nama Hakim             : " + hakim);

        System.out.println();
    }

    public void tampilkanFormCari() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                 PENCARIAN PUTUSAN                ");
        System.out.println("==================================================");
        System.out.println();

        System.out.println("1. Berdasarkan Nomor Perkara");
        System.out.println("2. Berdasarkan Nama Terdakwa");
    }

    public void tampilkanHasilPencarian() {
        System.out.println();
        System.out.println("================== HASIL PENCARIAN =====================");
        System.out.println();
    }
    public void tampilkanFormFilter() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                  FILTER PUTUSAN                  ");
        System.out.println("==================================================");
        System.out.println();

        System.out.println("1.Jenis Narkotika         ");
        System.out.println("2.Pengadilan              ");
        System.out.println("3.Rentang Vonis               ");
    }

    public void tampilkanHasilFilter() {
        System.out.println();
        System.out.println("================== HASIL FILTER =====================");
        System.out.println();
    }

    public void tampilkanStatistik(int totalPutusan, double rataVonis, double rataDenda, String jenisTerbanyak) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("            STATISTIK PUTUSAN NARKOTIKA           ");
        System.out.println("==================================================");
        System.out.println();

        System.out.println("Total Putusan          : " + totalPutusan);
        System.out.println("Rata-rata Vonis        : " + rataVonis + " Bulan");
        System.out.println("Rata-rata Denda        : Rp " + rataDenda);
        System.out.println("Jenis Terbanyak        : " + jenisTerbanyak);

        System.out.println();
    }

    public void tampilkanKonfirmasiHapus(String nomor, String nama) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                  KONFIRMASI HAPUS                ");
        System.out.println("==================================================");
        System.out.println();

        System.out.println("Nomor : " + nomor);
        System.out.println("Nama  : " + nama);

        System.out.println();
        System.out.println("Data putusan yang dipilih akan dihapus.");

        System.out.println();
    }

    public void tampilkanKonfirmasiKeluar() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("                   KELUAR SISTEM                  ");
        System.out.println("==================================================");
        System.out.println();

        System.out.println("Anda akan mengakhiri sesi aplikasi.");


        System.out.println();
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
        System.out.println();
    }

}
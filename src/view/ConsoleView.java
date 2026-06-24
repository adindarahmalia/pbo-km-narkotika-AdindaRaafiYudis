package view;

public class ConsoleView {
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
            System.out.println("======= TAMBAH PUTUSAN =======");
            System.out.println();
            System.out.println("Nomor Putusan          : ");
            System.out.println("Nama Terdakwa          : ");
            System.out.println("Pasal                  : ");
            System.out.println("Tahun                  : ");
            System.out.println("Jenis Narkotika        : ");
            System.out.println("Putusan                : ");

            System.out.println();
            System.out.println("[S] Simpan       [B] Batal");
            System.out.println("Pilih: ");
    }
}
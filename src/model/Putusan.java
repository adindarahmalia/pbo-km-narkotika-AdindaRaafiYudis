package model;

public class Putusan extends DataEntity implements Identifiable {

    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;
    private double vonisDenda;
    private String namaHakim;

    private static int jumlahDibuat = 0;

    // Constructor kosong
    public Putusan() {
        super();
        jumlahDibuat++;
    }

    // Constructor lengkap
    public Putusan(
            String nomorPerkara,
            String pengadilan,
            String tanggalPutusan,
            String namaTerdakwa,
            int umurTerdakwa,
            String jenisNarkotika,
            double beratBarangBukti,
            String pasalDilanggar,
            String peranTerdakwa,
            int vonisHukuman,
            double vonisDenda,
            String namaHakim
    ) {
        super();
        setNomorPerkara(nomorPerkara);
        setPengadilan(pengadilan);
        setTanggalPutusan(tanggalPutusan);
        setNamaTerdakwa(namaTerdakwa);
        setUmurTerdakwa(umurTerdakwa);
        setJenisNarkotika(jenisNarkotika);
        setBeratBarangBukti(beratBarangBukti);
        setPasalDilanggar(pasalDilanggar);
        setPeranTerdakwa(peranTerdakwa);
        setVonisHukuman(vonisHukuman);
        setVonisDenda(vonisDenda);
        setNamaHakim(namaHakim);

        jumlahDibuat++;
    }

    private String validasiString(String nilai, String namaField) {
        if (nilai == null || nilai.trim().isEmpty()) {
            throw new IllegalArgumentException(namaField + " tidak boleh kosong.");
        }
        return nilai.trim();
    }

    @Override
    public String getId() {
        return nomorPerkara;
    }

    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    public String getNomorPerkara() {
        return nomorPerkara;
    }

    public void setNomorPerkara(String nomorPerkara) {
        this.nomorPerkara = validasiString(nomorPerkara, "Nomor perkara");
        touch();
    }

    public String getPengadilan() {
        return pengadilan;
    }

    public void setPengadilan(String pengadilan) {
        this.pengadilan = validasiString(pengadilan, "Pengadilan");
        touch();
    }

    public String getTanggalPutusan() {
        return tanggalPutusan;
    }

    public void setTanggalPutusan(String tanggalPutusan) {
        this.tanggalPutusan = validasiString(tanggalPutusan, "Tanggal putusan");
        touch();
    }

    public String getNamaTerdakwa() {
        return namaTerdakwa;
    }

    public void setNamaTerdakwa(String namaTerdakwa) {
        this.namaTerdakwa = validasiString(namaTerdakwa, "Nama terdakwa");
        touch();
    }

    public int getUmurTerdakwa() {
        return umurTerdakwa;
    }

    public void setUmurTerdakwa(int umurTerdakwa) {
        if (umurTerdakwa <= 0) {
            throw new IllegalArgumentException("Umur terdakwa harus lebih dari 0.");
        }
        this.umurTerdakwa = umurTerdakwa;
        touch();
    }

    public String getJenisNarkotika() {
        return jenisNarkotika;
    }

    public void setJenisNarkotika(String jenisNarkotika) {
        this.jenisNarkotika = validasiString(jenisNarkotika, "Jenis narkotika");
        touch();
    }

    public double getBeratBarangBukti() {
        return beratBarangBukti;
    }

    public void setBeratBarangBukti(double beratBarangBukti) {
        if (beratBarangBukti <= 0) {
            throw new IllegalArgumentException("Berat barang bukti harus lebih dari 0.");
        }
        this.beratBarangBukti = beratBarangBukti;
        touch();
    }

    public String getPasalDilanggar() {
        return pasalDilanggar;
    }

    public void setPasalDilanggar(String pasalDilanggar) {
        this.pasalDilanggar = validasiString(pasalDilanggar, "Pasal dilanggar");
        touch();
    }

    public String getPeranTerdakwa() {
        return peranTerdakwa;
    }

    public void setPeranTerdakwa(String peranTerdakwa) {
        this.peranTerdakwa = validasiString(peranTerdakwa, "Peran terdakwa");
        touch();
    }

    public int getVonisHukuman() {
        return vonisHukuman;
    }

    public void setVonisHukuman(int vonisHukuman) {
        if (vonisHukuman < 0) {
            throw new IllegalArgumentException("Vonis hukuman tidak boleh negatif.");
        }
        this.vonisHukuman = vonisHukuman;
        touch();
    }

    public double getVonisDenda() {
        return vonisDenda;
    }

    public void setVonisDenda(double vonisDenda) {
        if (vonisDenda < 0) {
            throw new IllegalArgumentException("Vonis denda tidak boleh negatif.");
        }
        this.vonisDenda = vonisDenda;
        touch();
    }

    public String getNamaHakim() {
        return namaHakim;
    }

    public void setNamaHakim(String namaHakim) {
        this.namaHakim = validasiString(namaHakim, "Nama hakim");
        touch();
    }


    public void tampilkan() {
        System.out.println(toString());
    }


    public void tampilkan(boolean detail) {
        if (!detail) {
            tampilkan();
            return;
        }

        System.out.println(
                "Nomor Perkara      : " + nomorPerkara + "\n" +
                        "Pengadilan         : " + pengadilan + "\n" +
                        "Tanggal Putusan    : " + tanggalPutusan + "\n" +
                        "Nama Terdakwa      : " + namaTerdakwa + "\n" +
                        "Umur Terdakwa      : " + umurTerdakwa + " tahun\n" +
                        "Jenis Narkotika    : " + jenisNarkotika + "\n" +
                        "Berat Barang Bukti : " + beratBarangBukti + " gram\n" +
                        "Pasal Dilanggar    : " + pasalDilanggar + "\n" +
                        "Peran Terdakwa     : " + peranTerdakwa + "\n" +
                        "Vonis Hukuman      : " + vonisHukuman + " bulan\n" +
                        "Vonis Denda        : Rp" + vonisDenda + "\n" +
                        "Nama Hakim         : " + namaHakim
        );
    }

    @Override
    public String toString() {
        return nomorPerkara + " | " +
                namaTerdakwa + " | " +
                jenisNarkotika + " | " +
                vonisHukuman + " bulan | " +
                pengadilan;
    }
}
package model;

public class Putusan extends DataEntity implements Identifiable {

    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisKelamin;
    private String pekerjaan;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;
    private double vonisDenda;
    private String namaHakim;

    public Putusan(
            String nomorPerkara,
            String pengadilan,
            String tanggalPutusan,
            String namaTerdakwa,
            int umurTerdakwa,
            String jenisKelamin,
            String pekerjaan,
            String jenisNarkotika,
            double beratBarangBukti,
            String pasalDilanggar,
            String peranTerdakwa,
            int vonisHukuman,
            double vonisDenda,
            String namaHakim
    ){
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;

        touch();
    }

    @Override
    public String getId(){
        return nomorPerkara;
    }

    public String getNomorPerkara() {
        return nomorPerkara;
    }
    public String getPengadilan() {
        return pengadilan;
    }
    public String getTanggalPutusan() {
        return tanggalPutusan;
    }
    public String getNamaTerdakwa() {
        return namaTerdakwa;
    }
    public int getUmurTerdakwa() {
        return umurTerdakwa;
    }
    public String getJenisKelamin() {
        return jenisKelamin;
    }
    public String getPekerjaan() {
        return pekerjaan;
    }
    public String getJenisNarkotika() {
        return jenisNarkotika;
    }
    public double getBeratBarangBukti() {
        return beratBarangBukti;
    }
    public String getPasalDilanggar() {
        return pasalDilanggar;
    }
    public String getPeranTerdakwa() {
        return peranTerdakwa;
    }
    public int getVonisHukuman() {
        return vonisHukuman;
    }
    public double getVonisDenda() {
        return vonisDenda;
    }
    public String getNamaHakim() {
        return namaHakim;
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

package model;

public class Putusan extends DataEntity implements Identifiable {

    private String nomorPerkara;
    private String namaTerdakwa;
    private String pasal;
    private int tahun;
    private String jenisNarkotika;
    private String putusan;

    public Putusan(String nomorPerkara, String namaTerdakwa, String pasal, int tahun, String jenisNarkotika, String putusan){
        this.nomorPerkara = nomorPerkara;
        this.namaTerdakwa = namaTerdakwa;
        this.pasal = pasal;
        this.tahun = tahun;
        this.jenisNarkotika = jenisNarkotika;
        this.putusan = putusan;

        touch();
    }

    @Override
    public String getId(){
        return nomorPerkara;
    }

    public String getNomorPerkara(){
        return nomorPerkara;
    }
    public String getNamaTerdakwa(){
        return namaTerdakwa;
    }
    public String getPasal(){
        return pasal;
    }
    public int getTahun(){
        return tahun;
    }
    public String getJenisNarkotika(){
        return jenisNarkotika;
    }
    public String getPutusan(){
        return putusan;
    }

    @Override
    public String toString() {
        return nomorPerkara + " | " +
                namaTerdakwa + " | " +
                pasal + " | " +
                jenisNarkotika + " | " +
                tahun + " | " +
                putusan;
    }
}

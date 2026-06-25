package model;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeRepository {

    private List<Putusan> data = new ArrayList<>();

    public void simpan(Putusan p) {
        data.add(p);
    }

    public boolean hapusByNomor(String nomor) {
        return data.removeIf(p -> p.getNomorPerkara().equalsIgnoreCase(nomor));
    }

    public List<Putusan> getSemuaData() {
        return new ArrayList<>(data);
    }

    public Putusan cariByNomor(String nomor) {
        for (Putusan p : data) {
            if (p.getNomorPerkara().equalsIgnoreCase(nomor)) return p;
        }
        return null;
    }

    public List<Putusan> cariByNama(String nama) {
        List<Putusan> hasil = new ArrayList<>();
        for (Putusan p : data) {
            if (p.getNamaTerdakwa().toLowerCase().contains(nama.toLowerCase())) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public List<Putusan> filterByJenisNarkotika(String jenis) {
        List<Putusan> hasil = new ArrayList<>();
        for (Putusan p : data) {
            if (p.getJenisNarkotika().equalsIgnoreCase(jenis)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public List<Putusan> filterByPengadilan(String pengadilan) {
        List<Putusan> hasil = new ArrayList<>();
        for (Putusan p : data) {
            if (p.getPengadilan().equalsIgnoreCase(pengadilan)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public List<Putusan> filterByRentangVonis(int min, int max) {
        List<Putusan> hasil = new ArrayList<>();
        for (Putusan p : data) {
            if (p.getVonisHukuman() >= min && p.getVonisHukuman() <= max) {
                hasil.add(p);
            }
        }
        return hasil;
    }
}
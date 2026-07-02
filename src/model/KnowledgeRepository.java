package model;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeRepository {

    private List<Putusan> daftarPutusan = new ArrayList<>();



    public void simpan(Putusan p) {
        if (p == null) {
            throw new IllegalArgumentException("Data putusan tidak boleh null.");
        }
        daftarPutusan.add(p);
    }



    public boolean hapus(String nomor) {
        if (nomor == null || nomor.trim().isEmpty()) {
            return false;
        }

        return daftarPutusan.removeIf(p ->
                p.getNomorPerkara().equalsIgnoreCase(nomor.trim())
        );
    }

    public boolean hapusByNomor(String nomor) {
        return hapus(nomor);
    }



    public List<Putusan> getDaftarSemua() {
        return new ArrayList<>(daftarPutusan);
    }

    public int getTotalData() {
        return daftarPutusan.size();
    }




    public Putusan cariByNomor(String nomor) {
        if (nomor == null || nomor.trim().isEmpty()) {
            return null;
        }

        for (Putusan p : daftarPutusan) {
            if (p.getNomorPerkara().equalsIgnoreCase(nomor.trim())) {
                return p;
            }
        }

        return null;
    }

    public List<Putusan> cariByNama(String nama) {
        List<Putusan> hasil = new ArrayList<>();

        if (nama == null || nama.trim().isEmpty()) {
            return hasil;
        }

        for (Putusan p : daftarPutusan) {
            if (p.getNamaTerdakwa().toLowerCase().contains(nama.toLowerCase().trim())) {
                hasil.add(p);
            }
        }

        return hasil;
    }



    public List<Putusan> filterByJenis(String jenis) {
        List<Putusan> hasil = new ArrayList<>();

        if (jenis == null || jenis.trim().isEmpty()) {
            return hasil;
        }

        for (Putusan p : daftarPutusan) {
            if (p.getJenisNarkotika().equalsIgnoreCase(jenis.trim())) {
                hasil.add(p);
            }
        }

        return hasil;
    }

    public List<Putusan> filterByJenisNarkotika(String jenis) {
        return filterByJenis(jenis);
    }

    public List<Putusan> filterByPengadilan(String pengadilan) {
        List<Putusan> hasil = new ArrayList<>();

        if (pengadilan == null || pengadilan.trim().isEmpty()) {
            return hasil;
        }

        for (Putusan p : daftarPutusan) {
            if (p.getPengadilan().equalsIgnoreCase(pengadilan.trim())) {
                hasil.add(p);
            }
        }

        return hasil;
    }

    public List<Putusan> filterByRentangVonis(int min, int max) {
        List<Putusan> hasil = new ArrayList<>();

        if (min > max) {
            return hasil;
        }

        for (Putusan p : daftarPutusan) {
            if (p.getVonisHukuman() >= min && p.getVonisHukuman() <= max) {
                hasil.add(p);
            }
        }
        return hasil;
    }
}
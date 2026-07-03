package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatistikPutusan {

    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private Map<String, Integer> distribusiPeran;
    private Map<String, Integer> distribusiJenisNarkotika;

    public StatistikPutusan(List<Putusan> daftarPutusan) {
        hitungSemua(daftarPutusan);
    }

    public void hitungSemua(List<Putusan> daftarPutusan) {
        List<Putusan> data = daftarPutusan == null ? Collections.emptyList() : daftarPutusan;

        totalPutusan = data.size();
        distribusiPeran = new LinkedHashMap<>();
        distribusiJenisNarkotika = new LinkedHashMap<>();

        if (data.isEmpty()) {
            rataRataVonis = 0;
            rataRataDenda = 0;
            jenisNarkotikaTerbanyak = "-";
            return;
        }

        int totalVonis = 0;
        double totalDenda = 0;

        for (Putusan p : data) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            tambahCounter(distribusiPeran, p.getPeranTerdakwa());
            tambahCounter(distribusiJenisNarkotika, p.getJenisNarkotika());
        }

        rataRataVonis = (double) totalVonis / totalPutusan;
        rataRataDenda = totalDenda / totalPutusan;
        jenisNarkotikaTerbanyak = cariTerbanyak(distribusiJenisNarkotika);
    }

    private static void tambahCounter(Map<String, Integer> map, String key) {
        String cleanKey = normalisasiKey(key);
        map.put(cleanKey, map.getOrDefault(cleanKey, 0) + 1);
    }

    private static String normalisasiKey(String key) {
        if (key == null || key.trim().isEmpty()) {
            return "-";
        }
        return key.trim();
    }

    private static String cariTerbanyak(Map<String, Integer> map) {
        String hasil = "-";
        int max = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                hasil = entry.getKey();
            }
        }

        return hasil;
    }

    public int getTotalPutusan() {
        return totalPutusan;
    }

    public double getRataRataVonis() {
        return rataRataVonis;
    }

    public double getRataRataDenda() {
        return rataRataDenda;
    }

    public String getJenisNarkotikaTerbanyak() {
        return jenisNarkotikaTerbanyak;
    }

    public Map<String, Integer> getDistribusiPeran() {
        return new LinkedHashMap<>(distribusiPeran);
    }

    public Map<String, Integer> getDistribusiJenisNarkotika() {
        return new LinkedHashMap<>(distribusiJenisNarkotika);
    }

    public void tampilkanLaporan() {
        System.out.println("Total Putusan              : " + totalPutusan);
        System.out.println("Rata-rata Vonis            : " + rataRataVonis + " bulan");
        System.out.println("Rata-rata Denda            : Rp" + rataRataDenda);
        System.out.println("Jenis Narkotika Terbanyak  : " + jenisNarkotikaTerbanyak);
        System.out.println("Distribusi Peran           : " + distribusiPeran);
        System.out.println("Distribusi Jenis Narkotika : " + distribusiJenisNarkotika);
    }



    public static int totalPutusan(List<Putusan> data) {
        return new StatistikPutusan(data).getTotalPutusan();
    }

    public static double rataRataVonis(List<Putusan> data) {
        return new StatistikPutusan(data).getRataRataVonis();
    }

    public static double rataRataDenda(List<Putusan> data) {
        return new StatistikPutusan(data).getRataRataDenda();
    }

    public static String jenisNarkotikaTerbanyak(List<Putusan> data) {
        return new StatistikPutusan(data).getJenisNarkotikaTerbanyak();
    }

    public static Map<String, Integer> distribusiPeran(List<Putusan> data) {
        return new StatistikPutusan(data).getDistribusiPeran();
    }

    public static Map<String, Integer> distribusiJenisNarkotika(List<Putusan> data) {
        return new StatistikPutusan(data).getDistribusiJenisNarkotika();
    }
}
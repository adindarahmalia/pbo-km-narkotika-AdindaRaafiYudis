package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatistikPutusan {


    private int totalData;
    private double rataRataTahun;
    private String jenisTerbanyak;

    public StatistikPutusan(List<Putusan> data){
        hitung(data);
    }

    private void hitung(List<Putusan> data){
        totalData = data.size();

        int totalTahun = 0;
        for (Putusan p : data){
            totalTahun += p.getTahun();
        }
        if (totalData == 0) {
            rataRataTahun = 0;
            jenisTerbanyak = "-";
            return;
        }

        Map<String, Integer> counter = new HashMap<>();

        for (Putusan p : data){
            String jenis = p.getJenisNarkotika();
            counter.put(jenis, counter.getOrDefault(jenis, 0) + 1);
        }

        int max = 0;
        String maxJenis = "";

        for (Map.Entry<String, Integer> entry : counter.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
                maxJenis = entry.getKey();
            }
        }
        jenisTerbanyak = maxJenis;
    }

    public int getTotalData(){
        return totalData;
    }

    public double getRataRataTahun() {
        return rataRataTahun;
    }

    public String getJenisTerbanyak() {
        return jenisTerbanyak;
    }

    public void tampilkan() {
        System.out.println("=== STATISTIK PUTUSAN ===");
        System.out.println("Total Data       : " + totalData);
        System.out.println("Rata-rata Tahun  : " + rataRataTahun);
        System.out.println("Jenis Terbanyak  : " + jenisTerbanyak);
    }
}

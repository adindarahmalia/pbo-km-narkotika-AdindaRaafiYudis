package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatistikPutusan {

    public static int totalPutusan(List<Putusan> data) {
        return data.size();
    }

    public static double rataRataVonis(List<Putusan> data) {
        if (data.isEmpty()) return 0;

        int total = 0;
        for (Putusan p : data) {
            total += p.getVonisHukuman();
        }
        return (double) total / data.size();
    }

    public static double rataRataDenda(List<Putusan> data) {
        if (data.isEmpty()) return 0;

        double total = 0;
        for (Putusan p : data) {
            total += p.getVonisDenda();
        }
        return total / data.size();
    }

    public static String jenisTerbanyak(List<Putusan> data) {
        Map<String, Integer> map = new HashMap<>();

        for (Putusan p : data) {
            map.put(p.getJenisNarkotika(),
                    map.getOrDefault(p.getJenisNarkotika(), 0) + 1);
        }

        String maxKey = "-";
        int max = 0;

        for (String k : map.keySet()) {
            if (map.get(k) > max) {
                max = map.get(k);
                maxKey = k;
            }
        }

        return maxKey;
    }
}
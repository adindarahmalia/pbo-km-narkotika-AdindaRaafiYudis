package model;

import java.util.*;

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

    public static String jenisNarkotikaTerbanyak(List<Putusan> data) {
        Map<String, Integer> map = new HashMap<>();

        for (Putusan p : data) {
            map.put(p.getJenisNarkotika(),
                    map.getOrDefault(p.getJenisNarkotika(), 0) + 1);
        }

        String maxKey = "-";
        int max = 0;

        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                maxKey = key;
            }
        }

        return maxKey;
    }

    public static Map<String, Integer> distribusiPeran(List<Putusan> data) {
        Map<String, Integer> map = new HashMap<>();

        for (Putusan p : data) {
            map.put(p.getPeranTerdakwa(),
                    map.getOrDefault(p.getPeranTerdakwa(), 0) + 1);
        }

        return map;
    }
}
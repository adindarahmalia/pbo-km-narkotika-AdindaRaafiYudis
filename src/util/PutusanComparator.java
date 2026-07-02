package util;

import model.Putusan;
import java.util.Comparator;

public class PutusanComparator {
    public static Comparator<Putusan> byNomorPerkara() {
        return Comparator.comparing(Putusan::getNomorPerkara);
    }
    public static Comparator<Putusan> byNamaTerdakwa() {
        return Comparator.comparing(Putusan::getNamaTerdakwa);
    }
    public static Comparator<Putusan> byVonis() {
        return Comparator.comparingInt(Putusan::getVonisHukuman);
    }
    public static Comparator<Putusan> byTanggalPutusan() {
        return Comparator.comparing(Putusan::getTanggalPutusan);
    }
}

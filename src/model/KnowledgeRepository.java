package model;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeRepository {

    private List<Putusan> data = new ArrayList<>();

    public void tambah(Putusan p){
        data.add(p);
    }

    public boolean hapus(String nomorPerkara){
        return data.removeIf(p-> p.getNomorPerkara().equals(nomorPerkara));
    }

    public List<Putusan> cari(String keyword){
        List<Putusan> hasil = new ArrayList<>();

        for (Putusan p : data){
            if (p.getNamaTerdakwa().toLowerCase().contains(keyword.toLowerCase()) || p.getNomorPerkara().toLowerCase().contains(keyword.toLowerCase())){
                hasil.add(p);
            }
        }
        return hasil;
     }

     public List<Putusan> getSemua(){
        return data;
     }
}

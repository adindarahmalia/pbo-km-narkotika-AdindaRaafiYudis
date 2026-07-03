package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PutusanCsvLoader {

    public static void loadFromCsv(String path, KnowledgeRepository repo) {
        int nomorBaris = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = br.readLine()) != null) {
                nomorBaris++;


                if (nomorBaris == 1) {
                    continue;
                }


                if (line.trim().isEmpty()) {
                    continue;
                }


                String[] kolom = line.split(";", -1);

                if (kolom.length != 14) {
                    System.out.println("Baris " + nomorBaris + " tidak valid. Jumlah kolom: " + kolom.length);
                    continue;
                }

                try {
                    Putusan putusan = new Putusan(
                            bersihkan(kolom[0]),                      // nomorPerkara
                            bersihkan(kolom[1]),                      // pengadilan
                            bersihkan(kolom[2]),                      // tanggalPutusan
                            bersihkan(kolom[3]),                      // namaTerdakwa
                            Integer.parseInt(bersihkan(kolom[4])),    // umurTerdakwa
                            bersihkan(kolom[5]),                      // jenisKelamin
                            bersihkan(kolom[6]),                      // pekerjaan
                            bersihkan(kolom[7]),                      // jenisNarkotika
                            Double.parseDouble(bersihkan(kolom[8])),  // beratBarangBukti
                            bersihkan(kolom[9]),                      // pasalDilanggar
                            bersihkan(kolom[10]),                     // peranTerdakwa
                            Integer.parseInt(bersihkan(kolom[11])),   // vonisHukuman
                            Double.parseDouble(bersihkan(kolom[12])), // vonisDenda
                            bersihkan(kolom[13])                      // namaHakim
                    );

                    repo.simpan(putusan);

                } catch (IllegalArgumentException e) {
                    System.out.println("Baris " + nomorBaris + " dilewati: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Gagal membaca file CSV: " + e.getMessage());
        }
    }

    private static String bersihkan(String nilai) {
        return nilai == null ? "" : nilai.trim();
    }
}
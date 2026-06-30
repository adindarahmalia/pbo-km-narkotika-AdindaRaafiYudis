package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PutusanCsvLoader {

    public static void loadFromCsv(String path, KnowledgeRepository repo) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] kolom = line.split(";");

                if (kolom.length != 12) {
                    System.out.println("Data tidak valid, dilewati: " + line);
                    continue;
                }

                Putusan putusan = new Putusan(
                        kolom[0],
                        kolom[1],
                        kolom[2],
                        kolom[3],
                        Integer.parseInt(kolom[4]),
                        kolom[5],
                        Double.parseDouble(kolom[6]),
                        kolom[7],
                        kolom[8],
                        Integer.parseInt(kolom[9]),
                        Double.parseDouble(kolom[10]),
                        kolom[11]
                );

                repo.simpan(putusan);
            }

        } catch (IOException e) {
            System.out.println("Gagal membaca file CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format angka tidak valid: " + e.getMessage());
        }
    }
}
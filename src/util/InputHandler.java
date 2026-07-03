package util;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);
    public String inputString(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong");
        }
    }
    public String inputHuruf(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            if (input.matches("[a-zA-Z\\s\\-\\.]+")) {
                return input;
            }
            System.out.println("Input harus berupa huruf!");
        }
    }
    public int inputInt(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
    public double inputDouble(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka desimal!");
            }
        }
    }
    public int inputPilihan(String pesan, int min, int max) {
        while (true) {
            int pilihan = inputInt(pesan);
            if (pilihan >= min && pilihan <= max) {
                return pilihan;
            }
            System.out.println("Pilihan harus antara " + min + " sampai " + max);
        }
    }
    public String validasiString(String pesan) {
        return inputString(pesan);
    }
    public int validasiInt(String pesan) {
        return inputInt(pesan);
    }
    public double validasiDouble(String pesan) {
        return inputDouble(pesan);
    }
    public int validasiPilihan(String pesan, int min, int max) {
        return inputPilihan(pesan, min, max);
    }

    public void tekanEnter() {
        scanner.nextLine();
    }
}
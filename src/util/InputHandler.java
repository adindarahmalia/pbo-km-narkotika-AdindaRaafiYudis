package util;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);
    public String inputString(String pesan) {
        System.out.println(pesan);
        return scanner.nextLine();
    }
    public int inputInt(String pesan) {
        System.out.println(pesan);
        return Integer.parseInt(scanner.nextLine());
    }
}
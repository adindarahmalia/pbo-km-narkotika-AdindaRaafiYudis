package util;
import java.util.Scanner;

public class InputHandler {
    public static String validasiString(String prompt, Scanner sc) {
        System.out.println(prompt);
        return sc.nextLine();
    }
}
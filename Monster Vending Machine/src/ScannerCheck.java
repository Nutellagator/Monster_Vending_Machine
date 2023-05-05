import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerCheck {
    //Diese Methode prüft, ob ein Int vom Nutzer eingegeben wurde.
    //Wenn nicht, dann wird Neu-Eingabe aufgefordert.
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);

        int num;

        while(true) {
            System.out.print("GIB EINE GANZZAHL EIN: ");

            try {
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Fehler: Sie haben keinen Integer eingegeben. Bitte versuchen Sie es erneut.");
                scanner.nextLine(); // resettet den Scanner quasi

            }
        } return num;

    }

    //Diese Methode prüft, ob ein String vom Nutzer eingegeben wurde.
    //Wenn nicht, dann wird Neu-Eingabe aufgefordert.
    public String getInputString() {
        Scanner sc = new Scanner(System.in);

        System.out.print("EINGABE: ");
        String inputString;

        while (true) {

            inputString = sc.nextLine();

            if (inputString.isEmpty()){
                System.out.print("Bitte Tippe ein [ja] oder [nein]: ");
            }
            else if (inputString.equalsIgnoreCase("ja")) {
                //System.out.println("Deine Eingabe: " + inputString); -> zu Testzwecken
                break;

            } else if (inputString.equalsIgnoreCase("nein")) {
                //System.out.println("Deine Eingabe: " + inputString); -> zu Testzwecken
                break;

            } else {
                System.out.print("Bitte Tippe ein [ja] oder [nein]: ");
            }
        } return inputString;

    }
}

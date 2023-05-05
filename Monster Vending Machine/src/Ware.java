import java.util.Scanner;
import  java.util.Random;

public class Ware {
    Scanner sc = new Scanner(System.in);
    //Waren-Attribute
    private int aktuellerBestand;
    private int wareGewinn;

    public Ware(int aktuellerBestand){
        this.aktuellerBestand = aktuellerBestand;
    }

    public int getAktuellerBestand() {
        return aktuellerBestand;
    }

    public int getWareGewinn() {
        return wareGewinn;
    }

    public void setAktuellerBestand(int aktuellerBestand) {
        this.aktuellerBestand = aktuellerBestand;
    }

    //globale Variablen für die folgenden Methoden
    int kundenkauf; // erzeugt eine zufällige Kundenzahl
    int ueberschuss; // errechnet den Überschuss, wie viel Produkte noch gekauft wären, wenn genügend Vorräte
    int produkteBisNull; // gibt den tatsächlich von Kunden gekauften Wert zurück

    //Warenrechner-Methode
    // errechnet rein nur wie viel an einem Tag von der Kundschaft gekauft wurde
    public int warenRechner() {

        Random rand = new Random();


        kundenkauf = rand.nextInt(300) + 1;

        if (kundenkauf >aktuellerBestand) {
                ueberschuss = kundenkauf - aktuellerBestand;
                produkteBisNull =  kundenkauf -ueberschuss;
                System.out.println("Dein Business läuft zu gut...");
                System.out.println("Dein Automat ist leer gekauft... "+ ueberschuss +" Kunden hätten heute gerne noch etwas an deinem Automaten gekauft.");
                System.out.println("Somit wurden heute "+produkteBisNull+" Produkte gekauft.");
                return aktuellerBestand = 0;
            }else {
                aktuellerBestand = aktuellerBestand - kundenkauf;
                System.out.println("");
                System.out.println(" - Es wurden: " + kundenkauf + " Artikel gekauft. - ");
                System.out.println(" + Es sind noch " + aktuellerBestand + " Artikel verfügbar. + ");
                System.out.println("");
                return aktuellerBestand;
            }
    }
    // Dient der Berechnung des Gewinns nach einem Tag
    // dabei wird unterschieden, ob noch genügend Ware vorhanden oder nicht
    public int warenVerrechnung() {
        if(aktuellerBestand>0) {
            wareGewinn = kundenkauf * 5;   // normale Waren-Verrechnung
        }else {
            wareGewinn = produkteBisNull * 5; // Verrechnet den Rest bis Ware 0 ist
        }return wareGewinn;
    }
}

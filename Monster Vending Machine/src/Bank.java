import java.util.Scanner;
public class Bank {
Scanner sc = new Scanner(System.in);
    //Attribut
    private int guthaben;
    private int kredit;

     public Bank (int guthaben,int kredit){
         this.guthaben = guthaben;
         this.kredit = kredit;
     }
    public int getGuthaben(){
        return guthaben;
    }

    public void setGuthaben(int guthaben) {
        this.guthaben = guthaben;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    //Externe Attribute und Methoden
    ScannerCheck instanzIntCheck = new ScannerCheck();

    public void kreditAufnehmen(){
        System.out.println("--------------------------------");
        System.out.println("  Willkommen im Kredit-Panel");
        System.out.println("");
        System.out.println("Dir stehen folgende Verfügungsrahmen zur Auswahl:");
        System.out.println("[1] 50.000 $ ");
        System.out.println("[2] 5000 $ ");
        System.out.println("[3] 1000 $ ");
        System.out.println("[4] 100 $ ");
        System.out.println("Bitte wähle eine der oben stehende Optionen aus!");
        int kreditOption = instanzIntCheck.getInputInt();
            if(kreditOption == 1){
               kredit = 50000;
            }else if(kreditOption == 2){
                kredit = 5000;
            } else if (kreditOption == 3) {
                kredit = 1000;
            }else if (kreditOption == 4) {
                kredit = 100;
            }else {
                System.out.println("");
                System.out.println("Zum fortsetzen des Spiels, bitte eine Kredit-Option wählen.");
            }
    }
    public void warenKauf(int anzahlWarenKauf){

        //int anzahlWarenKauf = instanzIntCheck.getInputInt();
        int warenVerrechnung;
        System.out.println(" + "+anzahlWarenKauf+" Produkte erfolgreich gekauft.");


        while ( anzahlWarenKauf < 1 || anzahlWarenKauf > 300) {
            System.out.println("");
            System.out.println("Bitte Verwende eine Zahl zwischen 1-300!");
            System.out.println("Zahlen ausgeschrieben sind nicht zulässig!");
            System.out.print("Wie viele Produkte möchtest du einkaufen:");
            anzahlWarenKauf = sc.nextInt();
        }
        warenVerrechnung = anzahlWarenKauf*2;

        while (guthaben < warenVerrechnung) {
            System.out.println("Ihr Guthaben reicht leider nicht für folgenden Kauf aus.");
            System.out.println("Anzahl der Produkte: "+anzahlWarenKauf);
            System.out.println("Kosten hierfür gesamt: "+warenVerrechnung);
            System.out.println("Möchten Sie es probieren...");
            System.out.println("...mit einem Kredit. [1]");
            System.out.println("...mit weniger Produkten. [2]");
            int auswahl = instanzIntCheck.getInputInt();
                if(auswahl == 1){
                    kreditAufnehmen();
                    System.out.println("Ihr kredit aufgeladen auf... "+kredit);
                    guthaben = guthaben + kredit;
                    System.out.println("neues guthaben: "+guthaben);

                }else if(auswahl == 2){
                    System.out.println("");
                    System.out.println("Bitte Verwende eine Zahl zwischen 1-100!");
                    System.out.println("Zahlen ausgeschrieben sind nicht zulässig!");
                    System.out.print("Wie viele Produkte möchtest du einkaufen:");
                    anzahlWarenKauf = sc.nextInt();
                    warenVerrechnung = anzahlWarenKauf*2;

                }

        }
        guthaben = guthaben - warenVerrechnung;
        //return guthaben;
    }

    public void monatlicheRate(){
       int ratenZahlung = (kredit * 25) /100;
        int faelligeZinsen = ((kredit * 20) / 100);
        guthaben = guthaben - faelligeZinsen;
        guthaben = guthaben - faelligeZinsen;
        System.out.println("");
        System.out.println("Für diesen Monat musstest du "+faelligeZinsen+" $ Zinsen bezahlen.");
        System.out.println("Für diesen Monat musstest du "+ratenZahlung+" $ Rate bezahlen.");
        System.out.println("");
    }
    public void reparaturOderNeukaufBezahlen(int auswahlNummer){
        if(auswahlNummer == 1){
            int kostenKauf = 50000;
            while(guthaben<kostenKauf){
                kreditAufnehmen();
                guthaben = guthaben + kredit;
            }   guthaben = guthaben - kostenKauf;

        }else if (auswahlNummer == 2){
            int kostenKauf = 25000;
            while(guthaben<kostenKauf){
                kreditAufnehmen();
                guthaben = guthaben + kredit;
            }   guthaben = guthaben - kostenKauf;
        }
    }
}

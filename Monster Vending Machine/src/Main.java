public class Main {
    public static void main(String[] args) {


        int tag = 28; // globale-Tag Variable die für die Gesamtzahl der Tage des Spiels steht
        //int kreditTage = 0;

        // Warenmenge wird als Startwert auf 100 gesetzt
        Ware warenAttribut = new Ware(100);

        // Automat wird zum Anfang hin auf funktionstüchtig gesetzt und tageInBetrieb sind die Betriebstage des Automates
        Haltbarkeit haltbarkeitAttribut = new Haltbarkeit(true,0);

        // Start-Kapital zum Spielbeginn sind 150 $, Kredit wird dazu addiert, wenn in Anspruch genommen oder subtrahiert bei Rate und Zinsen
        Bank bankAttribut = new Bank(150,0);


        // Zum Prüfen von Nutzereingaben im Scanner
        ScannerCheck instanzIntCheck = new ScannerCheck();
        ScannerCheck instanzStringCheck = new ScannerCheck();



        String userCharakter;


        System.out.println("Gebe die entsprechende Zahl für deinen Charakter ein!");
        System.out.println("1.Blutsauger  ");
        System.out.println("2.Orc  ");
        System.out.println("3.Goblin  ");


        int charInput = instanzIntCheck.getInputInt();
       if (charInput < 1 || charInput >3) {
           System.out.println("Ungültige Eingabe!");
           System.out.println("[1] für Blutsauger");
           System.out.println("[2] für Orc");
           System.out.println("[3] für Goblin");
           charInput = instanzIntCheck.getInputInt();
       }
        if (charInput >=1 && charInput <= 3) {
            switch (charInput) {
                case 1:
                    userCharakter = "Blutsauger";
                    System.out.println("=> Blut ist das was du liebst und dies wissen deine Artgenossen wirklich zu schätzen.");
                    break;
                case 2:
                    userCharakter = "Orc";
                    System.out.println(" => Eine interessante Wahl...Orks sind berüchtigt für Ihren großen Bekannten-Kreis.");
                    break;
                case 3:
                    userCharakter = "Goblin";
                    System.out.println(" => Oh ja...Goblins...Die Meister des Handwerks.Da sollten Störungen für dich nie zu einem Problem werden.");
                    break;
            }
        }

        while(true) {

            //Payday-Zinsen (diese werden bei bestehendem Kredit automatisch abgebucht vom Guthaben)
            if(bankAttribut.getKredit() > 0 && tag == 30) {

                bankAttribut.monatlicheRate();
            }

            //Warenkauf
            if(warenAttribut.getAktuellerBestand() == 0){
                System.out.println("");
                System.out.println("Du musst deinen Automaten wieder befüllen, damit Kunden weiterhin einkaufen können!");
                System.out.println("Dein Automat kann mit maximal 300 Produkten befüllt werden! Gebe somit bitte eine Zahl von 1-300 ein");
                System.out.println("Pro Produkt fallen 2 dollar an.");
                System.out.println("=> Konto Guthaben: "+bankAttribut.getGuthaben()+" $");
                System.out.println("");
                int nummerCheck1 = instanzIntCheck.getInputInt(); // Prüft Eingabe auf Korrektheit
                bankAttribut.warenKauf(nummerCheck1); //Methode zum Kauf von mehr Ware (die Eingabe nummerCheck wird der Methode direkt übergeben)
                warenAttribut.setAktuellerBestand(nummerCheck1); // übergibt die Eingabe nummerCheck, als neuen Warenbestand
            }
            //Wartung durchführen
            if (haltbarkeitAttribut.getTageInBetrieb() == 30) { // wenn der Automat 30 Betriebstage erreicht hat, dann wird dieses statement durchgeführt
                System.out.println("An deinem Automaten könnte, mal wieder eine Wartung durchgeführt werden.");
                System.out.println("Mit einer Wartung verringerst du die Chance, dass dein Automat einen Defekt erleidet. Dies kann kostspielig werden.");
                System.out.println("Dies kann dann kostspielig werde. Möchtest du also für 5000$ dein Gerät warten lassen?");
                System.out.println("Tippe ein [ja] für eine Wartung  oder [nein] für in 30 Tagen nochmal fragen.");
                String jaWartung= instanzStringCheck.getInputString(); // Prüft Eingabe auf Korrektheit
                if (jaWartung.equalsIgnoreCase("ja")) { // prüft, ob eine ja-eingabe = Wartung wird durchgeführt
                    bankAttribut.setGuthaben(bankAttribut.getGuthaben()-6000); // zieht die Kosten der Wartung vom Guthaben ab
                    haltbarkeitAttribut.setTageInBetrieb(16); // setzt Tage in Betrieb wieder auf 16 und somit geringere Chance auf Ausfall der Maschine
                } else {
                    System.out.println("");
                    System.out.println("Sparbrötchen...Na dann mal viel Glück!");
                    System.out.println("");
                }
            }
            //Reparatur oder Neukauf des Automatens
            if (!haltbarkeitAttribut.getFunktionstuechtig()){
                System.out.println(" ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ");
                System.out.println("Ihr Automat ist leider beschädigt.");
                System.out.println("Hierfür wäre eine Reparatur von nöten oder Neukauf.");
                System.out.println("Bitte beachte! Eine Reparatur bedeutet nicht das der Automat wieder wie neu ist.");
                System.out.println("Folgende Auswahlmöglichkeiten haben Sie:");
                System.out.println("Neu-Kauf eines Automatens [1] für 50.000 $");
                System.out.println("Reparatur des Automatens [2] für 25.000 $");
                System.out.println(" ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ");
                int nummerCheck2 = instanzIntCheck.getInputInt(); // Prüft Eingabe auf Korrektheit
                    if(nummerCheck2 == 1){ // Neukauf
                        bankAttribut.reparaturOderNeukaufBezahlen(nummerCheck2);
                        haltbarkeitAttribut.setTageInBetrieb(0); // Tag auf 0, weil neu
                        haltbarkeitAttribut.setFunktionstuechtig(true);
                    }else if (nummerCheck2 == 2){ // Reparatur
                        bankAttribut.reparaturOderNeukaufBezahlen(nummerCheck2);
                        haltbarkeitAttribut.setTageInBetrieb(16); // Tag auf 16, weil wie bei der Wartung nicht ganz neu
                        haltbarkeitAttribut.setFunktionstuechtig(true);
                    }else {
                        continue;
                    }

            }
            System.out.println("---------------------------------------");
            System.out.println(" |   Guthaben derzeit: "+bankAttribut.getGuthaben()+" $");
            System.out.println(" |   Laufender Kredit: "+bankAttribut.getKredit()+" $");
            System.out.println(" |   Der aktueller Warenbestand: "+warenAttribut.getAktuellerBestand());
            System.out.println(" |   Der Automat funktioniert : "+haltbarkeitAttribut.getFunktionstuechtig());
            System.out.println("---------------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.print("----------|Bereit für den Start in einen neuen Tag? ");
            System.out.println("Tippe ein [ja] zum fortsetzen des Spiels oder [nein] zum beenden.|----------");
            String tagesSchleife = instanzStringCheck.getInputString();

            // Vor jedem Beginn eines "neuen Tages" besteht für den User die Möglichkeit, dass Spiel fortzusetzen oder zu beenden
            if (tagesSchleife.equalsIgnoreCase("ja")) {

                // zählt die einzelnen Tage des Monats hoch bis 30 und danach wieder reset auf 0
                tag++;
                if (tag > 30){
                    tag = 1;
                }

                System.out.println("");
                System.out.println("---------------------");
                System.out.println("Heute ist Tag " + tag+" dieses Monats.");
                System.out.println("---------------------");

                // Für aktuellen Warenbestand und Warenkauf
                warenAttribut.warenRechner();

                // Errechnet die Einnahmen
                bankAttribut.setGuthaben(bankAttribut.getGuthaben() + warenAttribut.warenVerrechnung());

                // Erhöht nach aufsteigenden (tageInBetrieb) die Chance auf Defekt
                // außerdem wird ab (tageInBetrieb) = 30 eine Wartung angeboten
                haltbarkeitAttribut.haltbarkeitsRechner();
                System.out.println("");
                System.out.println("-> Dein Gewinn heute: "+warenAttribut.getWareGewinn()+" $ <-");
            } else if (tagesSchleife.equalsIgnoreCase("nein")) {
                break;
            }

        }

    }
}


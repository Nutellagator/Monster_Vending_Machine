import java.util.Random;
import java.util.Scanner;

public class  Haltbarkeit {

    //ATTRIBUT

    private boolean funktionstuechtig;
    private int tageInBetrieb;

    public Haltbarkeit(boolean funktionstuechtig,int tageInBetrieb) {
        this.funktionstuechtig = funktionstuechtig;
        this.tageInBetrieb = tageInBetrieb;
    }

    public void setFunktionstuechtig(boolean funktionstuechtig) {
        this.funktionstuechtig = funktionstuechtig;
    }

    public void setTageInBetrieb(int tageInBetrieb) {
        this.tageInBetrieb = tageInBetrieb;
    }

    public int getTageInBetrieb() {
        return tageInBetrieb;
    }

    public boolean getFunktionstuechtig() {
        return funktionstuechtig;
    }

    //METHODE
    // Die Chance auf Defekt erhöht sich alle 5 Tage
    // Bei defekt ist eine Reparatur fällig
    public void haltbarkeitsRechner() {


        Random random = new Random();


        if (funktionstuechtig) {
        tageInBetrieb++;


            if (tageInBetrieb >= 1 && tageInBetrieb <=5){
                boolean numGenerator = random.nextInt(1,51) == 1;
                if (numGenerator) {
                    funktionstuechtig = false;
                }
            }
            else if (tageInBetrieb >=6 && tageInBetrieb <=10) {
                boolean numGenerator = random.nextInt(1,41) == 1;
                if (numGenerator) {
                    funktionstuechtig = false;
                }
            } else if (tageInBetrieb >=11 && tageInBetrieb <=15) {
                boolean numGenerator = random.nextInt(1,31) == 1;
                if (numGenerator) {
                    funktionstuechtig = false;
                }
            } else if (tageInBetrieb >=16 && tageInBetrieb <=20) {
                boolean numGenerator = random.nextInt(1,21) == 1;
                if (numGenerator) {
                    funktionstuechtig = false;
                }
            } else if (tageInBetrieb >=21 && tageInBetrieb <=25) {
                boolean numGenerator = random.nextInt(1,21) == 1;
                if (numGenerator) {
                    funktionstuechtig = false;
                }
            } else if (tageInBetrieb >=26 && tageInBetrieb <=29) {
                boolean numGenerator = random.nextInt(1,21) == 1;
                if (numGenerator) {
                    funktionstuechtig = false;
                }
            }
              else if (tageInBetrieb > 30) {
                boolean numGenerator = random.nextInt(1,11) == 1;
                if (numGenerator) {
                    funktionstuechtig = false;

                }
            }
        }

    }

}

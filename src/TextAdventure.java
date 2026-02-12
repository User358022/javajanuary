import java.util.Scanner;

    public class TextAdventure {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            boolean spielt = true;
            boolean hatSchluessel = false;
            String raum = "start";

            System.out.println("Willkommen zum Mini Text Adventure!");

            while (spielt) {

                if (raum.equals("start")) {
                    System.out.println("\nDu bist in einem dunklen Raum.");
                    System.out.println("Links ist eine Truhe. Rechts ist eine Tür.");
                    System.out.println("Wohin willst du? (links/rechts)");

                    String eingabe = scan.next();

                    if (eingabe.equals("links")) {
                        raum = "truhe";
                    } else if (eingabe.equals("rechts")) {
                        raum = "tuer";
                    } else {
                        System.out.println("Ungültige Eingabe.");
                    }
                }

                else if (raum.equals("truhe")) {
                    if (!hatSchluessel) {
                        System.out.println("\nDu öffnest die Truhe und findest einen Schlüssel!");
                        hatSchluessel = true;
                    } else {
                        System.out.println("\nDie Truhe ist leer.");
                    }

                    raum = "start";
                }

                else if (raum.equals("tuer")) {
                    if (hatSchluessel) {
                        System.out.println("\nDu öffnest die Tür mit dem Schlüssel.");
                        System.out.println("Du hast gewonnen!");
                        spielt = false;
                    } else {
                        System.out.println("\nDie Tür ist verschlossen. Du brauchst einen Schlüssel.");
                        raum = "start";
                    }
                }
            }

            scan.close();
        }
    }

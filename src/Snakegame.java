import java.awt.Point;
import java.util.Scanner;

public class Snakegame {
    public static void main(String[] args) {
        //objekte und spielfeld erstellen
        Point spielerPosition = new Point(10, 9);
        Point schlangePosition = new Point(30, 2);
        Point goldPosition = new Point(6, 6);
        Point tuerPosition = new Point(2, 5);
        boolean weiter = true;
        boolean goldeingesammelt = false;
        Scanner scan = new Scanner(System.in);

        //10x40
        while (weiter) {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(spielerPosition)) {
                        System.out.print("P");
                    } else if (p.equals(schlangePosition)) {
                        System.out.print("S");
                    } else if (p.equals(goldPosition)) {
                        System.out.print("$");
                    } else if (p.equals(tuerPosition)) {
                        System.out.print("T");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            if (schlangePosition.equals(spielerPosition)) {
                weiter = false;
                System.out.println("game over Peddderr.");
            }
            if (spielerPosition.equals(goldPosition)) {
                goldeingesammelt = true;
                goldPosition = new Point(-1, -1);
            }
            if (spielerPosition.equals(tuerPosition) && goldeingesammelt) {
                weiter = false;
                System.out.println("Gewonnen!!!");
            }
            bewegeSpieler(spielerPosition, scan);
            bewegeSchlange(schlangePosition, spielerPosition);
        }
    }

    private static void bewegeSchlange(Point schlangePosition, Point spielerPosition) {
        if (spielerPosition.x < schlangePosition.x)
            schlangePosition.x--;
        else if (spielerPosition.x > schlangePosition.x)
            schlangePosition.x++;
        if (spielerPosition.y < schlangePosition.y)
            schlangePosition.y--;
        else if (spielerPosition.y > schlangePosition.y)
            schlangePosition.y++;
    }

    private static void bewegeSpieler(Point spielerPosition, Scanner scan) {
        String input = scan.next();

        //w,a,s,d
        if (input.equals("w")) {
            if (spielerPosition.y > 0)
                spielerPosition.y--;
        }else if (input.equals("s")) {
            if (spielerPosition.y < 9)
                spielerPosition.y++;
        }else if (input.equals("a")) {
            if (spielerPosition.x > 0)
                spielerPosition.x--;
        }else if (input.equals("d"))
            if (spielerPosition.x < 39)
                spielerPosition.x++;
        }
    }

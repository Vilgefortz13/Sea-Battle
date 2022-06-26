import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String[][] field = new String[9][9];

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Player ship = new Player();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = " ";
            }
        }

        printField();

        ship.direction(field, 4);
        printField();
    }

    public static void printField() {
        int verticalCoordinates = 1;

        System.out.println("\tA   B   C   D   E   F   G   H   I");
        for (int i = 0; i < field.length; i++) {
            System.out.print(verticalCoordinates + " | ");
            verticalCoordinates++;
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println();
        }
    }

}
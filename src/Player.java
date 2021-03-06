import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int sideX;
    private int sideY;
    private String direction;

    public int sideX() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select horizontal line coordinate: ");
        String direction = tryString(sc, "[a-i]+").toLowerCase();

        switch (direction) {
            case "a":
                return 0;

            case "b":
                return 1;

            case "c":
                return 2;

            case "d":
                return 3;

            case "e":
                return 4;

            case "f":
                return 5;

            case "g":
                return 6;

            case "h":
                return 7;

            case "i":
                return 8;

            default:
                System.out.println();
                break;
        }

        return 0;
    }

    public int createSideY() {
        System.out.print("Select vertical line coordinate: ");
        sideY = getNum() - 1;

        while (sideY < 0 || sideY > 8) {
            System.out.print("Invalid value! Enter from 1 to 9: ");
            sideY = getNum() - 1;
        }

        return sideY;
    }

    public void direction(String[][] arr, int shipLength) {
        Scanner sc = new Scanner(System.in);

        int sideX = sideX();
        int sideY = createSideY();
        while (arr[sideY][sideX].equals("*")) {
            System.out.println("This coordinate is busy. Please choose an another place!");
            sideX = sideX();
            sideY = createSideY();
        }

        System.out.print("""
                Enter the direction of the ship
                  up - w;
                  down - s;
                  right - d;
                  left - a;
                  :  \040""");
        String action = tryString(sc, "[a-z]+").toLowerCase();

        while (!action.equals("w") && !action.equals("s") && !action.equals("d") && !action.equals("a")) {
            System.out.print("Invalid value! Try again: ");
            action = tryString(sc, "[a-z]+").toLowerCase();
        }

        switch (action) {
            case "w" -> {
                for (int i = 0; i < shipLength; i++) {
                    arr[sideY][sideX] = "*";
                    sideY--;
                }
            }
            case "s" -> {
                for (int i = 0; i < shipLength; i++) {
                    arr[sideY][sideX] = "*";
                    sideY++;
                }
            }
            case "d" -> {
                for (int i = 0; i < shipLength; i++) {
                    arr[sideY][sideX] = "*";
                    sideX++;
                }
            }
            case "a" -> {
                for (int i = 0; i < shipLength; i++) {
                    arr[sideY][sideX] = "*";
                    sideX--;
                }
            }
            default -> {
                System.out.println("Invalid direction.");
            }
        }

    }

    private String whilePlaceIsBusy() {
        Scanner sc = new Scanner(System.in);
        String action = tryString(sc, "[a-z]+").toLowerCase();

        while (!action.equals("w") && !action.equals("s") && !action.equals("d") && !action.equals("a")) {
            System.out.print("Invalid value! Try again: ");
            action = tryString(sc, "[a-z]+").toLowerCase();
        }

        return action;
    }

    public int getSideX() {
        return sideX;
    }

    public int getSideY() {
        return sideY;
    }

    public String getDirection() {
        return direction;
    }

    //    Checking for a number instead of a string
    public int getNum() {
        int number = 0;
        try {
            number = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Invalid value. Try again: ");
        }
        return number;
    }

    public String tryString(Scanner sc, String pattern) {
        String str = "";
        while (sc.hasNextLine()) {
            try {

                str = sc.next(pattern);
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value. Enter from 'a' to 'h': ");
                sc.nextLine();
            }
        }

        return str;
    }
}

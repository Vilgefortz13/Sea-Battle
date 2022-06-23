import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private String sideX;
    private int sideY;
    private String direction;

    public int createSideY() {
        System.out.print("Select vertical line coordinate: ");
        sideY = getNum();

        while (sideY < 1 || sideY > 9) {
            System.out.print("Invalid value! Enter from 1 to 9: ");
            sideY = getNum();
        }

        return sideY;
    }

    public String createSideX() {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (sc.hasNextLine()) {
            try {
                str = sc.next("[a-h]+");
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value. Enter from 'a' to 'h': ");
                sc.nextLine();
            }
        }

        return str;
    }

    public String getSideX() {
        return sideX;
    }

    public int getSideY() {
        return sideY;
    }

    public String getDirection() {
        return direction;
    }

//    Checking for a number instead of a string
    private int getNum() {
        int number = 0;
        try {
            number += new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Invalid value. Try again: ");
            getNum();
        }

        return number;
    }
}

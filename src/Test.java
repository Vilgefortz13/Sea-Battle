import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
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

        System.out.println(str);
    }
}

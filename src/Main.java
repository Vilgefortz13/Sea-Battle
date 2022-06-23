public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        String[][] field = new String [9][9];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = " ";
            }
        }

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
import java.util.Scanner;

public class Human extends Player {
    Human(Piece piece) {
        super(piece);
    }

    @Override
    public int[] tryMove() {
        Scanner s = new Scanner(System.in);
        int[] coordinates = new int[2];
        System.out.print("Enter column: ");

        try {
            coordinates[0] = s.nextInt() - 1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invoer moet een getal zijn");
        }

        System.out.print("Enter row: ");
        try {
        coordinates[1] = s.nextInt() - 1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invoer moet een getal zijn");
        }

        return coordinates;
    }
}

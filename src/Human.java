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
        coordinates[0] = s.nextInt() - 1;
        System.out.print("Enter row: ");
        coordinates[1] = s.nextInt() - 1;

        return coordinates;
    }
}

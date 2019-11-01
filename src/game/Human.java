package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {
    public Human(Piece piece) {
        super(piece);
    }

    @Override
    public int[] tryMove() {
        Scanner s = new Scanner(System.in);
        int[] coordinates = new int[2];

        try {
            System.out.print("Enter column: ");
            coordinates[0] = s.nextInt() - 1;

            System.out.print("Enter row: ");
            coordinates[1] = s.nextInt() - 1;

        } catch (InputMismatchException e) {
            System.out.println("Invoer moet een getal zijn");
            coordinates = tryMove();
        }

        return coordinates;
    }
}
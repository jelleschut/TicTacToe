import java.util.Scanner;

public class View {
    private Scanner s;

    View() {
        s = new Scanner(System.in);
    }

    public boolean getYesNo(String question) {
        String answer = "";
        do {
            System.out.print(question + "? (Y/N): ");
            answer = s.next().toLowerCase();
        } while (!answer.equals("y") && !answer.equals("n"));

        return answer.equals("y");
    }

    public void drawScore(Player[] players) {
        for(Player p : players) {
            System.out.print(p.getPiece() + ":" + p.getScore() + "  ");
        }
        System.out.println();
    }

    public void drawBoard(Board board) {
        int size = board.getSize();

        System.out.print(" ");

        for(int i = 0; i < size; i++) {
            System.out.print(" " + (i + 1));
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < size - 1; j++) {
                if(i == size - 1) {
                    System.out.print(board.getPiece(j, i) + "|");
                } else {
                    System.out.print("\u0332" + board.getPiece(j, i) + "|");
                }
            }
            if(i == size - 1) {
                System.out.print(board.getPiece(size - 1, i));
            } else {
                System.out.println("\u0332" + board.getPiece(size - 1, i));
            }
        }
        System.out.println();
    }
}

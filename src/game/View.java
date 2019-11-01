package game;

import java.util.Scanner;

public class View {
    private Scanner s;

    public View() {
        s = new Scanner(System.in);
    }

    public boolean getYesNo(String question) {
        char[] answer;

        do {
            System.out.print(question + "? (Y/N): ");
            answer = s.nextLine().toLowerCase().toCharArray();
        } while (answer[0] != 'y' && answer[0] != 'n');

        return answer[0] == 'y';
    }

    public void drawScore(Player[] players) {
        for (Player p : players) {
            System.out.print(p.getPiece() + ":" + p.getScore() + "  ");
        }
        System.out.println();
    }

    public void drawBoard(Board board) {
        int size = board.getSize();

        System.out.print(" ");

        for (int i = 0; i < size; i++) {
            System.out.print(" " + (i + 1));
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size - 1; j++) {
                if (i == size - 1) {
                    System.out.print(board.getPiece(j, i) + "|");
                } else {
                    System.out.print("\u0332" + board.getPiece(j, i) + "|");
                }
            }
            if (i == size - 1) {
                System.out.print(board.getPiece(size - 1, i));
            } else {
                System.out.println("\u0332" + board.getPiece(size - 1, i));
            }
        }
        System.out.println();
    }


    public String drawBoardWeb(Board board) {
        StringBuilder s = new StringBuilder();

        s.append("<table class=\"tg\"> ");
        for (int i = 0; i < board.getSize(); i++) {
            s.append("<tr> ");
            for (int j = 0; j < board.getSize(); j++) {
                s.append("<th class=\"tg-baqh\">" +
                        "<a href=\"?row=" + i + "&column=" + j + "\"><h1>" + board.getPiece(i, j).toString() + "</h1></a>" +
                        "</th>");
            }
            s.append("</tr>");
        }
        s.append("</table>");

        return s.toString();
    }
}

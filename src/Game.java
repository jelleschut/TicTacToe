public class Game {
    private View view;
    private Board board;
    private Player[] players;
    private boolean simulation;
    private boolean isGameRunning;
    private int activePlayer;

    Game() {
        view = new View();
        board = new Board(3);

        initGame();
        initPlayers();
        startNewGame();
    }

    private void initGame() {
        isGameRunning = view.getYesNo("New Game");
    }

    private void initPlayers() {
        players = new Player[2];

        if (view.getYesNo("Simulate")) {
            players[0] = new AI(Piece.X, board);
            players[1] = new AI(Piece.O, board);
            simulation = true;
        } else {
            players[1] = new AI(Piece.X, board);
            if (view.getYesNo("Human opponent")) {
                players[1] = new Human(Piece.O);
            } else {
                players[1] = new AI(Piece.O, board);
            }
        }
        activePlayer = 0;
    }

    public void startNewGame() {
        while (isGameRunning) {
            do {
                System.out.println(players[activePlayer] + "'s turn");
                view.drawBoard(board);
            } while (!board.setPiece(players[activePlayer].tryMove(), players[activePlayer].getPiece()));

            if (board.isWon() || board.isDraw()) {
                if (board.isWon()) {
                    players[activePlayer].increaseScore();

                    view.drawScore(players);
                    view.drawBoard(board);
                }
                if (simulation) {
                    board.clear();
                } else if (view.getYesNo("New Game")) {
                    board.clear();
                    if (view.getYesNo("Other opponent")) {
                        if (view.getYesNo("Are you sure, this wil reset score")) {
                            initPlayers();
                        }
                    }
                } else {
                    isGameRunning = false;
                }
            }
            endTurn();
        }
    }

    public void endTurn() {
        activePlayer = (++activePlayer) % 2;
    }
}

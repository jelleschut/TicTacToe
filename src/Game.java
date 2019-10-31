public class Game {
    private View view;
    private Board board;
    private Player[] players;
    private boolean simulation;
    private boolean isGameRunning;
    private int activePlayer;
    private final int size = 3;

    Game() {
        view = new View();
        board = new Board(size);

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
            boolean hardMode = view.getYesNo("AI 1 Hard Mode");
            players[0] = new AI(Piece.X, board, hardMode);
            hardMode = view.getYesNo("AI 2 Hard Mode");
            players[1] = new AI(Piece.O, board, hardMode);
            simulation = true;
        } else {
            players[0] = new Human(Piece.X);
            if (view.getYesNo("Human opponent")) {
                players[1] = new Human(Piece.O);
            } else {
                boolean hardMode = view.getYesNo("AI 1 Hard Mode");
                players[1] = new AI(Piece.O, board, hardMode);
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

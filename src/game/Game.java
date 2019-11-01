package game;

public class Game {
    private View view;
    private Board board;
    private Player[] players;
    private boolean simulation;
    private boolean isGameRunning;
    private int activePlayer;
    private final int size = 3;

    public Game() {
        view = new View();
        board = new Board(size);


        initWebPlayers();

        //initGame();
        //initPlayers();
        //startNewGame();
    }

    private void initGame() {
        isGameRunning = view.getYesNo("New Game");
    }

    private void initWebPlayers() {
        players = new Player[2];
        players[0] = new Human(Piece.X);
        players[1] = new Human(Piece.O);
        activePlayer = 0;
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

    private void getInput() throws InvalidMoveException {
        do {
            System.out.println(players[activePlayer] + "'s turn");
            view.drawBoard(board);
        } while (!board.setPiece(players[activePlayer].tryMove(), players[activePlayer].getPiece()));
    }

    private void gameEnd() {
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

    public void startNewGame() {
        while (isGameRunning) {
            try {
                getInput();
            } catch (InvalidMoveException ime) {
                System.out.println(ime);
            }

            if (board.isWon() || board.isDraw()) {
                gameEnd();
            }
            endTurn();
        }
    }

    public String getGameView() {
        return view.drawBoardWeb(board);
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return players[activePlayer];
    }

    public void endTurn() {
        activePlayer = (++activePlayer) % 2;
    }
}
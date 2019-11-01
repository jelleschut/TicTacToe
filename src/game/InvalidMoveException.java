package game;

public class InvalidMoveException extends Exception {
    public InvalidMoveException(String errormessage) {
        super("Kies een coordinaat op het veld\n" + errormessage);
    }
}

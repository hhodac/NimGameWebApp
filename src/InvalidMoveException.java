public class InvalidMoveException extends Exception {
    public InvalidMoveException(int validStone) {
        System.out.println();
        System.out.printf("Invalid move. ");
        System.out.printf("You must remove between 1 and %d stones.\n", validStone);
    }
}

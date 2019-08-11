public class PorkerGameException extends Exception {
    public static final String INVALID_POINT = "Invalid Point!";
    public static final String INVALID_SUIT = "Invalid Suit!";
    public static final String CARDS_NUM_ARE_OVER = "The Number of Cards is Over!";

    public PorkerGameException(String message) {
        super(message);
    }
}

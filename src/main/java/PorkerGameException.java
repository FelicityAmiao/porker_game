public class PorkerGameException extends Exception {
    public static final String INVALID_POINT = "Invalid Point!";
    public static final String INVALID_SUIT = "Invalid Suit!";
    public static final String CARDS_NUM_ARE_OVER = "The Number of Cards is Over!";
    public static final String ONE_POINT_HAS_4_CARDS_AT_MOST = "One Point Has 4 Cards At Most";

    public PorkerGameException(String message) {
        super(message);
    }
}

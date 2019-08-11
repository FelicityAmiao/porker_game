public class PorkerGameException extends Exception{
    public static final String INVALID_POINT = "Invalid Point!";
    public static final String INVALID_SUIT = "Invalid Suit!";

    public PorkerGameException(String message) {
        super(message);
    }
}

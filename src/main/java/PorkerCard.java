import java.util.Objects;

public class PorkerCard {
    private static final String POINT_ORDER = "23456789TJQKA";
    private static final String CARD_SUIT = "CHSD";
    private String point;
    private String suit;

    public PorkerCard(String point, String suit) throws PorkerGameException {
        if (isPointInvalid(point)) {
            throw new PorkerGameException(PorkerGameException.INVALID_POINT);
        }
        if (isSuitInvalid(suit)) {
            throw new PorkerGameException(PorkerGameException.INVALID_SUIT);
        }
        this.point = point;
        this.suit = suit;
    }

    private boolean isSuitInvalid(String suit) {
        return CARD_SUIT.indexOf(suit) == -1? true: false;
    }

    public static boolean isPointInvalid(String point) {
        return getPointOrderIndex(point) == -1 ? true : false;
    }

    public String getPoint() {
        return point;
    }

    public String getSuit() {
        return suit;
    }

    public PorkerCard compare(PorkerCard porkerCard2) {
        if (getPointOrderIndex(this.point) > getPointOrderIndex(porkerCard2.getPoint())) {
            return this;
        } else if (getPointOrderIndex(this.point) < getPointOrderIndex(porkerCard2.getPoint())) {
            return porkerCard2;
        }
        return null;
    }

    public static int getPointOrderIndex(String point) {
        return PorkerCard.POINT_ORDER.indexOf(point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, suit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof PorkerCard)) return false;
        PorkerCard porkerCard = (PorkerCard) obj;
        if (hasNullProperty(porkerCard) || hasNullProperty(this)) return false;
        if (porkerCard.getPoint().equals(this.point)) return true;
        return super.equals(obj);
    }

    private boolean hasNullProperty(PorkerCard porkerCard) {
        return porkerCard.getPoint() == null;
    }
}

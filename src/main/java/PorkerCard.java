import java.util.Objects;

public class PorkerCard {
    private static final String POINT_ORDER = "23456789TJQKA";
    private String point;
    private String suit;

    public PorkerCard(String point, String suit) {
        this.point = point;
        this.suit = suit;
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

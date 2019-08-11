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
        }else if(getPointOrderIndex(this.point) < getPointOrderIndex(porkerCard2.getPoint())) {
            return porkerCard2;
        }
        return null;
    }

    public static int getPointOrderIndex(String point) {
        return PorkerCard.POINT_ORDER.indexOf(point);
    }
}

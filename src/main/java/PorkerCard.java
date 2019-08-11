public class PorkerCard {
    private int point;
    private String suit;
    public PorkerCard(int point, String suit) {
        this.point = point;
        this.suit = suit;
    }

    public int getPoint() {
        return point;
    }

    public String getSuit() {
        return suit;
    }

    public PorkerCard compare(PorkerCard porkerCard2) {
        if(this.point > porkerCard2.getPoint()) {
            return this;
        }
        return porkerCard2;
    }
}

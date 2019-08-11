import java.util.List;

public class Player{
    private int playerNum;
    private List<PorkerCard> porkerCards;

    public Player(int playerNum, List<PorkerCard> porkerCards) {
        this.playerNum = playerNum;
        this.porkerCards = porkerCards;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public List<PorkerCard> getPorkerCards() {
        return porkerCards;
    }

    public Player playWith(Player p2) {
        int p1Point = getMaxPoint();
        int p2Point = p2.getMaxPoint();
        if(p1Point == p2Point) return null;
        return p1Point > p2Point ? this: p2;
    }

    private int getMaxPoint() {
        return porkerCards.stream().reduce(PorkerCard::compare).get().getPoint();
    }
}

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
        PorkerCard p1PorkerCard = getMaxPorkerCard();
        PorkerCard p2PorkerCard = p2.getMaxPorkerCard();
        PorkerCard result = p1PorkerCard.compare(p2PorkerCard);
        return result == null ? null: result == p1PorkerCard? this: p2;
    }

    private PorkerCard getMaxPorkerCard() {
        return porkerCards.stream().reduce(PorkerCard::compare).get();
    }
}

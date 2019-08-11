import java.util.*;

public class Player{
    private int playerNum;
    private List<PorkerCard> porkerCards;
    private int level;

    public Player(int playerNum, List<PorkerCard> porkerCards) {
        this.playerNum = playerNum;
        this.porkerCards = porkerCards;
        this.level = calculateCardsLevel();
    }

    private int calculateCardsLevel() {
        return LevelCaculator.calculateLevelByCards(porkerCards);
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getLevel() {
        return level;
    }

    public Player playWith(Player p2) {
        if(this.level > p2.getLevel()) {
            return this;
        }else if(this.level < p2.level) {
            return p2;
        }
        return compareNormalCards(p2);
    }

    private Player compareNormalCards(Player p2) {
        PorkerCard p1PorkerCard = getMaxPorkerCard();
        PorkerCard p2PorkerCard = p2.getMaxPorkerCard();
        PorkerCard result = p1PorkerCard.compare(p2PorkerCard);
        return result == null ? null: result == p1PorkerCard? this: p2;
    }

    private PorkerCard getMaxPorkerCard() {
        return porkerCards.stream().reduce((porkerCard, porkerCard2) -> {
            return Optional.ofNullable(porkerCard.compare(porkerCard2)).orElse(porkerCard);
        }).get();
    }
}

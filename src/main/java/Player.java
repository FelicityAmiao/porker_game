import java.util.*;

public class Player {
    private int playerNum;
    private List<PorkerCard> porkerCards;
    private LevelCard levelCard;

    public Player(int playerNum, List<PorkerCard> porkerCards) {
        this.playerNum = playerNum;
        this.porkerCards = porkerCards;
        this.levelCard = calculateCardsLevel();
    }

    private LevelCard calculateCardsLevel() {
        return LevelCaculator.getLevelResultsByCards(porkerCards);
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getLevel() {
        return levelCard.getLevelNumber();
    }

    public LevelCard getLevelCard() {
        return levelCard;
    }

    public Player playWith(Player p2) {
        if (this.getLevel() > p2.getLevel()) {
            return this;
        } else if (this.getLevel() < p2.getLevel()) {
            return p2;
        }
        return compareInSameLevel(p2);
    }

    private Player compareInSameLevel(Player p2) {
        int sameLevel = this.getLevel();
        switch (sameLevel) {
            case 1:
            case 3:
                return compareSamePointRepeatedCards(p2);
            case 2:
                return compareTwoPairCards(p2);
            default:
                return compareNormalCards(p2);
        }
    }

    private Player compareTwoPairCards(Player p2) {
        PorkerCard p1MaxCard = getMaxPorkerCard(this.levelCard.getPairCards());
        PorkerCard p2MaxCard = getMaxPorkerCard(p2.getLevelCard().getPairCards());
        PorkerCard result = p1MaxCard.compare(p2MaxCard);
        if(result != null) return getWinerByCardResult(result, p1MaxCard, p2);
        return compareNormalCards(p2);
    }

    private Player compareSamePointRepeatedCards(Player p2) {
        PorkerCard p1PairCard = this.levelCard.getPairCards().get(0);
        PorkerCard result = p1PairCard.compare(p2.getLevelCard().getPairCards().get(0));
        if (result != null) return getWinerByCardResult(result, p1PairCard, p2);
        return compareNormalCards(p2);
    }

    private Player compareNormalCards(Player p2) {
        PorkerCard p1PorkerCard = getMaxPorkerCard(porkerCards);
        PorkerCard p2PorkerCard = p2.getMaxPorkerCard(p2.porkerCards);
        PorkerCard result = p1PorkerCard.compare(p2PorkerCard);
        return getWinerByCardResult(result, p1PorkerCard, p2);
    }

    private Player getWinerByCardResult(PorkerCard result, PorkerCard p1PorkerCard, Player p2) {
        return result == null ? null : result == p1PorkerCard ? this : p2;
    }

    private PorkerCard getMaxPorkerCard(List<PorkerCard> porkerCards) {
        return porkerCards.stream().reduce((porkerCard, porkerCard2) -> {
            return Optional.ofNullable(porkerCard.compare(porkerCard2)).orElse(porkerCard);
        }).get();
    }
}

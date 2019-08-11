import java.util.List;

public class CardLevel {
    private int levelNumber;
    private List<PorkerCard> pairCards;

    public CardLevel(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public CardLevel(int levelNumber, List<PorkerCard> pairCards) {
        this.levelNumber = levelNumber;
        this.pairCards = pairCards;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<PorkerCard> getPairCards() {
        return pairCards;
    }
}

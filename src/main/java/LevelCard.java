import java.util.List;

public class LevelCard {
    private int levelNumber;
    private List<PorkerCard> pairCards;

    public LevelCard(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public LevelCard(int levelNumber, List<PorkerCard> pairCards) {
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

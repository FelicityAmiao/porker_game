import java.util.List;

public class LevelCard {
    private int levelNumber;
    private List<PorkerCard> pairCards;
    private List<PorkerCard> threeCards;

    public LevelCard(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public LevelCard(int levelNumber, List<PorkerCard> pairCards) {
        this.levelNumber = levelNumber;
        this.pairCards = pairCards;
    }

    public LevelCard(int levelNumber, List<PorkerCard> pairCards, List<PorkerCard> threeCards) {
        this.levelNumber = levelNumber;
        this.pairCards = pairCards;
        this.threeCards = threeCards;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<PorkerCard> getPairCards() {
        return pairCards;
    }

    public List<PorkerCard> getThreeCards() {
        return threeCards;
    }
}

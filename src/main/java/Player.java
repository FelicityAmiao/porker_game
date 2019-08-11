import java.util.*;
import java.util.stream.Collectors;

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
        if(porkerCards == null) return 0;
        List<String> points = porkerCards.stream().map(PorkerCard::getPoint).collect(Collectors.toList());
        List<String> repeatedItem = points.stream().filter(item -> Collections.frequency(points, item) == 2).collect(Collectors.toList());
        if(repeatedItem.size() > 0) return 1;
        return 0;
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

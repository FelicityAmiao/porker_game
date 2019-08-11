import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LevelCaculator {
    public static final int NORMAL_CARDS_LEVEL = 0;
    public static final int ONE_PAIR = 1;

    public static CardLevel getLevelResultsByCards(List<PorkerCard> porkerCards) {
        if (porkerCards == null) return new CardLevel(NORMAL_CARDS_LEVEL);
        List<PorkerCard> pairCards = porkerCards.stream().filter(item -> Collections.frequency(porkerCards, item) == 2).collect(Collectors.toList());
        if (pairCards.size() == 2) return new CardLevel(ONE_PAIR, pairCards);
        return new CardLevel(NORMAL_CARDS_LEVEL);
    }
}

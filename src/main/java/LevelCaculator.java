import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LevelCaculator {
    public static final int NORMAL_CARDS_LEVEL = 0;
    public static final int ONE_PAIR = 1;
    private static final int TWO_PAIR = 2;
    private static final int THREE_CARD = 3;

    public static CardLevel getLevelResultsByCards(List<PorkerCard> porkerCards) {
        if (porkerCards == null) return new CardLevel(NORMAL_CARDS_LEVEL);

        List<PorkerCard> pairCards = getRepeatedCardsByTimes(porkerCards, 2);
        if (pairCards.size() == 2) return new CardLevel(ONE_PAIR, pairCards);
        if (pairCards.size() == 4) return new CardLevel(TWO_PAIR, pairCards);

        List<PorkerCard> threeCards = getRepeatedCardsByTimes(porkerCards, 3);
        if (threeCards.size() == 3) return new CardLevel(THREE_CARD, threeCards);

        return new CardLevel(NORMAL_CARDS_LEVEL);
    }

    private static List<PorkerCard> getRepeatedCardsByTimes(List<PorkerCard> porkerCards, int repeatedTimes) {
        return porkerCards.stream().filter(item -> Collections.frequency(porkerCards, item) == repeatedTimes).collect(Collectors.toList());
    }
}

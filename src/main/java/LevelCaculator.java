import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LevelCaculator {
    public static final int NORMAL_CARDS_LEVEL = 0;
    public static final int ONE_PAIR = 1;
    private static final int TWO_PAIR = 2;
    private static final int THREE_CARD = 3;
    private static final int STRAIGHT = 4;
    private static final int SAME_SUIT = 5;
    private static final int THREE_CARD_AND_ONE_PAIR = 6;

    public static LevelCard getLevelResultsByCards(List<PorkerCard> porkerCards) {
        if (porkerCards == null) return new LevelCard(NORMAL_CARDS_LEVEL);

        LevelCard levelCard = getLevelCardByContainsPairsType(porkerCards);
        if (levelCard != null) return levelCard;

        levelCard = getLevelCardByThreeCardsType(porkerCards);
        if (levelCard != null) return levelCard;

        levelCard = getLevelCardByStraightType(porkerCards);
        if (levelCard != null) return levelCard;

        levelCard = getLevelCardBySameSuitType(porkerCards);
        if (levelCard != null) return levelCard;

        return new LevelCard(NORMAL_CARDS_LEVEL);
    }

    private static LevelCard getLevelCardBySameSuitType(List<PorkerCard> porkerCards) {
        List<String> suits = porkerCards.stream().map(PorkerCard::getSuit).collect(Collectors.toList());
        List<String> sameSuitItems = suits.stream().filter(item -> Collections.frequency(suits, item) == 5).collect(Collectors.toList());
        if (sameSuitItems.size() == suits.size()) return new LevelCard(SAME_SUIT);
        return null;
    }

    private static LevelCard getLevelCardByStraightType(List<PorkerCard> porkerCards) {
        List<Integer> indexs = porkerCards.stream().map(item -> PorkerCard.getPointOrderIndex(item.getPoint())).collect(Collectors.toList());
        List<Integer> minusLists = IntStream.range(0, indexs.size() - 1).filter(i -> indexs.get(i + 1) - indexs.get(i) == 1).boxed().collect(Collectors.toList());
        if (indexs.size() - 1 == minusLists.size()) return new LevelCard(STRAIGHT);
        return null;
    }

    private static LevelCard getLevelCardByThreeCardsType(List<PorkerCard> porkerCards) {
        List<PorkerCard> threeCards = getRepeatedCardsByTimes(porkerCards, 3);
        if (threeCards.size() == 3) return new LevelCard(THREE_CARD, null, threeCards);
        return null;
    }

    private static LevelCard getLevelCardByContainsPairsType(List<PorkerCard> porkerCards) {
        List<PorkerCard> pairCards = getRepeatedCardsByTimes(porkerCards, 2);
        if (pairCards.size() == 2) {
            List<PorkerCard> threeCards = getRepeatedCardsByTimes(porkerCards, 3);
            return threeCards.size() == 0 ? new LevelCard(ONE_PAIR, pairCards) : new LevelCard(THREE_CARD_AND_ONE_PAIR, pairCards, threeCards);
        }
        if (pairCards.size() == 4) return new LevelCard(TWO_PAIR, pairCards);
        return null;
    }

    private static List<PorkerCard> getRepeatedCardsByTimes(List<PorkerCard> porkerCards, int repeatedTimes) {
        return porkerCards.stream().filter(item -> Collections.frequency(porkerCards, item) == repeatedTimes).collect(Collectors.toList());
    }
}

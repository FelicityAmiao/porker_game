import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LevelCaculator {
    public static final int NORMAL_CARDS_LEVEL = 0;
    public static final int ONE_PAIR = 1;

    public static int calculateLevelByCards(List<PorkerCard> porkerCards) {
        if (porkerCards == null) return NORMAL_CARDS_LEVEL;
        List<String> points = porkerCards.stream().map(PorkerCard::getPoint).collect(Collectors.toList());
        List<String> repeatedItem = points.stream().filter(item -> Collections.frequency(points, item) == 2).collect(Collectors.toList());
        if (repeatedItem.size() == 2) return ONE_PAIR;
        return NORMAL_CARDS_LEVEL;
    }
}

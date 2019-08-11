import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PorkerGame {
    public static int startGame(List<PorkerCard> totalCards) throws PorkerGameException {
        int totalNum = totalCards.size();
        if (totalNum > 10) throw new PorkerGameException(PorkerGameException.CARDS_NUM_ARE_OVER);
        List<PorkerCard> overRepeatedItems = totalCards.stream().filter(item -> Collections.frequency(totalCards, item) > 4).collect(Collectors.toList());
        if (overRepeatedItems.size() != 0)
            throw new PorkerGameException((PorkerGameException.ONE_POINT_HAS_4_CARDS_AT_MOST));
        Player p1 = new Player(1, totalCards.subList(0, totalNum / 2));
        Player p2 = new Player(2, totalCards.subList(totalNum / 2, totalNum));
        return Optional.ofNullable(p1.playWith(p2)).orElse(new Player(0, null)).getPlayerNum();
    }
}

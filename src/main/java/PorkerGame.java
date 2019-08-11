import java.util.List;
import java.util.Optional;

public class PorkerGame {
    public static int startGame(List<PorkerCard> totalCards) throws PorkerGameException {
        int totalNum = totalCards.size();
        if (totalNum > 10) throw new PorkerGameException(PorkerGameException.CARDS_NUM_ARE_OVER);
        Player p1 = new Player(1, totalCards.subList(0, totalNum / 2));
        Player p2 = new Player(2, totalCards.subList(totalNum / 2, totalNum));
        return Optional.ofNullable(p1.playWith(p2)).orElse(new Player(0, null)).getPlayerNum();
    }
}

import java.util.List;

public class PorkerGame {
    public static int startGame(List<PorkerCard> totalCards) {
        Player p1 = new Player(1, totalCards.get(0));
        Player p2 = new Player(2, totalCards.get(1));
        return p1.playWith(p2).getPlayerNum();
    }
}

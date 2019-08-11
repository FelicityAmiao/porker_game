import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorkerGameTest {
    @Test
    public void should_return_2_given_2_3_cards_with_normal_suit() {

        PorkerCard porkerCard = new PorkerCard(2, "H");
        PorkerCard porkerCard2 = new PorkerCard(3, "H");

        int result = PorkerGame.startGame(Arrays.asList(porkerCard, porkerCard2));

        assertEquals(2, result);
    }

    @Test
    public void should_return_0_given_2_2_cards_with_normal_suit() {

        PorkerCard porkerCard = new PorkerCard(2, "H");
        PorkerCard porkerCard2 = new PorkerCard(2, "D");

        int result = PorkerGame.startGame(Arrays.asList(porkerCard, porkerCard2));

        assertEquals(0, result);
    }

    @Test
    public void should_return_1_given_10_normal_cards_with_normal_suit() {

        List<Integer> points = Arrays.asList(2, 3, 4, 5, 9, 2, 3, 4, 5, 8);
        List<String> suits = Arrays.asList("H", "D", "S", "C", "D", "D", "S", "D", "D", "H");

        ArrayList<PorkerCard> porkerCards = new ArrayList<>();

        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(1, result);
    }
}

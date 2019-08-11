import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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

        PorkerCard porkerCard = new PorkerCard(2, "H");
        PorkerCard porkerCard2 = new PorkerCard(3, "D");
        PorkerCard porkerCard3 = new PorkerCard(4, "S");
        PorkerCard porkerCard4 = new PorkerCard(5, "C");
        PorkerCard porkerCard5 = new PorkerCard(9, "D");
        PorkerCard porkerCard6 = new PorkerCard(2, "D");
        PorkerCard porkerCard7 = new PorkerCard(3, "S");
        PorkerCard porkerCard8 = new PorkerCard(4, "D");
        PorkerCard porkerCard9 = new PorkerCard(5, "D");
        PorkerCard porkerCard10 = new PorkerCard(8, "H");

        int result = PorkerGame.startGame(Arrays.asList(porkerCard, porkerCard2,
                porkerCard3, porkerCard4, porkerCard5, porkerCard6, porkerCard7,
                porkerCard8, porkerCard9, porkerCard10));

        assertEquals(1, result);
    }
}

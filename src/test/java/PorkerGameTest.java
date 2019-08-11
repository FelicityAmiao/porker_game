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
}

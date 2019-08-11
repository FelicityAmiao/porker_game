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

        PorkerCard porkerCard = new PorkerCard("2", "H");
        PorkerCard porkerCard2 = new PorkerCard("3", "H");

        int result = PorkerGame.startGame(Arrays.asList(porkerCard, porkerCard2));

        assertEquals(2, result);
    }

    @Test
    public void should_return_0_given_2_2_cards_with_normal_suit() {

        PorkerCard porkerCard = new PorkerCard("2", "H");
        PorkerCard porkerCard2 = new PorkerCard("2", "D");

        int result = PorkerGame.startGame(Arrays.asList(porkerCard, porkerCard2));

        assertEquals(0, result);
    }

    @Test
    public void should_return_1_given_10_normal_cards_with_normal_suit() {

        List<String> points = Arrays.asList("2", "3", "4", "5", "9", "2", "3", "4", "5", "8");
        List<String> suits = Arrays.asList("H", "D", "S", "C", "D", "D", "S", "D", "D", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for (int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(1, result);
    }

    @Test
    public void should_return_1_given_10_word_point_cards_with_normal_suit() {

        List<String> points = Arrays.asList("2", "3", "4", "T", "A", "2", "3", "J", "Q", "K");
        List<String> suits = Arrays.asList("H", "D", "S", "C", "D", "D", "S", "D", "D", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for (int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(1, result);
    }

    @Test
    public void should_return_2_given_level0_level1_cards_with_normal_suit() {

        List<String> points = Arrays.asList("2", "3", "4", "5", "7", "2", "2", "4", "5", "6");
        List<String> suits = Arrays.asList("H", "D", "S", "C", "D", "D", "S", "D", "D", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for (int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_given_level1_level1_cards_with_normal_suit() {

        List<String> points = Arrays.asList("2", "2", "4", "5", "7", "3", "3", "4", "5", "6");
        List<String> suits = Arrays.asList("H", "D", "S", "C", "D", "D", "S", "D", "D", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for (int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_1_given_same_level1_level1_cards_with_normal_suit() {

        List<String> points = Arrays.asList("2", "2", "4", "5", "7", "2", "2", "4", "5", "6");
        List<String> suits = Arrays.asList("H", "D", "S", "C", "D", "C", "S", "D", "D", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for (int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(1, result);
    }

    @Test
    public void should_return_2_given_level1_level2_cards_with_normal_suit() {

        List<String> points = Arrays.asList("4", "4", "5", "6", "7", "2", "2", "3", "3", "4");
        List<String> suits = Arrays.asList("C", "D", "S", "C", "D", "C", "S", "D", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_1_given_different_level2_cards_with_normal_suit() {

        List<String> points = Arrays.asList("2", "2", "4", "4", "6", "2", "2", "3", "3", "7");
        List<String> suits = Arrays.asList("C", "D", "S", "C", "D", "H", "S", "D", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(1, result);
    }

    @Test
    public void should_return_2_given_same_level2_cards_with_normal_suit() {

        List<String> points = Arrays.asList("2", "2", "3", "3", "4", "2", "2", "3", "3", "5");
        List<String> suits = Arrays.asList("C", "D", "H", "C", "D", "H", "S", "D", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

}

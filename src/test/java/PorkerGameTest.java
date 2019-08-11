import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PorkerGameTest {
    @Test
    public void should_return_2_given_2_3_cards_with_normal_suit() throws PorkerGameException {

        PorkerCard porkerCard = new PorkerCard("2", "H");
        PorkerCard porkerCard2 = new PorkerCard("3", "H");

        int result = PorkerGame.startGame(Arrays.asList(porkerCard, porkerCard2));

        assertEquals(2, result);
    }

    @Test
    public void should_return_0_given_2_2_cards_with_normal_suit() throws PorkerGameException {

        PorkerCard porkerCard = new PorkerCard("2", "H");
        PorkerCard porkerCard2 = new PorkerCard("2", "D");

        int result = PorkerGame.startGame(Arrays.asList(porkerCard, porkerCard2));

        assertEquals(0, result);
    }

    @Test
    public void should_return_1_given_10_normal_cards_with_normal_suit() throws PorkerGameException {

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
    public void should_return_1_given_10_word_point_cards_with_normal_suit() throws PorkerGameException {

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
    public void should_return_2_given_level0_level1_cards_with_normal_suit() throws PorkerGameException {

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
    public void should_return_2_given_level1_level1_cards_with_normal_suit() throws PorkerGameException {

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
    public void should_return_1_given_same_level1_level1_cards_with_normal_suit() throws PorkerGameException {

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
    public void should_return_2_given_level1_level2_cards_with_normal_suit() throws PorkerGameException {

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
    public void should_return_1_given_different_level2_cards_with_normal_suit() throws PorkerGameException {

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
    public void should_return_2_given_same_level2_cards_with_normal_suit() throws PorkerGameException {

        List<String> points = Arrays.asList("2", "2", "3", "3", "4", "2", "2", "3", "3", "5");
        List<String> suits = Arrays.asList("C", "D", "H", "C", "D", "H", "S", "D", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_given_level2_level3_cards_with_normal_suit() throws PorkerGameException {

        List<String> points = Arrays.asList("4", "4", "5", "5", "6", "2", "2", "2", "3", "4");
        List<String> suits = Arrays.asList("C", "D", "H", "C", "D", "H", "S", "D", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_1_given_defferent_level3_cards_with_normal_suit() throws PorkerGameException {

        List<String> points = Arrays.asList("4", "4", "4", "5", "6", "2", "2", "2", "3", "8");
        List<String> suits = Arrays.asList("C", "D", "S", "C", "D", "H", "S", "D", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(1, result);
    }

    @Test
    public void should_return_2_given_level3_level4_cards_with_normal_suit() throws PorkerGameException {

        List<String> points = Arrays.asList("4", "4", "4", "5", "6", "2", "3", "4", "5", "6");
        List<String> suits = Arrays.asList("C", "D", "S", "C", "D", "H", "S", "H", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_given_different_level4_cards_with_normal_suit() throws PorkerGameException {

        List<String> points = Arrays.asList("2", "3", "4", "5", "6", "3", "4", "5", "6", "7");
        List<String> suits = Arrays.asList("C", "D", "S", "C", "D", "H", "D", "H", "S", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_given_level4_level5_cards_with_same_suit() throws PorkerGameException {

        List<String> points = Arrays.asList("5", "6", "7", "8", "9", "2", "3", "5", "6", "8");
        List<String> suits = Arrays.asList("C", "D", "S", "C", "D", "H", "H", "H", "H", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);

        assertEquals(2, result);
    }

    @Test
    public void should_return_1_given_different_level5_cards_with_same_suit() throws PorkerGameException {

        List<String> points = Arrays.asList("2", "3", "5", "6", "9", "2", "3", "5", "6", "8");
        List<String> suits = Arrays.asList("D", "D", "D", "D", "D", "H", "H", "H", "H", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);
        assertEquals(1, result);
    }

    @Test
    public void should_return_2_given_level5_level6_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("2", "3", "5", "6", "9", "4", "4", "4", "7", "7");
        List<String> suits = Arrays.asList("D", "D", "D", "D", "D", "H", "S", "D", "C", "C");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);
        assertEquals(2, result);
    }

    @Test
    public void should_return_1_given_different_level6_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("5", "5", "5", "2", "2", "3", "3", "3", "7", "7");
        List<String> suits = Arrays.asList("D", "H", "S", "D", "C", "H", "C", "D", "C", "S");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);
        assertEquals(1, result);
    }

    @Test
    public void should_return_2_given_level6_level7_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("5", "5", "5", "6", "6", "4", "4", "4", "4", "3");
        List<String> suits = Arrays.asList("D", "S", "C", "D", "H", "H", "C", "S", "D", "C");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);
        assertEquals(2, result);
    }

    @Test
    public void should_return_1_given_different_level7_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("5", "5", "5", "5", "2", "4", "4", "4", "4", "7");
        List<String> suits = Arrays.asList("D", "S", "C", "H", "H", "H", "C", "S", "D", "C");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);
        assertEquals(1, result);
    }

    @Test
    public void should_return_2_given_level7_level8_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("9", "9", "9", "9", "T", "2", "3", "4", "5", "6");
        List<String> suits = Arrays.asList("D", "S", "C", "H", "H", "H", "H", "H", "H", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);
        assertEquals(2, result);
    }

    @Test
    public void should_return_1_given_different_level8_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("3", "4", "5", "6", "7", "2", "3", "4", "5", "6");
        List<String> suits = Arrays.asList("H", "H", "H", "H", "H", "D", "D", "D", "D", "D");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }

        int result = PorkerGame.startGame(porkerCards);
        assertEquals(1, result);
    }

    @Test
    public void should_throw_invalid_point_exception_given_has_F_point_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("2", "3", "4", "5", "F", "3", "4", "5", "6", "9");
        List<String> suits = Arrays.asList("H", "S", "C", "D", "S", "D", "D", "S", "D", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            if(i == 4) {
                assertThrows(PorkerGameException.class, () -> porkerCards.add(new PorkerCard(points.get(4), suits.get(4))));
                continue;
            }
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }
    }

    @Test
    public void should_throw_invalid_suit_exception_given_has_X_suit_cards() throws PorkerGameException {

        List<String> points = Arrays.asList("2", "3", "4", "5", "6", "3", "4", "5", "6", "9");
        List<String> suits = Arrays.asList("H", "S", "C", "D", "X", "D", "D", "S", "D", "H");
        ArrayList<PorkerCard> porkerCards = new ArrayList<>();
        for(int i = 0; i < points.size() && i < suits.size(); i++) {
            if(i == 4) {
                assertThrows(PorkerGameException.class, () -> porkerCards.add(new PorkerCard(points.get(4), suits.get(4))));
                continue;
            }
            porkerCards.add(new PorkerCard(points.get(i), suits.get(i)));
        }
    }

}

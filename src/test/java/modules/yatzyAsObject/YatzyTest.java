package modules.yatzyAsObject;

import modules.yatzyAsObject.domain.entities.Dices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(15, modules.yatzyAsObject.Yatzy.chance(new Dices(2, 3, 4, 5, 1)));
        assertEquals(16, modules.yatzyAsObject.Yatzy.chance(new Dices(3, 3, 4, 5, 1)));
        assertEquals(14, modules.yatzyAsObject.Yatzy.chance(new Dices(1, 1, 3, 3, 6)));
        assertEquals(21, modules.yatzyAsObject.Yatzy.chance(new Dices(4, 5, 5, 6, 1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, modules.yatzyAsObject.Yatzy.yatzy(new Dices(4, 4, 4, 4, 4)));
        assertEquals(50, modules.yatzyAsObject.Yatzy.yatzy(new Dices(6, 6, 6, 6, 6)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.yatzy(new Dices(6, 6, 6, 6, 3)));
        assertEquals(50, modules.yatzyAsObject.Yatzy.yatzy(new Dices(1, 1, 1, 1, 1)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.yatzy(new Dices(1, 1, 1, 2, 1)));
    }

    @Test
    public void ones() {
        assertEquals(1, modules.yatzyAsObject.Yatzy.ones(new Dices(1, 2, 3, 4, 5)));
        assertEquals(2, modules.yatzyAsObject.Yatzy.ones(new Dices(1, 2, 1, 4, 5)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.ones(new Dices(6, 2, 2, 4, 5)));
        assertEquals(4, modules.yatzyAsObject.Yatzy.ones(new Dices(1, 2, 1, 1, 1)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.ones(new Dices(3, 3, 3, 4, 5)));
    }

    @Test
    public void twos() {
        assertEquals(4, modules.yatzyAsObject.Yatzy.twos(new Dices(1, 2, 3, 2, 6)));
        assertEquals(10, modules.yatzyAsObject.Yatzy.twos(new Dices(2, 2, 2, 2, 2)));
        assertEquals(4, modules.yatzyAsObject.Yatzy.twos(new Dices(2, 3, 2, 5, 1)));
    }

    @Test
    public void threes() {
        assertEquals(6, modules.yatzyAsObject.Yatzy.threes(new Dices(1, 2, 3, 2, 3)));
        assertEquals(12, modules.yatzyAsObject.Yatzy.threes(new Dices(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours() {
        assertEquals(12, modules.yatzyAsObject.Yatzy.fours(new Dices(4, 4, 4, 5, 5)));
        assertEquals(8, modules.yatzyAsObject.Yatzy.fours(new Dices(4, 4, 5, 5, 5)));
        assertEquals(4, modules.yatzyAsObject.Yatzy.fours(new Dices(4, 5, 5, 5, 5)));
        assertEquals(8, modules.yatzyAsObject.Yatzy.fours(new Dices(1, 1, 2, 4, 4)));
    }

    @Test
    public void fives() {
        assertEquals(10, modules.yatzyAsObject.Yatzy.fives(new Dices(4, 4, 4, 5, 5)));
        assertEquals(15, modules.yatzyAsObject.Yatzy.fives(new Dices(4, 4, 5, 5, 5)));
        assertEquals(20, modules.yatzyAsObject.Yatzy.fives(new Dices(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixes() {
        assertEquals(0, modules.yatzyAsObject.Yatzy.sixes(new Dices(4, 4, 4, 5, 5)));
        assertEquals(6, modules.yatzyAsObject.Yatzy.sixes(new Dices(4, 4, 6, 5, 5)));
        assertEquals(18, modules.yatzyAsObject.Yatzy.sixes(new Dices(6, 5, 6, 6, 5)));
    }

    @Test
    public void pair() {
        assertEquals(6, modules.yatzyAsObject.Yatzy.pair(new Dices(3, 4, 3, 5, 6)));
        assertEquals(10, modules.yatzyAsObject.Yatzy.pair(new Dices(5, 3, 3, 3, 5)));
        assertEquals(12, modules.yatzyAsObject.Yatzy.pair(new Dices(5, 3, 6, 6, 5)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.pair(new Dices(1, 2, 3, 4, 5)));
        assertEquals(8, modules.yatzyAsObject.Yatzy.pair(new Dices(3, 3, 3, 4, 4)));
        assertEquals(12, modules.yatzyAsObject.Yatzy.pair(new Dices(1, 1, 6, 2, 6)));
        assertEquals(6, modules.yatzyAsObject.Yatzy.pair(new Dices(3, 3, 3, 4, 1)));
        assertEquals(6, modules.yatzyAsObject.Yatzy.pair(new Dices(3, 3, 3, 3, 1)));
    }

    @Test
    public void two_pairs() {
        assertEquals(16, modules.yatzyAsObject.Yatzy.two_pairs(new Dices(3, 3, 5, 4, 5)));
        assertEquals(16, modules.yatzyAsObject.Yatzy.two_pairs(new Dices(3, 3, 5, 5, 5)));
        assertEquals(8, modules.yatzyAsObject.Yatzy.two_pairs(new Dices(1, 1, 2, 3, 3)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.two_pairs(new Dices(1, 1, 2, 3, 4)));
        assertEquals(6, modules.yatzyAsObject.Yatzy.two_pairs(new Dices(1, 1, 2, 2, 2)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.two_pairs(new Dices(3, 3, 3, 3, 1)));
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(3, 3, 3, 4, 5)));
        assertEquals(15, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(5, 3, 5, 4, 5)));
        assertEquals(9, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(3, 3, 3, 3, 5)));
        assertEquals(9, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(3, 3, 3, 3, 3)));
        assertEquals(9, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(3, 3, 3, 4, 5)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(3, 3, 4, 5, 6)));
        assertEquals(9, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(3, 3, 3, 3, 1)));
        assertEquals(9, modules.yatzyAsObject.Yatzy.three_of_a_kind(new Dices(3, 3, 3, 1, 1)));
    }

    @Test
    public void four_of_a_kind() {
        assertEquals(12, modules.yatzyAsObject.Yatzy.four_of_a_kind(new Dices(3, 3, 3, 3, 5)));
        assertEquals(20, modules.yatzyAsObject.Yatzy.four_of_a_kind(new Dices(5, 5, 5, 4, 5)));
        assertEquals(8, modules.yatzyAsObject.Yatzy.four_of_a_kind(new Dices(2, 2, 2, 2, 5)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.four_of_a_kind(new Dices(2, 2, 2, 5, 5)));
        assertEquals(8, modules.yatzyAsObject.Yatzy.four_of_a_kind(new Dices(2, 2, 2, 2, 2)));
    }

    @Test
    public void small_straight() {
        assertEquals(15, modules.yatzyAsObject.Yatzy.smallStraight(new Dices(1, 2, 3, 4, 5)));
        assertEquals(15, modules.yatzyAsObject.Yatzy.smallStraight(new Dices(2, 3, 4, 5, 1)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.smallStraight(new Dices(1, 2, 2, 4, 5)));
    }

    @Test
    public void large_straight() {
        assertEquals(20, modules.yatzyAsObject.Yatzy.largeStraight(new Dices(6, 2, 3, 4, 5)));
        assertEquals(20, modules.yatzyAsObject.Yatzy.largeStraight(new Dices(2, 3, 4, 5, 6)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.largeStraight(new Dices(1, 2, 2, 4, 5)));
    }

    @Test
    public void full_house() {
        assertEquals(18, modules.yatzyAsObject.Yatzy.fullHouse(new Dices(6, 2, 2, 2, 6)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.fullHouse(new Dices(2, 3, 4, 5, 6)));
        assertEquals(8, modules.yatzyAsObject.Yatzy.fullHouse(new Dices(1, 1, 2, 2, 2)));
        assertEquals(0, modules.yatzyAsObject.Yatzy.fullHouse(new Dices(2, 2, 3, 3, 4)));
        assertEquals(0, Yatzy.fullHouse(new Dices(4, 4, 4, 4, 4)));
    }
}
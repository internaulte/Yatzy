package modules.yatzyAsCollection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
        assertEquals(14, Yatzy.chance(1, 1, 3, 3, 6));
        assertEquals(21, Yatzy.chance(4, 5, 5, 6, 1));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
        assertEquals(50, Yatzy.yatzy(1, 1, 1, 1, 1));
        assertEquals(0, Yatzy.yatzy(1, 1, 1, 2, 1));
    }

    @Test
    public void ones() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
        assertEquals(0, Yatzy.ones(3, 3, 3, 4, 5));
    }

    @Test
    public void twos() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
        assertEquals(4, Yatzy.twos(2, 3, 2, 5, 1));
    }

    @Test
    public void threes() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours() {
        assertEquals(12, Yatzy.fours(4, 4, 4, 5, 5));
        assertEquals(8, Yatzy.fours(4, 4, 5, 5, 5));
        assertEquals(4, Yatzy.fours(4, 5, 5, 5, 5));
        assertEquals(8, Yatzy.fours(1, 1, 2, 4, 4));
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void sixes() {
        assertEquals(0, Yatzy.sixes(4, 4, 4, 5, 5));
        assertEquals(6, Yatzy.sixes(4, 4, 6, 5, 5));
        assertEquals(18, Yatzy.sixes(6, 5, 6, 6, 5));
    }

    @Test
    public void pair() {
        assertEquals(6, Yatzy.pair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.pair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.pair(5, 3, 6, 6, 5));
        assertEquals(0, Yatzy.pair(1, 2, 3, 4, 5));
        assertEquals(8, Yatzy.pair(3, 3, 3, 4, 4));
        assertEquals(12, Yatzy.pair(1, 1, 6, 2, 6));
        assertEquals(6, Yatzy.pair(3, 3, 3, 4, 1));
        assertEquals(6, Yatzy.pair(3, 3, 3, 3, 1));
    }

    @Test
    public void two_pairs() {
        assertEquals(16, Yatzy.two_pairs(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.two_pairs(3, 3, 5, 5, 5));
        assertEquals(8, Yatzy.two_pairs(1, 1, 2, 3, 3));
        assertEquals(0, Yatzy.two_pairs(1, 1, 2, 3, 4));
        assertEquals(6, Yatzy.two_pairs(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.two_pairs(3, 3, 3, 3, 1));
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(0, Yatzy.three_of_a_kind(3, 3, 4, 5, 6));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 1));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 1, 1));
    }

    @Test
    public void four_of_a_kind() {
        assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
        assertEquals(8, Yatzy.four_of_a_kind(2, 2, 2, 2, 5));
        assertEquals(0, Yatzy.four_of_a_kind(2, 2, 2, 5, 5));
        assertEquals(8, Yatzy.four_of_a_kind(2, 2, 2, 2, 2));
    }

    @Test
    public void small_straight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void large_straight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void full_house() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
        assertEquals(8, Yatzy.fullHouse(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.fullHouse(2, 2, 3, 3, 4));
        assertEquals(0, Yatzy.fullHouse(4, 4, 4, 4, 4));
    }
}
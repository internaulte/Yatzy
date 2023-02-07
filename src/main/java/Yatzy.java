import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yatzy {

    public static int chance(final int d1, final int d2, final int d3, final int d4, final int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(final int d1, final int d2, final int d3, final int d4, final int d5) {
        boolean isYatzy = IntStream.of(d1, d2, d3, d4).allMatch(value -> value == d5);

        return isYatzy ? 50 : 0;
    }

    public static int ones(final int d1, final int d2, final int d3, final int d4, final int d5) {
        return sumTargetValues(IntStream.of(d1, d2, d3, d4, d5), 1);
    }

    public static int twos(final int d1, final int d2, final int d3, final int d4, final int d5) {
        return sumTargetValues(IntStream.of(d1, d2, d3, d4, d5), 2);
    }

    public static int threes(final int d1, final int d2, final int d3, final int d4, final int d5) {
        return sumTargetValues(IntStream.of(d1, d2, d3, d4, d5), 3);
    }

    public static int fours(final int d1, final int d2, final int d3, final int d4, final int d5) {
        return sumTargetValues(IntStream.of(d1, d2, d3, d4, d5), 4);
    }

    public static int fives(final int d1, final int d2, final int d3, final int d4, final int d5) {
        return sumTargetValues(IntStream.of(d1, d2, d3, d4, d5), 5);
    }

    public static int sixes(final int d1, final int d2, final int d3, final int d4, final int d5) {
        return sumTargetValues(IntStream.of(d1, d2, d3, d4, d5), 6);
    }

    private static int sumTargetValues(@NotNull final IntStream dices, final int targetValue) {
        return dices.reduce(0, (acc, value) -> value == targetValue ? acc + value : acc);
    }

    public static int pair(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final Set<Integer> allItems = new HashSet<>();
        final int maxPairValueOrZero = IntStream.of(d1, d2, d3, d4, d5).filter(n -> !allItems.add(n)).max().orElse(0);

        return maxPairValueOrZero * 2;
    }

    public static int two_pairs(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final Set<Integer> allItems = new HashSet<>();
        final Set<Integer> allPairsValues = IntStream.of(d1, d2, d3, d4, d5).boxed().filter(n -> !allItems.add(n)).collect(Collectors.toSet());

        return allPairsValues.size() == 2 ? allPairsValues.stream().reduce(0, Integer::sum) * 2 : 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[_1 - 1]++;
        tallies[_2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}


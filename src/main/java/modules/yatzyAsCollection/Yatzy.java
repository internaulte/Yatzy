package modules.yatzyAsCollection;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;

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
        final int maxPairValueOrZero = getDuplicatedValues(d1, d2, d3, d4, d5).max().orElse(0);

        return maxPairValueOrZero * 2;
    }

    public static int two_pairs(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final Set<Integer> allPairsValues = getDuplicatedValues(d1, d2, d3, d4, d5).boxed().collect(Collectors.toSet());

        return allPairsValues.size() == 2 ? allPairsValues.stream().reduce(0, Integer::sum) * 2 : 0;
    }

    private static IntStream getDuplicatedValues(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final Set<Integer> allItems = new HashSet<>();

        return IntStream.of(d1, d2, d3, d4, d5).filter(dice -> !allItems.add(dice));
    }

    public static int three_of_a_kind(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final int maxTriplicatedValue = getTriplicatedValues(d1, d2, d3, d4, d5).max().orElse(0);
        return maxTriplicatedValue * 3;
    }

    private static IntStream getTriplicatedValues(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final Set<Integer> allItems = new HashSet<>();
        final Set<Integer> duplicatesItems = new HashSet<>();

        return IntStream.of(d1, d2, d3, d4, d5).filter(dice -> !allItems.add(dice) && !duplicatesItems.add(dice));
    }

    public static int four_of_a_kind(final int d1, final int d2, final int d3, final int d4, final int d5) {
        Map<Integer, Long> frequenceOfValues = IntStream.of(d1, d2, d3, d4, d5).boxed().collect(Collectors.groupingBy(diceValue -> diceValue, counting()));
        int maxValueFourOfKing = frequenceOfValues.entrySet().stream().filter(entry -> entry.getValue() >= 4).map(Map.Entry::getKey).max(Integer::compareTo).orElse(0);

        return maxValueFourOfKing * 4;
    }

    public static int smallStraight(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final Set<Integer> smallStraight = IntStream.of(d1, d2, d3, d4, d5).boxed().collect(Collectors.toUnmodifiableSet());
        return Objects.equals(smallStraight, Set.of(1, 2, 3, 4, 5)) ? 15 : 0;
    }

    public static int largeStraight(final int d1, final int d2, final int d3, final int d4, final int d5) {
        final Set<Integer> smallStraight = IntStream.of(d1, d2, d3, d4, d5).boxed().collect(Collectors.toUnmodifiableSet());
        return Objects.equals(smallStraight, Set.of(2, 3, 4, 5, 6)) ? 20 : 0;
    }

    public static int fullHouse(final int d1, final int d2, final int d3, final int d4, final int d5) {
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


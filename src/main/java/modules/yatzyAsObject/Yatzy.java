package modules.yatzyAsObject;

import modules.yatzyAsObject.domain.entities.Dices;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class Yatzy {
    public static int chance(final @NotNull Dices dices) {
        return ones(dices) + twos(dices) + threes(dices) + fours(dices) + fives(dices) + sixes(dices);
    }

    public static int yatzy(final @NotNull Dices dices) {
        return dices.isYatsy() ? 50 : 0;
    }

    public static int ones(final @NotNull Dices dices) {
        return dices.onesSum();
    }

    public static int twos(final @NotNull Dices dices) {
        return dices.twosSum();
    }

    public static int threes(final @NotNull Dices dices) {
        return dices.threesSum();
    }

    public static int fours(final @NotNull Dices dices) {
        return dices.foursSum();
    }

    public static int fives(final @NotNull Dices dices) {
        return dices.fivesSum();
    }

    public static int sixes(final @NotNull Dices dices) {
        return dices.sixesSum();
    }

    public static int pair(final @NotNull Dices dices) {
        final Integer maxPairValue = dices.getDuplicatesDicesInDescendingOrder(2).findFirst().orElse(0);
        return maxPairValue * 2;
    }

    public static int two_pairs(final @NotNull Dices dices) {
        final Optional<Integer> maxPairValue = dices.getDuplicatesDicesInDescendingOrder(2).findFirst();
        final Optional<Integer> secondMaxPairValue = dices.getDuplicatesDicesInDescendingOrder(2).skip(1).findFirst();

        final Optional<Integer> sumOfTwoPairValue = maxPairValue.flatMap(firstValue ->
                secondMaxPairValue.map(secondValue -> firstValue + secondValue));
        return (sumOfTwoPairValue.orElse(0)) * 2;
    }

    public static int three_of_a_kind(final @NotNull Dices dices) {
        final Integer maxTriplicateValue = dices.getTriplicatesDices().orElse(0);
        return maxTriplicateValue * 3;
    }

    public static int four_of_a_kind(final @NotNull Dices dices) {
        final Integer maxQuadruplicateValue = dices.getQuadruplicatesDices().orElse(0);
        return maxQuadruplicateValue * 4;
    }

    public static int smallStraight(final @NotNull Dices dices) {
        return dices.isSmallStraight() ? 15 : 0;
    }

    public static int largeStraight(final @NotNull Dices dices) {
        return dices.isLargeStraight() ? 20 : 0;
    }

    public static int fullHouse(final @NotNull Dices dices) {
        return dices.isFullHouse() ? chance(dices) : 0;
    }
}

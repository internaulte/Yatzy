package modules.yatzyAsObject.domain.entities;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Dices {
    public final int numberOfOnes;
    public final int numberOfTwos;
    public final int numberOfThrees;
    public final int numberOfFours;
    public final int numberOfFives;
    public final int numberOfSixes;

    private Dices(final int numberOfOnes, final int numberOfTwos, final int numberOfThrees, final int numberOfFours, final int numberOfFives, final int numberOfSixes) {
        this.numberOfOnes = numberOfOnes;
        this.numberOfTwos = numberOfTwos;
        this.numberOfThrees = numberOfThrees;
        this.numberOfFours = numberOfFours;
        this.numberOfFives = numberOfFives;
        this.numberOfSixes = numberOfSixes;
    }

    public Dices(final int d1, final int d2, final int d3, final int d4, final int d5) {
        Map<Integer, Long> numberOfValues = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.groupingBy(diceValue -> diceValue, counting()));

        this.numberOfOnes = numberOfValues.getOrDefault(1, 0L).intValue();
        this.numberOfTwos = numberOfValues.getOrDefault(2, 0L).intValue();
        this.numberOfThrees = numberOfValues.getOrDefault(3, 0L).intValue();
        this.numberOfFours = numberOfValues.getOrDefault(4, 0L).intValue();
        this.numberOfFives = numberOfValues.getOrDefault(5, 0L).intValue();
        this.numberOfSixes = numberOfValues.getOrDefault(6, 0L).intValue();
    }

    public boolean isYatsy() {
        return this.numberOfOnes == 5 || this.numberOfTwos == 5 || this.numberOfThrees == 5 || this.numberOfFours == 5 || this.numberOfFives == 5 || this.numberOfSixes == 5;
    }

    public int onesSum() {
        return this.numberOfOnes;
    }

    public int twosSum() {
        return this.numberOfTwos * 2;
    }

    public int threesSum() {
        return this.numberOfThrees * 3;
    }

    public int foursSum() {
        return this.numberOfFours * 4;
    }

    public int fivesSum() {
        return this.numberOfFives * 5;
    }

    public int sixesSum() {
        return this.numberOfSixes * 6;
    }

    public Stream<Integer> getDuplicatesDicesInDescendingOrder(final int numberOfDuplications) {
        return Stream.of(
                new DiceValueEvents(numberOfOnes, 1),
                new DiceValueEvents(numberOfTwos, 2),
                new DiceValueEvents(numberOfThrees, 3),
                new DiceValueEvents(numberOfFours, 4),
                new DiceValueEvents(numberOfFives, 5),
                new DiceValueEvents(numberOfSixes, 6)
        ).filter(diceEvents -> diceEvents.numberOfEvents > numberOfDuplications - 1
        ).map(diceValueEvents -> diceValueEvents.diceValue).sorted(Comparator.reverseOrder());
    }

    public Optional<Integer> getTriplicatesDices() {
        return getDuplicatesDicesInDescendingOrder(3).findFirst();
    }

    public Optional<Integer> getQuadruplicatesDices() {
        return getDuplicatesDicesInDescendingOrder(4).findFirst();
    }

    public boolean isSmallStraight() {
        return numberOfOnes == 1 && numberOfTwos == 1 && numberOfThrees == 1 && numberOfFours == 1 && numberOfFives == 1;
    }

    public boolean isLargeStraight() {
        return numberOfTwos == 1 && numberOfThrees == 1 && numberOfFours == 1 && numberOfFives == 1 && numberOfSixes == 1;
    }

    public boolean isFullHouse() {
        final Stream<Integer> duplicatesDices = getDuplicatesDicesInDescendingOrder(2);
        final Optional<Integer> maybeThreeOfKindValue = getTriplicatesDices();
        boolean hasPairAndTriplicatesNotEquals = maybeThreeOfKindValue.flatMap(threeOfKind -> duplicatesDices.filter(diceValue -> !Objects.equals(diceValue, threeOfKind)).findFirst()).isPresent();
        boolean isYatsy = isYatsy();
        return hasPairAndTriplicatesNotEquals && !isYatsy;
    }
}

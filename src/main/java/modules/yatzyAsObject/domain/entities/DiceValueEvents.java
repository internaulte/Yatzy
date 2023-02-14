package modules.yatzyAsObject.domain.entities;

public class DiceValueEvents {
    public final int numberOfEvents;
    public final int diceValue;

    public DiceValueEvents(int numberOfEvents, int diceValue) {
        this.numberOfEvents = numberOfEvents;
        this.diceValue = diceValue;
    }
}

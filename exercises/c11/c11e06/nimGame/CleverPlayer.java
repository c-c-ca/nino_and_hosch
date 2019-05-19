package nimGame;

public class CleverPlayer extends IndependentPlayer {

    public CleverPlayer (String name) {
        super(name);
    }

    public void takeTurn (Pile pile, int maxOnATurn) {
        int number = Math.max((
                pile.sticks() - 1) % (maxOnATurn + 1),1);
        pile.remove(number);
        setNumberTaken(number);
    }
}

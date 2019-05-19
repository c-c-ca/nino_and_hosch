package nimGame;

public class GreedyPlayer extends AbstractPlayer
    implements IndependentPlayer {

    public GreedyPlayer (String name) {
        super(name);
    }

    public void takeTurn (Pile pile, int maxOnATurn) {
        int number;
        if (pile.sticks() < maxOnATurn)
            number = pile.sticks();
        else
            number = maxOnATurn;
        pile.remove(number);
        setNumberTaken(number);
    }
}

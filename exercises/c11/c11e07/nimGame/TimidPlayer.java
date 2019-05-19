package nimGame;

public class TimidPlayer extends AbstractPlayer
    implements IndependentPlayer
     {

    public TimidPlayer (String name) {
        super(name);
    }

    public void takeTurn (Pile pile, int maxOnATurn) {
        pile.remove(1);
        setNumberTaken(1);
    }
}

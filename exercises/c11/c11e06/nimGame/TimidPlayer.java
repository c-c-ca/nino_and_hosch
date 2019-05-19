package nimGame;

public class TimidPlayer extends IndependentPlayer {

    public TimidPlayer (String name) {
        super(name);
    }

    public void takeTurn (Pile pile, int maxOnATurn) {
        pile.remove(1);
        setNumberTaken(1);
    }
}

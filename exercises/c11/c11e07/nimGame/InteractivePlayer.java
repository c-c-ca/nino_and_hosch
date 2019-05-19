package nimGame;

public interface InteractivePlayer extends Player {

    public void takeTurn (Pile pile, int maxOnATurn);

    public void setNumberToTake (int number);

    public void register (PlayerObserver controller);

}

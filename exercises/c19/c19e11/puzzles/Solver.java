package puzzles;

import nhUtilities.containers.*;

public interface Solver {

    public boolean solved ();

    public void first ();

    public void next ();

    public boolean canAttack (int r, int c);

    public List<Queen> queens ();
}

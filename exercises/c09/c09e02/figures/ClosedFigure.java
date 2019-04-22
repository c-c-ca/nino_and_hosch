package figures;

/**
 * Models a simple two-dimensional closed figure.
 */
public interface ClosedFigure {

    // Queries:

    /**
     * The area of this ClosedFigure.
     * @ensure     result >= 0
     */
    public int area ();

}

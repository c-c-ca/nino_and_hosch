package date;

interface Comparable {

    /**
     * This Comparable is greater than the specified
     * Comparable other.
     * @require    this.isComparableTo(other)
     */
    public boolean greaterThan (Comparable other);

    /**
     * This Comparable can be compared to the specified
     * Comparable other.
     */
    public boolean isComparableTo (Comparable other);
}

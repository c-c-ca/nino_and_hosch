package cardGame;

/**
 * Models a playing card used in a card game.
 */
public class PlayingCard {

  // Enumerations:

  public enum Suit {clubs, diamonds, hearts, spades}
  public enum Rank {two, three, four, five, six, seven,
    eight, nine, ten, jack, queen, king, ace}

  // Static methods:

  /**
   * PlayingCard c1 is higher than PlayingCard c2.
   */
  public static boolean higherThan (PlayingCard c1, PlayingCard c2) {
      Rank r1, r2;
      Suit s1, s2;
      boolean higherThan;
      r1 = c1.rank();
      r2 = c2.rank();
      s1 = c1.suit();
      s2 = c2.suit();
      if (r1.compareTo(r2) != 0)
        higherThan = r1.compareTo(r2) > 0;
      else if (s1.compareTo(s2) != 0)
        higherThan = s1.compareTo(s2) > 0;
      else // same card
        higherThan = false;
      return higherThan;
  }

  // Private Components:

  private Suit suit;
  private Rank rank;

  // Constructors:

  /**
   * Create a new PlayingCard with the specified suit and rank.
   * @require    suit == PlayingCard.Suit.clubs || suit == PlayingCard.Suit.diamonds ||
   *             suit == PlayingCard.Suit.hearts || suit == PlayingCard.Suit.spades
   *             rank == PlayingCard.Rank.two || rank == PlayingCard.Rank.three ||
   *             rank == PlayingCard.Rank.four || rank == PlayingCard.Rank.five ||
   *             rank == PlayingCard.Rank.six || rank == PlayingCard.Rank.seven ||
   *             rank == PlayingCard.Rank.eight || rank == PlayingCard.Rank.nine ||
   *             rank == PlayingCard.Rank.ten || rank == PlayingCard.Rank.jack ||
   *             rank == PlayingCard.Rank.queen || rank == PlayingCard.Rank.king ||
   *             rank == PlayingCard.Rank.ace
   * @ensure     this.suit() == suit && this.rank() == rank
   */
  public PlayingCard (Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  // Queries:

  /**
   * The suit of this PlayingCard.
   * @ensure     result == Suit.clubs || result == Suit.diamonds ||
   *             result == Suit.hearts || result == Suit.spades
   */
  public Suit suit () {
    return suit;
  }

  /**
   * The rank of this PlayingCard.
   * @ensure     result == Rank.two || result == Rank.three ||
   *             result == Rank.four || result == Rank.five ||
   *             result == Rank.six || result == Rank.seven ||
   *             result == Rank.eight || result == Rank.nine ||
   *             result == Rank.ten || result == Rank.jack ||
   *             result == Rank.queen || result == Rank.king ||
   *             result == Rank.ace
   */
  public Rank rank () {
    return rank;
  }

  /**
   * String representation of this PlayingCard.
   */
  public String toString () {
      return rank + " of " + suit;
  }

}

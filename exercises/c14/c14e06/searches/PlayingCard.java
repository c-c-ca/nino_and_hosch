package searches;

/**
 * Models a playing card used in a card game.
 */
public class PlayingCard
    implements Comparable<PlayingCard> {

  /**
   * The club suit.
   */
  public static final int CLUB = 1;

  /**
   * The heart suit.
   */
  public static final int DIAMOND = 2;

  /**
   * The diamond suit.
   */
  public static final int HEART = 3;

  /**
   * The spade suit.
   */
  public static final int SPADE = 4;

  /**
   * The ace rank.
   */
  public static final int ACE = 14;

  /**
   * The jack rank.
   */
  public static final int JACK = 11;

  /**
   * The queen rank.
   */
  public static final int QUEEN = 12;

  /**
   * The king rank.
   */
  public static final int KING = 13;

  private int suit;
  private int rank;

  /**
   * Create a new PlayingCard with the specified suit and rank.
   * @require    suit == PlayingCard.CLUB || suit == PlayingCard.DIAMOND ||
   *             suit == PlayingCard.HEART || suit == PlayingCard.SPADE
   *             2 <= rank && rank <= 10 || rank == PlayingCard.ACE ||
   *             rank == PlayingCard.JACK || rank == PlayingCard.QUEEN ||
   *             rank == PlayingCard.KING
   * @ensure     this.suit() == suit && this.rank() == rank
   */
  public PlayingCard (int suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  /**
   * The suit of this PlayingCard.
   * @ensure     result == PlayingCard.CLUB || result == PlayingCard.DIAMOND ||
   *             result == PlayingCard.HEART || result == PlayingCard.SPADE
   */
  public int suit () {
    return suit;
  }

  /**
   * The rank of this PlayingCard.
   * @ensure     2 <= result && result <= 10 || result == PlayingCard.ACE ||
   *             result == PlayingCard.JACK || result == PlayingCard.QUEEN ||
   *             result == PlayingCard.KING
   */
  public int rank () {
    return rank;
  }

  public boolean equals (Object other) {
      if (other instanceof PlayingCard) {
          return this.rank == ((PlayingCard)other).rank &&
            this.suit == ((PlayingCard)other).suit;
      } else
        return false;
  }

  public int compareTo (PlayingCard other) {
      if (this.equals(other))
        return 0;
      else if ((this.rank < other.rank) ||
        (this.rank == other.rank &&
            this.suit < other.suit))
        return -1;
      else
        return 1;
  }

  /**
   * String representation of this PlayingCard.
   */
  public String toString () {
      String[] faces = {"Jack", "Queen", "King", "Ace"};
      String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
      String rankStr;
      if (rank == JACK || rank == QUEEN ||
          rank == KING || rank == ACE)
        rankStr = faces[rank-JACK];
      else
        rankStr = "" + rank;
      return rankStr + " of " + suits[suit-1];
  }

}

package cardGame;

/**
 * Models a playing card used in a card game.
 */
public class PlayingCard {

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
  public static final int ACE = 1;

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

}

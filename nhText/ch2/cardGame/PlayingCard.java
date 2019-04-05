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
   * suit must be one of PlayingCard.CLUB, PlayingCard.DIAMOND, PlayingCard.HEART,
   * or PlayingCard.SPADE.
   * rank must be PlayingCard.ACE, PlayingCard.JACK, PlayingCard.QUEEN,
   * PlayingCard.KING, or a value from 2 through 10.
   */
  public PlayingCard (int suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }
 
  /**
   * The suit of this PlayingCard.
   * Returns PlayingCard.CLUB, PlayingCard.DIAMOND, PlayingCard.HEART, or
   * PlayingCard.SPADE.
   */
  public int suit () {
    return suit;
  }
  
  /**
   * The rank of this PlayingCard.
   * Returns PlayingCard.ACE, PlayingCard.JACK, PlayingCard.QUEEN, PlayingCard.KING,
   * or a value from 2 through 10.
   */
  public int rank () {
    return rank;
  }
  
}

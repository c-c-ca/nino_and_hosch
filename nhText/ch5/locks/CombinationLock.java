package ch5.locks;

/**
 * Models a lock with an integer combination.
 */
public class CombinationLock {

  private int combination;     // combination open the lock
  private boolean isOpen;      // the lock is unlocked

  /**
   * Create a lock with the specified combination.
   * @require    0 <= combination && combination <= 999
   * @ensure     this.isOpen()
   */
  public CombinationLock (int combination) {
    assert 0 <= combination && combination <= 999;
    this.combination = combination;
    this.isOpen = true;
  }

  /**
   * This CombinationLock is unlocked.
   */
  public boolean isOpen () {
    return isOpen;
  }

  /**
   * Lock this CombinationLock.
   */
  public void close () {
    isOpen = false;
  }

  /**
   * Unlock this CombinationLock if the correct combination is provided.
   */
  public void open (int combinationToTry) {
    if (this.combination == combinationToTry)
      isOpen = true;
  }
}


package ch6.clocks;

/**
 * Models a 12-hour clock for display.
 * Needs a client to invoke increment() every second.
 */
public class TwelveHourClock {
  private int hours;      // invariant: 1 <= hours && hours <= 12
  private int minutes;    // invariant: 0 <= minuites && minuites <= 59
  private int seconds;    // invariant: 0 <= seconds && seconds <= 59
  private boolean isAM;   // time represented is from midnight (inclusive) to before noon.
                          // Though technically 12 A.M. and 12 P.M. have no meaning, midnight is
                          // represented as 12 A.M. and noon as 12 P.M.

  /**
   * Create a new clock initialized to the given hours, minutes, seconds, and am value.
   * If isAM is true, the time is taken to be from midnight (inclusive) to before noon.
   * Though technically 12 A.M. and 12 P.M. have no meaning, midnight is considered 12 A.M.
   * and noon 12 P.M.
   * @require    1 <= hours && hours <= 12 &&
   *             0 <= minutes && minuites <= 59 &&
   *             0 <= seconds && seconds <= 59
   * @ensure     this.hours() == hours && this.minutes() == minutes && this.seconds() == seconds &&
   *             this.isAM() == isAM
   */
  public TwelveHourClock (int hours, int minutes, int seconds, boolean isAM) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    this.isAM    = isAM;
  }

  /**
   * This Clock's seconds.
   * @ensure     0 <= this.seconds() && this.seconds() <= 59
   */
  public int seconds () {
    return seconds;
  }

  /**
   * This Clock's minutes.
   * @ensure     0 <= this.minutes() && this.minutes() <= 59
   */
  public int minutes () {
    return minutes;
  }

  /**
   * This Clock's hours.
   * @ensure     1 <= this.hours() && this.hours() <= 12
   */
  public int hours () {
    return hours;
  }

  /**
   * This Clock's time is from midnight (inclusive) to before noon.
   * Though technically 12 A.M. and 12 P.M. have no meaning, midnight is considered 12 A.M.
   * and noon 12 P.M.
   */
  public boolean isAM () {
    return isAM;
  }

  /**
   * Increment seconds by 1. If seconds is 59, reset to 0.
   * Minuites or hours are not affected.
   */ 
  public void incrementSeconds () {
    if (seconds < 59)
      seconds = seconds + 1;
    else
      seconds = 0;
  }

  /**
   * Increment minuites by 1. If minuites is 59, reset to 0.
   * Seconds or hours are not affected.
   */ 
  public void incrementMinutes(){
    if (minutes < 59)
      minutes = minutes + 1;
    else
      minutes = 0;
  }

  /**
   * Increment hours by 1. If hours is 12, reset to 1.
   * Seconds, minuites, or isAM are not affected.
   */ 
  public void incrementHours(){
    if (hours < 12)
      hours = hours + 1;
    else
      hours = 1;
  }
  
  /**
   * Increment this Clock by 1 second. Minuites, hours, isAm updated as needed.
   */
  public void increment () {
  }

  /**
   * A String representation of the this Clock's time.
   */
  public String toString(){
    return hours + ":" + 
      (minutes < 10 ? "0" : "") + minutes  + ":" + 
      (seconds < 10 ? "0" : "") + seconds  + " " + 
      (isAM ? "A.M." : "P.M.");
  }
}

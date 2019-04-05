package clocks;

/**
 * Models a 24-hour clock for display.
 * Needs a client to invoke increment() every second.
 */
public class TwentyFourHourClock {
  private int hours;      // invariant: 0 <= hours && hours <= 23
  private int minutes;    // invariant: 0 <= minuites && minuites <= 59
  private int seconds;    // invariant: 0 <= seconds && seconds <= 59

  /**
   * Create a new clock initialized to the given hours, minutes, seconds.
   * @require    0 <= hours && hours <= 23 &&
   *             0 <= minutes && minuites <= 59 &&
   *             0 <= seconds && seconds <= 59
   * @ensure     this.hours() == hours && this.minutes() == minutes && this.seconds() == seconds
   */
  public TwentyFourHourClock (int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
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
   * @ensure     0 <= this.hours() && this.hours() <= 23
   */
  public int hours () {
    return hours;
  }

  /**
   * Increment seconds by 1. If seconds is 59, reset to 0.
   * Minutes or hours are not affected.
   */ 
  public void incrementSeconds () {
  }

  /**
   * Increment minuites by 1. If minuites is 59, reset to 0.
   * Seconds or hours are not affected.
   */ 
  public void incrementMinutes(){
  }

  /**
   * Increment hours by 1. If hours is 23, reset to 0.
   * Seconds or minutes are not affected.
   */ 
  public void incrementHours(){
  }
  
  /**
   * Increment this Clock by 1 second. Minuites and hours updated as needed.
   */
  public void increment () {
  }

  /**
   * A String representation of the this Clock's time.
   */
  public String toString(){
    return (hours < 10 ? "0" : "") + hours + ":" + 
      (minutes < 10 ? "0" : "") + minutes  + ":" + 
      (seconds < 10 ? "0" : "") + seconds;
  }
}

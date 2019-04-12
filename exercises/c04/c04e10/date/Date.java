package date;

/**
 * A recent date in the Gregorian calendar.
 */
public class Date {

  // Private components:

  private final int day;      // day of the month
  private final int month;    // month
  private final int year;     // year

  // Static methods:

  /**
   * Arguments day, month, year represent a legal calendar date.
   */
  public static boolean isLegalDate (int day, int month, int year) {
      return true;
  }

  // Constructors:

  /**
   * Create a new Date.
   * @require    year > 1762 &&
   *             Date.isLegalDate(day,month,year)
   */
  public Date (int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  // Queries:

  /**
   * The day of this Date.
   */
  public int day () {
    return day;
  }

  /**
   * The month of this Date.
   */
  public int month () {
    return month;
  }

  /**
   * The year of this Date.
   */
  public int year () {
    return year;
  }

  /**
   * This Date occurs in a leap year.
   */
  public boolean isLeapYear () {
    boolean aLeapYear;
    if (year % 4 == 0)
      if (year % 100 == 0)
        // if divisible by 100,
        // must also be divisible by 400
        aLeapYear = (year % 400 == 0);
      else // divisible by 4, not by 100
        aLeapYear = true;
    else // not divisible by 4
      aLeapYear = false;
    return aLeapYear;
  }

  /**
   * The next Date that follows this Date in the
   * Gregorian calendar.
   */
  public Date nextDate () {
    int day, month, year;
    if (isLastDayOfYear()) {
      year = this.year + 1;
      month = 1;
      day = 1;
    } else
       if (isLastDayOfMonth()) {
          year = this.year;
          month = this.month + 1;
          day = 1;
       } else {
          year = this.year;
          month = this.month;
          day = this.day + 1;
       }
    return new Date(day,month,year);
  }

  /**
   * This Date is the last day of a year;
   * i.e., 31 December.
   */
  private boolean isLastDayOfYear () {
      return (month == 12) && (day == 31);
  }

  /**
   * This Date is the last day of a month.
   */
  public boolean isLastDayOfMonth () {
    boolean lastDayOfMonth;
    if (is30DayMonth())
      lastDayOfMonth = day == 30;
    else if (month == 2)
      if (isLeapYear())
        lastDayOfMonth = day == 29;
      else
        lastDayOfMonth = day == 28;
    else // it's a 31 day month
      lastDayOfMonth = day == 31;
    return lastDayOfMonth;
  }

  /**
   * This Date occurs in a month with 30 days.
   */
  private boolean is30DayMonth () {
      return month == 4 || month == 6 || month == 9 ||
         month == 11;
  }

  /**
   * A String representation of this Date.
   */
  public String toString () {
    return  day + " " + monthToString() + " " + year;
  }

  /**
   * Representation of month as a String.
   */
  private String monthToString () {
    switch (month) {
      case 1: return "JAN";
      case 2: return "FEB";
      case 3: return "MAR";
      case 4: return "APR";
      case 5: return "MAY";
      case 6: return "JUN";
      case 7: return "JUL";
      case 8: return "AUG";
      case 9: return "SEP";
      case 10: return "OCT";
      case 11: return "NOV";
      case 12: return "DEC";
      default: return ""; // to keep the compiler happy; should throw exception
    }
  }
}

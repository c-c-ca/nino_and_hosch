package date;

/**
 * A recent date in the Gregorian calendar.
 */
public class Date {

  // Named constants:

  public static final int MONDAY = 0;
  public static final int TUESDAY = 1;
  public static final int WEDNESDAY = 2;
  public static final int THURSDAY = 3;
  public static final int FRIDAY = 4;
  public static final int SATURDAY = 5;
  public static final int SUNDAY = 6;

  // Private components:

  private final int day;      // day of the month
  private final int month;    // month
  private final int year;     // year

  // Static methods:

  /**
   * Arguments day, month, year represent a legal calendar date.
   */
  public static boolean isLegalDate (int day, int month, int year) {
      boolean legalDate;
      if (year > 1762)
        if (1 <= month && month <= 12)
            if (Date.is30DayMonth(month))
              legalDate = 1 <= day && day <= 30;
            else if (month == 2)
              if (Date.isLeapYear(year))
                legalDate = 1 <= day && day <= 29;
              else
                legalDate = 1 <= day && day <= 28;
            else  // it's a 31 day month
              legalDate = 1 <= day && day <= 31;
        else
          legalDate = false;
      else
        legalDate = false;
      return legalDate;
  }

  /**
   * The specified month has 30 days.
   * @require    1 <= month && month <= 12
   */
  private static boolean is30DayMonth (int month) {
      return month == 4 || month == 6 || month == 9 ||
         month == 11;
  }

  /**
   * The specified year is a leap year.
   */
  private static boolean isLeapYear (int year) {
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
   * The specified Date is the last day of a month.
   */
  private static boolean isLastDayOfMonth (int day, int month, int year) {
    boolean lastDayOfMonth;
    if (Date.is30DayMonth(month))
      lastDayOfMonth = day == 30;
    else if (month == 2)
      if (Date.isLeapYear(year))
        lastDayOfMonth = day == 29;
      else
        lastDayOfMonth = day == 28;
    else // it's a 31 day month
      lastDayOfMonth = day == 31;
    return lastDayOfMonth;
  }

  // Constructors:

  /**
   * Create a new Date.
   * @require    year > 1762 &&
   *             Date.isLegalDate(day,month,year)
   */
  public Date (int day, int month, int year) {
    assert year > 1762 :
        "precondition: year (" + year + ") > 1762";
    assert Date.isLegalDate(day,month,year) :
        "precondition: Date.isLegalDate(day (" + day +
        "), month (" + month + "), year (" + year + "))";
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
   * Returns the day of the week for the specified day and year.
   * @require    year > 1762
   *             Date.isLeapYear(year) ? 1 <= day && day <= 366 :
   *                1 <= day && day <= 365
   * @ensure     result == Date.MONDAY || result == Date.TUESDAY ||
   *             result == Date.WEDNESDAY || result == Date.THURSDAY ||
   *             result == Date.FRIDAY || result == Date.SATURDAY ||
   *             result == Date.SUNDAY
   */
  public int dayOfWeek (int day, int year) { return 0; }

  /**
   * The Date following this Date.
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
  private boolean isLastDayOfMonth () {
    return Date.isLastDayOfMonth(day, month, year);
  }

  /**
   * This Date occurs in a leap year.
   */
  public boolean isLeapYear () {
    return Date.isLeapYear(year);
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

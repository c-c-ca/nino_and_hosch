package date;

/**
 * A recent date in the Gregorian calendar.
 */
public class Date {

  private final int day;      // day of the month
  private final int month;    // month
  private final int year;     // year

  /**
   * Create a new Date.
   * Arguments day, month, year must represent
   * a legal calendar date. year must be > 1752.
   */
  public Date (int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
   
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


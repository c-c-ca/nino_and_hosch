package date;

public class Date {

    // Named constants:

    // minimum year for a Date
    private static final int MIN_YEAR = 1763;
    // The month of January
    private static final int JAN = 1;
    // The month of February
    private static final int FEB = 2;
    // The month of December
    private static final int DEC = 12;

    private static final int[] daysInMonth =
        {0,31,28,31,30,31,30,31,31,30,31,30,31};

    private static final int[] daysBeforeMonth = new int[13];

    static {
        daysBeforeMonth[JAN] = 0;
        for (int m = JAN; m < DEC; m = m+1) {
            daysBeforeMonth[m+1] =
                daysBeforeMonth[m] + daysInMonth[m];
        }
    }

    // Static methods:

    /**
     * Arguments day, month, year represent a calendar date.
     */
    public static boolean isLegalDate (
        int day, int month, int year) {
        int maxDay;    // maximum day in the month
        boolean isLegal;
        if (year >= MIN_YEAR &&
            JAN <= month && month <= DEC) {
                // year and month are valid; check day
                maxDay = daysInMonth[month];
                if (month == FEB && isLeapYear(year))
                    maxDay = maxDay + 1;
                isLegal = (1 <= day && day <= maxDay);
        } else
            // year or month is bad
            isLegal = false;
        return isLegal;
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

    // Private components:

    private int day;
    private int month;
    private int year;
    private boolean isLeapYear;
    private int daysInThisMonth;
    private int dayOfYear;

    // Constructors:

    /**
     * Create a new Date instance with the specified
     * day, month, and year.
     */
    public Date (int day, int month, int year) {
        assert isLegalDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
        this.isLeapYear = isLeapYear(month);
        this.daysInThisMonth = daysInMonth[month];
        if (month == FEB && isLeapYear)
            daysInThisMonth = daysInThisMonth + 1;
        this.dayOfYear = dayOfYear();
    }

    // Queries:

    /**
     * The day of the month for this Date.
     */
    public int day () {
        return day;
    }

    /**
     * The month for this Date.
     */
    public int month () {
        return month;
    }

    /**
     * The year for this Date.
     */
    public int year () {
        return year;
    }

    /**
     * This Date is in a leap year.
     */
    public boolean isLeapYear () {
      return Date.isLeapYear(year);
    }

    /**
     * The Date following this Date.
     */
    public Date nextDate () {
        Date nextDate;
        if (day < daysInThisMonth)
            nextDate = new Date(day+1,month,year);
        else if (month < DEC)
            nextDate = new Date(1,month+1,year);
        else
            nextDate = new Date(1,JAN,year+1);
        return nextDate;
    }

    /**
     * The day of the year for this Date.  1 January
     * is the first day of the year, 1 February is the
     * 32nd, and so on.
     */
    public int dayOfYear () {
        int daysBefore = daysBeforeMonth[this.month];
        if (this.month > FEB && this.isLeapYear)
            daysBefore = daysBefore + 1;
        return daysBefore + this.day;
    }
}

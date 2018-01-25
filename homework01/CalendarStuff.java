/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  Brock Squires
 *  Date          :  2017-01-23 (prototype)
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2018.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-23  Brock Squires  Initial writing and release
 */
public class CalendarStuff {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   *
   * These didn't end up being used so they are not needed, but it doesn't hurt anything so they are 
   * being left in.
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY    = SUNDAY    + 2;
   private static final int WEDNESDAY    = SUNDAY    + 3;
   private static final int THURSDAY    = SUNDAY    + 4;
   private static final int FRIDAY    = SUNDAY    + 5;
   private static final int SATURDAY    = SUNDAY    + 6;

  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   *
   * These didn't end up being used so they are not needed, but it doesn't hurt anything so they are
   * being left in.
   */
   private static final int JANUARY    = 1;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH   = JANUARY   + 2;
   private static final int APRIL   = JANUARY   + 3;
   private static final int MAY   = JANUARY   + 4;
   private static final int JUNE   = JANUARY   + 5;
   private static final int JULY   = JANUARY   + 6;
   private static final int AUGUST   = JANUARY   + 7;
   private static final int SEPTEMBER   = JANUARY   + 8;
   private static final int OCTOBER   = JANUARY   + 9;
   private static final int NOVEMBER   = JANUARY   + 10;
   private static final int DECEMBER   = JANUARY   + 11;


  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   *  NOTE: this is optional, but suggested
   */
   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public CalendarStuff() {
      System.out.println( "Constructor called..." );  // replace this with the actual code
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear (long year) { //the % sign checks if evenly divisible
     if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) { //the && symbol will stop the testing if the first parameter is false
       return true; // the || means or
     }
       return false; // for all other years it will return false
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   * The way I feel like this should work would be as follows
   * if the year returned true from the boolean in isLeapYear
   * then I want it to check if it is month 2 aka FEBRUARY
   * if those both pass as true then it should display 29
   * if either of those two things fail to pass as true then it should
   * check the first array which has all of the days in each month in it
   */
    public static long daysInMonth( long month, long year ) { // code to follow
      if (month == 4 || month == 6 || month == 9 || month == 11) {
        return 30;
      } else if (month == 2 && isLeapYear(year)) {
         return 29;
      } else if (month == 2 && !isLeapYear(year)) {
        return 28;
      }
        return 31;

 }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   * here check and see if the months are equal,
   * maybe use the && symbol to only pass on if the first part is true.
   * Next check whether the days are equal and the years.
   * If it comes up as true then maybe use a throw code to stop the program,
   * after throwing, display that the dates are equal or invalid
   *
   *This method simply checks if the dates are equal. If they are then it passes the date on to check
   * if the month is equal and eventually to see if the day is equal.
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {

       if (isValidDate(month1, day1, year1) && isValidDate(month2, day2, year2)){

           if (month1 == month2 && year1 == year2 && day1 == day2){
               return true;
           }

       }
       return false;  // replace this with the actual code
   }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   *
   * This method compares the two dates to see qhich one is larger and which is smaller than the other
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       if (isValidDate(month1, day1, year1) && isValidDate(month2, day2, year2)){
           if (year1 < year2) return -1;
           if (year1 == year2){
               if (month1 > month2) {
                   return 1;
               } else if (month1 < month2) {
                   return -1;
               } else if (month1 == month2) {
                   if (day1 > day2) {
                       return 1;
                   } else if (day1 < day2) {
                       return -1;
                   }
               }
           }
           if (year1 > year2) return 1;
       }

      return 0;  // replace this with the actual code
   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   * Make sure all of the months fit in 1-12
   * the dates don't exceed the max in their month.
   * Also make sure that none of the dates are negative
   * The year can go as high as needed.
   *
   * The way that this worked out was to set a boolean to be false by default and
   * change it to true only if the date is valid. It just checks if the year is
   * greater than 0 and if the month is between 1 and 12. For the day it calls
   * on the daysInMonth method and compares how many days that month should have.
   */
   public static boolean isValidDate( long month, long day, long year ) {

     boolean isValid = false;
        if (year > 0){
            if (month >= 1 && month <= 12){
                if (day > 0 && day <= daysInMonth(month, year)){
                    isValid = true;
                }
            }
        }
        return isValid;
   }

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {

      // switch( month - 1 ) {
      /* Here, the method compares months numerical placements to their written names
       * it uses the switch case to change the numerical value of 1 to January or
       * whatever it happens to be. This goes for as long as the month is greater
       * than or equal 1, and less than or equal to 12.
       */

      if (month >= 1 && month <= 12){
          switch (month){
              case 1: return "January";
              case 2: return "February";
              case 3: return "March";
              case 4: return "April";
              case 5: return "May";
              case 6: return "June";
              case 7: return "July";
              case 8: return "August";
              case 9: return "September";
              case 10: return "October";
              case 11: return "November";
              case 12: return "December";
              default: break;
          }
      }
      return "";

   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
      // switch( day - 1 ) {
      // This works the same as the above, just with days of the week instead
      if (day >= 1 && day <= 7){
          switch (day){
              case 1: return "Sunday";
              case 2: return "Monday";
              case 3: return "Tuesday";
              case 4: return "Wednesday";
              case 5: return "Thursday";
              case 6: return "Friday";
              case 7: return "Saturday";
              default: break;
          }
      }
      return "";
   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      long dayCount = 0;
        /* For the counter in this method to work, it first has to check whether the first date is the smaller one.
         * If it turns out that the first date is larger than the second date, the if statement will basically
         * switch the two of them so that the smaller date runs first. This is to help the counter count up
         * to the second date.
         */
          if ((year1 > year2) || (year1 == year2 && month1 > month2) || (year1 == year2 && month1 == month2 && day1 > day2)){
              long tempYear = year1;
              long tempMonth = month1;
              long tempDay = day1;

              year1 = year2;
              month1 = month2;
              day1 = day2;

              year2 = tempYear;
              month2 = tempMonth;
              day2 = tempDay;
        }
        /* This is the actual counter. The while statement runs and tells the computer to check if the first year
         * is less than the second. If it is, it adds one day to the counter and loops back to run it again.
         * When the year is equal then it will check if the month is less and add a day if it is. It will do this until the
         * month is not a valid date. When the month reaches a non-valid date, it will set the month to 1 and begin the loop
         * again. Every time it loops it basically adds one to dayCount until the dates are equal, which is when it
         * returns the day count.
         */
        while ((year1 < year2) || (year1 == year2 && month1 < month2) || (year1 == year2 && month1 == month2 && day1 < day2)) {
                    day1++;
                    if(!isValidDate(month1, day1, year1)){
                        day1 = 1;
                        month1++;
                    }
                    if(!isValidDate(month1, day1, year1)){
                        month1 = 1;
                        year1++;
                    }
                    dayCount++;
            }
    return dayCount;


    }
  }

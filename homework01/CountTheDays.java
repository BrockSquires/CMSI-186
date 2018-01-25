/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Uses the daysBetween method based off of user input
 *  Author        :  Brock Squires
 *  Date          :  2017-01-24 (prototype)
 *  Description   :  This program takes the user input in as a string and parses it so it will remove
                     the comma and space after each number. After parsing the numbers it makes them
                     into an array. From the array, the strings are turned into longs and are able
                     to be treated as numbers. From there the longs are inputted into the daysBetween
                     method to find the actual numbers of days between.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-24  Brock Squires  Initial writing and release
 */
import java.util.Scanner; // prepares java for user input

public class CountTheDays {
   public static void main ( String [] args ) {
    String dates; //takes the input in as a string with the name dates
       System.out.println("This program calculates the number of days between two given dates"); //prompt
       Scanner in = new Scanner(System.in); // also part of the scanner
       System.out.println("Input Two Dates Numerically: mm/dd/yyyy (eg. 3, 2, 1999, 5, 1, 2001)");
       dates = in.nextLine(); // puts the input in as a string
       String[] splitDates = dates.split(", "); //this splits the dates between every comma and space

       long a = Long.parseLong(splitDates[0]); // all of these change the new 6 strings with no
       long b = Long.parseLong(splitDates[1]); // commas and spaces and sets them to be
       long c = Long.parseLong(splitDates[2]); // longs instead of strings
       long d = Long.parseLong(splitDates[3]);
       long e = Long.parseLong(splitDates[4]);
       long f = Long.parseLong(splitDates[5]);

       System.out.println("There are " + CalendarStuff.daysBetween(a, b, c, d, e, f) + " days between "
       + CalendarStuff.toMonthString(Integer.valueOf(splitDates[0])) + " " + b + ", " + c
       + " and " + CalendarStuff.toMonthString(Integer.valueOf(splitDates[3])) + " " + e + ", " + f);
       /* Here is a fancy way of printing out the results from the days between method. It goes on to call on
        * the toMonthString method also to take the first and second months inputted, and turns them into
        * actual words for the months which just looks a lottle bit nicer. */

   }
}

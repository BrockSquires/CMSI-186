/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Brock Squires
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-22  Brock Squires  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definitions go here
   */
   private static final double SECONDS_PER_TWELVE_HOURS = 43200;
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static double timeSlice, userTimeSlice;
   double totalSeconds = 0;

  /**
   *  Constructor
   */
   public Clock() {
     totalSeconds = 0;
   }


  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main program's args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) throws IllegalArgumentException, NumberFormatException {
      if ( argValue.equals("") ){
        return DEFAULT_TIME_SLICE_IN_SECONDS;
      }
      double argDouble = Double.parseDouble(argValue);
      if ( !( argDouble > 0 ) ){
        throw new IllegalArgumentException( "Time slice is out of acceptable range" );
      } else if ( argDouble > 0 ) {
         return argDouble;
      } else {
        throw new NumberFormatException( "Time slice is not a double-precision number" );
      }
   }

  /**
   *
   *  Method to calculate the next tick from the time increment
   *  @param  timeSlice  Double to calculate the next clock tick
   *  @return double-precision value of the current clock tick
   */
   public double tick( double timeSlice ) {
     if ( timeSlice <= 0 ) {
      timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
     }
     totalSeconds += timeSlice;
     return totalSeconds;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }
   public String toString() {
       int hours = (int) totalSeconds / 3600;
       int minutes = (int) (totalSeconds / 60) % 60;
       double seconds = (double) totalSeconds % 60;
       return hours + ":" + minutes + ":" + seconds;
     }
}

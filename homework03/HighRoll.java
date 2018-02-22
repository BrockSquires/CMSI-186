/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  MainProgLoopDemo.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  Brock Squires
 *  Date          :  2017-02-12
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-12  Brock Squires  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {
      System.out.println( "\n   Step on Down and Roll Some Dice!\n" );
      System.out.println( "     Press the 'r' key to ROLL ALL THE DICE" );
      System.out.println( "     Or Press the 's' key to ROLL A SINGLE DIE" );
      System.out.println( "     Or Press the 'c' key to CALCULATE THE SCORE FOR THIS SET" );
      System.out.println( "     Or Press the 'h' key to SAVE THIS SCORE AS A HIGH SCORE" );
      System.out.println( "     Or Press the 'd' key to DISPLAY A HIGH SCORE" );
      System.out.println( "     Or Press the 'q' key to quit the program." );


     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("enter some text!:");
            }
            System.out.println( "   You typed: " + inputLine );
            if( 'q' == inputLine.charAt(0) ) {
               break;
           }
            else if( 'r' == inputLine.charAt(0) ) {
                break; //roll some shit
            }
            else if( 's' == inputLine.charAt(0) ) {
                break; //roll some shit
            }
            else if( 'c' == inputLine.charAt(0) ) {
                break; //roll some shit
            }
            else if( 'h' == inputLine.charAt(0) ) {
                break; //roll some shit
            }
            else if( 'd' == inputLine.charAt(0) ) {
                break; //roll some shit
            }
            
         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}

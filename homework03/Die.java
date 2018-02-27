/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Brock Squires
 *  Date          :  2018-02-12
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-02-12  Brock Squires  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   * Here we have a little checker to make sure that the die inputted has at least 4 sides.
   * If it does then all is well, but if it doesn't, then it throws an excption and sets the
   * sides equal to the minimum, which is 4, and runs the rest of the program.
   */
   public Die(int nSides) {
       if (nSides < 4) {
           throw new IllegalArgumentException("Sides will be set to the minimum of 4");
           // sides = MINIMUM_SIDES;   NOTE: THIS IS AN UNREACHABLE STATEMENT; PROGRAM ABORTS AT LINE ABOVE
       } else {
           this.sides = nSides;
       }
   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   * This is the meat of the program where the die gets rolled and that value
   * gets assigned to the variable pips. To roll it, it takes the random Math
   * statement and multiplies it by sides to get a real whole number value that
   * pertains to the die we have inputted.
   */
   public int roll() {
       pips = (int)(Math.random() * sides + 1);
       return pips;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   * Simply returns pips here, defined in another method, for the string methods
   * that follow later in the code.
   */
   public int getValue() {
      return pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   * This will attempt to replace the sides that the program already ran through
   * with a new number as sides. To do this it takes the new number of sides and
   * rerolls, assigning that roll to the variable newSides.
   */
   public int setSides( int newSides ) {
       newSides = sides;
       pips = (int)(Math.random() * sides + 1);
       return newSides;
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   * The string representation of pips here simply takes the int that is the value
   * of the top of the die and turns it into a string surrounded by brackets.
   */
   public String toString() {
     String dieS = Integer.toString(pips);
     return "[" + dieS + "]";
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   * Here I have a class wide version of the above that produces a string from the getValue
   * method and returns that.
   */
   public static String toString( Die d ) {
       String dieS = Integer.toString(d.getValue());
       return "[" + dieS + "]";

   }

  /**
   * A little test main to check things out
   * Here, new values get put into the sides of the die then run through the different methods.
   * Before any of the methods are called, it runs the roll method to actually assign
   * values to the die, then it goes on to display the rest of the information.
   */
   public static void main( String[] args ) {
      System.out.println( "Hello world from the Die class..." );

      try {Die myDie = new Die(3);
      myDie.roll();
      System.out.println(myDie.toString());}
      catch( Exception e ) { System.out.println ( false ); }

      try {Die myDie = new Die(7);
      myDie.roll();
      System.out.println(myDie.toString());}
      catch( Exception e ) { System.out.println ( false ); }

      try {Die myDie = new Die(69);
      myDie.roll();
      System.out.println(myDie.toString());}
      catch( Exception e ) { System.out.println ( false ); }

      try {Die myDie = new Die(4);
      myDie.roll();
      System.out.println(myDie.setSides(8));
      System.out.println(myDie.toString());}
      catch( Exception e ) { System.out.println ( false ); }

      try {Die myDie = new Die(11);
      myDie.roll();
      System.out.println(myDie.toString());}
      catch( Exception e ) { System.out.println ( false ); }
   }

}

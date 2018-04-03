/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Defines the balls for the soccer sim
 *  @author       :  Brock Squires
 *  Date          :  2018-03-24
 *  Description   :  This is set to simulate the soccer balls and their functions
 *
 *  Notes         :  None at the moment
 *
 *  Warnings      :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-03-24  Brock Squires  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.TimerTask;


public class SoccerSim{

    public static ArrayList ballList;
    public static double[] attributeArray;
    public static Ball[] arBalls;
    public static double timeSlice;


    public void initialAttributes(String args[]) {
        Clock tempClock = new Clock();
        ballList = new ArrayList<Ball>();
        if( args.length % 4 != 0 ) {
            System.out.println("Please enter the correct number of attributes");
            System.exit(0);
        } else {
            arBalls = new Ball[ attributeArray.length / 4 ];
            for ( int i = 0; i < attributeArray.length; i += 4 ) {
                arBalls[ i / 4 ] = new Ball( attributeArray[ i ], attributeArray[ i + 1 ], attributeArray[ i + 2 ], attributeArray[ i + 3 ] );
                ballList.add( i / 4, arBalls[ i / 4 ] );
        }

    }



}
    public void moveBall() {
         for ( int i = 0; i < arBalls.length; i++) {
              arBalls[ i ].move( timeSlice );
}
}
    public static boolean detectCollision( Ball b1, Ball b2 ) {
  	     if ( b1.getXPosition() == b2.getXPosition() && b1.getYPosition() == b2.getYPosition() ) {
  	          return true;
          } else {
              return false;
          }
}

public static void main( String args[] ) {
  	SoccerSim soccerSim = new SoccerSim();
  	Clock clock = new Clock();
  	soccerSim.initialAttributes( args );
  	while ( true ) {
  	  System.out.println( "Current time: " + clock.toString() );
  	  soccerSim.moveBall();
  	  for ( int i = 0; i < arBalls.length; i++ ) {
  	    for ( int j = i + 1; j < arBalls.length; j++ ) {
  	      if ( soccerSim.detectCollision( arBalls[ i ], arBalls[ j ] ) ) {
  	  	    if ( j == arBalls.length - 1 ) {
  	  	      System.out.println( "Collision detected at time " + clock.toString() );
  	  	    } else {
                System.out.println("No collision detected currently");
  	  	    }
  	  	    System.exit( 0 );
  	  	  }
  	    }
  	  }
  	  clock.tick( timeSlice );
  	  soccerSim.moveBall();
  	}
  }
}

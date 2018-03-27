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

public class SoccerSim{

    public static ArrayList ballList;
    public static double[] attributeArray;
    public static Ball[] arBalls;

    public void initialAttributes(String args[]) {
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
}

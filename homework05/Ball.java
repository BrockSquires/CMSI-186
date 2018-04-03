/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Defines the balls for the soccer sim
 *  @author       :  Brock Squires
 *  Date          :  2018-03-24
 *  Description   :  This is set to state the balls for the soccer sim and their functions
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
 import java.util.Date;
 import java.util.Timer;
 import java.util.TimerTask;
 import javafx.scene.shape.*;
 import java.lang.*;


 public class Ball {

    private double px, py; //position of ball
    private double vx, vy; //velocity of ball
    private double vix, viy; // initial velocity of balls
    private double timeSlice; // initial velocity of balls
    private double fieldSize = 500;

    private final double radius = .5; //radius of ball

    public Ball(double px, double py, double vix, double viy) {
        this.px = px;
        this.py = py;
        this.vix = vix;
        this.viy = viy;
        vx = this.vix - ((this.vix * .01) * timeSlice);
        vy = this.viy - ((this.viy * .01) * timeSlice);
        timeSlice = 0;




    //     TimerTask task;
    //     task = new TimerTask() {
    //             @Override
    //             public void run() {
    //                 if (vx > 0 && vy > 0) {
    //                     timeSlice++;
    //                 } else {
    //                     // stop the timer
    //                     cancel();
    //                 }
    //             }
    //         };
    //
    //     for(;;) {
    //         Timer timer = new Timer();
    //         timer.schedule(task, 0, 1000);
    //
    //         //Thread.sleep(1000);
    //         timeSlice ++;
    //     }
    //
    }


    public void bounceVertical() {
        vx = -vx;
    }

    public void bounceHorizontal() {
        vy = -vy;
    }

    public double getXPosition() {
      return px;
    }

    public double getYPosition() {
          return py;
        }

    public void move(double timeSlice) {
     px = px + vx;
     py = py + vy;
     if (!checkBounds()) {
         throw new IllegalArgumentException("One of the balls has hit the pole!");
     }
    }

    private boolean checkBounds() {
        if (Math.abs(px + vx) + radius > fieldSize) bounceVertical();
        if (Math.abs(py + vy) + radius > fieldSize) bounceHorizontal();
        boolean Pole;
            if (px == 0 && py == 250){
                return false;
            }
            else {
                return true;
            }
        // Need a way to check if multiple balls hit eachother.
        }

}

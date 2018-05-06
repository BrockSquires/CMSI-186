/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangemaker.java
 * Purpose    :  Program to make change from a set of coins
 * @author    :  Brock Squires
 * Description:  This program will try to take user input in the form of coins to find the
                minimum amount of coins needed to give change.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial release; stolen blatently from Professor Don Murphy with his
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Scanner;
import java.util.Arrays;

/**
 * DynamicChangemaker is the main class that takes input as a set of coin denominations
 * as well as a monetary value and attempts to make the minimum amount of change
 * for this target value using the given denominations.
 *
 * @author Brock Squires
 * @version 1.0.0
 */

public class DynamicChangeMaker {

	/**
	 * Checks that the input integers are positive
	 * @param coins     the <code>int[]</code> of denominations to make change from
	 * @param totalValue    the <code>int</code> containing value to make out of coins
	 * @return          <code>false</code> if all tests don't pass
	 *                  <code>true</code> if all tests are good
	 */

	public static boolean checkInput(int[] coins, int totalValue) {

		// Check through all coins for negative numbers
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= 0) {
				System.out.println("BAD DATA:  Coins must be positive numbers");
				return false;
			}

			// Loops through coins and checks if same as other coins
			for (int j = 0; j < coins.length; j++) {
				if (j != i && coins[i] == coins[j]) {
					System.out.println("BAD DATA:  None of the same coins allowed");
					return false;
				}
			}
		}
		if (totalValue <= 0) {
			System.out.println("BAD DATA:  target must be a positive integer");
			return false;
		}

		// If nothing tripped the Bad Data
		return true;
	}

	/**
	 * The method that actually works to find the minimum number of Coins
	 * that can be used to reach the totalValue input.
	 * @param coins     the <code>int[]</code> of denominations to make change from
	 * @param totalValue    the <code>int</code> containing value to make out of coins
	 * @return          A {@link Tuple} that contains the number of each coin in each slot
	 */
	public static Tuple makeChangeWithDynamicProgramming(int[] coins, int totalValue){

		if (!checkInput(coins, totalValue)) {
			return Tuple.IMPOSSIBLE;
		}
		

		Tuple [][]  tArr;
		Tuple solution = Tuple.IMPOSSIBLE;
		
		int rowCount = coins.length;
		int columnCount = totalValue + 1;
		tArr = new Tuple[rowCount][columnCount];

		// First we need to make sure the input passes the checkInput method
		// If it doesn't we just return invalid, if it does then we just continue
		

		// this is just to locate you in the process -- I know YOU know this belongs here...
		//  BTW, the indenting implies the if statements needed


		for( int i = 0; i < rowCount; i++ ) {
			for( int j = 0; j < columnCount; j++ ) {

				// Special case for column zero for all rows
				// check to see if we CAN take ONE thing out of the current value;
				//  if we CAN'T take one of the denominations out of the value of "j"
				//   impossible, at least temporarily

				if( j == 0) {

					tArr[i][j] = Tuple.IMPOSSIBLE;
					continue;
				}
					// Otherwise, this is NOT column zero

				if(0 > j - coins[i]) {
				
					// if this is NOT row zero we need to look above to see if there is
					//  a better/non-impossible solution; if so, copy it down
					if(i != 0) {
						tArr[i][j] = Tuple.IMPOSSIBLE;

						// if the cell looking backward is NOT an "IMPOSSIBLE", add it
						if(tArr[i-1][j] != Tuple.IMPOSSIBLE) {

							//create a new array with the data from the cell above
							// adding 1 because we started from base 0 when in reality it isn't the first cell

							tArr[i][j] = new Tuple(Arrays.copyOf(tArr[i - 1][j].data, i + 1));

						}
						// else if the cell above has a total that is less than the current
						//  cell, copy it down
					}
					
				} 

				else {

					// make a new tuple with a one in the current cell index
					tArr[i][j] = new Tuple(i + 1);
					tArr[i][j].setElement(i, 1);

					// look backward to see if there is a valid/impossible solution
					if(j - coins[i] >= 0) {

						if (tArr[i][j - coins[i]] == Tuple.IMPOSSIBLE) {
							tArr[i][j] = Tuple.IMPOSSIBLE;
						} else { // else, add the previous cell to the current cell
							tArr[i][j] = tArr[i][j].add(tArr[i][j - coins[i]]);
						}

					} 

					// if this is NOT row zero we need to look above to see if there is
					//  a better/non-impossible solution; if so, copy it down
					if( i != 0 ) {

						// if the cell above is impossible, basically do nothing since
						//  this the current cell is already IMPOSSIBLE


						// if the cell above has a total that is less than the current
						// cell, copy it down
						if (tArr[i][j] != Tuple.IMPOSSIBLE) {
							if (tArr[i - 1][j].total() < tArr[i][j].total()
									&& tArr[i - 1][j] != Tuple.IMPOSSIBLE) {
								tArr[i][j] = new Tuple(Arrays.copyOf(tArr[i - 1][j].data, i + 1));
							}
						} else if (tArr[i - 1][j] != Tuple.IMPOSSIBLE) {
							tArr[i][j] = new Tuple(Arrays.copyOf(tArr[i - 1][j].data, i + 1));
						}

						// else if the cell above has a total that is less than the current
						//  cell, copy it down
					}
				}

				if (j == totalValue) {
					if (tArr[i][j].total() <= solution.total() || solution == Tuple.IMPOSSIBLE) {
						solution = tArr[i][j];
					}
				}

				
			}


			
		}

		return solution;

	

	}


	public static void main(String[] args) {

		int[] ar = {5,10,20,50};
		System.out.println(DynamicChangeMaker.makeChangeWithDynamicProgramming(ar, 85));


	}

}

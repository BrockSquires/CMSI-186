/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  Brock Squires
 *  Date          :  2018-01-25
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-01-25  Brock Squires  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringStuff {

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * This method just works to test vowels upper and lower case by just mass checking every single vowels
   *
   * @param s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {
       if ((s.contains("A")) || (s.contains("E")) || (s.contains("I")) || (s.contains("O")) || (s.contains("U")) ||
           (s.contains("a")) || (s.contains("e")) || (s.contains("i")) || (s.contains("o")) || (s.contains("u"))) {
               return true;
       } else return false;

   }

  /**
   * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
   * the first and last, second and last-but-one, etc. against each other.  If something doesn't
   * match that way, returns false, otherwise returns true.
   *
   * It splits the string in half because if it is a palindrome then it would only need to check
   * the first half againt the second.
   *
   * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
   * @return  boolean which is true if this a palindrome, or false otherwise
   */
   public static boolean isPalindrome( String s ) {
       int n = s.length();
       for (int i = 0; i < (n/2); ++i) {
          if (s.charAt(i) != s.charAt(n - i - 1)) {
              return false;
              }
          }


      return true;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * Brute force on this one also. By checking if a string has even letters only, it simply
   * replaces every odd letter in the alphabet, upper and lower case, with nothing or "".
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
      s = s.replace("A","");
      s = s.replace("C","");
      s = s.replace("E","");
      s = s.replace("G","");
      s = s.replace("I","");
      s = s.replace("K","");
      s = s.replace("M","");
      s = s.replace("O","");
      s = s.replace("Q","");
      s = s.replace("S","");
      s = s.replace("U","");
      s = s.replace("W","");
      s = s.replace("Y","");

      s = s.replace("a","");
      s = s.replace("c","");
      s = s.replace("e","");
      s = s.replace("g","");
      s = s.replace("i","");
      s = s.replace("k","");
      s = s.replace("m","");
      s = s.replace("o","");
      s = s.replace("q","");
      s = s.replace("s","");
      s = s.replace("u","");
      s = s.replace("w","");
      s = s.replace("y","");

      return s;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * Brute force on this one also. By checking if a string has even letters only, it simply
   * replaces every odd letter in the alphabet, upper and lower case, with nothing or "".
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {
       s = s.replace("B","");
       s = s.replace("D","");
       s = s.replace("F","");
       s = s.replace("H","");
       s = s.replace("J","");
       s = s.replace("L","");
       s = s.replace("N","");
       s = s.replace("P","");
       s = s.replace("R","");
       s = s.replace("T","");
       s = s.replace("V","");
       s = s.replace("X","");
       s = s.replace("Z","");

       s = s.replace("b","");
       s = s.replace("d","");
       s = s.replace("f","");
       s = s.replace("h","");
       s = s.replace("j","");
       s = s.replace("l","");
       s = s.replace("n","");
       s = s.replace("p","");
       s = s.replace("r","");
       s = s.replace("t","");
       s = s.replace("v","");
       s = s.replace("x","");
       s = s.replace("z","");


      return s;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * For this one to work we import the string through the evensOnly method so it is down to just
   * the letters we need. Then it begins a for loop where it checks if the value of the first letter
   * in the string is comparable to the second letter etc. To make sure it tests without being
   * case sensitive, the only way I could think to do it was test it for upper case and then again
   * for lower case. This is identical to what the oddsOnlyNoDupes method does.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input without duplicates
   */
    public static String evensOnlyNoDupes( String s ) {

       s = evensOnly(s);
       String temp = "";
       for (int i = 0; i < s.length(); i++) {
           if(!temp.contains(String.valueOf(s.toUpperCase().charAt(i))) && !temp.contains(String.valueOf(s.toLowerCase().charAt(i)))) {
               temp += String.valueOf(s.charAt(i));
           }
       }
       return temp;
    }



  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input without duplicates
   */
   public static String oddsOnlyNoDupes( String s ) {

       s = oddsOnly(s);
       String oddTemp = "";
       for (int i = 0; i < s.length(); i++) {
           if(!oddTemp.contains(String.valueOf(s.toUpperCase().charAt(i))) && !oddTemp.contains(String.valueOf(s.toLowerCase().charAt(i)))) {
               oddTemp += String.valueOf(s.charAt(i));
           }
       }
       return oddTemp;
   }

  /**
   * Method to return the reverse of a string passed as an argument
   * This works by using a one line command which builds a new String
   * from the reverse of our string s. After that, it simply returns the
   * new string which we set equal to the reverse of the first.
   * @param s String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String s ) {
      String reverse = new StringBuilder(s).reverse().toString();
      return reverse;
   }

  /**
   * Main method to test the methods in this class
   *
   * @param args String array containing command line parameters
   */
   public static void main( String args[] ) {
      String blah = new String( "Blah blah blah" );
      String woof = new String( "BCDBCDBCDBCDBCD" );
      String pal1 = new String( "a" );
      String pal2 = new String( "ab" );
      String pal3 = new String( "aba" );
      String pal4 = new String( "amanaplanacanalpanama" );
      String pal5 = new String( "abba" );
      System.out.println( containsVowel( blah ) );
      System.out.println( containsVowel( woof ) );
      System.out.println( isPalindrome( pal1 ) );
      System.out.println( isPalindrome( pal2 ) );
      System.out.println( isPalindrome( pal3 ) );
      System.out.println( isPalindrome( pal4 ) );
      System.out.println( isPalindrome( pal5 ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REHEARSALSZ" ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REhearSALsz" ) );
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "REhearRrRRRrSALsz" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "xylophones" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "XYloPHonES" ) );
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "XYlOoOOoPHonES" ) );
      System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
   }
}

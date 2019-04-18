import java.awt.Color;

import turtle.Turtle;
import turtle.World;

/**
 * Homework 6
 * 
 * Implement the following methods on recursion
 * as defined in the homework 6 document.
 * 
 * @author yl2vv
 *
 */
public class Recursion {

	/** Takes a string and returns the reverse of the string
	 * @param s : the string to reverse **/
	public static String reverseString(String s) {
		// Implement this method
		if (s.length() == 0) { // the base case if string is one character (the last character)
			return s;
		}
		return reverseString(s.substring(1)) + s.charAt(0); // recurse each character of string plus first character
	}

	/** Based on Ackermann's function.
	 * A recursive mathematical algorithm that can be used to test how well a computer performs recursion.
	 * Will only work with positive integers of m and n.
	 * @param m : first long
	 * @param n : second long **/
	public static long Ackermann(long m, long n) {
		// Implement this method
		if (m == 0) { // the base case if m is 0
			return n + 1;
		}
		if (m > 0 && n == 0) {
			return Ackermann(m - 1, 1);
		}
		return Ackermann(m - 1, Ackermann(m, n - 1));
	}

	/**  Assuming there is more than one person (n > 1), each person shakes hands once with every other person.
	 * @param n : the number of people **/
	public static int handshakes(int n) {
		// Implement this method
		if (n < 2) { // less than two people will result in no handshakes
			return 0;
		}
		if (n == 2) { // the base case if there are two people, there is one handshake
			return 1;
		}
		return (n - 1) + handshakes(n - 1); // the recursion that adds the number of handshakes (n - 1) per person
	}

	/**
	 * Draw a Koch snowflake using recursion.
	 * The snowflake can be broken up into three sides. 
	 * Used the oneSide helper function to create a whole snowflake using three symmetrical sides
	 * @param t : Turtle
	 * @param depth : how many levels of recursion
	 * @param size : length turtle travels
	 */
	public static void snowflake(Turtle t, int depth, double size) {
		// Implement this method
		for (int i = 0; i < 3; i ++) {  // loop three times
			oneSide(t, depth, size); // draw one side
			t.right(120); // turn 120 degrees to form a  new side of "triangle"
		}
	}
	
	/**
	 * Helper function that draws one side of the snowflake using recursion
	 * @param t : Turtle
	 * @param depth : how many levels of recursions
	 * @param size : length turtle travels
	 */
	public static void oneSide (Turtle t, int depth, double size) {
		if (depth == 0) { // the base case if depth is 0, go straight 
			t.forward(size);
			return;
		}
		oneSide(t, depth - 1, size / 3); // recursion that creates the "peak" for each line for each level. 
		t.left(60.0); // turn to make peak
		oneSide(t, depth - 1, size / 3); 
		t.left(-120.0);
		oneSide(t, depth - 1, size / 3);
		t.left(60.0);
		oneSide(t, depth - 1, size / 3);
	}



	public static void main(String[] args) {
		// write your tests here

		// Test for reverseString:
		System.out.println(reverseString("")); // expected: "" return: ""
		System.out.println(reverseString("Hello")); // expected: olleH return: olleH
		System.out.println(reverseString("h e l l o")); // expected: o l l e h return: o l l e h

		// Test for Ackermann:
		System.out.println(Ackermann(1,1)); // expected: 3 return: 3
		System.out.println(Ackermann(2,2)); // expected: 7 return: 7

		//Test for handshakes:
		System.out.println(handshakes(1)); // expected: 0 return: 0
		System.out.println(handshakes(4)); // expected: 6 return: 6
		System.out.println(handshakes(5)); // expected: 10 return: 10

		// Note: for snowflake, you must create the turtle and world:
		World myWorld = new World(900,900,Color.WHITE); // the world
		Turtle bob = new Turtle(myWorld); // the turtle
		bob.setDelay(0); // no pause in movement
		snowflake(bob, 4, 200.0); // expected: snowflake of four levels return: snowflake of four levels
		snowflake(bob, 0, 200.0); // expected: base case of triangle return: triangle
		
	}
}

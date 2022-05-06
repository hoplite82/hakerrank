package playing;

import java.io.*;

class Assignment {
	public static void main(String[] args) throws Exception {
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Principal Amount : ");// prompt for entering the principal amount
		float P = Float.parseFloat(ob.readLine());// accepting the principal amount
		int choice = 0;
		do {
			choice = 0;// reseting the user's choice
			//displaying the Menu of Options
			System.out.println("------------- M E N U ----------------");
			System.out.println("1 - To Find the Simple Interest");
			System.out.println("2 - To Find the Compound Interest");
			System.out.println("3 - To Find the Difference between the Simple and Compound Interests");
			System.out.println("4 - To Exit The Program");
			System.out.print("Enter Choice : ");// prompting for user's choice
			choice = Integer.parseInt(ob.readLine());// accepting user's choice
			System.out.println("");// line feed between menu and result
			switch (choice) {
			case 1:// for simple interest
				System.out.println("The Simple Interest is " + simple(P));
				break;
			case 2:// for compound interest
				System.out.println("The Compound Interest is " + compound(P));
				break;
			case 3:// for difference between simple and compound interests
				System.out.println("The Absolute Difference is " + (compound(P) - simple(P)));
				break;
			case 4:
				System.out.println("Program Terminated");
				break;
			default:// for a wrong choice entered by the user
				System.out.println("Invalid Option");
			}// end of switch(choice)
			System.out.println("\n");// linefeed between two consecutive choices by the user
		} while (choice != 4);// end of do-while
	}// end of main

	public static float simple(float p)// to calculate the simple interest
	{
		return (float) ((p * 8.5 * 7.0) / 100.0); // returning the simple interest
	}// end of simple

	public static float compound(float p)// to calculate the compound interest
	{
		return (p * (float) (Math.pow((1.0 + (8.5 / 100.0)), 7.0) - 1.0));// returning the compound interest
	}// end of compound
}// end of class
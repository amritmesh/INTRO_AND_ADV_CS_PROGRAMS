import java.util.Scanner;

public class IntegerRangeProgram
{
	public static void main ( String [] args )
	{
		System.out.println ( "This program calculates the sum of the integers in a range that are divisible by 3." ); 

		Scanner input = new Scanner ( System.in );

		//Stores user upper bound in variable upperBound
		System.out.print ( "Enter an upper bound for the range: " );
		int upperBound = input.nextInt();

		//Declares variables for the # of divisible values, the sum of the divisible values, and the sum of the non-divisible values
		int count = 0;
		int divisibleSum = 0;
		int nonDivisibleSum = 0;

		// Procedure for evaluating whether the values within the range are divisible by 3, counting the # of divisible values, and summing the divisible and non-divisible values
		for ( int i = 1; i <= upperBound; i++ )
			{
				if ( i % 3 == 0 )
				{
					count += 1;
					divisibleSum += i;
				}
				else
					nonDivisibleSum += i;
			}

		int leftover = upperBound - count;

		System.out.println ( count + " numbers in the range 1 - " + upperBound + " are divisible by 3 and their sum is " + divisibleSum + ".");
		System.out.println ( leftover + " numbers in the range 1 - " + upperBound + " are not divisible by 3 and their sum is " + nonDivisibleSum + ".");
	}
}
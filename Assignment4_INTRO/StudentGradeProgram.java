import java.util.Scanner;

public class StudentGradeProgram
{
	public static void main( String [] args )
	{
		Scanner input = new Scanner( System.in );

		System.out.print( "Enter a value for the first test score: " );
		float firstTestScore = input.nextFloat();

		System.out.print( "Enter a value for the second test score: " );
		float secondTestScore = input.nextFloat();

		System.out.print( "Enter a value for the third test score: " );
		float thirdTestScore = input.nextFloat();

		float averageTestScore = ( firstTestScore + secondTestScore + thirdTestScore ) / 3;

		System.out.print( "Average is " + averageTestScore + " ");

		if ( averageTestScore <= 69.49 )
			System.out.print( "Grade is F" );
		else if ( averageTestScore <= 79.49 )
			System.out.print( "Grade is C" );
		else if ( averageTestScore <= 82.49 )
			System.out.print( "Grade is B-" );
		else if ( averageTestScore <= 86.49 )
			System.out.print( "Grade is B" );
		else if ( averageTestScore <= 89.49 )
			System.out.print( "Grade is B+" );
		else if ( averageTestScore <= 93.49 )
			System.out.print( "Grade is A-" );
		else if ( averageTestScore <= 97.49 )
			System.out.print( "Grade is A" );
		else if ( averageTestScore <= 100 )
			System.out.print( "Grade is A+" );
	}
}
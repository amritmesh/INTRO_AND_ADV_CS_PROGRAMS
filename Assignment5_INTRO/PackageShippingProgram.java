import java.util.Scanner;

public class PackageShippingProgram
{
	public static void main( String [] args )
	{
		Scanner input = new Scanner( System.in );

		//Stores user package weight input in variable packageWeight
		System.out.print( "Please enter a package weight in pounds: " );
		float packageWeight = input.nextFloat();

		//Evaluates whether package weight is a valid input value
		if ( packageWeight < 0 )
			System.out.print( "The weight must be greater than zero" );
		else if ( packageWeight > 20 )
			System.out.print( "The package is too heavy to be shipped ");

		//Evaluates in what range the user's package weight input is contained within
		else if ( ( 0 < packageWeight ) & ( packageWeight <= 1 ) )
			System.out.print( "The shipping cost is $2.95" );
		else if ( ( 1 < packageWeight ) & ( packageWeight <= 3 ) )
			System.out.print( "The shipping cost is $4.95 ");
		else if ( ( 3 < packageWeight ) & ( packageWeight <= 10 ) )
			System.out.print( "The shipping cost is $9.45 ");
		else if ( ( 10 < packageWeight ) & ( packageWeight <= 20 ) )
			System.out.print( "The shipping cost is $12.50 ");
	}
}
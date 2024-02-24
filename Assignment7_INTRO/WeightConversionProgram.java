import java.util.Scanner;

public class WeightConversionProgram
{
	public static void main ( String [] args )
	{
		Scanner input = new Scanner ( System.in );

		System.out.print( "Enter the weight of an object on Earth: " );
		double earthWeight = input.nextDouble();

		earthToMars ( earthWeight );
		earthToMoon ( earthWeight );

		System.out.print( "Enter the weight of an object on Mars: " );
		double marsWeight = input.nextDouble();

		marsToEarth ( marsWeight );

		System.out.print( "Enter the weight of an object on the Moon: " );
		double moonWeight = input.nextDouble();

		moonToEarth ( moonWeight );
	}

	public static void earthToMars ( double earthWeight )
	{
		double result = ( earthWeight / 9.81 ) * 3.711;
		System.out.println ( "The weight of the object on Mars is " + result );
	}

	public static void earthToMoon ( double earthWeight )
	{
		double result = ( earthWeight / 9.81 ) * 1.622;
		System.out.println ( "The weight of the object on the Moon is " + result );
	}

	public static void marsToEarth ( double marsWeight )
	{
		double result = ( marsWeight / 3.711 ) * 9.81;
		System.out.println ( "The weight of the object on Earth is " + result );
	}

	public static void moonToEarth ( double moonWeight )
	{
		double result = ( moonWeight / 1.622 ) * 9.81;
		System.out.println ( "The weight of the object on Earth is " + result );
	}
}
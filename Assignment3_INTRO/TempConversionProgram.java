import java.util.Scanner;

public class TempConversionProgram
{
	public static void main( String [] args )
	{
		float fahrenheitTemp = 0;
		float kelvinTemp = 0;

		Scanner input = new Scanner( System.in );

		System.out.println( "Enter a temperature in degrees Fahrenheit: " );

		fahrenheitTemp = input.nextFloat();
		kelvinTemp = ( (fahrenheitTemp - 32) / 1.8F ) + 273;

		System.out.println( "Kelvin temperature = " + kelvinTemp );

		System.out.println (4 + 20 / (3 - 1) * 2);

	}
}

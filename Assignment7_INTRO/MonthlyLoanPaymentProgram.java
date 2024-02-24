import java.util.Scanner;

public class MonthlyLoanPaymentProgram 
{
    public static void main ( String [] args )
    {
        Scanner input = new Scanner ( System.in );

        System.out.print( "Enter the dollar amount of the loan (without the dollar sign): " );
        double loanAmt = input.nextFloat();

        System.out.print( "Enter the annual interest rate (as a decimal): " );
        double intRate = input.nextFloat();

        System.out.print( "Enter the number of years: " );
        double numYears = input.nextFloat();

        double monthlyLoanPayment = finalCalc ( loanAmt, intRate, numYears );

        java.text.DecimalFormat df = new java.text.DecimalFormat( "####.##" );

        System.out.print( "The monthly loan payment amount would be " + "$" + df.format ( monthlyLoanPayment ) );
    }

    public static double finalCalc ( double L, double i, double N )
    {
        double r = i / 12;
        double n = 12 * N;
        double P = ( r * L ) / (1 - Math.pow( 1 + r, -n ) );

        return P;
    }
}
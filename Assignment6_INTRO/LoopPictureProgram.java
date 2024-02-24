public class LoopPictureProgram
{
	public static void main ( String [] args )
	{
		for ( int count = 1; count <= 10; count++ )
		{
			for ( int space = 1; space <= count + 1; space++ )
			{
				System.out.print ( " " );
			}

			for ( int asterisk = 10; asterisk >= count; asterisk-- )
			{
				System.out.print ( "*" );
			}

			System.out.println ();
		}
	}
}
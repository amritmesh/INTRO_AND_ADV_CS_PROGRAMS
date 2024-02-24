public class IllegalArgumentExceptionCatch
{
    public static void argErr(int num) throws IllegalArgumentException
    {
        if(num < 0)
        {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[]args)
    {
        try
        {
        argErr(-1);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Cannot accept negative value. IllegalArgumentException \n is thrown in order to indicate that a method \n has been passed an illegal argument");
        }
    }
}
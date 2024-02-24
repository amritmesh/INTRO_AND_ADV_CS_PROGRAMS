public class IllegalArgumentExceptionThrown 
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
        argErr(-1);
    }
}
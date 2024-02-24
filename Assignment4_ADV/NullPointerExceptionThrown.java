public class NullPointerExceptionThrown
{
    public static char firstChar(String ex) throws NullPointerException
    {
        try 
        {
            return ex.charAt(0);
        }
        catch (NullPointerException e)
        {
            throw new NullPointerException(ex);
        }
    }

    public static void main(String[]args)
    {
        firstChar(null);
    }
}
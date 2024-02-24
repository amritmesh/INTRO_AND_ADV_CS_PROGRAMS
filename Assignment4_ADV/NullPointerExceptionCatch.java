public class NullPointerExceptionCatch
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
        try
        {
            firstChar(null);
        }
        catch (NullPointerException e)
        {
            System.out.println("Cannot access a null string. NullPointerException \n is thrown when a reference variable is accessed (or de-referenced) and \n is not pointing to any object");
        }
    }
}
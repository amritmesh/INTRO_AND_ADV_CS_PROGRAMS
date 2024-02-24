public class ArrayIndexOutOfBoundsExceptionThrown 
{
    public static int array(int val) throws ArrayIndexOutOfBoundsException
    {
        try
        {
            int array[] = new int [2];

            for(int i = 0; i < array.length; i++)
            {
                array[i] = i;
            }
            return array[val];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new ArrayIndexOutOfBoundsException(val);
        }
    }

    public static void main(String[]args)
    {
        array(5);
    }
}
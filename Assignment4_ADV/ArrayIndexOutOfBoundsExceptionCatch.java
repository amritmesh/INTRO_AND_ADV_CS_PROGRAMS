public class ArrayIndexOutOfBoundsExceptionCatch
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
        try
        {
            array(5);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("The index does not exist in the array. \n ArrayIndexOutOfBoundsException is thrown \n to indicate that you are trying to access \n array element with an illegal index.");
        }
    }
}
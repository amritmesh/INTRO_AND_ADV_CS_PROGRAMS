public class ClassCastExceptionCatch
{
    public static void NumToSub() throws ClassCastException
    {
        try
        {
            Num a = new Num();
            SubNum b = (SubNum) a;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException();
        }
    }

    public static void main(String[]args)
    {
        try
        {
            NumToSub();
        }
        catch (ClassCastException e)
        {
            System.out.println("Cannot downcast without explicit class casting. \n ClassCastException is an Exception that can occur \n when you try to improperly convert a class from one type to another");
        }
    }
}

class Num
{
}

class SubNum extends Num
{
}

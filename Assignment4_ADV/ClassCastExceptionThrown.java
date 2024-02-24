public class ClassCastExceptionThrown
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
        NumToSub();
    }
}

class Num
{
}

class SubNum extends Num
{
}

public class ArrayProgram 
{
    public static void main(String[] args)
    {
        int array[] = new int[100];

        for(int i = 0; i < array.length; i++)
        {
            array[i] = (int)((Math.random()*100) + 1);
        }

        int evenMultiples[] = sortEven(array);
        System.out.println("The even multiples of 4 are: ");
        for(int n = 0; n < evenMultiples.length; n++)
        {
            System.out.print(evenMultiples[n] + " ");
        }
        
        System.out.println();

        int notEvenMultiples[] = sortNotEven(array);
        System.out.println("The numbers that aren't multiples of 4 are: ");
        for(int m = 0; m < notEvenMultiples.length; m++)
        {
            System.out.print(notEvenMultiples[m] + " ");
        }
    }
    
    public static int[] sortEven(int[] array)
    {
        int numEvenMults = 0;

        for(int i = 0; i < array.length; i++)
        {
            if (array[i] % 4 == 0 && array[i] % 2 == 0)
            {
                numEvenMults++;
            }
        }

        int evenMults[] = new int[numEvenMults];
        int evenMultsCounter = 0;

        for(int j = 0; j < array.length; j++)
        {
            if (array[j] % 4 == 0 && array[j] % 2 == 0)
            {
                evenMults[evenMultsCounter] = array[j];
                evenMultsCounter++;
            }
        }

        return evenMults;
    }

    public static int[] sortNotEven(int[] array)
    {
        int numNotEvenMults = 0;

        for(int i = 0; i < array.length; i++)
        {
            if (!(array[i] % 4 == 0 && array[i] % 2 == 0))
            {
                numNotEvenMults++;
            }
        }

        int notEvenMults[] = new int[numNotEvenMults];
        int notEvenMultsCounter = 0;

        for(int j = 0; j < array.length; j++)
        {
            if (!(array[j] % 4 == 0 && array[j] % 2 == 0))
            {
                notEvenMults[notEvenMultsCounter] = array[j];
                notEvenMultsCounter++;
            }
        }

        return notEvenMults;
    }
}
import java.util.Scanner;

public class SentenceProgram 
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in);

        System.out.print ("Enter a sentence: ");
        String sentence = input.nextLine();

        System.out.print ("Enter 1 to count characters, 2 to count words: ");
        int choice = input.nextInt();

        if (choice == 1)
        {
            String numChar = characters (sentence);
            int finalNumChar = Integer.parseInt (numChar);
            System.out.print ("There are " + finalNumChar + " characters in the sentence");
        }
        
        else if (choice == 2)
        {
            String numWord = words (sentence);
            int finalNumWord = Integer.parseInt (numWord);
            System.out.print ("There are " + finalNumWord + " words in the sentence");
        }
    }

    public static String characters (String sentence)
    {
        String numChar = sentence.length() + "";
        return numChar;
    }

    public static String words (String sentence)
    {
        int count = 0;

        if (sentence.trim().equals("")) 
        {
            return (count + "");
        }
       
        else 
        {
            count = 1;
        }
    
        for (int i = 0; i < sentence.length(); i++)
        {
            char ch = sentence.charAt (i);
            String str = new String (ch + "");
            if ((i + 1) != sentence.length() && str.equals (" ") && !(sentence.charAt (i + 1) + "").equals (" "))
            {
                count++;
            }
        }
    
        return (count + "");
    }
}
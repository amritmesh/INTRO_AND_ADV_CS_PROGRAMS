import java.util.Scanner;

public class MessageEncoderProgram 
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in);

        System.out.print ("Enter 1 for encoding, 2 for decoding: ");
        int x = Integer.parseInt(input.nextLine());

        if( x != 1 && x != 2)
        {
            System.out.println("Invalid option");
            System.exit(0);
        }
        else
        {
            System.out.print ("Enter a message (only alphabets, spaces, and periods): ");
            String message = input.nextLine();

            String allowedChars = new String ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ. ");

            for (int i = 0; i < message.length(); i++)
            {
                if(allowedChars.indexOf(message.charAt(i)) == -1)
                {
                    System.out.println("Invalid input");
                    System.exit(0);
                }
            }

            if (x == 1)
            {
                String finalEncodedMessage = encode (message);
                System.out.print(finalEncodedMessage);
            }

            else if (x == 2)
            {
                String finalDecodedMessage = decode (message);
                System.out.print(finalDecodedMessage);
            }
        }
    }

    public static String encode (String message)
    {
        String finalEncodedMessage = new String();
        
        String upper = new String ("ABCDEFGHIJKLM NOPQRSTUVWXYZ");
        String lower = new String ("abcdefghijklm.nopqrstuvwxyz");

        StringBuilder upperCase = new StringBuilder (upper);
        StringBuilder lowerCase = new StringBuilder (lower);

        StringBuilder reverseUpperCase = upperCase.reverse();
        StringBuilder reverseLowerCase = lowerCase.reverse();

        for(int i = 0; i < message.length(); i++)    
        {
            for(int j = 0; j < upper.length(); j++)
            {
                if(message.charAt(i) == upper.charAt(j))
                {
                    finalEncodedMessage += reverseUpperCase.charAt(j);
                }
            }

            for(int j = 0; j < lower.length(); j++)
            {
                if(message.charAt(i) == lower.charAt(j))
                {
                    finalEncodedMessage += reverseLowerCase.charAt(j);
                }
            }
        }
        
        return finalEncodedMessage;
    }

    public static String decode (String message)
    {
        String finalDecodedMessage = new String();
        
        String upper = new String ("ABCDEFGHIJKLM NOPQRSTUVWXYZ");
        String lower = new String ("abcdefghijklm.nopqrstuvwxyz");

        StringBuilder upperCase = new StringBuilder (upper);
        StringBuilder lowerCase = new StringBuilder (lower);

        StringBuilder reverseUpperCase = upperCase.reverse();
        StringBuilder reverseLowerCase = lowerCase.reverse();

        for(int i = 0; i < message.length(); i++)    
        {
            for(int j = 0; j < reverseUpperCase.length(); j++)
            {
                if(message.charAt(i) == reverseUpperCase.charAt(j))
                {
                    finalDecodedMessage += upper.charAt(j);
                }
            }

            for(int j = 0; j < reverseLowerCase.length(); j++)
            {
                if(message.charAt(i) == reverseLowerCase.charAt(j))
                {
                    finalDecodedMessage += lower.charAt(j);
                }
            }
        }
        
        return finalDecodedMessage;
    }
}
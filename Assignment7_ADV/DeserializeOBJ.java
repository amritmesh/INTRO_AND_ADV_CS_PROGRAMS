import java.util.Scanner;
import java.io.*;

public class DeserializeOBJ
{
    public static void main(String[]args) throws Exception
    {
        Scanner input = new Scanner(System.in);

        String folder = "C:/MyJavaPrograms/Assignment7_ADV/";
        ObjectInputStream in = null;

        try 
        {
            System.out.print("Please enter the file name: ");
            String fileName = input.nextLine();
            String file = folder + fileName;

            in = new ObjectInputStream(
                 new BufferedInputStream(
                 new FileInputStream(fileName)));

            for(int i = 0; i < 3; i++)
            {
                Song p = (Song) in.readObject();
                display(p);
            }
            in.close();
        } 

        catch (Exception e) 
        {
            System.out.print("Exception thrown.");
        }
    }   

    public static void display(Song p)
    {
        System.out.println("\n" + p.getTitle() + "\t" + p.getArtist() + "\t" + p.getGenre() + "\t" + p.getDate().getDate());
    }
}
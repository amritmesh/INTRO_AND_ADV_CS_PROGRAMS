import java.util.Scanner;
import java.io.*;

public class SerializeOBJ
{
    public static void main(String[]args) throws Exception
    {
        Scanner input = new Scanner(System.in);

        String folder = "C:/MyJavaPrograms/Assignment7_ADV/";
        Song[] songInfo = new Song[3];

        try
        {
            // Capture file name to store the song details
            System.out.print("Please enter the file name of the song collection (.dat extension): ");
            String fileName = input.nextLine();
            String file = folder + fileName;

            // Capture song details, create object, and store into object array
            for(int i = 0; i < songInfo.length; i++)
            {
                System.out.println();
                System.out.println("SONG " + (i + 1));
                System.out.println("---- ");
                System.out.println("Please enter the title of the song: ");
                String title = input.nextLine();
                System.out.println("Please enter the artist of the song: ");
                String artist = input.nextLine();
                System.out.println("Please enter the genre of the song: ");
                String genre = input.nextLine();

                System.out.println("Please enter the song's release date month as a number (MM): ");
                int m = input.nextInt();
                System.out.println("Please enter the song's release date day as a number (DD): ");
                int d = input.nextInt();
                System.out.println("Please enter the songs release date year as a number (YYYY): ");
                int y = input.nextInt();

                input.nextLine();

                Date releaseDate = new Date(m, d, y);

                songInfo[i] = new Song(title, artist, genre, releaseDate);
            }

            // Write song details into file
            ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(fileName)));
            
            for(int j = 0; j < songInfo.length; j++)
            {
                out.writeObject(songInfo[j]);
            }
            out.close();
        }
        catch (IOException e)
        {
            System.out.print(e);
        }
    }
}
import java.util.*;
import java.io.*;
import java.net.SocketTimeoutException;

public class SongCollection
{
    public static void main(String[]args) throws Exception
    {
        Scanner input = new Scanner(System.in);

        String folder = "C:/MyJavaPrograms/Assignment8_ADV/";
        ObjectInputStream in = null;

        int songCount = 0;

        Map<String, Song> songHashCollection = new HashMap<>();

        // 1. Read the object file
        try
        {
            System.out.print("Please enter the file name: ");
            String fileName = input.nextLine();
            String file = folder + fileName;

            in = new ObjectInputStream(
                 new BufferedInputStream(
                 new FileInputStream(fileName)));

            for(;;)
            {
                songCount++;
                Song p = (Song) in.readObject();
                songHashCollection.put(p.getTitle(), p);
            }
        }
        catch (SocketTimeoutException exc)
        {
            // you got the timeout
        }
        catch (EOFException exc)
        {
            // end of stream
            in.close();
        }
        catch (IOException exc)
        {
            // some other I/O error: print it, log it, etc.
            exc.printStackTrace(); // for example
        }

        // 2. Create a TreeMap
        Map<String, Song> songTreeCollection = new TreeMap<>(songHashCollection);

        // 3. Give user options to add, delete, display, and write songs in song collection
        while(true)
        {
            System.out.print("Please enter: \n 0 to add a song, \n 1 to delete a song, \n 2 to display the song collection, \n 3 to write song collection to file: ");
            String choice = input.nextLine();

            // Add song
            if(choice.equals("0"))
            {
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

                songTreeCollection.put(title, new Song(title, artist, genre, releaseDate));
                songCount++;
            }
            // Delete song
            else if(choice.equals("1"))
            {
                System.out.println("Please enter the song title to delete (use display option to view song titles): ");
                String songTitle = input.nextLine();

                songTreeCollection.remove(songTitle);
            }
            // Display song collection
            else if(choice.equals("2"))
            {
                for(Map.Entry song : songTreeCollection.entrySet())
                {
                    System.out.println(song.getKey() + " : " + ((Song)song.getValue()).getTitle() + "\t" + ((Song)song.getValue()).getArtist() + "\t" + ((Song)song.getValue()).getGenre() + "\t" + ((Song)song.getValue()).getDate().getDate());
                }
            }
            // Write collection to binary file
            else if(choice.equals("3"))
            {
                System.out.print("Please enter the output file name to write the song collection (.dat extension): ");
                String fileName = input.nextLine();
                String file = folder + fileName;

                ObjectOutputStream out = new ObjectOutputStream(
                                         new BufferedOutputStream(
                                         new FileOutputStream(fileName)));
                
                for(Map.Entry song : songTreeCollection.entrySet())
                {
                    out.writeObject(song.getValue());
                }

                out.close();

                System.exit(1);
            }
            // Invalid option
            else
            {
                System.out.print("You have entered an invalid option. Please try again.");
            }
        }
    }
}
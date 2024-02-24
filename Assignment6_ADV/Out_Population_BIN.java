import java.util.*;
import java.io.*;

public class Out_Population_BIN
{
    public static void main(String[]args) throws Exception
    {
        DataInputStream in = null;

        try
        {
            in = new DataInputStream(
                 new BufferedInputStream(
                 new FileInputStream("C:/MyJavaPrograms/Assignment6_ADV/Out_PovertyData.dat")));

            while(true)
            {
                String line = in.readUTF();
                System.out.print(line);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown.");
        }
        finally
        {
            in.close();
        }
    }
}
import java.util.*;
import java.io.*;

public class Test2
{
     public static void main( String [] args ) throws Exception
     {   
          ObjectInputStream in = new ObjectInputStream( new FileInputStream( "widget.dat" ) );
          Test w = (Test) in.readObject();

          System.out.println( w.getX() );
     }
}
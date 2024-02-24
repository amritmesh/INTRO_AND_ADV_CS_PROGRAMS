import java.util.*;
import java.io.*;

public class Population_TXT
{
    public static void main(String[]args) throws Exception
    {
        BufferedReader in = null;
        Scanner fileScanner = null;
        String prevState = "99";

        try
        {
            in = new BufferedReader(new FileReader("C:/MyJavaPrograms/Assignment5_ADV/PovertyData.txt"));
            fileScanner = new Scanner(in);

            State[] stateInfo = new State[55];
            State stateOBJ = null;
            int arrCount = 0;
            int loopCounter = 0;

            // Reading and processing the file
            while(fileScanner.hasNext())
            {
                // Read the lines
                loopCounter++;
                String line = fileScanner.nextLine();
                String stateCode = line.substring(0,2);
                int totalPop = Integer.parseInt((line.substring(82,90)).trim());
                int childPop = Integer.parseInt((line.substring(91,99)).trim());
                int childPovPop = Integer.parseInt((line.substring(100,108)).trim());

                /** When state code changes, store the object array with 
                 * the summarized object value and initialize new object with
                 * current line from the file*/
                if(!(prevState.equals(stateCode)))
                {
                 /**Do not process the first line from the file; otherwise store
                  * the summarized object record into the array*/
                    if (prevState != "99")
                    {
                        stateInfo[arrCount] = stateOBJ;
                        arrCount++;
                    }

                    // Build the object from the line from the file
                    stateOBJ = new State(stateCode, totalPop, childPop, childPovPop);

                }
                /** When state code does not change, keep the object summing
                 * up the total*/
                else
                {
                    stateOBJ.setTotalPop(totalPop);
                    stateOBJ.setChildPop(childPop);
                    stateOBJ.setChildPovPop(childPovPop);
                }
                /**For every line, store the current state code as the previous state code*/
                prevState = stateCode;

            }
            /**Store the last summarized state object*/
            stateInfo[arrCount] = stateOBJ;

            // Write array into output file
            PrintWriter out = null;
            try
            {
                // Write the summarized object array contents into the new output file
                out = new PrintWriter(new BufferedWriter(new FileWriter("C:/MyJavaPrograms/Assignment5_ADV/Out_PovertyData.txt")));
                for(int i = 0; i <= arrCount; i++)
                {
                    out.printf("%10s %10d %10d %10d \n", stateInfo[i].getStateCode(), stateInfo[i].getTotalPop(), stateInfo[i].getChildPop(), stateInfo[i].getChildPovPop());
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception thrown while writing.");
            }
            finally
            {
                out.close();
            }

            // Reading and displaying the array
            for(int i = 0; i <= arrCount ; i++)
            {
                // if(stateInfo[i] != null)
                // {
                    System.out.println(stateInfo[i].getStateCode());
                    System.out.println(stateInfo[i].getTotalPop());
                    // System.out.println(stateInfo[i].getChildPop());
                    // System.out.println(stateInfo[i].getChildPovPop());
                // }
                // if(stateInfo[i] != null)
                // {
                //     System.out.println(stateInfo[i].getStateCode());
                // }
            }
        }
        catch (Exception e)
        {
            System.out.print("Exception thrown while reading file");
            System.out.print(e);
        }
    }
}

// State class that stores the state code, with the total population characteristics per state
class State
{
    private String stateCode;
    private int totalPop;
    private int childPop;
    private int childPovPop;

    public State(String stateCode, int totalPop, int childPop, int childPovPop)
    {
        this.stateCode = stateCode;
        this.totalPop = totalPop;
        this.childPop = childPop;
        this.childPovPop = childPovPop;
    }

    // Getter and setter for state code
    public String getStateCode()
    {
        return this.stateCode;
    }
    // Sum the total object value until state code changes
    public void setStateCode(String stateCode)
    {
        this.stateCode = stateCode;
    }

    // Getter and setter for total population
    public int getTotalPop()
    {
        return this.totalPop;
    }
    // Sum the total object value until state code changes
    public void setTotalPop(int totalPop)
    {
        this.totalPop += totalPop;
    }

    // Getter and setter for child population
    public int getChildPop()
    {
        return this.childPop;
    }
    // Sum the total object value until state code changes
    public void setChildPop(int childPop)
    {
        this.childPop += childPop;
    }

    // Getter and setter for child poverty population
    public int getChildPovPop()
    {
        return this.childPovPop;
    }
    // Sum the total object value until state code changes
    public void setChildPovPop(int childPovPop)
    {
        this.childPovPop += childPovPop;
    }
}
import java.util.Scanner;
public abstract class Vehicle
{
    public abstract void display();

    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        Vehicle[] vehicleInfo = new Vehicle[2];

        for(int i = 0; i < vehicleInfo.length; i++)
        {
            System.out.print("Is the vehicle a car or a boat (C/B): ");
            String vehicleType = input.nextLine();

            if(vehicleType.equals("B"))
            {
                System.out.print("Please enter the length of the boat in feet: ");
                float vehicleLength = input.nextFloat();

                System.out.print("Please enter the draft of the boat in feet: ");
                float vehicleDraft = input.nextFloat();

                input.nextLine();

                vehicleInfo[i] = new Boat(vehicleLength, vehicleDraft);
            }

            else if(vehicleType.equals("C"))
            {
                System.out.print("Please enter the make of the car: ");
                String vehicleMake = input.nextLine();

                System.out.print("Please enter the year of the car (YYYY): ");
                int vehicleYear = input.nextInt();

                input.nextLine();

                vehicleInfo[i] = new Car(vehicleMake, vehicleYear);
            }
        }

        for(int i = 0; i < vehicleInfo.length; i++)
        {
            vehicleInfo[i].display();
        }
    }
}

class Boat extends Vehicle
{
    // Declaring variables
    float length;
    float draft;

    // Parameterized contructor
    public Boat(float length, float draft)
    {
        this.length = length;
        this.draft = draft;
    }

    // Getter and setter for length attribute
    public float getLength()
    {
        return length;
    }

    public void setLength(float length)
    {
        this.length = length;
    }

    // Getter and setter for draft attribute
    public float getDraft()
    {
        return draft;
    }

    public void setDraft(float draft)
    {
        this.draft = draft;
    }

    public void display()
    {
        System.out.println("This is a " + this.getClass() + " object.");
        System.out.println("The length of this boat is " + this.length + " feet.");
        System.out.println("The draft of this boat is " + this.draft + " feet.");
    }
}

class Car extends Vehicle
{
    // Declaring variables
    String make;
    int year;

    // Parameterized contructor
    public Car(String make, int year)
    {
        this.make = make;
        this.year = year;
    }

    // Getter and setter for make attribute
    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    // Getter and setter for year attribute
    public int getYear()
    {
        return year;
    }

    public void setYear(int Year)
    {
        this.year = year;
    }

    public void display()
    {
        System.out.println("This is a " + this.getClass() + " object.");
        System.out.println("The make of this car is " + this.make + ".");
        System.out.println("The year of this car is " + this.year + ".");
    }
}
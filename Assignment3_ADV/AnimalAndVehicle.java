public class AnimalAndVehicle
{
    public static void main(String[]args)
    {
        Sounds[] animalVehicleInfo = {new Dog(), new Cat(), new Car(), new Boat()};

        for(int i = 0; i < animalVehicleInfo.length; i++)
        {
            animalVehicleInfo[i].makeSound();
        }
    }
}

// Animal abstract class
abstract class Animal implements Sounds
{
    // Declare variables
    private float age;
    private float weight;

    // Getter and setter for age
    public float getAge()
    {
        return age;
    }
    public void setAge(float age)
    {
        this.age = age;
    }

    // Getter and setter for weight
    public float getWeight()
    {
        return weight;
    }
    public void setWeight(float weight)
    {
        this.weight = weight;
    }
}

// Vehicle abstract class
abstract class Vehicle implements Sounds
{
    // Declare variables
    private String make;
    private int year;

    // Getter and setter for make
    public String getMake()
    {
        return make;
    }
    public void setMake(String make)
    {
        this.make = make;
    }

    // Getter and setter for year
    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
}

// Interface for sound method reuse
interface Sounds
{
    void makeSound();
}

// Dog concrete subclass
class Dog extends Animal
{
    public void makeSound()
    {
        System.out.println("bow wow");
    }
}

// Cat concrete subclass
class Cat extends Animal
{
    public void makeSound()
    {
        System.out.println("meow");
    }
}

// Car concrete subclass
class Car extends Vehicle
{
    public void makeSound()
    {
        System.out.println("honk honk");
    }
}

// Boat concrete subclass
class Boat extends Vehicle
{
    public void makeSound()
    {
        System.out.println("toot toot");
    }
}
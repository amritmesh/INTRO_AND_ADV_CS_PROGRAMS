public class Dog 
{
    private String name;
    private String breed;
    private String gender;
    private int age;
    private double weight;
    private boolean fleas;

    // first constructor (attributes of dog)
    public Dog (String name, String breed, String gender, int age, double weight, boolean fleas)
    {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.fleas = fleas;
    }

    // second constructor (attributes of dog)
    public Dog (String name, String breed, String gender, int age, double weight)
    {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    // getter and setter for name
    public String getName ()
    {
        return name;
    }
    public void setName (String name)
    {
        this.name = name;
    }

    // getter and setter for breed
    public String getBreed ()
    {
        return breed;
    }
    public void setBreed (String breed)
    {
        this.breed = breed;
    }

    // getter and setter for gender
    public String getGender ()
    {
        return gender;
    }
    public void setGender (String gender)
    {
        this.gender = gender;
    }

    // getter and setter for age
    public int getAge ()
    {
        return age;
    }
    public void setAge (int age)
    {
        this.age = age;
    }

    // getter and setter for weight
    public double getWeight ()
    {
        return weight;
    }
    public void setWeight (double weight)
    {
        this.weight = weight;
    }

    // getter and setter for fleas
    public boolean getFleas ()
    {
        return fleas;
    }
    public void setFleas (boolean fleas)
    {
        this.fleas = fleas;
    }

    // dog behavior methods

    // eating method
    public void Eat ()
    {
        System.out.println ("chomp chomp chomp");
    }

    // barking method
    public void Bark ()
    {
        System.out.println ("woof woof woof");
    }

    // scratching fleas method
    public void ScratchFleas ()
    {
        if (getFleas ())
        {
            System.out.println ("scratch scratch scratch");
        }
        else
        {
            System.out.println ("aaah ... no fleas!");
        }
    }

    public void DisplayDogInfo()
    {
        System.out.println("Dog info");
        System.out.println("--------");
        System.out.println("Name: " + this.name);
        System.out.println("Breed: " + this.breed);
        System.out.println("Gender: " + this.gender);
        System.out.println("Age: " + this.age);
        System.out.println("Weight: " + this.weight);
        System.out.println("Has fleas?: " + this.fleas);
    }
    public static void main (String [] args)
    {
        Dog d1 = new Dog ("Max", "German Shepherd", "male", 16, 66, true);
        Dog d2 = new Dog ("Coco", "Shih Tzu", "female", 15, 8.8);

        d1.Eat ();
        d1.Bark ();
        d1.ScratchFleas ();
        System.out.println ("\n");
        d1.DisplayDogInfo ();
        
        System.out.println ("\n");

        d2.Eat ();
        d2.Bark ();
        d2.ScratchFleas ();
        System.out.println ("\n");
        d2.DisplayDogInfo ();
    }
}
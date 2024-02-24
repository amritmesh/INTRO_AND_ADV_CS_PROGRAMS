import java.util.Scanner;

public class SuperHero 
{
    HeroName name; 
    Date date;
    private boolean duties;
    private String specialSuit; 
    private String cape;
    private boolean powers;

    // constructor
    public SuperHero (HeroName name, Date date, boolean duties, String specialSuit, String cape, boolean powers)
    {
        this.name = name;
        this.date = date;
        this.duties = duties;
        this.specialSuit = specialSuit;
        this.cape = cape;
        this.powers = powers;
    }

    // getter and setter for name
    public String getName()
    {
        return this.name.getName();
    }
    public void setName (String heroName)
    {
        this.name.setName(heroName);
    }

    // getter and setter for date
    public String getDate()
    {
        return this.date.getDate();
    }
    public void setDate(String birthDate)
    {
        this.date.setDate(birthDate);
    }

    // getter and setter for duties
    public boolean getDuties()
    {
        return this.duties;
    }
    public void setDuties(boolean duties)
    {
        this.duties = duties;
    }

    // getter and setter for specialSuit
    public String getSpecialSuit ()
    {
        return this.specialSuit;
    }
    public void setSuit (String specialSuit)
    {
        this.specialSuit = specialSuit;
    }

    // getter and setter for cape
    public String getCape ()
    {
        return this.cape;
    }
    public void setCape (String cape)
    {
        this.cape = cape;
    }

    // getter and setter for powers
    public boolean getPowers()
    {
        return this.powers;
    }
    public void setPowers(boolean powers)
    {
        this.powers = powers;
    }

    public String toString()
    {
        return this.getName() + "\n" + this.getDate() + "\n" + this.duties + "\n" + this.specialSuit + "\n" + this.cape + "\n" + this.powers;
    }
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        SuperHero[] superHeroes = new SuperHero[2];

        System.out.println("Please enter 2 hero names ... ");

        for(int i = 0; i < 2; i++)
        {
            System.out.print("Please enter hero name: ");
            HeroName heroName = new HeroName(input.nextLine());
    
            System.out.print("Birth month (MM): ");
            String heroMonth = input.nextLine();
           // if(heroMonth.length() != 2)
           if(Integer.parseInt(heroMonth) <= 0 || Integer.parseInt(heroMonth) > 12)
            {
                System.out.println("Invalid month ... exiting ...");
                System.exit(0);
            }
            System.out.print("Birth day (DD): ");
            String heroDay = input.nextLine();
           // if(heroDay.length() != 2)
           if(Integer.parseInt(heroDay) <= 0 || Integer.parseInt(heroDay) > 31)            
            {
                System.out.println("Invalid day ... exiting ...");
                System.exit(0);
            }
            System.out.print("Birth year (YYYY): ");
            String heroYear = input.nextLine();
           if(heroYear.length() != 4)
            {
                System.out.println("Invalid year ... exiting ...");
                System.exit(0);
            }
            Date date = new Date(heroMonth + "/" + heroDay + "/" + heroYear);

            System.out.print("Is he/she perfoming hero duties (yes/no): ");
            String duty = input.nextLine();
            if (!(duty.equals("yes") || duty.equals("no")))
            {
                System.out.println("Invalid input ... exiting ...");
                System.exit(0);
            }

            boolean boolDuty;
            if(duty.equals("yes"))
            {
                boolDuty = true;
            }
            else
            {
                boolDuty = false;
            }

            String suit;
            String cape;

            if (boolDuty == true)
            {
                System.out.print("What type of suit is he/she wearing: ");
                suit = input.nextLine();

                System.out.print("What type of cape is he/she wearing: ");
                cape = input.nextLine();
            }
            else
            {
                suit = "";
                cape = "";
            }

            System.out.print("Does he/she invoke his/her superpowers (yes/no): ");
            String power = input.nextLine();

            if (!(power.equals("yes") || power.equals("no")))
            {
                System.out.println("Invalid input ... exiting ...");
                System.exit(0);
            }

            boolean boolPower;
            if(power.equals("yes"))
            {
                boolPower = true;
            }
            else
            {
                boolPower = false;
            }

            SuperHero hero = new SuperHero(heroName, date, boolDuty, suit, cape, boolPower);
            
            superHeroes[i] = hero;
            System.out.println("\n");
        }

        System.out.println("\n********\n");

        for (int i = 0; i < superHeroes.length; i++)
        {
            System.out.println(superHeroes[i].toString());
            System.out.println("\n********\n");
        }
    }
}

class HeroName
{
    private String heroName;

    public HeroName (String name)
    {
        this.heroName = name;
    }

    // getter and setter for name
    public String getName ()
    {
        return heroName;
    }
    public void setName (String name)
    {
        this.heroName = name;
    }
}

class Date
{
    private String birthDate;

    public Date (String birthDate)
    {
        this.birthDate = birthDate;
    }

    // getter and setter for date
    public String getDate ()
    {
        return birthDate;
    }
    public void setDate (String birthDate)
    {
        this.birthDate = birthDate;
    }
}
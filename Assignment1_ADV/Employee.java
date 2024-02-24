public class Employee
{
    // Declaring variables
    private String name;
    private Date hireDate;

    // Parameterized contructor
    public Employee(String name, Date hireDate)
    {
        this.name = name;
        this.hireDate = hireDate;
    }
    
    // Getter and setter for name attribute
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // Getter and setter for hire date attribute
    public Date getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }

    public static void main(String[]args)
    {
        Employee[] employeeInfo = new Employee[2];

        for(int i = 0; i < 2; i++)
        {
            String name = Input.getString("Please enter name of employee: ");
;
            int m = Input.getInt("Please enter employee's hire month as a number (MM): ");
            int d = Input.getInt("Please enter employee's hire day as a number (DD): ");
            int y = Input.getInt("Please enter employee's hire year as a number (YYYY):");

            Date hireDate = new Date(m, d, y);
            //hireDate.setDate(hireMonth, hireDay, hireYear);

            int n = Input.getInt("Please enter 0 for salaried worker and 1 for hourly worker: ");

            if(n == 0)
            {
                float annualSalaryAmt = Input.getFloat("Please enter employee's annual salary amount: ");
                employeeInfo[i] = new SalariedEmployee(name, hireDate, annualSalaryAmt);
            } 
            else if(n == 1)
            {
                float hourlyWage = Input.getFloat("Please enter employee's hourly wage: ");
                float hoursWorked = Input.getFloat("Please enter number of hours employee worked: ");
                employeeInfo[i] = new HourlyEmployee(name, hireDate, hourlyWage, hoursWorked);   
            }
        }

        for(int i = 0; i < employeeInfo.length; i++)
        {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.println(employeeInfo[i].getName());
            System.out.println(employeeInfo[i].getHireDate().getDate());

            if(employeeInfo[i] instanceof SalariedEmployee)
            {
                System.out.println("$" + ((SalariedEmployee)employeeInfo[i]).getAnnualSalaryAmt());
            }
            else if(employeeInfo[i] instanceof HourlyEmployee)
            {
                System.out.println("$" + ((HourlyEmployee)employeeInfo[i]).getHourlyWage() + "/hr");
                System.out.println(((HourlyEmployee)employeeInfo[i]).getHoursWorked() + " hours");
            }
            System.out.println();
        }
    }
}

class SalariedEmployee extends Employee
{
    // Declaring variables
    private float annualSalaryAmt;

    // Parameterized constructor
    public SalariedEmployee(String name, Date hireDate, float annualSalaryAmt)
    {
        super(name, hireDate);
        this.annualSalaryAmt = annualSalaryAmt;
    }

    // Getter and setter for annual salary amount
    public float getAnnualSalaryAmt()
    {
        return annualSalaryAmt;
    }

    public void setAnnualSalaryAmt(float annualSalaryAmt)
    {
        this.annualSalaryAmt = annualSalaryAmt;
    }
}

class HourlyEmployee extends Employee
{
    // Declaring variables
    private float hourlyWage;
    private float hoursWorked;
    
    // Parameterized contructor
    public HourlyEmployee(String name, Date hireDate, float hourlyWage, float hoursWorked)
    {
        super(name, hireDate);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    // Getter and setter for hourly wage
    public float getHourlyWage()
    {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage)
    {
        this.hourlyWage = hourlyWage;
    }

    // Getter and setter for hours worked
    public float getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }
}

// class PrintEmployeeInfo
// {
//     public static void main(String[]args)
//     {
//         Employee[] employeeInfo = new Employee[5];

//         for(int i = 0; i < 5; i++)
//         {
//             String name = Input.getString("Please enter name of employee: ");
// ;
//             int m = Input.getInt("Please enter employee's hire month as a number (MM): ");
//             int d = Input.getInt("Please enter employee's hire day as a number (DD): ");
//             int y = Input.getInt("Please enter employee's hire year as a number (YYYY):");

//             Date hireDate = new Date(m, d, y);
//             //hireDate.setDate(hireMonth, hireDay, hireYear);

//             int n = Input.getInt("Please enter 0 for salaried worker and 1 for hourly worker: ");

//             if(n == 0)
//             {
//                 float annualSalaryAmt = Input.getFloat("Please enter employee's annual salary amount: ");
//                 employeeInfo[i] = new SalariedEmployee(name, hireDate, annualSalaryAmt);
//             } 
//             else if(n == 1)
//             {
//                 float hourlyWage = Input.getFloat("Please enter employee's hourly wage: ");
//                 float hoursWorked = Input.getFloat("Please enter number of hours employee worked: ");
//                 employeeInfo[i] = new HourlyEmployee(name, hireDate, hourlyWage, hoursWorked);   
//             }
//         }

//         for(int i = 0; i < employeeInfo.length; i++)
//         {
//             System.out.print("Employee #" + i + ":");
//             System.out.print(employeeInfo[i]);
//         }
//     }
// }
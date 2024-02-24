interface I1 { void method1(); }

interface I2 { void method2(); }

class Animal { protected String name = "animal"; }

class Cat extends Animal implements I1, I2
{
     public void method1() { System.out.print( "I'm a cat" ); }
     public void method2() { name = "Gizmo"; System.out.print( " and my name is " + name ); }
}

class Dog extends Animal implements I1, I2
{
     public void method1() { System.out.print( "I'm a dog" ); }
     public void method2() { name = "Snoopy"; System.out.println( " and my name is " + name ); }
}

public class Test
{
     public static void main( String [] args )
     {
          Animal [] myAnimals = { new Dog(), new Cat() };

          for( int i = 0; i < 2; i++ )
          {
               myAnimals[i].method1();
               myAnimals[i].method2();
          }
     }
}
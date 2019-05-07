package exceptionhandling;
import java.util.*;

class AgeException extends Exception{
  public AgeException(String msg){
    super(msg);
  }
}

class AgeTooLowException extends AgeException{
  public AgeTooLowException(String msg){
    super(msg);
  }
}

class AgeTooHighException extends AgeException{
  public AgeTooHighException(String msg){
    super(msg);
  }
}

class AnotherException extends Exception{
    public AnotherException(String msg){
        super(msg);
    }
}

class Person{
  private int Age;
  final public String Name;
  public Person(String name){
    Name = name;
  }
//  public void ChangeName(String newName){
//    Name = newName;
//  }
  public int getAge(){
    return Age;
  }
//  public void setAge(int value)throws AgeTooLowException,AgeTooHighException{
//    if(value<=0) throw new AgeTooLowException("Age must be >0");
//    if(value>128) throw new AgeTooHighException("Is this a Human?!");
//    Age = value;
//  }
  public void setAge(int value) throws AgeTooLowException,AgeTooHighException{
    if(value<=0) throw new AgeTooLowException("Age must be >0");
    if(value>128) throw new AgeTooHighException("Is this a Human?!");
    Age = value;
  }
}

class Staff extends Person{
    double Salary;
    public Staff(String name, double salary){
        super(name);
        Salary = salary;
    }
    @Override
    public void setAge(int value) throws AgeTooLowException{
//        if(value<=0) throw new AgeTooLowException("Age must be >0");
//        if(value>128) throw new AgeTooHighException("Is this a Human?!");
//        super.setAge(value);
    }
}

public class ExceptionHandling {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Person p = new Person("Ali");
    
    while(true){
      System.out.print("age>");
      try{
        p.setAge(Integer.parseInt(sc.nextLine()));
        System.out.printf("%s's Age is %d%n",p.Name,p.getAge());
        break;//from while(true)
      }
      catch(NumberFormatException ex){
        System.out.println("Handle NumberFormatException");
      }
      catch(AgeTooLowException|AgeTooHighException ex){
        System.out.println("Handle AgeTooLowException");
      }
      catch(AgeException ex){
        System.out.println("In the AgeException handler");
        System.out.println(ex);
      }
      catch(RuntimeException ex){
        System.out.println("Handle RuntimeException");
      }
      catch(Exception ex){
        System.out.println("Handle Exception");
      }
      finally{
        System.out.println("Calling finally block");
      }
      System.out.println("Try again!");
    }
    System.out.println("bye...");
  }  
}

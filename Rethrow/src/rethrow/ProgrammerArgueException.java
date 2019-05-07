package rethrow;

public class ProgrammerArgueException extends Exception{
  public final String Person1,Person2;  
  public ProgrammerArgueException(String person1,String person2){
    Person1 = person1;
    Person2 = person2;
  }  
  @Override
  public String getMessage(){
    return Person1 + " argue with " + Person2;
  }
}

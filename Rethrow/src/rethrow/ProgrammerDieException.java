package rethrow;

public class ProgrammerDieException extends Exception{
  public String Who;
  public String Reason;
  public ProgrammerDieException(String who,String reason){
    Who = who;
    Reason = reason;
  }  
  @Override
  public String getMessage(){
    return Who + " die due to " + Reason;
  }
}

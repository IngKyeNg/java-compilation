package rethrow;

public class ProgrammerResignException extends Exception{
  public String Who;
  public ProgrammerResignException(String who){
    Who = who;
  }
  @Override
  public String getMessage(){
    return Who + " resigned";
  }
}

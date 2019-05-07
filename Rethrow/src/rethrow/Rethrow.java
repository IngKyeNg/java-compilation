package rethrow;

public class Rethrow {
  static void RunCompany(){
    try{
      ManageDepartment();
    }
    catch(ProgrammerDieException ex){
      System.out.print("The boss has press conference concerning ");
      System.out.println(ex.getMessage());
      System.out.println("The boss will ensure that \""+
        ex.Reason+"\" will not happend again in the company");
    }
  }
  static void ManageDepartment() throws ProgrammerDieException{
    for(int stage=1;stage<=10;stage++){
      try{
        DoProject(stage);
      }
      catch(ProgrammerResignException ex){
        System.out.println("Department inform HR to handle the case");
      }
      catch(ProgrammerDieException ex){
        System.out.println("Department head will get everyone contribute $ for "+ex.Who+"'s family");
        throw ex;
      }
      catch(Exception ex){
      }
    }
  }
  static void DoProject(int stage)throws ProgrammerResignException,ProgrammerDieException{
    System.out.println("Project at stage #"+stage);
    try{
      switch(stage){
        case 3:
          throw new ProgrammerArgueException("Ali","Abu");
        case 5:
          throw new ProgrammerResignException("Peter");
        case 8:
          throw new ProgrammerDieException("John","heavy workload");
      }
    }
    catch(ProgrammerArgueException ex){
      System.out.println(ex.getMessage());
      System.out.println("The project manager already sattled the case");
    }
    catch(ProgrammerResignException ex){
      System.out.println(ex.getMessage());
      System.out.println("The project manager already reassign the task to another programmer");
      throw ex;
    }
    catch(ProgrammerDieException ex){
      System.out.println(ex.getMessage());
      System.out.println("The project manager will get someone to replace "+ex.Who); 
      throw ex;
    }
    catch(Exception ex){
    }
  }
    
  public static void main(String[] args) {
    RunCompany();
  }
}

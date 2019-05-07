package testinterface;

interface CertifiedJavaDeveloper{
  void ProgramInJava();
}

interface CertifiedDotNetDeveloper{
  void ProgramInCSharp();
}

interface CertifiedSoftwareEngineer extends CertifiedJavaDeveloper,CertifiedDotNetDeveloper{
  int n=10;
  //  int m; -> no, you can't declare attibute
  void DoUML();
}

class A{
  
}

class B{
  
}

class TalentCorpCandidate implements CertifiedSoftwareEngineer{
  //public static final int n=10;
  @Override
  public void ProgramInJava(){
    //The methods goes here...
  }
  
  @Override
  public void ProgramInCSharp(){
    //The methods goes here...
  }
  
  @Override
  public void DoUML(){
    //The methods goes here...
  }

}



public class TestInterface {

  public static void main(String[] args) {
    TalentCorpCandidate c = new TalentCorpCandidate();
    CertifiedJavaDeveloper j = c;
    j.ProgramInJava();
    CertifiedDotNetDeveloper d = c;
    d.ProgramInCSharp();
  }  
}

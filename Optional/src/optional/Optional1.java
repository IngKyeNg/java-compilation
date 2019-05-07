package optional;

import java.util.*;

class Optional1 {
  static class Course {
    private List modules = new ArrayList();
    public void addModule(Module module) {
      modules.add(module);
    }
    public List getModules() {
      return modules;
    }
  }

  static class Module {
    private Student students;
    private String moduleName;
    public Module(String moduleName) {
      this.moduleName = moduleName;
    }
    public String getModuleName() {
      return moduleName;
    }
    public Student getStudent() {
      return students;
    }
    public void setStudents(Student students) {
      this.students = students;
    }
  }

  static class Student {
    private int numberOfStudents;
    public Student(int number) {
      this.numberOfStudents = number;
    }
    public int getNumberOfStudents() {
      return numberOfStudents;
    }
    public void setNumberOfStudents(int numberOfStudents) {
      this.numberOfStudents = numberOfStudents;
    }
  }

  public static void main1(String[] args) {
    Course computerScience = new Course();
    Module algorithms = new Module("Algorithms");
    Student studentsOnAlgorithm = new Student(50);
    algorithms.setStudents(studentsOnAlgorithm);
    computerScience.addModule(algorithms);

    computerScience.getModules().stream().forEach((m) -> {
      System.out.println("Module ---> " + ((Module) m).getModuleName() + " \n"
          + ((Module) m).getStudent().getNumberOfStudents()
          + " students take this module");
    });
  }

  public static void main(String[] args) {
    Course computerScience = new Course();
    Module algorithms = new Module("Algorithms");
    Student studentsOnAlgorithm = new Student(50);
    algorithms.setStudents(studentsOnAlgorithm);
    computerScience.addModule(algorithms);

    Module cancelledModules = new Module("Pascal");
    computerScience.addModule(cancelledModules);

    computerScience.getModules().stream().forEach((m) -> {
      System.out.println("Module ---> " + ((Module) m).getModuleName() + " \n"
          + ((Module) m).getStudent().getNumberOfStudents()
          + " students take this module");
    });
  }

}

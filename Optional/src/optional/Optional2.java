package optional;

import java.util.*;

class Optional2 {
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
    private Optional students = Optional.empty();
    private String moduleName;
    public Module(String moduleName) {
      this.moduleName = moduleName;
    }
    public String getModuleName() {
      return moduleName;
    }
    public Optional getStudent() {
      return students;
    }
    public void setStudents(Optional students) {
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

  public static void main(String[] args) {
    Course computerScience = new Course();
    Module algorithms = new Module("Algorithms");
    Optional studentsOnAlgorithm = Optional.of(new Student(50));
    algorithms.setStudents(studentsOnAlgorithm);
    computerScience.addModule(algorithms);

    Module cancelledModules = new Module("Pascal");
    computerScience.addModule(cancelledModules);

    computerScience.getModules().stream().forEach((m) -> {
      if (((Module) m).getStudent().isPresent()) {
        System.out.println("Module ---> " + ((Module) m).getModuleName()
            + " \n" + ((Student)((Module) m).getStudent().get()).getNumberOfStudents()
            + " students take this module");
      } else {
        System.out.println("Module ---> " + ((Module) m).getModuleName()
            + "\nhas no students attached to it");
      }
    });

  }
}

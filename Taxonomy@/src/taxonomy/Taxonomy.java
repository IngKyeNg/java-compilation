package taxonomy;

public class Taxonomy {

    public static void main(String[] args) {
        Staff[] staff2017 = new Staff[]{
            new Lecturer("Ali",2356,550F),
            new Clerk("Azizi",1255,25F),
            new Manager("Ahmad",4500,550F),
            new HRManager("Abdullah",5445),
            new SalesManager("Abu",5660,650F,800F),
        };
        ShowAllStaffInfo(staff2017);
        
        Sort(staff2017,Staff.SortCriteria.ByMonthlySalary);
        ShowAllStaffInfo(staff2017);
        
        Sort(staff2017,Staff.SortCriteria.ByMonthlySalaryDesc);
        ShowAllStaffInfo(staff2017);
        
        Sort(staff2017,Staff.SortCriteria.ByName);
        ShowAllStaffInfo(staff2017);
        
        Sort(staff2017,Staff.SortCriteria.ByNameDesc);
        ShowAllStaffInfo(staff2017);
        
        Student [] student2017 = new Student[]{
            new Student("Alex",3.24F),
            new Student("Charlie",3.09F),
            new Student("David",3.57F),
            new Student("Eugene",3.67F),
            new Student("Brian",3.38F),
        };
        
        ShowAllStudentInfo(student2017);
        
        Sort(student2017,Student.SortCriteria.ByName);
        ShowAllStudentInfo(student2017);
        
        Sort(student2017,Student.SortCriteria.ByNameDesc);
        ShowAllStudentInfo(student2017);
        
        Sort(student2017,Student.SortCriteria.Bycgpa);
        ShowAllStudentInfo(student2017);
        
        Sort(student2017,Student.SortCriteria.BycgpaDesc);
        ShowAllStudentInfo(student2017);
        
        
    }
    
    static void Sort(Sortable[] items, Object sortCriteria) {
        int n = items.length;
        for(int x=0; x<n-1; x++) {
            for(int y=0;y<(n-1-x);y++){
                if(items[y].Swap(items[y+1],sortCriteria)){
                    Sortable item = items[y];
                    items[y] = items[y+1];
                    items[y+1] = item;
                }
            }
        }
    }
    
    static void ShowAllStaffInfo(Staff[] items) {
        for(int i=0;i<items.length;i++){
            System.out.printf("Name:%-12s\tMonthly Salary:$%.2f%n",
                    items[i].Name,items[i].getMonthlySalary());
        }
        System.out.println();
    }
    
    static void ShowAllStudentInfo(Student[] items) {
        for(Student student:items){
            System.out.printf("Name:%-12s\tCGPA:%.2f%n",
                    student.Name,student.CGPA);
        }
        System.out.println();
    }

    public static void main3(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Person p = new Person("Ali");
        System.out.print("Age>>");
        p.setAge(Integer.parseInt(sc.nextLine()));
        System.out.printf("%s's age is %d%n", p.getName(), p.getAge());
        
        
        Staff l = new Lecturer("Abu",4000, 1000F);
        System.out.print("Age>>");
        l.setAge(Integer.parseInt(sc.nextLine()));
        System.out.printf("%s's age is %d%n", l.getName(), l.getAge());
        
    }

    public static void main2(String[] args) {
        Manager m = new Manager("Ali", 4500, 400F);
        HRManager hrm = new HRManager("Ahmad", 5500);
        SalesManager sm = new SalesManager("Abu",4500,400F,750F);
        
        ShowManagerInfo(m);
        ShowManagerInfo(hrm);
        sm.MonthlySales = 100_000;
        ShowManagerInfo(sm); 
        
        m = sm;
        
        if(m instanceof SalesManager) {
            SalesManager sm2 = (SalesManager)m;
        }
        else {
            //Warn the user
        }
    }
    
    static void ShowManagerInfo(Manager m) {
        System.out.printf("Name:%-12s\tMonthly Salary:%.2f%n",m.Name, m.getMonthlySalary());
    }



    public static void main1(String[] args) {
        Student s = new Student(); // Object Instantiation
        
        Student s1 = new Student("Tong Sam Pah",3.15F);
        Student s2 = s; // s is reference to the object
        
        System.out.printf("Name:%-12s\tCGPA:%.2f%n", // %n is newline
                s2.Name, s2.CGPA);
        
        Lecturer lec = new Lecturer("Alibaba", 2500, 450F);
    }
}

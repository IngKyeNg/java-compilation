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
    }
    static void Sort(Sortable[] items,Object sortCriteria){
        int n = items.length;
        for(int x=0;x<(n-1);x++){
            for (int y=0;y<(n-1-x);y++){
                if(items[y].Swap(items[y+1],sortCriteria)){
                    Sortable item = items[y];
                    items[y] = items[y+1];
                    items[y+1] = item;
                }
            }
        }
    }
    static void ShowAllStaffInfo(Staff[] items){
//        for(int i=0;i<items.length;i++){
//            System.out.printf("Name:%-12s\tMonthly Salary:$%.2f%n",
//                    items[i].Name,items[i].getMonthlySalary());
//        }
        for(Staff staff:items){
            System.out.printf("Name:%-12s\tMonthly Salary:$%.2f%n",
                    staff.Name,staff.getMonthlySalary());
        }
        System.out.println();
    }
    /*
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Person p = new Person("Ali");
        //p.Name = "Abu Bakar";
        System.out.print("Age>>");
        p.setAge(Integer.parseInt(sc.nextLine()));
        System.out.printf("%s's age is %d%n",p.Name,p.getAge());
    }
    */
    /*
    public static void main(String[] args) {
        Manager m = new Manager("Ali",4500,400F);
        HRManager hrm = new HRManager("Ahmad", 5500);
        SalesManager sm = new SalesManager("Abu",4500,400F,750F);
        
        ShowManagerInfo(m);
        
        ShowManagerInfo(hrm);

        sm.MonthlySales = 100_000;
        
        ShowManagerInfo(sm);
        
        m = sm;
           
        if (m instanceof SalesManager){
          SalesManager sm2 = (SalesManager)m;
        }
        else{
            //Warn the user
        }
    }   
    static void ShowManagerInfo(Manager m){
        System.out.printf("Name:%-12s\tMonthly Salary:$%.2f%n",
                m.Name,m.getMonthlySalary());
    }
*/
}
